import axios from "../custom-axios/axios";
import {userUrl} from "../util/constants";

export const userRepository = {

    register: (username,name,lastname,password,repeatPassword) => {

        console.log(username,name,lastname,password,repeatPassword);
        return axios.post(userUrl+"/register",{
            username: username,
            name:name,
            lastname:lastname,
            password: password,
            repeatPassword: repeatPassword
        })
    },

    authenticate: (username,password) => {
        return axios.post(userUrl+"/authenticate",{
            username:username,
            password:password
        })
    },

    getUserByToken: (token) => {
        return axios.post(userUrl+`/get-user-by-token`,
            {
                token:token
            });
    },

    getUserById: (userId) => {
        console.log(userId);
        return axios.post(userUrl+"/get-user-by-id",userId);
    },

    checkUserValidity: (token) => {
        return axios.post(userUrl+`/user-expiration`,
            {
                token:token
            });
    }

}