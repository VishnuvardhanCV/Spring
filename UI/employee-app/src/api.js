import axios from 'axios';
const baseUrl = 'http://localhost:8080/Employee/';

export function get(url,data) {
    return axios({
        method:'get',
        'headers' :  {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer '+localStorage.getItem('jwttoken')
          },
        data :data,
        url : url,
        baseURL :baseUrl
    }).then(function(response){
        return response;
    });
}

export function post(url,data,params) {
    return axios({
        method:'post',
        'headers' :  {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer '+localStorage.getItem('jwttoken')
          },
        data :data,
        url : url,
        baseURL :baseUrl,
        params : params
    }).then(function(response){
        return response;
    });
}