<style lang="less">
  @import "deptManage.less";
</style>
<template>
  <div class="search">
    <el-card :aria-colspan="9">
      <el-row class="operation">
        <el-button @click="add" type="primary" icon="md-add">添加子部门</el-button>
        <el-button @click="addRoot" icon="md-add">添加一级部门</el-button>
        <el-button @click="delAll" icon="md-trash">批量删除</el-button>
        <el-button @click="getParentList" icon="md-refresh">刷新</el-button>
      </el-row>
      <el-row type="flex" justify="start" class="code-row-bg">
        <el-col :span="9">
          <el-alert show-icon title="test">
            当前选择编辑： <span class="select-count">{{editName}}</span>
            <a class="select-clear" v-if="form.id" @click="canelEdit">取消选择</a>
          </el-alert>
          <el-tree :data="data" :load="loadData" :props="defaultProps" :expand-on-click-node="false"
                   @node-click="selectTree" @check-change="changeSelect" lazy show-checkbox
                   @node-drag-start="handleDragStart"
                   @node-drag-enter="handleDragEnter"
                   @node-drag-leave="handleDragLeave"
                   @node-drag-over="handleDragOver"
                   @node-drag-end="handleDragEnd"
                   @node-drop="handleDrop"
                   :allow-drop="allowDrop"
                   :allow-drag="allowDrag"
                   draggable></el-tree>
          <el-spinner size="large" fix v-if="loading"></el-spinner>
        </el-col>
        <!---->
        <el-col :span="15">
          <el-form ref="form" :model="form" label-width="85" :rules="menuFormValidate">
            <el-form-item label="上级部门" prop="parentName">
              <el-input v-model="form.parentName"/>
            </el-form-item>
            <el-form-item label="部门名称" prop="title">
              <el-input v-model="form.name"/>
            </el-form-item>
            <el-form-item label="排序值" prop="sortOrder">
              <el-input-number :max="1000" :min="0" v-model="form.sortOrder"></el-input-number>
              <span style="margin-left:5px">值越小越靠前</span>
            </el-form-item>
            <el-form-item label="是否启用" prop="status">
              <el-switch
                v-model="editStatus"
                @on-change="changeEditSwitch"
                active-text="启用"
                inactive-text="禁用">
              </el-switch>
            </el-form-item>
            <el-form-item>
              <el-button style="margin-right:5px" @click="submitEdit" :loading="submitLoading" type="primary"
                         icon="ios-create-outline">修改并保存
              </el-button>
              <el-button @click="handleReset">重置</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
    </el-card>

    <el-dialog :title="modalTitle" :visible.sync="menuModalVisible" :mask-closable='false' width="500">
      <el-form ref="formAdd" :model="formAdd" label-width="85" :rules="menuFormValidate">
        <div v-if="showParent">
          <el-form-item label="上级部门：">
            {{form.name}}
          </el-form-item>
        </div>
        <el-form-item label="部门名称" prop="name">
          <el-input v-model="formAdd.name"/>
        </el-form-item>
        <el-form-item label="排序值" prop="sortOrder">
          <el-input-number :max="1000" :min="0" v-model="formAdd.sortOrder"></el-input-number>
          <span style="margin-left:5px">值越小越靠前，支持小数</span>
        </el-form-item>
        <el-form-item label="是否启用" prop="status">
          <el-switch
            v-model="addStatus"
            @on-change="changeAddSwitch"
            active-text="启用"
            inactive-text="禁用">
          </el-switch>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="text" @click="cancelAdd">取消</el-button>
        <el-button type="primary" :loading="submitLoading" @click="submitAdd">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import Vue from 'vue'
  import {deleteRequest, getRequest, postRequest, putRequest, uploadFileRequest} from '@/service'

  Vue.prototype.getRequest = getRequest;
  Vue.prototype.postRequest = postRequest;
  Vue.prototype.putRequest = putRequest;
  Vue.prototype.deleteRequest = deleteRequest;
  Vue.prototype.uploadFileRequest = uploadFileRequest;

  export default {
    name: "department-manage",
    data() {
      return {
        loading: true,
        loadingEdit: true,
        menuModalVisible: false,
        selectList: [],
        selectCount: 0,
        showParent: false,
        editStatus: true,
        addStatus: true,
        modalTitle: "",
        editName: "",
        form: {
          id: "",
          parentId: "",
          parentName: "",
          sortOrder: null,
          status: 0,
          url: ""
        },
        formAdd: {},
        menuFormValidate: {
          title: [{required: true, message: "名称不能为空", trigger: "blur"}]
        },
        submitLoading: false,
        data: [],
        defaultProps: {
          label: 'name',
          isLeaf: (data, node) => {
            return !node.data.parent
          }
        },
        dataEdit: []
      };
    },
    methods: {
      init() {
        this.getParentList();
        this.getParentListEdit();
      },
      getParentList() {
        this.loading = true;
        getRequest('auth/dept/listByParent/0', {}).then(res => {
          this.loading = false;
          if (res.data.success === true) {
            res.data.data.forEach(function (e) {
              if (e.isParent) {
                e.loading = false;
                e.children = [];
              }
            });
            this.data = res.data.data;
          }
        });
      },
      getParentListEdit() {
        this.loadingEdit = true;
        getRequest('auth/dept/listByParent/0', {}).then(res => {
          this.loadingEdit = false;
          if (res.data.success === true) {
            res.data.data.forEach(function (e) {
              if (e.isParent) {
                e.loading = false;
                e.children = [];
              }
            });
            // 头部加入一级
            let first = {
              id: "0",
              title: "一级部门"
            };
            res.data.data.unshift(first);
            this.dataEdit = res.data.data;
          }
        });
      },
      loadData(node, resolve) {
        this.getRequest("auth/dept/listByParent/" + node.data.id, {}).then(res => {
          if (res.data.success === true) {
            res.data.data.forEach(function (e) {
              if (e.isParent) {
                e.loading = false;
                e.children = [];
              }
            });
            resolve(res.data.data);
          }
        });
      },
      handleNodeClick(data) {
        console.log("handleNodeClick", data);
      },
      selectTree(data) {
        if (Number(data.status) === 0) {
          this.editStatus = true;
        } else {
          this.editStatus = false;
        }
        // 转换null为""
        for (let attr in data) {
          if (data[attr] === null) {
            data[attr] = "";
          }
        }
        this.form = JSON.parse(JSON.stringify(data));
        this.editName = data.name;
      },
      canelEdit() {
        this.isMenu = false;
        this.isButton = false;
        this.$refs.form.resetFields();
        delete this.form.id;
        this.editName = "";
      },
      selectTreeEdit(data) {
        // 转换null为""
        for (let attr in v) {
          if (data[attr] === null) {
            data[attr] = "";
          }
        }
        let temp = JSON.parse(JSON.stringify(data));
        this.form.parentId = temp.id;
        this.form.parentName = temp.name;
      },
      cancelAdd() {
        this.menuModalVisible = false;
      },
      handleReset() {
        this.$refs.form.resetFields();
        this.editStatus = true;
        this.form.status = 0;
      },
      changeEditSwitch(v) {
        if (v) {
          this.form.status = 0;
        } else {
          this.form.status = -1;
        }
      },
      submitEdit() {
        this.$refs.form.validate(valid => {
          if (valid) {
            if (!this.form.id) {
              this.$Message.warning("请先点击选择要修改的部门");
              return;
            }
            this.submitLoading = true;
            if (this.form.sortOrder === null) {
              this.form.sortOrder = "";
            }
            if (this.form.buttonType === null) {
              this.form.buttonType = "";
            }
            postRequest('/department/edit', this.form).then(res => {
              this.submitLoading = false;
              if (res.data.success === true) {
                this.$Message.success("编辑成功");
                this.init();
                this.menuModalVisible = false;
              }
            });
          }
        });
      },
      changeAddSwitch(v) {
        if (v) {
          this.formAdd.status = 0;
        } else {
          this.formAdd.status = -1;
        }
      },
      submitAdd() {
        this.$refs.formAdd.validate(valid => {
          if (valid) {
            this.submitLoading = true;
            if (this.formAdd.sortOrder === null) {
              this.formAdd.sortOrder = "";
            }
            if (this.formAdd.buttonType === null) {
              this.formAdd.buttonType = "";
            }
            postRequest('/department/add', this.formAdd).then(res => {
              this.submitLoading = false;
              if (res.data.success === true) {
                this.$Message.success("添加成功");
                this.init();
                this.menuModalVisible = false;
              }
            });
          }
        });
      },
      add() {
        if (this.form.id == "" || this.form.id == null) {
          this.$alert('请先点击选择一个部门');
          return;
        }
        this.modalTitle = "添加子部门";
        this.showParent = true;
        this.formAdd = {
          parentId: this.form.id,
          sortOrder: 1,
          status: 0
        };
        this.menuModalVisible = true;
      },
      addRoot() {
        this.modalTitle = "添加一级部门";
        this.showParent = false;
        this.formAdd = {
          parentId: 0,
          sortOrder: 1,
          status: 0
        };
        this.menuModalVisible = true;
      },
      changeSelect(v) {
        this.selectCount = v.length;
        this.selectList = v;
      },
      delAll() {
        if (this.selectCount <= 0) {
          this.$alert("您还未勾选要删除的数据");
          return;
        }
        this.$Modal.confirm({
          title: "确认删除",
          content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
          onOk: () => {
            let ids = "";
            this.selectList.forEach(function (e) {
              ids += e.id + ",";
            });
            ids = ids.substring(0, ids.length - 1);
            deleteRequest(`/department/delByIds/${ids}`, {}).then(res => {
              if (res.data.success === true) {
                this.$Message.success("删除成功");
                this.selectList = [];
                this.selectCount = 0;
                this.canelEdit();
                this.init();
              }
            });
          }
        });
      },
      handleDragStart(node, ev) {
        console.log('drag start', node);
      },
      handleDragEnter(draggingNode, dropNode, ev) {
        console.log('tree drag enter: ', dropNode.label);
      },
      handleDragLeave(draggingNode, dropNode, ev) {
        console.log('tree drag leave: ', dropNode.label);
      },
      handleDragOver(draggingNode, dropNode, ev) {
        console.log('tree drag over: ', dropNode.label);
      },
      handleDragEnd(draggingNode, dropNode, dropType, ev) {
        console.log('tree drag end: ', dropNode && dropNode.label, dropType);
      },
      handleDrop(draggingNode, dropNode, dropType, ev) {
        console.log('tree drop: ', dropNode.label, dropType);
      },
      allowDrop(draggingNode, dropNode, type) {
        return true;
      },
      allowDrag(draggingNode) {
        return true;
      }
    },
    mounted() {
      this.init();
    }
  };
</script>
