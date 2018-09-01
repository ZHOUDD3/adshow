import axios from 'axios'


const AXIOS = axios.create({
  baseURL: process.env.BASE_API
})


AXIOS.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
export default AXIOS