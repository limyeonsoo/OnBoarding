CREATE TABLE IF NOT EXISTS TASKS (
    id VARCHAR(100) NOT NULL,
    details VARCHAR(100) NOT NULL,
    task_status VARCHAR(100) NOT NULL
);

INSERT INTO TASKS(id, details, task_status)
VALUES ('help', 'me', 'PLEASE');
