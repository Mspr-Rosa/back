CREATE TABLE conversation
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    user1_id BIGINT NOT NULL,
    user2_id BIGINT NOT NULL,
    CONSTRAINT pk_conv PRIMARY KEY (id)
);

CREATE TABLE message
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    conversation_id BIGINT NOT NULL,
    sender_id       BIGINT NOT NULL,
    content         VARCHAR(255) NULL,
    CONSTRAINT pk_message PRIMARY KEY (id)
);

ALTER TABLE conversation
    ADD CONSTRAINT FK_CONV_USER1 FOREIGN KEY (user1_id) REFERENCES users (id);

ALTER TABLE conversation
    ADD CONSTRAINT FK_CONV_USER2 FOREIGN KEY (user2_id) REFERENCES users (id);

ALTER TABLE message
    ADD CONSTRAINT fk_MESSAGE_USER FOREIGN KEY (sender_id) REFERENCES users (id);

ALTER TABLE message
    ADD CONSTRAINT fk_MESSAGE_CONV FOREIGN KEY (conversation_id) REFERENCES conversation (id);