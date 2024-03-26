import axios from 'axios';
const baseUrl="http://localhost:8080"
class AdminService{
    constructor(){
    }

    login(adminCreds){

        // const std = {
        //    userName : "ac@gmail.com",
        //    password : "2000-02-18"
        // }
        console.log(adminCreds)
         return axios.post("http://localhost:8080/users/signin",adminCreds)
      }
}

export default new AdminService();