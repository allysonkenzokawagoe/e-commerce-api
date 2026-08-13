CREATE SEQUENCE SEQ_USER INCREMENT BY 1 START WITH 1;

CREATE TABLE "users" (
    id         BIGINT             NOT NULL DEFAULT nextval('SEQ_USER'),
    name       VARCHAR(255)       NOT NULL,
    email      VARCHAR(255)       NOT NULL,
    password   VARCHAR(255)       NOT NULL,
    created_at TIMESTAMP(6)        NOT NULL,

    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT uk_user_email UNIQUE (email)
);
