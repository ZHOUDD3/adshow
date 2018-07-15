<template>
	<div class="modify-container">
		<div class="menu-btn">
			<span>返回</span>
			<span>选择模板</span>
			<span>保存</span>
			<span>预览</span>	
		</div>
		<div class="workarea">
			<div class="menu">
				<div class="text">
					<span @click="addText"></span>
					<span></span>
					<span @click="addDate"></span>
				</div>
				<div class="block">
					<span></span>
					<span></span>
					<span @click="addVideo"></span>
					<span></span>
					<span></span>
				</div>
				<div class="link">
					<span></span>
					<span></span>
					<span></span>
					<span></span>
					<span></span>
				</div>
				<div class="small-tool"></div>
				<div class="more">
					<span></span>
				</div>
			</div>
			<div class="show">
				<div v-if="showLeftPanel" class="left">
					<div class="left-tool">
						<span>属性</span><span style="cursor: pointer" @click="showLeftPanel=false">关闭</span>
					</div>
					<div class="left-tab">
						<span @click="tabIndex=0" :class="{'active': tabIndex === 0}">源</span>
						<span @click="tabIndex=1" :class="{'active': tabIndex === 1}">历史</span>
						<span @click="tabIndex=2" :class="{'active': tabIndex === 2}">组件</span>
					</div>
					<!--组件面板-->
					<div class="component-list" v-if="tabIndex === 2">
						<div v-for="(item, index) in componentArr" :key="index" class="component-item">
							<i :class="item.visible ? 'eye-icon' : 'eye-hide-icon'" @click="item.visible = !item.visible"></i>
							<div>
								<p>{{item.content}}</p>
							</div>
							<p>{{item.type}}</p>
							<i :class="{'unlock-icon': item.status === 'unlock', 'lock-icon': item.status === 'lock'}" @dblclick="item.status = item.status === 'lock' ? 'unlock' : 'lock' "></i>
						</div>
					</div>
					<!--历史面板-->
					<div v-else-if="tabIndex === 1">
						<div v-for="(item, index) in componentArr" :key="index" class="history-item">
							{{item.type}}
						</div>
					</div>
					<!--源面板-->
					<div v-else></div>
				</div>
				<div class="main">
					<!--文本框区域-->
					<Deformation v-for="(item, index) in txtArr" :key="index" :w="200" :h="60" :parent="true" :draggable="item.status === 'unlock'" v-show="item.visible" @dragDblclick="editText(item)">
						<p>{{item.content}}</p>
					</Deformation>
					<!--日历区域-->
					<Deformation v-for="(item, index) in dateArr" :key="`date${index}`" :w="200" :h="60" :draggable="item.status === 'unlock'" v-show="item.visible" :parent="true" @dragDblclick="editDate(item)">
						<p>{{item.content}}</p>
					</Deformation>
				</div>
				<div class="right" v-if="showRightPanel">
					<div class="right-tool">
						<span>场景</span><span style="cursor: pointer" @click="showRightPanel=false">关闭</span>
					</div>
				</div>
			</div>
		</div>
		<!--视频Dialog-->
		<video-dialog v-if="videoDialogVisible" @closeVideoDialog="videoDialogVisible = false"></video-dialog>
	</div>
</template>

<script>
import Deformation from 'deformation'
import SpaceTime from 'spacetime'
import VideoDialog from './Edit/videoDialog.vue'
export default {
	data () {
		return {
			txtArr: [],
			dateArr: [],
			componentArr: [],
			tabIndex: 2,
			showLeftPanel: true,
			showRightPanel: true,
			videoDialogVisible: false
		}
	},
	components: {
		Deformation,
		'video-dialog': VideoDialog
	},
	methods: {
		addText () {
			this.componentArr.push({
				type: '文本', 
				content: '请输入文本',
				status: 'unlock',
				visible: true
			})
			this.txtArr = this.componentArr.filter(item => {
				return item.type === '文本'
			})
		},
		addDate () {
			let date = SpaceTime().format('yyyy/MM/dd hh:mm:ss')
			this.componentArr.push({
				type: '日期',
				content: date,
				status: 'unlock',
				visible: true
			})
			this.dateArr = this.componentArr.filter(item => {
				return item.type === '日期'
			})
		},
		addVideo () {
			this.videoDialogVisible = true
		},
		editText (index) {
			debugger
		},
		editDate (item) {

		}
	},
	mounted () {
		
	}
}
</script>

