<template>
    <div class="container">
      <div class="header">
      	<span class="title">
      		<el-breadcrumb separator="/">
					  <el-breadcrumb-item>节目管理</el-breadcrumb-item>
					  <el-breadcrumb-item>节目信息</el-breadcrumb-item>
					</el-breadcrumb>
      	</span>
      	<span class="search-panel">
      		<span>
      			<label>节目名称</label>
      			<input type="text" v-model="name">
      		</span>
      		<span>
      			<label>创建时间</label>
      			<input type="text" v-model="createTime">
      		</span>
      		<span class="search" @click="getProgramByPage(1)">搜索</span>
      	</span>
      </div>
      <div class="tool-panel">
      	<span>复制</span>
      	<span>编辑</span>
      	<span>发布</span>
      	<span>导出</span>
      	<span @click="deleteProgram">删除</span>
      </div>
      <div class="content">
      	<el-table
          :data="programList"
          height="100%"
          @select="selectProgram"
          @select-all="selectAll"
          style="width: 100%">
          <el-table-column
              type="selection"
              width="55">
          </el-table-column>
          <el-table-column
              prop="name"
              label="节目名称">
          </el-table-column>
          <el-table-column
              align="left"
              label="预览">
              <template slot-scope="scope">
                <div class="preview-box">
                  <img :src="scope.row.previewImage" style="cursor: pointer" @click="previewProgram(scope.$index, scope.row)">
                </div>
              </template>
          </el-table-column>
          <el-table-column
              prop="programDuration"
              label="节目时长">
          </el-table-column>
          <el-table-column
              prop="updateTime"
              :formatter="formatTime"
              label="更新时间">
          </el-table-column>
          <el-table-column
              prop="resolution"
              label="分辨率">
          </el-table-column>
          <el-table-column
              prop="address"
              label="当前状态">
          </el-table-column>
          <el-table-column
              prop="createUser"
              label="创建人">
          </el-table-column>
          <el-table-column
              prop="programDescription"
              label="备注">
          </el-table-column>
        </el-table>
      </div>
      <div class="bottom">
        <div class="pager">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            :page-size="pageSize"
            :current-page="currentPage"
            @current-change="getProgramByPage"
            @prev-click="getProgramByPage"
            @next-click="getProgramByPage">
          </el-pagination>
        </div>
      </div>
      <transition name="el-zoom-in-center">
        <preview-dialog
          v-if="dialogVisible"
          ref="preview"
          :programId="programId"
          :componentArr="componentArr"
          @closePreview="closePreview">
        </preview-dialog>
      </transition>
    </div>
</template>

<script>
import {
  getProgramList,
  deleteProgram
} from '@/service'
import Preview from  './Preview'
export default {
    data () {
        return {
        	programList: [],
          currentPage: 1,
          pageSize: 15,
          selectData: [],
          total: 0,
          name: '',
          createTime: '',
          componentArr: [],
          dialogVisible: false,
          programId: ''
        }
    },
    components: {
      'preview-dialog': Preview
    },
    methods: {
    	selectProgram (selection) {
        this.selectData = selection
    	},
    	selectAll (selection) {
        this.selectData = selection
    	},
      getProgramByPage (page) {
        if (page) {
          this.currentPage = page
        }
        getProgramList({
          current: this.currentPage,
          size: this.pageSize,
          name: this.name,
          createTime: this.createTime
        }).then(res => {
          if (res.data.success) {
            this.programList = res.data.data
            this.programList.forEach(item => {
              if(item.previewImage){
                item.previewImage = process.env.BASE_API + item.previewImage;
              }
            })
            this.total = Math.ceil(res.data.total / this.pageSize)
          }
        })
      },
      deleteProgram () {
        if (this.selectData.length === 0) {
          return
        }
        let deleteArr = []
        this.selectData.forEach(item => {
            deleteArr.push(item.id)
        })
        deleteProgram({
          ids: deleteArr.join(',')
        }).then(res => {
          if (res.data.success) {
            this.programList = this.programList.filter(item => {
              return !~deleteArr.indexOf(item.id)
            })
          }
        })
        this.selectData = []
      },
      formatTime (row, colums, cellValue, index) {
        return this.$spacetime(cellValue).format('yyyy-MM-dd')
      },
      previewProgram (index, row) { // 预览节目
        this.programId  = row.id
        this.dialogVisible = true
      },
      closePreview () {
        this.dialogVisible = false
      }
    },
    mounted () {
      this.getProgramByPage()
    }
}
</script>

<style lang="less" scoped>
@base: 192;
.container {
	height: 100%;
	background: #f4f4f2;
	.header {
		display: flex;
		justify-content: space-between;
		padding-top: 34rem/@base;
		span {
			display: inline-block;
		}
		.title {
			padding-left: 64rem/@base;
		}
		.search-panel {
			padding-right: 58rem/@base;
			input {
				outline: none;
        height: 18px;
        line-height: 18px;
        margin-right: 12px;
        padding: 0 6px;
			}
      .search {
        display: inline-block;
        width: 50px;
        height: 20px;
        line-height: 20px;
        background: #23303b;
        text-align: center;
        color: #fff;
        cursor: pointer;
        border-radius: 8px;
        &:hover {
          background: #151e25;
        }
      }
		}
	}
	.tool-panel {
		display: flex;
		padding-right: 58rem/@base;
		justify-content: flex-end;
    margin: 20px 0;
    span {
      display: inline-block;
      width: 70px;
      height: 26px;
      line-height: 26px;
      margin-left: 10px;
      background: #23303b;
      text-align: center;
      color: #fff;
      cursor: pointer;
      border-radius: 8px;
      &:hover {
        background: #151e25;
      }
    }
	}
	.content {
    margin: 0 58rem/@base;
    height: 702rem/@base;
	}
  .bottom {
    margin-top: 12px;
    padding: 0 58rem/@base;
    .pager {
      display: flex;
      justify-content: flex-end;
    }
  }
  .preview-box {
    display: flex;
    justify-content: flex-start;
    align-items: center;
  }
}
</style>
