CREATE TABLE flower
(
    id             INT AUTO_INCREMENT NOT NULL,
    flower         VARCHAR(255) NULL,
    `description`  VARCHAR(255) NULL,
    longitude DOUBLE NULL,
    latitude DOUBLE NULL,
    location_name  VARCHAR(255) NULL,
    titre          VARCHAR(255) NULL,
    user_entity_id BIGINT NULL,
    CONSTRAINT pk_flower PRIMARY KEY (id)
);

CREATE TABLE flower_type
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_flower_type PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    role_id INT    NOT NULL,
    user_id BIGINT NOT NULL
);

CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE flower
    ADD CONSTRAINT FK_FLOWER_ON_USERENTITY FOREIGN KEY (user_entity_id) REFERENCES users (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user_entity FOREIGN KEY (user_id) REFERENCES users (id);


INSERT INTO roles (name) value('USER');
INSERT INTO users (username, password) value('user@gmail.com','$2y$10$S7ES2tiqh/G7qb/kNGPnt.PTepB0/9vWOx6A8JuKRpzelKwBDF04G');
INSERT INTO users (username, password) value('test','$2y$10$5RNK.tVnYl6.xgdIrsko3etJ4NPGBL1P7G2QRmsiiF88gSu6TMzKa');