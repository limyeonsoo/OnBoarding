import HTTP from './axios-config';

const host = 'http://127.0.0.1:8080'

export const getTasks = async () => {
    const tasks = await HTTP.get(host + '/todos');
    return tasks.data;
}