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

// 查询视频素材
export function getVideoList () {
	return request({
		url: 'ad/video/all',
		method: 'GET'
	})
}