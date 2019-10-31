import Axios from "axios";


let JWTToken;
export function authenticate(user,onSuccess,onFailure) {
    Axios.post("http://localhost:8080/authenticate",user).then((response) => {
       let token = response.data.jwttoken;
       localStorage.setItem('jwttoken',token);
        onSuccess();
    }).catch((response) => {
        onFailure();
    })
};

export default JWTToken;