<template>
    <div class="video-container">
        <div class="header" @click="close">插入视频</div>
        <div class="tool">
            <input type="text" class="search" v-model="name" placeholder="搜索..." @keyup.enter="searchVideo">
            <div class="btn-box">
                <span>
                    <el-upload
                        ref="upload"
                        class="upload-box"
                        :show-file-list="false"
                        :data="uploadParams"
                        :on-success="getVideoList"
                        :action="GLOBAL.DOMAIN + 'ad/video/upload'"
                        >
                        <span>上传
                        </span>
                    </el-upload>
                </span><span @click="deleteVideo">删除</span>
            </div>
        </div>
        <div class="content">
            <el-table
                ref="multipleTable"
                :data="tableData"
                @select="pushVideo"
                @select-all="pushAll"
                @row-click="clickRow"
                height="'100%'"
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
                    prop="createTime"
                    :formatter="formatTime"
                    label="上传时间">
                </el-table-column>
                <el-table-column
                    label="操作">
                    <template slot-scope="scope">
                        <el-button
                          size="mini"
                          @click="previewVideo(scope.$index, scope.row)">预览</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div class="pager" v-if="total !== 0">
          <el-pagination
            background
            layout="prev, pager, next"
            :current-page="current"
            @current-change="getVideoList"
            @prev-click="getVideoList"
            @next-click="getVideoList"
            :page-size="size"
            :total="total">
          </el-pagination>
        </div>
        <div class="submit">
            <span @click="insertVideo">确认</span>
        </div>
        <video-play
            v-if="dialogVisible"
            :id="videoId"
            :name="videoName"
            @closeVideo="dialogVisible=false">
        </video-play>
    </div>
</template>

<script>
import {
    getVideoListByPage,
    deleteVideo,
    previewVideo
} from '@/service'
import VideoPlay from './Play'
export default {
    data () {
        return {
            tableData: [],
            uploadParams: {
                fileType: 'VIDEO'
            },
            current: 1,
            size: 15,
            name: '',
            selectedData: [],
            dialogVisible: false,
            videoId: '',
            videoName: '',
            total: 0
        }
    },
    props: {
        type: {
            type: String,
            default: 'add'
        }
    },
    methods: {
        close () {
          this.$emit('closeInsertVideo', 'VIDEO')
        },
        getVideoList (page) {
            if (page) {
                this.current = page
            }
            getVideoListByPage({
                current: this.current,
                size: this.size,
                name: this.name
            }).then(res => {
                this.total = res.data.total
                this.tableData = res.data.data
            })
        },
        previewVideo (index, row) {
            this.videoId = row.id
            this.videoName = row.name
            this.dialogVisible = true
        },
        pushVideo (selection, row) {
            this.selectedData = selection
        },
        pushAll (selection, row) {
            this.selectedData = selection
        },
        clickRow (row, event, column) {

        },
        insertVideo () {
            if (this.type === 'add') {
                this.$emit('insertVideo', this.selectedData)
            } else {
                this.$emit('reimportVideo', this.selectedData[0])
            }
        },
        deleteVideo () {
            let deleteArr = []
            this.selectedData.forEach(item => {
                deleteArr.push(item.id)
            })
            deleteVideo(deleteArr.join(',')).then(res => {
                if (res.data.success === true) {
                    this.tableData = this.tableData.filter(item => {
                        return !~deleteArr.indexOf(item.id)
                    })
                }
            })
        },
        searchVideo () {
            this.current = 1
            this.getVideoList()
        },
        formatTime (row, column, cellValue, index) {
            return this.$spacetime(cellValue).format('yyyy-MM-dd')
        }
    },
    components: {
        'video-play': VideoPlay
    },
    mounted () {
        this.getVideoList()
    }
}
</script>
<style lang="less" scoped>
@base: 192;
.video-container {
    position: absolute;
    top: 10%;
    left: 10%;
    right: 10%;
    bottom: 10%;
    background: #fff;
    z-index: 10;
    border-radius: 6px;
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
                height: 30px;
                line-height: 30px;
                text-align: center;
                background: #222f3a;
                color: #fff;
                border-radius: 4px;
                cursor: pointer;
                &:hover {
                    background: #10171d;
                }
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
            font-size: 16rem/@base;
            cursor: pointer;
            border-radius: 4px;
            &:hover {
                background: #ef325f;
            }
        }
    }
    .el-table {
        height: 100%;
    }
    .pager {
        margin-top: 6px;
        margin-right: 30px;
    }
}
</style>

