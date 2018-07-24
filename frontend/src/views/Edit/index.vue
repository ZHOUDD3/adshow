<template>
    <div class="edit-container">
        <div class="menu">
            <div class="menu-item"
            	v-for="(item, index) in menuList"
            	:key=index>
            	<img :src="item.icon" alt="">
            	<span>{{item.title}}</span>
            </div>
        </div>
        <div class="main">
            <div class="title">
            	
            </div>
            <div class="content">
            	
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
        	menuList: [
        		{
        			icon: require('../../assets/image/vid.png'),
        			title: '视频插入'
        		},
        		{
        			icon: require('../../assets/image/img_icon.png'),
        			title: '插入图片'
        		},
        		{
        			icon: require('../../assets/image/music.png'),
        			title: '背景音乐'
        		},
        		{
        			icon: require('../../assets/image/text.png'),
        			title: '插入文字'
        		},
        		{
        			icon: require('../../assets/image/calendar.png'),
        			title: '日期插入'
        		},
        		{
        			icon: require('../../assets/image/mar_text.png'),
        			title: '滚动文字'
        		}
        	]
        }
    }
}
</script>
<style lang="less" scoped>
.edit-container {
    height: 100%;
    display: flex;
    .menu {
			width: 140px;
			display: flex;
			flex-direction: column;
			align-items: center;
			background: #232e2a;
			.menu-item {
				width: 120px;
				height: 120px;
				position: relative;
				text-align: center;
				cursor: pointer;
				border-bottom: 2px solid #535a62;
				img {
					width: 60px;
					height: 60px;
				}
				span {
					position: absolute;
					width: 100%;
					display: inline-block;
					text-align: center;
					left: 0;
					bottom: 24px;
					color: #fff;
				}
			}
    }
    .main {
			flex: 1;
			.title, .content {
				width: 70%;
				margin: 20px auto;
				border: 2px solid #2c3e50;
			}
			.title {
				height: 40px;
			}
			.content {
				height: calc(~'100% - 140px');
			}
    }
}
</style>

