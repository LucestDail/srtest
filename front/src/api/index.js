import axios from 'axios';
import config from '../config';

const { SERVER_URI } = config;

export const getHello = async () => {
    const response = await axios.get(`${SERVER_URI}/hello`);
    return response;
}