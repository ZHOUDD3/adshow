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

// 删除视频
export function deleteVideo (ids) {
	return request({
		url: '/ad/video/delete',
		method: 'DELETE',
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
