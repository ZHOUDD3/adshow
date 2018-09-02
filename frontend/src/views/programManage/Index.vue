<template>
    <div class="container">
      <div class="header">
      	<span class="title">
      		<el-breadcrumb separator="/">
					  <el-breadcrumb-item :to="{ path: '/' }">节目管理</el-breadcrumb-item>
					  <el-breadcrumb-item><a href="/">节目信息</a></el-breadcrumb-item>
					</el-breadcrumb>
      	</span>
      	<span class="search-panel">
      		<span>
      			<label>节目名称</label>
      			<input type="text">
      		</span>
      		<span>
      			<label>创建时间</label>
      			<input type="text">
      		</span>
      		<span class="search">搜索</span>
      	</span>
      </div>
      <div class="tool-panel">
      	<span>复制</span>
      	<span>编辑</span>
      	<span>发布</span>
      	<span>导出</span>
      	<span>删除</span>
      </div>
      <div class="content">
      	<el-table
          :data="tableData"
          height="'100%'"
          @select="selectProgram"
          @select-all="selectAll"
          style="width: 100%">
          <el-table-column
              type="selection"
              width="55">
          </el-table-column>
          <el-table-column
              prop="name"
              label="文件名">
          </el-table-column>
          <el-table-column
              prop="id"
              label="id">
          </el-table-column>
          <el-table-column
              prop="size"
              label="大小">
          </el-table-column>
          <el-table-column
              prop="createTime"
              label="上传时间">
          </el-table-column>
          <el-table-column
              prop="address"
              label="操作">
          </el-table-column>
      </el-table>
      </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
        	tableData: []
        }
    },
    methods: {
    	selectProgram () {

    	},
    	selectAll () {

    	}
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
			padding-right: 54rem/@base;
			input {
				outline: none;
			}
		}
	}
	.tool-panel {
		display: flex;
		padding-right: 54rem/@base;
		justify-content: flex-end;
	}
	.content {

	}
}
</style>
