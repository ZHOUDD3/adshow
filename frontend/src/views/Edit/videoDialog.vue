<template>
    <div>
        <el-dialog title="视频" :visible.sync="videoDialogVisible" width="60%" :before-close="handleClose">>
            <div class="dialog-menu">
                <div class="select">
                    <span>
                        <label>名称</label>
                        <el-input v-model="videoName"></el-input>
                    </span>
                    <span>
                        <label>分类</label>
                        <el-select v-model="videoType">
                            <el-option v-for="item in typeArr" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </span>
                </div>
                <div class="btn">
                    <span>搜索</span>
                    <span>大文件上传</span>
                    <span>断点上传</span>
                    <span>上传</span>
                </div>
            </div>
            <div class="video-content">
                <div class="tree-list">
                    <el-tree :data="menuTree" show-checkbox ref="tree" highlight-current>
                    </el-tree>
                </div>
                <div class="table-list">
                    <div class="list-content">
                        <el-table 
                        		:data="videoList"
                        		 @selection-change="handleSelectionChange">
                            <el-table-column type="selection" width="55">
                            </el-table-column>
                            <el-table-column prop="name" label="视频名称">
                            </el-table-column>
                            <el-table-column prop="type" label="分类" width="80">
                            </el-table-column>
                            <el-table-column prop="src" label="视频路径">
                            </el-table-column>
                            <el-table-column prop="rate" label="分辨率" width="100">
                            </el-table-column>
                            <el-table-column prop="size" label="大小" width="80">
                            </el-table-column>
                        </el-table>
                    </div>
                    <div class="pagination">
                        <el-pagination small layout="prev, pager, next" :total="50">
                        </el-pagination>
                    </div>
                </div>
            </div>
            <div class="select-menu">
                <div>
                    <span>已选择素材列表</span>
                </div>
                <div class="select-btn">
                    <span>添加</span>
                    <span>删除</span>
                </div>
            </div>
            <div class="select-list">
                <el-table :data="searchList">
                    <el-table-column type="selection" width="55">
                    </el-table-column>
                    <el-table-column prop="name" label="视频名称">
                    </el-table-column>
                    <el-table-column prop="type" label="分类" width="80">
                    </el-table-column>
                    <el-table-column prop="src" label="视频路径">
                    </el-table-column>
                    <el-table-column prop="rate" label="分辨率" width="100">
                    </el-table-column>
                    <el-table-column prop="size" label="大小" width="80">
                    </el-table-column>
                </el-table>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="handleClose">取 消</el-button>
                <el-button type="primary" @click="handleSure">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
export default {
  data() {
    return {
      typeArr: [],
      videoType: '',
      videoName: '',
      videoDialogVisible: true,
      menuTree: [
        {
          id: 1,
          label: '视频',
          children: [
            {
              id: 2,
              label: '15s广告'
            },
            {
              id: 3,
              label: '公益广告'
            }
          ]
        }
      ],
      videoList: [
        {
          name: '爱剪辑-水神2.mp4 [103秒]',
          type: '视频',
          src: '/Project/Video/2018071410332.',
          rate: '*',
          size: '62.85MB'
        },
        {
          name: '爱剪辑-水神2.mp4 [103秒]',
          type: '视频',
          src: '/Project/Video/2018071410332.',
          rate: '*',
          size: '62.85MB'
        }
      ],
      searchList: []
    }
  },
  methods: {
    handleClose() {
      this.$emit('closeVideoDialog')
    },
    handleSure () {
        this.$emit('closeVideoDialog')
    },
    handleSelectionChange (val) {
    	 this.searchList = val
    }
  }
}
</script>

<style lang="less" scoped>
.dialog-menu {
  display: flex;
  height: 40px;
  align-items: center;
  background: #32011e;
  .select {
    flex-basis: 38%;
    display: flex;
    span {
      display: flex;
      align-items: center;
      label {
        display: inline-block;
        width: 40px;
        color: #fff;
      }
    }
  }
  .btn {
    flex-basis: 62%;
    display: flex;
    justify-content: flex-end;
    span {
      display: inline-block;
      width: 80px;
      height: 26px;
      line-height: 26px;
      background: #e7e7e7;
      border-radius: 4px;
      margin-left: 6px;
      text-align: center;
      cursor: pointer;
    }
  }
}
.video-content {
  display: flex;
  background: #bfc2cb;
  height: 240px;
  .tree-list {
    flex-basis: 30%;
    height: 100%;
    background: #fff;
    border-right: 1px solid #ccc;
  }
  .table-list {
    flex-basis: 70%;
    display: flex;
    background: #fff;
    flex-direction: column;
    justify-content: space-between;
    .list-content {
    }
    .pagination {
      display: flex;
      justify-content: flex-end;
    }
  }
}
.select-menu {
  display: flex;
  justify-content: space-between;
  background: #bfc2cb;
  height: 30px;
  align-items: center;
  .select-btn {
    display: flex;
    justify-content: flex-end;
    span {
      display: inline-block;
      width: 80px;
      margin-right: 8px;
      height: 26px;
      line-height: 26px;
      border-radius: 4px;
      background: #e7e7e7;
      text-align: center;
      cursor: pointer;
    }
  }
}
.select-list {
	height: 240px;
}
</style>

