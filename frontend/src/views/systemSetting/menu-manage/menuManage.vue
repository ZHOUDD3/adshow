<style lang="less">
@import "./menuManage.less";
</style>
<template>
    <el-row class="search">
        <el-card>
          <el-row class="operation">
            <el-button @click="addMenu" type="primary" icon="plus-round">添加子节点</el-button>
            <el-button @click="addRootMenu" type="ghost" icon="plus-round">添加一级菜单</el-button>
            <el-button @click="delAll" type="ghost" icon="trash-a">批量删除</el-button>
            <el-dropdown @command="handleDropdown">
              <span class="el-dropdown-link">
                更多操作<i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="refresh">刷新</el-dropdown-item>
                <el-dropdown-item command="expandTwo">仅展开两级</el-dropdown-item>
                <el-dropdown-item command="expandAll">展开所有</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </el-row>
          <el-row type="flex" justify="start" class="code-row-bg">
            <el-col :span="6">
              <el-tree :data="data" show-checkbox @on-check-change="changeSelect" @on-select-change="selectTree"></el-tree>
              <el-spinner size="large" fix v-if="loading"></el-spinner>
            </el-col>
            <el-col :span="9">
              <el-form ref="menuForm" :model="menuForm" label-width="85px" :rules="menuFormValidate">
                <el-form-item label="类型" prop="type">
                  <el-radio-group v-model="menuForm.type">
                    <el-radio-button :label="0">
                      <i class="ios-list-outline"></i>
                      <span>页面菜单</span>
                    </el-radio-button>
                    <el-radio-button :label="1" :disabled="isMenu">
                      <i class="log-in"></i>
                      <span>操作按钮</span>
                    </el-radio-button>
                  </el-radio-group>
                </el-form-item>
                 <el-form-item label="名称" prop="title">
                  <el-input v-model="menuForm.title"/>
                </el-form-item>
                <el-form-item label="路径" prop="path">
                  <el-input v-model="menuForm.path"/>
                </el-form-item>
                <el-form-item label="按钮权限类型" prop="buttonType" v-if="menuForm.type===1">
                  <el-select v-model="menuForm.buttonType" placeholder="请选择">
                    <el-option value="add">添加操作</el-option>
                    <el-option value="edit">编辑操作</el-option>
                    <el-option value="delete">删除操作</el-option>
                    <el-option value="clearAll">清空全部</el-option>
                    <el-option value="enable">启用操作</el-option>
                    <el-option value="disable">禁用操作</el-option>
                    <el-option value="search">搜索操作</el-option>
                    <el-option value="upload">上传文件</el-option>
                    <el-option value="output">导出操作</el-option>
                    <el-option value="editPerm">分配权限</el-option>
                    <el-option value="setDefault">设为默认</el-option>
                    <el-option value="other">其他操作</el-option>
                  </el-select>
                </el-form-item>
                <div v-if="menuForm.type===0">
                  <el-form-item label="英文名" prop="name">
                    <el-input v-model="menuForm.name"/>
                  </el-form-item>
                  <el-form-item label="图标" prop="icon" style="margin-bottom: 5px;">
                    <el-input v-model="menuForm.icon"/>
                    <span>
                      图标请参考 <a target="_blank" href="http://ionicons.com/"><i class="ionic"></i>ionicons</a>
                    </span>
                  </el-form-item>
                  <el-form-item label="前端组件" prop="component">
                    <el-input v-model="menuForm.component"/>
                  </el-form-item>
                </div>
                <el-form-item label="排序值" prop="sortOrder">
                  <el-input-number :max="1000" :min="0" v-model="menuForm.sortOrder"></el-input-number>
                  <span style="margin-left:5px">值越小越靠前，支持小数</span>
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
                  <el-button @click="submitEdit" :loading="submitLoading" type="primary" icon="compose">修改</el-button>
                  <el-button @click="handleReset" type="ghost" >重置</el-button>
                </el-form-item>
              </el-form>
            </el-col>
          </el-row>
        </el-card>

        <el-dialog :title="modalTitle" v-model="menuModalVisible" :mask-closable='false' width="500" :styles="{top: '30px'}">
          <el-form ref="menuFormAdd" :model="menuFormAdd" label-width="85px" :rules="menuFormValidate">
            <div v-if="showParent">
              <el-form-item label="上级节点：">
                {{menuForm.title}}
              </el-form-item>
            </div>
            <el-form-item label="类型" prop="type">
              <el-radio-group v-model="menuFormAdd.type">
                <el-radio-button :label="0" :disabled="isButtonAdd">
                  <i class="ios-list-outline"></i>
                  <span>页面菜单</span>
                </el-radio-button>
                <el-radio-button :label="1" :disabled="isMenuAdd">
                  <i class="log-in"></i>
                  <span>操作按钮</span>
                </el-radio-button>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="名称" prop="title">
              <el-input v-model="menuFormAdd.title"/>
            </el-form-item>
            <el-form-item label="路径" prop="path">
              <el-input v-model="menuFormAdd.path"/>
            </el-form-item>
            <el-form-item label="按钮权限类型" prop="buttonType" v-if="menuFormAdd.type===1">
              <el-select v-model="menuFormAdd.buttonType" placeholder="请选择">
                <el-option value="add">添加操作</el-option>
                <el-option value="edit">编辑操作</el-option>
                <el-option value="delete">删除操作</el-option>
                <el-option value="clearAll">清空全部</el-option>
                <el-option value="enable">启用操作</el-option>
                <el-option value="disable">禁用操作</el-option>
                <el-option value="search">搜索操作</el-option>
                <el-option value="upload">上传文件</el-option>
                <el-option value="output">导出操作</el-option>
                <el-option value="editPerm">分配权限</el-option>
                <el-option value="setDefault">设为默认</el-option>
                <el-option value="other">其他操作</el-option>
              </el-select>
            </el-form-item>
            <div v-if="menuFormAdd.type===0">
              <el-form-item label="英文名" prop="name">
                <el-input v-model="menuFormAdd.name"/>
              </el-form-item>
              <el-form-item label="图标" prop="icon"  style="margin-bottom: 5px;">
                <el-input v-model="menuFormAdd.icon"/>
                <span>
                  图标请参考 <a target="_blank" href="http://ionicons.com/"><Icon type="ionic"></Icon> ionicons</a>
                </span>
              </el-form-item>
              <el-form-item label="前端组件" prop="component">
                <el-input v-model="menuFormAdd.component"/>
              </el-form-item>
            </div>
            <el-form-item label="排序值" prop="sortOrder">
              <el-input-number :max="1000" :min="0" v-model="menuFormAdd.sortOrder"></el-input-number>
              <span style="margin-left:5px">值越小越靠前，支持小数</span>
            </el-form-item>
            <el-form-item label="是否启用" prop="status">
              <el-switch size="large" v-model="addStatus" @on-change="changeAddSwitch">
                <span slot="open">启用</span>
                <span slot="close">禁用</span>
              </el-switch>
            </el-form-item>
          </el-form>
          <div slot="footer">
            <el-button type="text" @click="cancelAdd">取消</el-button>
            <el-button type="primary" :loading="submitLoading" @click="submitAdd">提交</el-button>
          </div>
        </el-dialog>
    </el-row>
