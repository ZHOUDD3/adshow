import axios from 'axios'

const AXIOS = axios.create({
  baseURL: process.env.BASE_API
})

export default AXIOS