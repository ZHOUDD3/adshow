<template>
  <div class="home-container">
		<div class="header">
			<div class="logo">
				<img src="../assets/image/logo.png" alt="">
			</div>
			<div class="list">
				<!-- <span 
					v-for="(item, index) in menuList" 
					:key="index" 
					:class="{'active': tabIndex === index }"
					@click="clickItem(index)">
					{{item.title}}
				</span> -->
				<span
					:class="{'active': tabIndex === 0 }"
					@click="clickItem(0)">节目制作</span>
				<span
					:class="{'active': tabIndex === 1 }"
					@click="clickItem(1)">
				
					<el-tooltip placement="bottom">
						<div slot="content" class="tip-box">
							<span @click="showProgramInfo">节目信息</span>
							<span>节目审核</span>
						</div>
						<span>节目管理</span>
					</el-tooltip>
			</span>
				<span
					:class="{'active': tabIndex === 2 }"
					@click="clickItem(2)">终端管理</span>
				<span
					:class="{'active': tabIndex === 3 }"
					@click="clickItem(3)">系统日志</span>
				<span
					:class="{'active': tabIndex === 4 }"
					@click="clickItem(4)">系统设置</span>
			</div>
			<div class="user">
				<el-select size="mini" v-model="userItem">
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
import { getUserById } from '@/service'
export default {
  data () {
  	return {
  		tabIndex: 0,
  		menuList: [
  			{
  				title: '节目制作',
  				route: '/home/make'
  			},
  			{
  				title: '节目管理',
  				route: '/home/programManage'
  			},
  			{
  				title: '终端管理',
  				route: '/home/terminalManage'
  			},
  			{
  				title: '系统日志',
  				route: '/home/systemLog'
  			},
  			{
  				title: '系统设置',
  				route: '/home/systemManage'
  			}
  		],
  		userItem: '亿光联',
  		userList: [
  			'亿光联',
  			'退出'
  		]
  	}
  },
  methods: {
  	clickItem (index) {
	  	this.tabIndex = index
  		if (index !== 1) {
	  		this.$router.push(this.menuList[index].route)
  		}
  	},
  	showProgramInfo () {
  		this.tabIndex = 1
  		this.$router.push('/home/programManage')
  	}
  },
  mounted () {
      
  }
}
</script>

<style lang="less" scoped>
@base: 192;
.home-container {
	height: 100%;
	display: flex;
	flex-direction: column;
	.header {
		position: relative;
		height: 90rem/@base;
		background: #232e2a;
		padding-left: 154rem/@base;
		display: flex;
		justify-content: space-between;
		align-items: center;
		.logo {
			position: absolute;
			top: 50%;
			left: -20rem/@base;
			transform: translateY(-50%);
			img {
				width: 148rem/@base;
				height: 58rem/@base;
			}
		}
		.list {
			font-size: 0px;
			span {
				display: inline-block;
				width: 100rem/@base;
				height: 30rem/@base;
				line-height: 30rem/@base;
				color: #fff;
				margin-right: 40rem/@base;
				font-size: 16rem/@base;
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
			width: 100rem/@base;
			margin-right: 12rem/@base;
			.el-select {
				background: #232e2a;
			}
		}
	}
	.content {
		// height: calc(~'100% - 90px');
		flex: 1;
	}
}
</style>
