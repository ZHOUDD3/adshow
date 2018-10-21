<style lang="less">
@import "./userManage.less";
</style>
<template>
    <div class="search">
        <el-card>
            <el-row>
                <el-form ref="searchForm" :model="searchForm" inline label-width="70px" class="search-form">
                    <el-form-item label="用户名称" prop="username">
                      <el-input type="text" v-model="searchForm.username" clearable placeholder="请输入用户名" style="width: 200px"/>
                    </el-form-item>
                    <el-form-item label="手机号" prop="mobile">
                      <el-input type="text" v-model="searchForm.mobile" clearable placeholder="请输入手机号" style="width: 200px"/>
                    </el-form-item>
                    <span v-if="drop">
                      <el-form-item label="邮箱" prop="email">
                        <el-input type="text" v-model="searchForm.email" clearable placeholder="请输入邮箱" style="width: 200px"/>
                      </el-form-item>
                      <el-form-item label="性别" prop="sex">
                        <el-select v-model="searchForm.sex" placeholder="请选择" clearable style="width: 200px">
                          <el-option value="0">女</el-option>
                          <el-option value="1">男</el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="用户类型" prop="type">
                        <el-select v-model="searchForm.type" placeholder="请选择" clearable style="width: 200px">
                          <el-option value="0">普通用户</el-option>
                          <el-option value="1">管理员</el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="用户状态" prop="status">
                        <el-select v-model="searchForm.status" placeholder="请选择" clearable style="width: 200px">
                          <el-option value="0">正常</el-option>
                          <el-option value="-1">禁用</el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="创建时间">
                        <el-date-picker type="daterange" format="yyyy-MM-dd" clearable @on-change="selectDateRange" placeholder="选择起始时间" style="width: 200px"></el-date-picker>
                      </el-form-item>
                    </span>
                    <el-form-item style="margin-left:-35px;">
                      <el-button @click="handleSearch" type="primary" icon="search">搜索</el-button>
                      <el-button @click="handleReset" type="ghost" >重置</el-button>
                      <i class="dropDownIcon"></i>
                      <a class="drop-down" @click="dropDown">{{dropDownContent}}
                      </a>
                    </el-form-item>
                </el-form>
            </el-row>
            <el-row class="operation">
                <el-button @click="addUser" type="primary" icon="plus-round">添加用户</el-button>
                <el-button @click="delAll" type="ghost" icon="trash-a">批量删除</el-button>

              <el-dropdown @command="handleDropdown">
                <span class="el-dropdown-link">
                  更多操作<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="refresh">刷新</el-dropdown-item>
                  <el-dropdown-item command="exportData">导出所选数据</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </el-row>
            <el-row>
                <el-alert show-icon title="test">
                    已选择 <span class="select-count">{{selectCount}}</span> 项
                    <a class="select-clear" @click="clearSelectAll">清空</a>
                </el-alert>
            </el-row>
            <el-row class="content">
              <el-table
                ref="table"
                :data="data"
                height="100%"
                style="width: 100%">
                <el-table-column type="selection" width="60"></el-table-column>
                <el-table-column prop="username" label="用户名" sortable ></el-table-column>
                <el-table-column prop="avatar" label="头像" >
                  <template slot-scope="scope">
                    <img :src='scope.row.avatar' style="height: 35px;vertical-align: middle;" alt="">
                  </template>
                </el-table-column>
                <el-table-column prop="mobile" label="手机" ></el-table-column>
                <el-table-column prop="email" label="邮箱" ></el-table-column>
                <el-table-column prop="sex" label="性别" >
                  <template slot-scope="scope">
                    {{ scope.row.sex===1 ? '男' : '女' }}
                  </template>
                </el-table-column>
                <el-table-column prop="type" label="用户类型" >
                  <template slot-scope="scope">
                    {{ scope.row.type===1 ? '管理员' : '普通用户' }}
                  </template>
                </el-table-column>
                <el-table-column prop="status" label="状态" >
                  <template slot-scope="scope">
                    {{ scope.row.status===0 ? '启用' : '禁用' }}
                  </template>
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" sortable >
                  <template slot-scope="scope">
                    {{ scope.row.createTime | dateFormatter }}
                  </template>
                </el-table-column>
                <el-table-column prop="action" label="操作" width="300" fixed="right">
                  <template slot-scope="scope">
                    <el-button
                      size="small"
                      type="default"
                      icon="edit"
                      @click="edit(scope.$index, scope.row)">编辑
                    </el-button>
                    <el-button v-show="scope.row.status===0"
                      size="small"
                      type="info"
                      icon="setting"
                      @click="disable(scope.$index, scope.row)">禁用
                    </el-button>
                    <el-button v-show="scope.row.status!=0"
                      size="small"
                      type="info"
                      icon="setting"
                      @click="enable(scope.$index, scope.row)">启用
                    </el-button>
                    <el-button
                      size="small"
                      type="danger"
                      @click="remove(scope.$index, scope.row)">删除
                    </el-button>
                  </template>
                </el-table-column>
              </el-table>
            </el-row>
            <el-row class="bottom">
              <div class="pager">
                <el-pagination
                  background
                  layout="prev, pager, next"
                  :total="total"
                  :page-size="this.searchForm.pageSize"
                  :current-page="this.searchForm.pageNumbe"
                  @current-change="changePageSize"
                  @prev-click="changePageSize"
                  @next-click="changePageSize">
                </el-pagination>
              </div>
            </el-row>
        </el-card>

        <el-dialog :title="modalTitle" :visible.sync="userModalVisible" :mask-closable='false' style=".user-el-dialog"
                   :show-close="true"
                   :close-on-click-modal="false"
                   :close-on-press-escape="true"
                   :lock-scroll="true">
            <el-form ref="userForm" :model="userForm" label-width="70px" :rules="userFormValidate">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="userForm.username"/>
                </el-form-item>
                <el-form-item label="密码" prop="password" v-if="modalType===0" :error="errorPass">
                    <el-input type="password" v-model="userForm.password"/>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="userForm.email"/>
                </el-form-item>
                <el-form-item label="手机号" prop="mobile">
                    <el-input v-model="userForm.mobile"/>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                  <el-radio-group v-model="userForm.sex">
                    <el-radio :label="1">男</el-radio>
                    <el-radio :label="0">女</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="头像" prop="avatar">
                  <el-input v-model="userForm.avatar" placeholder="可直接填入网络图片链接" clearable style="width: 280px"/>
                  <el-button @click="viewPic(userForm.avatar)" type="ghost" icon="eye" class="view-pic">预览图片</el-button>
                  <el-upload action="/xboot/upload/file"
                          :headers="accessToken"
                          :on-success="handleSuccess"
                          :format="['jpg','jpeg','png','gif']"
                          :max-size="5120"
                          :on-format-error="handleFormatError"
                          :on-exceeded-size="handleMaxSize"
                          :before-upload="beforeUpload"
                          ref="up1"
                          class="upload">
                    <Button type="ghost" icon="ios-cloud-upload-outline">上传图片</Button>
                  </el-upload>
                </el-form-item>
                <el-form-item label="用户类型" prop="type">
                  <el-select v-model="userForm.type" placeholder="请选择">
                    <el-option :value="0">普通用户</el-option>
                    <el-option :value="1">管理员</el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="角色分配" prop="roles">
                  <el-select v-model="userForm.roles" multiple @on-change="selectRoles">
                      <el-option v-for="item in roleList" :value="item.id" :key="item.id">{{ item.name }}</el-option>
                  </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer">
                <el-button type="text" @click="cancelUser">取消</el-button>
                <el-button type="primary" :loading="submitLoading" @click="submitUser">提交</el-button>
            </div>
        </el-dialog>
        <el-dialog title="图片预览" :visible.sync="viewImage">
          <img :src="imgUrl" alt="无效的图片链接" style="width: 80%;margin: 0 auto;display: block;">
        </el-dialog>
    </div>
