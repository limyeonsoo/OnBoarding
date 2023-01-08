CREATE TABLE IF NOT EXISTS TASKS (
    id VARCHAR(100) NOT NULL,
    details VARCHAR(100) NOT NULL,
    taskStatus VARCHAR(100) NOT NULL
);

INSERT INTO TASKS(id, details, taskStatus)
VALUES ('help', 'me', 'PLEASE');
