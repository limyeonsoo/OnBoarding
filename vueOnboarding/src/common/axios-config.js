import axios from 'axios';

const HTTP = () => {
    return axios.create({
        baseURL: ''
    });
}

export default HTTP();