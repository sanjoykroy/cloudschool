SET MODE MySQL;

CREATE TABLE DATABASECHANGELOG (
    id varchar(150) NOT NULL,
    author varchar(150) NOT NULL,
    filename varchar(255) NOT NULL,
    dateExecuted datetime NOT NULL,
    md5sum varchar(32),
    description varchar(255),
    comments varchar(255),
    tag varchar(255),
    liquibase varchar(10),
    PRIMARY KEY(id, author, filename)
);

CREATE TABLE DATABASECHANGELOGLOCK (
    id number(38,0) NOT NULL,
    locked number(1,0),
    lockgranted timestamp(6),
    lockedby varchar(255),
    PRIMARY KEY(id)
);