</template>

<script>
  import Vue from 'vue'
  import { getRequest, postRequest, putRequest, deleteRequest, uploadFileRequest } from '@/service'
  Vue.prototype.getRequest = getRequest;
  Vue.prototype.postRequest = postRequest;
  Vue.prototype.putRequest = putRequest;
  Vue.prototype.deleteRequest = deleteRequest;
  Vue.prototype.uploadFileRequest = uploadFileRequest;

  export default {
  name: "role-manage",
  data() {
    return {
      loading: true,
      expandAll: false,
      modalType: 0,
      menuModalVisible: false,
      selectList: [],
      selectCount: 0,
      showParent: false,
      isButtonAdd: false,
      isMenuAdd: false,
      isMenu: false,
      editStatus: true,
      addStatus: true,
      modalTitle: "",
      menuForm: {
        id: "",
        parentId: "",
        buttonType: "",
        type: 0,
        sortOrder: null,
        level: null,
        status: 0
      },
      menuFormAdd: {},
      menuFormValidate: {
        title: [{ required: true, message: "名称不能为空", trigger: "blur" }],
        name: [{ required: true, message: "英文名不能为空", trigger: "blur" }],
        icon: [{ required: true, message: "图标不能为空", trigger: "blur" }],
        path: [{ required: true, message: "路径不能为空", trigger: "blur" }],
        component: [
          { required: true, message: "前端组件不能为空", trigger: "blur" }
        ]
      },
      submitLoading: false,
      data: []
    };
  },
  methods: {
    init() {
      this.getAllList();
    },
    handleDropdown(name) {
      if (name === "expandTwo") {
        this.expandAll = false;
        this.getAllList();
      } else if (name === "expandAll") {
        this.expandAll = true;
        this.getAllList();
      } else if (name === "refresh") {
        this.getAllList();
      }
    },
    getAllList() {
      this.loading = true;
      this.getRequest("auth/permission/all").then(res => {
        this.loading = false;
        if (res.success === true) {
          // 仅展开2级
          if (!this.expandAll) {
            res.result.forEach(function(e) {
              if (e.children && e.children.length > 0) {
                e.children.forEach(function(c) {
                  if (c.level === 2) {
                    c.expand = false;
                  }
                });
              }
            });
          }
          this.data = res.result;
        }
      });
    },
    selectTree(v) {
      if (v.length > 0) {
        if (Number(v[0].level) === 1 || Number(v[0].level) === 2) {
          this.isMenu = true;
        } else {
          this.isMenu = false;
        }
        if (Number(v[0].status) === 0) {
          this.editStatus = true;
        } else {
          this.editStatus = false;
        }
        // 转换null为""
        for (let attr in v[0]) {
          if (v[0][attr] === null) {
            v[0][attr] = "";
          }
        }
        let str = JSON.stringify(v[0]);
        let menu = JSON.parse(str);
        if (menu.access === "") {
          menu.access = null;
        }
        this.menuForm = menu;
      }
    },
    cancelAdd() {
      this.menuModalVisible = false;
    },
    handleReset() {
      this.$refs.menuForm.resetFields();
      this.editStatus = true;
      this.menuForm.status = 0;
    },
    changeEditSwitch(v) {
      if (v) {
        this.menuForm.status = 0;
      } else {
        this.menuForm.status = -1;
      }
    },
    submitEdit() {
      this.$refs.menuForm.validate(valid => {
        if (valid) {
          if (!this.menuForm.id) {
            this.$Message.warning("请先点击选择要修改的菜单节点");
            return;
          }
          this.submitLoading = true;
          if (this.menuForm.sortOrder === null) {
            this.menuForm.sortOrder = "";
          }
          if (this.menuForm.buttonType === null) {
            this.menuForm.buttonType = "";
          }
          if (this.menuForm.type == 1) {
            this.menuForm.name = "";
            this.menuForm.icon = "";
            this.menuForm.component = "";
          }
          this.postRequest("auth/permission/edit", this.menuForm).then(res => {
            this.submitLoading = false;
            if (res.success === true) {
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
        this.menuFormAdd.status = 0;
      } else {
        this.menuFormAdd.status = -1;
      }
    },
    submitAdd() {
      this.$refs.menuFormAdd.validate(valid => {
        if (valid) {
          this.submitLoading = true;
          if (this.menuFormAdd.sortOrder === null) {
            this.menuFormAdd.sortOrder = "";
          }
          if (this.menuFormAdd.buttonType === null) {
            this.menuFormAdd.buttonType = "";
          }
          if (this.menuFormAdd.type == 1) {
            this.menuForm.name = "";
            this.menuForm.icon = "";
            this.menuForm.component = "";
          }
          this.postRequest("auth/permission/add", this.menuFormAdd).then(res => {
            this.submitLoading = false;
            if (res.success === true) {
              this.$Message.success("添加成功");
              this.init();
              this.menuModalVisible = false;
            }
          });
        }
      });
    },
    addMenu() {
      if (this.menuForm.id == "" || this.menuForm.id == null) {
        this.$Message.warning("请先点击选择一个菜单权限节点");
        return;
      }
      this.modalTitle = "添加菜单权限";
      this.showParent = true;
      let type = 0;
      if (this.menuForm.level === 1) {
        type = 0;
        this.isMenuAdd = true;
        this.isButtonAdd = false;
      } else if (this.menuForm.level === 2) {
        type = 1;
        this.isMenuAdd = false;
        this.isButtonAdd = true;
      } else {
        type = 0;
        this.isMenuAdd = false;
        this.isButtonAdd = false;
      }
      this.menuFormAdd = {
        type: type,
        parentId: this.menuForm.id,
        level: Number(this.menuForm.level) + 1,
        sortOrder: 1,
        buttonType: "",
        status: 0
      };
      this.menuModalVisible = true;
    },
    addRootMenu() {
      this.modalTitle = "添加一级菜单";
      this.isMenuAdd = true;
      this.isButtonAdd = false;
      this.showParent = false;
      this.menuFormAdd = {
        type: 0,
        level: 1,
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
        this.$Message.warning("您还未勾选要删除的数据");
        return;
      }
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除所选的 " + this.selectCount + " 条数据?",
        onOk: () => {
          let ids = "";
          this.selectList.forEach(function(e) {
            ids += e.id + ",";
          });
          ids = ids.substring(0, ids.length - 1);
          this.deleteRequest("auth/permission/delByIds", { ids: ids }).then(res => {
            if (res.success === true) {
              this.$Message.success("删除成功");
              this.selectList = [];
              this.selectCount = 0;
              this.init();
            }
          });
        }
      });
    }
  },
  mounted() {
    this.init();
  }
};
</script>
