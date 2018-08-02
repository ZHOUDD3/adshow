import request from './http-common'

export function getUserById (id) {
	return request({
		url: 'user/' + id,
		method: 'GET'
	})
}