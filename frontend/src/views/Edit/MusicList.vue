<template>
    <div class="video-container">
        <div class="header" @click="close">{{title}}</div>
        <div class="tool">
            <input type="text" v-model="name" class="search" @keyup.enter="searchMusic" placeholder="搜索...">
            <div class="btn-box">
                <el-upload
                    ref="upload"
                    class="upload-box"
                    :show-file-list="false"
                    :on-success="getMusicByPage"
                    :data="uploadParams"
                    :action="GLOBAL.DOMAIN + 'ad/music/upload'"
                    >
                    <span @click="uploadMeterial">上传
                    </span>
                </el-upload>
                <span @click="deleteMeterial">删除</span>
            </div>
        </div>
        <div class="content">
            <el-table
                :data="tableData"
                height="'100%'"
                @select="pushMeterial"
                @select-all="pushAll"
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
                    prop="timeLength"
                    label="时长">
                </el-table-column>
                <el-table-column
                    prop="size"
                    label="大小">
                </el-table-column>
                <el-table-column
                    prop="address"
                    label="上传时间">
                </el-table-column>
                <el-table-column
                    prop="address"
                    label="操作">
                </el-table-column>
            </el-table>
        </div>
        <div class="pager" v-if="total !== 0">
          <el-pagination
            background
            layout="prev, pager, next"
            :page-size="pageSize"
            :current-page="currentPage"
            :total="total"
            @current-change="getMusicByPage"
            @prev-click="getMusicByPage"
            @next-click="getMusicByPage">
          </el-pagination>
        </div>
        <div class="submit">
            <span @click="addMusic">确认</span>
        </div>
    </div>
</template>

<script>
import {getMusicByPage, deleteMusic} from '@/service'
export default {
    data () {
        return {
            tableData: [],
            uploadParams: {
                fileType: 'MUSIC'
            },
            pageSize: 15,
            currentPage: 1,
            selectData: [],
            name: '',
            total: 0
        }
    },
    props: {
        title: {
            type: String,
            default: ''
        }
    },
    methods: {
        close () {
          this.$emit('closeMusicListDialog')
        },
        uploadMeterial () {

        },
        pushMeterial (selection) {
            this.selectData = selection
        },
        pushAll (selection) {
            this.selectData = selection
        },
        deleteMeterial () {
            let deleteArr = []
            this.selectData.forEach(item => {
                deleteArr.push(item.id)
            })
            deleteMusic(deleteArr.join(',')).then(res => {
                if (res.data.success === true) {
                    this.tableData = this.tableData.filter(item => {
                        return !~deleteArr.indexOf(item.id)
                    })
                }
            })
        },
        addMusic () {
            this.$emit('addMusic', this.selectData)
            this.$emit('closeMusicListDialog')
        },
        getMusicByPage (page) {
            if (typeof page === 'number') {
                this.currentPage = page
            }
            getMusicByPage({
                current: this.currentPage,
                size: this.pageSize,
                name: this.name
            }).then(res => {
                if (res.data.success === true) {
                    this.total = res.data.total
                    this.tableData = res.data.data
                }
            })
        },
        searchMusic () {
            this.getMusicByPage(1)
        }
    },
    mounted () {
        this.getMusicByPage(1)
    }
}
</script>
<style lang="less" scoped>
.video-container {
    position: absolute;
    top: 10%;
    left: 10%;
    right: 10%;
    bottom: 10%;
    background: #fff;
    border-radius: 6px;
    z-index: 10;
    .header {
        height: 60px;
        line-height: 60px;
        background: #232e3a;
        color: #fff;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        position: relative;
        pointer-events: none;
        &::after {
            content: '';
            display: inline-block;
            width: 32px;
            height: 32px;
            position: absolute;
            top: 50%;
            right: 0;
            cursor: pointer;
            transform: translate(-50%, -50%);
            background: url('../../assets/image/close.png');
            pointer-events: auto;
        }
    }
    .tool {
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 60px;
        .search {
            width: 240px;
            height: 30px;
            margin-left: 20px;
            padding-left: 30px;
            background: #fff;
            border: none;
            outline: none;
            border-bottom: 1px solid #ccc;
        }
        .btn-box {
            width: 180px;
            height: 30px;
            margin-right: 20px;
            display: flex;
            justify-content: space-between;
            span {
                display: inline-block;
                width: 80px;
                height: 24px;
                line-height: 24px;
                text-align: center;
                background: #222f3a;
                color: #fff;
                border-radius: 4px;
                cursor: pointer;
            }
        }
    }
    .content {
        height: calc(~'100% - 220px');
        width: 96%;
        margin: 0 auto;
        background: #ddd;
        border-radius: 8px;
        box-shadow: 0 0 4px #999;
    }
    .submit {
        display: flex;
        justify-content: flex-end;
        align-items: center;
        span {
            display: inline-block;
            width: 120px;
            height: 40px;
            margin-right: 40px;
            line-height: 40px;
            background: #ff4b76;
            color: #fff;
            text-align: center;
            cursor: pointer;
        }
    }
    .pager {
        margin-top: 10px;
        margin-right: 30px;
    }
    .el-table {
        height: 100%;
    }
}
</style>

