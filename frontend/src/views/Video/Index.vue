<template>
    <div class="video-container">
        <div class="header" @click="close">插入视频</div>
        <div class="tool">
            <input type="text" class="search" placeholder="搜索...">
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
                </span><span>删除</span>
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
                    label="上传时间">
                </el-table-column>
                <el-table-column
                    label="操作">
                    <template slot-scope="scope">
                        <el-button
                          size="mini"
                          @click="previewVideo(scope.$index, scope.row)">预览</el-button>
                        <el-button
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div class="submit">
            <span @click="insertVideo">确认</span>
        </div>
        <video-play 
            v-if="dialogVisible"
            @closeVideo="dialogVisible=false"> 
        </video-play>
    </div>
</template>

<script>
import {getVideoListByPage} from '@/service'
import VideoPlay from './Play'
export default {
    data () {
        return {
            tableData: [],
            uploadParams: {
                fileType: 'VIDEO'
            },
            current: 1,
            size: 10,
            name: null,
            selectedData: [],
            dialogVisible: false
        }
    },
    methods: {
        close () {
          this.$emit('closeInsertVideo', 'video')
        },
        getVideoList () {
            getVideoListByPage({
                current: this.current,
                size: this.size,
                name: this.name
            }).then(res => {
                this.tableData = res.data.data
            })
        },
        previewVideo (index, row) {
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
            this.$emit('insertVideo', this.selectedData)
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
.video-container {
    height: 100%;
    background: #fff;
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
        height: calc(~'100% - 200px');
        width: 96%;
        margin: 0 auto;
        background: #ddd;
        border-radius: 8px;
        box-shadow: 4px 4px 2px #999;
    }
    .submit {
        height: 80px;
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
    .el-table {
        height: 100%;
    }
}
</style>

