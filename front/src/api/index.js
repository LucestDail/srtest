import axios from 'axios';
import config from '../config';

const { SERVER_URI } = config;

export const getHello = async () => {
    const response = await axios.get(`${SERVER_URI}/sample`);
    return response;
}

export const postJson = async (jsonData) => {
    const response = await axios.post(`${SERVER_URI}/postJson`, jsonData);
    return response;
}