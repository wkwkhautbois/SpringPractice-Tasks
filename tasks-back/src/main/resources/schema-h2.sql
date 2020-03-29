CREATE TABLE IF NOT EXISTS task (
    id varchar(100) NOT NULL,
    user_id varchar(100) NOT NULL,
    title varchar(100) NOT NULL,
    description varchar(1000) NOT NULL,
    deadline TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY(id)
);