<style scoped lang="less">
.modify-container {
	font-size: 14px;
	.menu-btn {
		display: flex;
		align-items: center;
		height: 30px;
		background: #d4d4dc;
		span {
			display: inline-block;
			width: 90px;
			height: 26px;
			line-height: 26px;
			border: 1px solid #ccc;
			border-radius: 5px;
			margin-right: 10px;
			cursor: pointer;
		}
	}
	.workarea {
		position: absolute;
		top: 30px;
		left: 0px;
		right: 0px;
		bottom: 0px;
		.menu {
			width: 100%;
			height: 60px;
			background: #efefef;
			display: flex;
			div {
				display: flex;
				align-items: center;
				border: 1px solid #ccc;
				margin-right: 4px;
				border-radius: 4px;
				span {
					display: inline-block;
					width: 48px;
					height: 48px;
					margin-right: 6px;
					cursor: pointer;
				}
			}
			.text {
				span{
					cursor: pointer;
					&:nth-child(1) {
						background: url('../assets/image/txt.png')
					}
					&:nth-child(2) {
						background: url('../assets/image/marquee.png')
					}
					&:nth-child(3) {
						background: url('../assets/image/date.png')
					}	
				}
			}
			.block {
				span{
					&:nth-child(1) {
						background: url('../assets/image/weather.png')
					}
					&:nth-child(2) {
						background: url('../assets/image/image.png')
					}
					&:nth-child(3) {
						background: url('../assets/image/video.png')
					}
					&:nth-child(4) {
						background: url('../assets/image/webpage.png')
					}	
					&:nth-child(5) {
						background: url('../assets/image/qrcode.png')
					}		
				}
			}
			.link {
				span{
					&:nth-child(1) {
						background: url('../assets/image/interact.png')
					}
					&:nth-child(2) {
						background: url('../assets/image/tblink.png')
					}
					&:nth-child(3) {
						background: url('../assets/image/tbunlink.png')
					}
					&:nth-child(4) {
						background: url('../assets/image/livevideo.png')
					}	
					&:nth-child(5) {
						background: url('../assets/image/doc.png')
					}		
				}
			}
			.more {
				span {
					background: url('../assets/image/more.png')
				}
			}
		}
		.show {
			position: absolute;
			top: 60px;
			bottom: 0px;
			left: 0px;
			right: 0px;
			display: flex;
			.left, .right {
				width: 160px;
				height: 100%;
			}
			.left {
				border-right: 1px solid #ccc;
				.left-tool, .left-tab {
					display: flex;
					justify-content: space-between;
				}
				.left-tool {
					background: #888;
					color: #ffffff;
				}
				.left-tab {
					background: #ddd;
					span {
						display: inline-block;
						flex: 1;
						height: 100%;
						cursor: pointer;
					}
					.active {
						background: #fff;
					}
				}
				.component-item {
					width: 150px;
					height: 43px;
					border: 1px solid #ddd;
					margin: 2px auto;
					display: flex;
					justify-content: space-between;
					align-items: center;
					div {
						width: 35px;
						height: 37px;
						border: 1px solid #179ff9;
						overflow: hidden;
						p {
							line-height: 14px;
						}
					}
					p {
						margin-bottom: 0px;
					}
					i {
						display: inline-block;
						width: 16px;
						height: 16px;
					}
					.eye-icon {
						background: url('../assets/image/show.png');
					}
					.eye-hide-icon {
						background: url('../assets/image/hide.png');
					}
					.unlock-icon {
						background: url('../assets/image/unlock.png');
					}
					.lock-icon {
						background: url('../assets/image/lock.png');
					}
				}
				.history-item {
					width: 60px;
					margin: 5px auto;
					background: #fff;
					line-height: 20px;
					padding: 5px 2px;
					border: 1px solid #666;
					overflow: hidden;
					cursor: pointer;
				}
			}
			.right {
				border-left: 1px solid #ccc;
				.right-tool, .right-tab {
					display: flex;
					justify-content: space-between;
				}
				.right-tool {
					background: #888;
					color: #ffffff;
				}
			}
			.main {
				flex: 1;
				position: relative;
			}
		}
		.vdr {
			border: 1px solid #45DBF7;
		}
	}
}
</style>