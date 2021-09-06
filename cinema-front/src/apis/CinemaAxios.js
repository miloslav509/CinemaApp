import axios from 'axios';
import { logout } from '../services/Auth';
import jwt_decode from 'jwt-decode';

var CinemaAxios = axios.create({
    baseURL: 'http://localhost:8080/api',
});

CinemaAxios.interceptors.request.use(
    function succes(config) {
        const jwt = window.localStorage['jwt'];
        if(jwt){
            const decode = jwt_decode(jwt)
            console.log(Date.now())
            if(decode.exp_date<Date.now()) {
                alert("Istekao jwt")
                logout()
                return false
            }
            config.headers['Authorization'] = 'Bearer' + jwt;
        }
        return config;
    }
);

CinemaAxios.interceptors.response.use(
    function success(response) {
        return response;
    },
    function failure(error) {
        let jwt = window.localStorage['jwt'];
        if(jwt) {
            if(error.response && error.response.status == 403){
                logout();
            }
        }

        throw error;
    }
);

export default CinemaAxios;
