import CinemaAxios from "../apis/CinemaAxios";
import jwt_decode from "jwt-decode";

export const login = async function(username, password) {
    const cred={
        username: username,
        password: password
    }

    try {
        const ret = await CinemaAxios.post('korisnici/auth', cred);
        const decode = jwt_decode(ret.data);
        console.log(decode.role.authority)
        window.localStorage.setItem('role', decode.role.authority);
        window.localStorage.setItem('jwt', ret.data);
        window.localStorage.setItem('username', username);
    }catch(error) {
        console.log(error);
    }
    window.location.reload();
} 

export const logout = function() {
    window.localStorage.removeItem('jwt');
    window.location.reload();
}