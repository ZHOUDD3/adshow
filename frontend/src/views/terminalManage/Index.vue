<template>
    <div class="container">
      <div class="header">
      	<span class="title">
      		<el-breadcrumb separator="/">
					  <el-breadcrumb-item>终端管理</el-breadcrumb-item>
					  <el-breadcrumb-item>终端信息</a></el-breadcrumb-item>
					</el-breadcrumb>
      	</span>
      	<span class="search-panel">
      		<span>
      			<label>终端名称</label>
      			<input type="text">
      		</span>
      		<span class="search">搜索</span>
      	</span>
      </div>
      <div class="tool-panel">
      	<span>清空节目</span>
      	<span>开关机设置</span>
      	<span>关机重启</span>
      	<span>编辑</span>
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
              label="终端名称">
          </el-table-column>
          <el-table-column
              prop="id"
              label="终端状态">
          </el-table-column>
          <el-table-column
              prop="size"
              label="当前节目">
          </el-table-column>
          <el-table-column
              prop="address"
              label="分辨率">
          </el-table-column>
          <el-table-column
              prop="address"
              label="软件版本">
          </el-table-column>
          <el-table-column
              prop="address"
              label="节目统计">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="showProgramStatics(scope.$index, scope.row)">展开</el-button>
              </template>
          </el-table-column>
          <el-table-column
              prop="address"
              label="详情">
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
        <div class="submit">
            <span @click="submit">确认</span>
        </div>
      </div>
      <!--节目统计弹出层-->
      <transition name="el-zoom-in-top">
        <div v-if="showStatics" class="program-popup">
          <program-statics @closeProgramStatics="showStatics = false"></program-statics>
        </div>
      </transition>
    </div>
</template>

<script>
import { 
  getProgramList,
  deleteProgram
} from '@/service'
import ProgramStatics from './ProgramStatics'
export default {
    data () {
        return {
        	programList: [],
          currentPage: 1,
          pageSize: 20,
          selectData: [],
          total: 0,
          showStatics: false
        }
    },
    components: {
      ProgramStatics
    },
    methods: {
    	selectProgram (selection) {
        this.selectData = selection
    	},
    	selectAll (selection) {
        this.selectData = selection
    	},
      submit () {

      },
      getProgramByPage (page) {
        if (page) {
          this.currentPage = page
        }
        getProgramList({
          current: this.currentPage,
          size: this.pageSize
        }).then(res => {
          if (res.data.success) {
            this.programList = res.data.data
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
        deleteProgram(deleteArr.join(',')).then(res => {
          if (res.data.success) {
            this.programList = this.programList.filter(item => {
              return !~deleteArr.indexOf(item.id)
            })
          }
        })
        this.selectData = []
      },
      showProgramStatics () {
        this.showStatics = true
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
  position: relative;
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
    height: 620rem/@base;
	}
  .bottom {
    padding: 0 58rem/@base;
    .pager {
      display: flex;
      justify-content: flex-end;
      background: #fff;
    }
  }
  .program-popup {
    position: absolute;
    width: 1200px;
    height: 500px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
}
</style>
