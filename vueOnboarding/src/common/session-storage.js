export const getMyName = () => sessionStorage.getItem('MYNAME');

export const setMyName = (myName) => sessionStorage.setItem('MYNAME', myName);