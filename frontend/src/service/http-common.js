import axios from 'axios'
import { Message } from 'element-ui'
import {getStore} from "../utils/storage";

const request = axios.create({
  baseURL: process.env.BASE_API,
  headers: {
  	// 'Content-Type': 'application/x-www-form-urlencoded'
  }
})

// add a request interceptor
request.interceptors.request.use(config => {
	return config
}, error => {
	return Promise.reject(error)
})

//add a response interceptor
request.interceptors.response.use(response => {
	if (response.data.success) {

	} else {
		Message({
			type: 'error',
			message: response.data.message
		})
	}
	return response
}, error => {
	return Promise.reject(error)
})
export default request
