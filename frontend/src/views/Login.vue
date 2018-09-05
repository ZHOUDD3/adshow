<template>
  <div class="login-wrap">
  	<div class="login-container">
  		<div class="logo">
  			<img src="../assets/image/login_logo.png" alt="">
  		</div>
  		<el-form :model="loginForm" status-icon :rules="rules" ref="loginForm" class="demo-loginForm">
			  <el-form-item label="" prop="username">
			    <el-input type="text" placeholder="账号" v-model="loginForm.username" auto-complete="off"></el-input>
			  </el-form-item>
			  <el-form-item label="" prop="password">
			    <el-input type="password" placeholder="密码" v-model="loginForm.password" auto-complete="off"></el-input>
			  </el-form-item>
        <el-form-item v-if="showValidCode" label="" prop="picCode">
          <div class="valid-box">
            <el-input placeholder="验证码" v-model="loginForm.picCode" auto-complete="off"></el-input>
            <img @click="getValid" :src="validSrc" alt="">
          </div>
        </el-form-item>
			  <el-form-item>
					<div class="item-box">
						<el-checkbox v-model="remberPass">记住我</el-checkbox>
						<span>忘记密码</span>
					</div>
			  </el-form-item>
			  <el-form-item>
			    <div class="btn-box">
			    	<el-button type="info" size="medium" @click="submitForm('loginForm')">登&nbsp;&nbsp;录</el-button>
			    </div>
			  </el-form-item>
			  <el-form-item>
					<div class="register-box">
						<span>没有账号？立即注册</span>
					</div>
			  </el-form-item>
			</el-form>
  	</div>
  </div>
</template>

<script>
import {
    login,
    getUserInfo,
    getValidCode
} from '@/service'
export default {
  data () {
  	let checkAccount = (rule, value, callback) => {
  		if (/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/.test(value)) {
  			callback()
  		} else {
  			callback(new Error('用户名输入不正确'))
  		}
  	}
  	let checkPassword = (rule, value, callback) => {
  		/*if (/^(?=.*\d)(?=.*[a-zA-Z]).{6,20}$/.test(value)) {
  			callback()
  		} else {
  			callback(new Error('密码格式不正确'))
  		}*/
  		callback()
  	}
  	return {
  		loginForm: {
  			username: '',
  			password: '',
        picCode: '' // 图片验证码
  		},
  		rules: {
  			username: [
  				{required: true, message: '请输入账号'},
  				{validator: checkAccount}
  			],
  			password: [
  				{required: true, message: '请输入密码'},
  				{validator: checkPassword}
  			],
        picCode: [
          {required: true, message: '请输入验证码'}
        ]
  		},
  		remberPass: false,
      showValidCode: false,
      validSrc: '' // 图片验证码地址
  	}
  },
  methods: {
  	submitForm () {
  		this.$refs.loginForm.validate(valid => {
  			if (valid) {
  				/*login({
  					username: this.loginForm.username,
  					password: this.loginForm.password
  				}).then(res => {
  					if (res.data.success) {
              this.$store.commit('SET_TOKEN', res.data.result)
              this.$store.dispatch('GetUserInfo', res.data.result)
  						this.$router.push('/home')
  					} else {
  						this.$message({
  							type: 'error',
  							message: res.data.message
  						})
  					}
  				})*/
          this.$axios.post(this.GLOBAL.DOMAIN + 'auth/login', {
            username: this.loginForm.username,
            password: this.loginForm.password,
            validCode: this.loginForm.picCode
          }).then(res => {
            if (res.data.success) {
              // 登录成功
              this.$store.commit('SET_TOKEN', res.data.result)
              // this.$store.dispatch('GetUserInfo', res.data.result)
              this.$axios({
                url: this.GLOBAL.DOMAIN + 'auth/user/info',
                method: 'GET',
                headers: {
                  accesstoken: res.data.result
                },
                data: {
                  token: res.data.result
                }
              }).then(res => {
                
              })
              this.$router.push('/home')
            } else {
              this.$message({
                type: 'error',
                message: res.data.message
              })
              if (res.data.code === 10001) {
                // 重新登录需要密码
                this.getValid()
                this.showValidCode = true
              }
            }
          })
  			}
  		})
  	},
  	resetForm () {

  	},
    getValid () {
      this.validSrc = getValidCode()
    }
  },
  mounted () {
   // this.validSrc = getValidCode()
  }
}
</script>

<style lang="less" scoped>
@base: 192;
.login-wrap {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background: #232f3b;
	.login-container {
		width: 420rem/@base;
		padding: 0 50rem/@base;
		background: #fff;
		border-radius: 4px;
		.logo {
			display: flex;
			justify-content: center;
			padding: 50rem/@base 0;
		}
		.item-box {
			display: flex;
			justify-content: space-between;
			span {
				cursor: pointer;
				color: #409eff;
			}
		}
		.register-box {
			display: flex;
			justify-content: center;
			span {
				cursor: pointer;
				color: #409eff;
			}
		}
		.btn-box {
			display: flex;
			justify-content: center;
		}
    .valid-box {
      display: flex;
      justify-content: space-between;
      align-items: center;
      img {
        width: 150px;
        height: 30px;
        margin-left: 16px;
      }
    }
	}
}
</style>
