import axios from 'axios'


const AXIOS = axios.create({
  baseURL: process.env.BASE_API,
  headers: {
  	'Content-Type': 'application/x-www-form-urlencoded'
  }
})
export default AXIOS