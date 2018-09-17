import request from './http-common'

export function getUserById (id) {
	return request({
		url: 'user/' + id,
		method: 'GET'
	})
}

// 查询所有用户
export function getAllUser () {
	return request({
		url: '/auth/user/all',
		method: 'GET'
	})
}

// 查询所有视频素材
export function getVideoList () {
	return request({
		url: 'ad/video/all',
		method: 'GET'
	})
}

// 分页查询视频素材
export function getVideoListByPage (pageObj) {
	let {current, size, name} = pageObj
	return request({
		url: '/ad/video/list',
		method: 'POST',
		data: {
			current,
			size,
			name
		}
	})
}

//分页获取图片资源
export function getImageByPage (pageObj) {
	let {current, size} = pageObj
	return request({
		url: 'ad/picture/list',
		method: 'POST',
		params: {
			current,
			size
		}
	})
}

// 获取音乐资源
export function getMusicByPage (pageObj) {
	let {current, size} = pageObj
	return request({
		url: 'ad/music/list',
		method: 'POST',
		params: {
			current,
			size
		}
	})
}

// 删除视频
export function deleteVideo (ids) {
	return request({
		url: '/ad/video/delete',
		method: 'POST',
		params: {
			ids
		}
	})
}

// 获取视频流
export function previewVideo (id) {
	return request({
		url: '/ad/video/view/' + id,
		method: 'GET'
	})
}

// 删除图片
export function deleteImage (ids) {
	return request({
		url: '/ad/picture/delete',
		method: 'POST',
		params: {
			ids
		}
	})
}

// 删除音乐
export function deleteMusic (ids) {
	return request({
		url: '/ad/music/delete',
		method: 'POST',
		params: {
			ids
		}
	})
}

// 创建节目
export function createProject (data) {
	return request({
		url: '/ad/program/create',
		method: 'POST',
		data
	})
}

// 获取节目列表
export function getProgramList (data) {
	return request({
		url: '/ad/program/list',
		method: 'POST',
		data
	})
}

// 删除节目
export function deleteProgram (data) {
	return request({
		url: '/ad/program/delete',
		method: 'POST',
		data
	})
}

// 登录接口
export function login (params) {
	return request({
		url: '/auth/login',
		method: 'POST',
		data: params
	})
}

// 获取用户信息
export function getUserInfo (data) {
	return request({
		url: '/auth/user/info',
		method: 'POST',
		data
	})
}

// 登录获取验证码
export function getValidCode () {
	/*return request({
		url: '/kaptcha/defaultKaptcha',
		method: 'GET'
	})*/
	return process.env.BASE_API + 'kaptcha/defaultKaptcha?t=' + Math.random()
}