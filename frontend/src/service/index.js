import request from './http-common'
import formRequest from './formRequest'
import axios from "axios/index";
import {getStore} from "../utils/storage";

export const getRequest = (url, params) => {
  let accessToken = getStore('accessToken');
  return axios({
    method: 'get',
    url: `${process.env.BASE_API}${url}`,
    params: params,
    headers: {
      'accessToken': accessToken
    }
  });
};

export const postRequest = (url, params) => {
  debugger;
  let accessToken = getStore("accessToken");
  return axios({
    method: 'post',
    url: `${process.env.BASE_API}${url}`,
    data: params,
    transformRequest: [function (data) {
      let ret = '';
      for (let it in data) {
        ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&';
      }
      return ret;
    }],
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      'accessToken': accessToken
    }
  });
};

export const putRequest = (url, params) => {
  let accessToken = getStore("accessToken");
  return axios({
    method: 'put',
    url: `${process.env.BASE_API}${url}`,
    data: params,
    transformRequest: [function (data) {
      let ret = '';
      for (let it in data) {
        ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&';
      }
      return ret;
    }],
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      'accessToken': accessToken
    }
  });
};

export const deleteRequest = (url, params) => {
  let accessToken = getStore('accessToken');
  return axios({
    method: 'delete',
    url: `${process.env.BASE_API}${url}`,
    params: params,
    headers: {
      'accessToken': accessToken
    }
  });
};

export const uploadFileRequest = (url, params) => {
  let accessToken = getStore('accessToken');
  return axios({
    method: 'post',
    url: `${process.env.BASE_API}${url}`,
    params: params,
    headers: {
      'accessToken': accessToken
    }
  });
};

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
	return formRequest({
		url: '/ad/program/list',
		method: 'POST',
		data
	})
}

// 获取审核列表
export function getPublishList (data) {
	return formRequest({
		url: '/ad/programPublish/list',
		method: 'POST',
		data
	})
}

// 删除节目
export function deleteProgram (data) {
	return formRequest({
		url: '/ad/program/delete',
		method: 'POST',
		data
	})
}

// 登录接口
export function login (params) {
	return formRequest({
		url: '/auth/login',
		method: 'POST',
		data: params
	})
}

// 获取用户信息
export function getUserInfo (data) {
	return formRequest({
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

// 根据节目id预览节目
export function previewProgram (data) {
	return formRequest({
		url: '/ad/program/view',
		method: 'POST',
		data
	})
}

// 获取审核节目
export function getCheckProgram (id) {
	return request({
		url: '/ad/programPublish/' + id,
		method: 'GET'
	})
}


// 审核节目
export function CheckProgram (data) {
	return request({
		url: '/ad/programPublish',
		method: 'POST',
		data
	})
}