</template>

<script>
  import Vue from 'vue'
  import { dateFormat } from 'vuex'
  import {getStore} from "@/utils/storage";
  import {deleteRequest, getRequest, postRequest, putRequest, uploadFileRequest} from '@/service'
Vue.prototype.getRequest = getRequest;
Vue.prototype.postRequest = postRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.uploadFileRequest = uploadFileRequest;

export default {
  name: "user-manage",
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error("密码长度不得小于6位"));
      } else {
        callback();
      }
    };
    const validateMobile = (rule, value, callback) => {
      var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
      if (!reg.test(value)) {
        callback(new Error("手机号格式错误"));
      } else {
        callback();
      }
    };
    return {
      accessToken: {},
      loading: true,
      drop: false,
      dropDownContent: "展开",
      dropDownIcon: "chevron-down",
      selectCount: 0,
      selectList: [],
      imgUrl: "",
      viewImage: false,
      searchForm: {
        username: "",
        mobile: "",
        email: "",
        sex: "",
        type: "",
        status: "",
        pageNumber: 1,
        pageSize: 10,
        sort: "createTime",
        order: "desc",
        startDate: "",
        endDate: ""
      },
      modalType: 0,
      userModalVisible: false,
      modalTitle: "",
      userForm: {
        sex: 1,
        type: 0,
        avatar: "https://s1.ax1x.com/2018/05/19/CcdVQP.png",
        roles: []
      },
      userRoles: [],
      roleList: [],
      errorPass: "",
      userFormValidate: {
        username: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        mobile: [
          { required: true, message: "手机号不能为空", trigger: "blur" },
          { validator: validateMobile, trigger: "blur" }
        ],
        email: [
          { required: true, message: "请输入邮箱地址" },
          { type: "email", message: "邮箱格式不正确" }
        ]
      },
      submitLoading: false,

      data: [],
      exportData: [],
      total: 0
    };
  },
  methods: {
    init() {
      this.accessToken = {
        accessToken: getStore("accessToken")
      };
      this.getUserList();
    },
    changePage(v) {
      this.searchForm.pageNumber = v;
      this.getUserList();
      this.clearSelectAll();
    },
    changePageSize(v) {
      this.searchForm.pageSize = v;
      this.getUserList();
    },
    selectDateRange(v) {
      if (v) {
        this.searchForm.startDate = v[0];
        this.searchForm.endDate = v[1];
      }
    },
    getUserList() {
      // 多条件搜索用户列表
      this.loading = true;
      this.postRequest("auth/user/page", this.searchForm).then(res => {
        this.loading = false;
        if (res.data.success === true) {
          this.data = res.data.data;
          this.total = res.data.total;
        }
      });
    },
    handleSearch() {
      this.searchForm.pageNumber = 1;
      this.searchForm.pageSize = 10;
      this.init();
    },
    handleReset() {
      this.userForm = null;
      this.$refs.searchForm.resetFields();
      this.searchForm.pageNumber = 1;
      this.searchForm.pageSize = 10;
      // 重新加载数据
      this.init();
    },
    changeSort(e) {
      this.searchForm.sort = e.key;
      this.searchForm.order = e.order;
      if (e.order === "normal") {
        this.searchForm.order = "";
      }
      this.init();
    },
    getRoleList() {
      this.getRequest("auth/role/all").then(res => {
        if (res.data.success === true) {
          this.roleList = res.data.data;
        }
      });
    },
    handleDropdown(name) {
      if (name === "exportData") {
        if (this.selectCount <= 0) {
          this.$Message.warning("您还未选择要导出的数据");
          return;
        }
        this.$confirm({
          title: "确认导出",
          content: "您确认要导出所选 " + this.selectCount + " 条数据?",
          onOk: () => {
            this.$refs.exportTable.exportCsv({
              filename: "用户数据"
            });
          }
        });
      } else if (name === "refresh") {
        this.getUserList();
      }
    },
    selectRoles(v) {},
    cancelUser() {
      this.userModalVisible = false;
    },
    submitUser() {
      this.$refs.userForm.validate(valid => {
        if (valid) {
          let url = "/user/admin/add";
          if (this.modalType === 1) {
            // 编辑用户
            url = "/user/admin/edit";
          }
          if (this.modalType === 0) {
            if (
              this.userForm.password == "" ||
              this.userForm.password == undefined
            ) {
              this.errorPass = "密码不能为空";
              return;
            }
            if (this.userForm.password.length < 6) {
              this.errorPass = "密码长度不得少于6位";
              return;
            }
          }
          this.submitLoading = true;
          this.postRequest(url, this.userForm).then(res => {
            this.submitLoading = false;
            if (res.data.success === true) {
              this.$Message.success("操作成功");
              this.init();
              this.userModalVisible = false;
            }
          });
        }
      });
    },
    viewPic(v) {
      this.imgUrl = v;
      this.viewImage = true;
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: "不支持的文件格式",
        desc:
          "所选文件‘ " +
          file.name +
          " ’格式不正确, 请选择 .jpg .jpeg .png .gif格式文件"
      });
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: "文件大小过大",
        desc: "所选文件‘ " + file.name + " ’大小过大, 不得超过 5M."
      });
    },
    beforeUpload() {
      if(!this.$route.meta.permTypes.includes("upload")){
        this.$Message.error("此处您没有上传权限")
        return false;
      }
      return true;
    },
    handleSuccess(res, file) {
      if (res.data.success === true) {
        file.url = res.data.data;
        this.userForm.avatar = res.data.data;
      } else {
        this.$Message.error(res.message);
      }
    },
    addUser() {
      this.modalType = 0;
      this.modalTitle = "添加用户";
      this.userModalVisible = true;
      debugger;
      this.$refs.userForm && this.$refs.userForm.resetFields();
    },
    edit(i, v) {
      this.modalType = 1;
      this.modalTitle = "编辑用户";
      this.$refs.userForm && this.$refs.userForm.resetFields();
      // 转换null为""
      for (let attr in v) {
        if (v[attr] === null) {
          v[attr] = "";
        }
      }
      let str = JSON.stringify(v);
      let userInfo = JSON.parse(str);
      this.userForm = userInfo;
      let selectRolesId = [];
      this.userForm.roles.forEach(function(e) {
        selectRolesId.push(e.id);
      });
      this.userForm.roles = selectRolesId;
      this.userModalVisible = true;
    },
    enable(i, v) {

      this.$confirm("您确认要启用用户 " + v.username + " ?")
        .then(_ => {
          this.postRequest("auth/user/admin/enable/" + v.id).then(res => {
            if (res.data.success === true) {
              this.$Message.success("操作成功");
              this.init();
            }
          });
        });
    },
    disable(i, v) {
      this.$confirm("您确认要禁用用户 " + v.username + " ?")
        .then(_ => {
          this.postRequest("auth/user/admin/disable/" + v.id).then(res => {
            if (res.data.success === true) {
              this.$Message.success("操作成功");
              this.init();
            }
          });
        });
    },
    remove(i, v) {
      this.$confirm("您确认要删除用户 " + v.username + " ?")
        .then(_ => {
          this.deleteRequest("auth/user/delByIds", { ids: v.id }).then(res => {
            if (res.data.success === true) {
              this.$Message.success("删除成功");
              this.init();
            }
          });
        });
    },
    dropDown() {
      if (this.drop) {
        this.dropDownContent = "展开";
        this.dropDownIcon = "chevron-down";
      } else {
        this.dropDownContent = "收起";
        this.dropDownIcon = "chevron-up";
      }
      this.drop = !this.drop;
    },
    showSelect(e) {
      this.exportData = e;
      this.selectList = e;
      this.selectCount = e.length;
    },
    clearSelectAll() {
      this.$refs.table.selectAll(false);
    },
    delAll() {
      if (this.selectCount <= 0) {
        this.$Message.warning("您还未选择要删除的数据");
        return;
      }
      this.$confirm("您确认要删除所选的 " + this.selectCount + " 条数据?")
        .then(_ => {
          let ids = "";
          this.selectList.forEach(function(e) {
            ids += e.id + ",";
          });
          ids = ids.substring(0, ids.length - 1);
          this.deleteRequest("auth/user/delByIds", { ids: ids }).then(res => {
            if (res.data.success === true) {
              this.$Message.success("删除成功");
              this.clearSelectAll();
              this.init();
            }
          });
        });
    }
  },
  mounted() {
    this.init();
    this.getRoleList();
  }
};
</script>
