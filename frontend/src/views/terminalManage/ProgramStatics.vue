<template>
    <div class="container">
        <div class="header" @click="close">节目统计</div>
        <div class="tool">
            <input type="text" class="search" placeholder="搜索...">
            <div class="btn-box">
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
        <div class="pager">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="total">
          </el-pagination>
        </div>
    </div>
</template>

<script>
import {getImageByPage, deleteImage} from '@/service'
export default {
    data () {
        return {
            tableData: [],
            uploadParams: {
                fileType: 'PICTURE'
            },
            pageSize: 15,
            currentPage: 1,
            selectData: [],
            total: 100
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
          this.$emit('closeProgramStatics')
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
            deleteImage(deleteArr.join(',')).then(res => {
                if (res.data.success === true) {
                    this.tableData = this.tableData.filter(item => {
                        return !~deleteArr.indexOf(item.id)
                    })
                }
            })
        },
        addImage () {
            if (this.type === 'add') {
                this.$emit('addImage', this.selectData)
            } else {
                this.$emit('reimportImage', this.selectData[0])
            }
            this.$emit('closeMeterialListDialog')
        }
    },
    mounted () {
        
    }
}
</script>
<style lang="less" scoped>
@base: 192;
.container {
    height: 100%;
    background: #fff;
    z-index: 10;
    box-sizing: border-box;
    border: 2px solid #232f3b;
    .header {
        height: 40px;
        line-height: 40px;
        background: #232e3a;
        color: #fff;
        text-align: center;
        font-size: 18px;
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
        height: calc(~'100% - 160px');
        width: 96%;
        margin: 0 auto;
        background: #ddd;
        box-shadow: 0 0 4px #999;
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
            font-size: 16rem/@base;
            text-align: center;
            border-radius: 4px;
            cursor: pointer;
            &:hover {
                background: #de355d
            }
        }
    }
    .el-table {
        height: 100%;
    }
    .pager {
        display: flex;
        justify-content: flex-end;
        margin-top: 10px;
        margin-right: 10px;
    }
}
</style>

