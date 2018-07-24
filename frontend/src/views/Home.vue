<template>
  <div class="home-container">
		<div class="header">
			<div class="list">
				<span 
					v-for="(item, index) in menuList" 
					:key="index" 
					:class="{'active': tabIndex === index }"
					@click="tabIndex=index">
					{{item.title}}
				</span>
			</div>
			<div class="user">
				<el-select v-model="userItem">
					<el-option v-for="(item, index) in userList" :key="index" :value="item" :label="item">

					</el-option>
				</el-select>
			</div>
		</div>
		<div class="content">
			<router-view></router-view>
		</div>
  </div>
</template>

<script>
export default {
  data () {
  	return {
  		tabIndex: 0,
  		menuList: [
  			{title: '节目制作'},
  			{title: '节目管理'},
  			{title: '终端管理'},
  			{title: '系统日志'},
  			{title: '系统设置'}
  		],
  		userItem: '亿光联',
  		userList: [
  			'亿光联'
  		]
  	}
  },
  methods: {

  },
  mounted () {
      
  }
}
</script>

<style lang="less" scoped>
.home-container {
	height: 100%;
	.header {
		height: 60px;
		background: #232e2a;
		padding-left: 140px;
		display: flex;
		justify-content: space-between;
		align-items: center;
		.list {
			font-size: 0px;
			span {
				display: inline-block;
				width: 100px;
				height: 30px;
				line-height: 30px;
				color: #fff;
				margin-right: 40px;
				font-size: 16px;
				font-weight: bold;
				text-align: center;
				border-radius: 4px;
				cursor: pointer;
				&:hover,
				&:active {
					background: #fe4a76;
				}
			}
			.active {
				background: #fe4a76;
			}
		}
		.user {
			width: 100px;
			margin-right: 12px;
			.el-select {
				background: #232e2a;
			}
		}
	}
	.content {
		height: calc(~'100% - 60px');
	}
}
</style>
