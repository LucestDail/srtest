import axios from 'axios';
import config from '../config';

const { SERVER_URI } = config;

export const getHello = async () => {return await axios.get(`${SERVER_URI}/sample`);}
export const postJson = async (jsonData) => {await axios.post(`${SERVER_URI}/postJson`, jsonData);}
export const getKebhanaApi = async () => {return await axios.get(`${SERVER_URI}/kebhana/today`);}
export const getKoreaeximApi = async (date) => {return await axios.get(`${SERVER_URI}/koreaexim/`+date);}