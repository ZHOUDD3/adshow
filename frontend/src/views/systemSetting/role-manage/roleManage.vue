<style lang="less">
@import "./roleManage.less";
</style>
<template>
    <div class="search">
                <el-card>
                    <div class="operation">
                        <el-button @click="addRole" type="primary" icon="plus-round">添加角色</el-button>
                        <el-button @click="delAll" type="ghost" icon="trash-a">批量删除</el-button>
                        <el-button @click="init" type="ghost" icon="refresh">刷新</el-button>
                    </div>
                     <div>
                        <el-alert show-icon title="testaa">
                            已选择 <span class="select-count">{{selectCount}}</span> 项
                            <a class="select-clear" @click="clearSelectAll">清空</a>
                        </el-alert>
                    </div>
                    <div class="margin-top-10 searchable-table-con1">

                      <el-table
                        ref="table"
                        :data="data"
                        height="100%"
                        style="width: 100%">
                        <el-table-column type="selection" width="60"></el-table-column>
                        <el-table-column prop="name" label="角色名称" sortable width="145"></el-table-column>
                        <el-table-column prop="createTime" label="创建时间" sortable width="145"></el-table-column>
                        <el-table-column prop="updateTime" label="更新时间" sortable width="145"></el-table-column>
                        <el-table-column prop="defaultRole" label="是否设置为注册用户默认角色">
                          <template slot-scope="scope">
                            <el-button v-show="scope.row.defaultRole"
                                       size="small"
                                       type="info"
                                       icon="setting"
                                       @click="cancelDefault(scope.$index, scope.row)">取消默认
                            </el-button>
                            <el-button v-show="!scope.row.defaultRole"
                                       size="small"
                                       type="info"
                                       icon="setting"
                                       @click="setDefault(scope.$index, scope.row)">设为默认
                            </el-button>
                          </template>
                        </el-table-column>
                        <el-table-column prop="action" label="操作" width="300" fixed="right">
                          <template slot-scope="scope">
                            <el-button
                              size="small"
                              type="default"
                              icon="edit"
                              @click="editPerm(scope.$index, scope.row)">分配权限
                            </el-button>
                            <el-button
                              size="small"
                              type="info"
                              icon="setting"
                              @click="edit(scope.$index, scope.row)">编辑
                            </el-button>
                            <el-button
                              size="small"
                              type="danger"
                              @click="remove(scope.$index, scope.row)">删除
                            </el-button>
                          </template>
                        </el-table-column>
                      </el-table>
                    </div>
                    <div type="flex" justify="end" class="code-row-bg page">
                      <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="total"
                        :page-size="this.pageSize"
                        :current-page="this.pageNumber"
                        @current-change="changePageSize"
                        @prev-click="changePageSize"
                        @next-click="changePageSize"
                        :page-sizes="[5, 10, 20]">
                      </el-pagination>
                    </div>
                </el-card>
        <el-dialog :title="modalTitle" :visible.sync="roleModalVisible" :mask-closable='false' width="500">
          <el-form ref="roleForm" :model="roleForm" :label-width="80" :rules="roleFormValidate">
            <el-form-item label="角色名称" prop="name">
              <el-input v-model="roleForm.name" placeholder="按照Spring Security约定建议以‘ROLE_’开头"/>
            </el-form-item>
          </el-form>
          <div slot="footer">
            <el-button type="text" @click="cancelRole">取消</el-button>
            <el-button type="primary" :loading="submitLoading" @click="submitRole">提交</el-button>
          </div>
        </el-dialog>
        <el-dialog title="分配权限(点击选择)" v-model="permModalVisible" :mask-closable='false' width="500" :styles="{top: '30px'}">
          <el-tree ref="tree" :data="permData" multiple></el-tree>
          <!--
          <Spin size="large" v-if="treeLoading"></Spin>-->
          <div slot="footer">
            <el-button type="text" @click="cancelPermEdit">取消</el-button>
            <el-button type="ghost" @click="selectTreeAll">全选/反选</el-button>
            <el-button type="primary" :loading="submitPermLoading" @click="submitPermEdit">提交</el-button>
          </div>
        </el-dialog>
    </div>
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
      treeLoading: true,
      submitPermLoading: false,
      sortColumn: "createTime",
      sortType: "desc",
      modalType: 0,
      roleModalVisible: false,
      permModalVisible: false,
      modalTitle: "",
      roleForm: {
        name: ""
      },
      roleFormValidate: {
        name: [{ required: true, message: "角色名称不能为空", trigger: "blur" }]
      },
      submitLoading: false,
      selectList: [],
      selectCount: 0,

      data: [{"id":"65717815964864111","createUser":null,"createTime":null,"updateTime":null,"updateUser":null,"version":null,"name":"role","delFlag":null,"defaultRole":null,"permissions":[],"empty":false}],
      pageNumber: 1,
      pageSize: 10,
      total: 0,
      permData: [],
      editRolePermId: "",
      selectPermList: [],
      selectAllFlag: false,
    };
  },
  methods: {
    init() {
      this.getRoleList();
      // 获取所有菜单权限树
      this.getPermList();
    },
    changePage(v) {
      this.pageNumber = v;
      this.getRoleList();
      this.clearSelectAll();
    },
    changePageSize(v) {
      this.pageSize = v;
      this.getRoleList();
    },
    changeSort(e) {
      this.sortColumn = e.key;
      this.sortType = e.order;
      if (e.order === "normal") {
        this.sortType = "";
      }
      this.getRoleList();
    },
    getRoleList() {
      this.loading = true;
      let params = {
        pageNumber: this.pageNumber,
        pageSize: this.pageSize,
        sort: "createTime"
      };
      this.postRequest("auth/role/page", params).then(res => {
        this.loading = false;
        if (res.success === true) {
          this.data = res.result.content;
          this.total = res.result.totalElements;
        }
      });
    },
    getPermList() {
      this.treeLoading = true;
      this.getRequest("auth/permission/all").then(res => {
        this.treeLoading = false;
        if (res.success === true) {
          this.deleteDisableNode(res.result);
          this.permData = res.result;
        }
      });
    },
    // 递归删除禁用节点
    deleteDisableNode(permData) {
      let that = this;
      permData.forEach(function(e) {
        if (e.status === 1) {
          e.title += "(已禁用)"
          e.disabled = true
        }
        if (e.children && e.children.length > 0) {
          that.deleteDisableNode(e.children);
        }
      });
    },
    cancelRole() {
      this.roleModalVisible = false;
    },
    submitRole() {
      this.$refs.roleForm.validate(valid => {
        if (valid) {
          let url = "/role/save";
          if (this.modalType === 1) {
            // 编辑用户
            url = "/role/edit";
          }
          this.submitLoading = true;
          this.postRequest(url, this.roleForm).then(res => {
            this.submitLoading = false;
            if (res.success === true) {
              this.$Message.success("操作成功");
              this.getRoleList();
              this.roleModalVisible = false;
            }
          });
        }
      });
    },
    addRole() {
      this.modalType = 0;
      this.modalTitle = "添加角色";
      this.roleForm = {
        name: "",
        access: null
      };
      this.roleModalVisible = true;
    },
    edit(i, v) {
      this.modalType = 1;
      this.modalTitle = "编辑角色";
      // 转换null为""
      for (let attr in v) {
        if (v[attr] === null) {
          v[attr] = "";
        }
      }
      let str = JSON.stringify(v);
      let roleInfo = JSON.parse(str);
      this.roleForm = roleInfo;
      this.roleModalVisible = true;
    },
    remove(i, v) {
      this.$Modal.confirm({
        title: "确认删除",
        content: "您确认要删除角色 " + v.name + " ?",
        onOk: () => {
          this.deleteRequest("auth/role/delAllByIds", { ids: v.id }).then(res => {
            if (res.success === true) {
              this.$Message.success("删除成功");
              this.getRoleList();
            }
          });
        }
      });
    },
    setDefault(i, v) {
      this.$Modal.confirm({
        title: "确认设置",
        content: "您确认要设置所选的 " + v.name + " 为注册用户默认角色?",
        onOk: () => {
          let params = {
            id: v.id,
            isDefault: true
          };
          this.postRequest("auth/role/setDefault", params).then(res => {
            if (res.success === true) {
              this.$Message.success("操作成功");
              this.getRoleList();
            }
          });
        }
      });
    },
    cancelDefault(i, v) {
      this.$Modal.confirm({
        title: "确认取消",
        content: "您确认要取消所选的 " + v.name + " 角色为默认?",
        onOk: () => {
          let params = {
            id: v.id,
            isDefault: false
          };
          this.postRequest("auth/role/setDefault", params).then(res => {
            if (res.success === true) {
              this.$Message.success("操作成功");
              this.getRoleList();
            }
          });
        }
      });
    },
    clearSelectAll() {
      this.$refs.table.selectAll(false);
    },
    changeSelect(e) {
      this.selectList = e;
      this.selectCount = e.length;
    },
    delAll() {
      if (this.selectCount <= 0) {
        this.$Message.warning("您还未选择要删除的数据");
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
          this.deleteRequest("auth/role/delAllByIds", { ids: ids }).then(res => {
            if (res.success === true) {
              this.$Message.success("删除成功");
              this.clearSelectAll();
              this.getRoleList();
            }
          });
        }
      });
    },
    editPerm(v) {
      this.editRolePermId = v.id;
      // 匹配勾选
      let rolePerms = v.permissions;
      // 递归判断子节点
      this.checkPermTree(this.permData, rolePerms);
      this.permModalVisible = true;
    },
    // 递归判断子节点
    checkPermTree(permData, rolePerms) {
      let that = this;
      permData.forEach(function(p) {
        if (that.hasPerm(p, rolePerms)) {
          p.selected = true;
        } else {
          p.selected = false;
        }
        if (p.children && p.children.length > 0) {
          that.checkPermTree(p.children, rolePerms);
        }
      });
    },
    // 判断角色拥有的权限节点勾选
    hasPerm(p, rolePerms) {
      let flag = false;
      for (let i = 0; i < rolePerms.length; i++) {
        if (p.id === rolePerms[i].id) {
          flag = true;
          break;
        }
      }
      if (flag) {
        return true;
      }
      return false;
    },
    // 全选反选
    selectTreeAll() {
      this.selectAllFlag = !this.selectAllFlag
      let select = this.selectAllFlag
      this.selectedTreeAll(this.permData, select)
    },
    // 递归全选节点
    selectedTreeAll(permData, select) {
      let that = this;
      permData.forEach(function(e) {
        e.selected = select
        if (e.children && e.children.length > 0) {
          that.selectedTreeAll(e.children, select);
        }
      });
    },
    submitPermEdit() {
      this.submitPermLoading = true;
      let permIds = "";
      let selectedNodes = this.$refs.tree.getSelectedNodes();
      selectedNodes.forEach(function(e) {
        permIds += e.id + ",";
      });
      permIds = permIds.substring(0, permIds.length - 1);
      this.postRequest("auth/role/editRolePerm/" + this.editRolePermId, {
        permIds: permIds
      }).then(res => {
        this.submitPermLoading = false;
        if (res.success === true) {
          this.$Message.success("操作成功");
          this.getRoleList();
          this.permModalVisible = false;
        }
      });
    },
    cancelPermEdit() {
      this.permModalVisible = false;
    }
  },
  mounted() {
    this.init();
  }
};
</script>
