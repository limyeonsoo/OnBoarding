import HTTP from './axios-config';

const host = 'http://127.0.0.1:8080'

export const getTasks = async () => {
    const tasks = await HTTP.get(host + '/todos');
    return tasks.data;
}

export const postTask = async (value) => {
    const { id } = await HTTP.post(host + '/todos', {
        member_id: -1,
        content: value
    })
    return id;
}

export const patchStatus = async (id, status) => {
    const tasks = await HTTP.patch(host + '/todos' + `/${id}`, {
        status: status
    });
    console.log(tasks);
}