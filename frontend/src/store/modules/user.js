import { getUserInfo } from '@/service'
const user = {
	state: {
		user: '',
		token: ''
	},
	mutations: {
		'SET_TOKEN': (state, token) => {
			state.token = token
		}
	},
	actions: {
		GetUserInfo({ commit, state }) {
			return new Promise((resolve, reject) => {
				getUserInfo({
					token: state.token
				}).then(response => {

				})
			})
		}
	}
}

export default user