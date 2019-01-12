CREATE SEQUENCE post_seq
  START 1
  INCREMENT 50;

CREATE TABLE post
(
  id    BIGINT NOT NULL,
  title VARCHAR(255),
  CONSTRAINT post_pk PRIMARY KEY (id)
);

CREATE SEQUENCE post_comment_seq
  START 1
  INCREMENT 50;

CREATE TABLE post_comment
(
  id      BIGINT NOT NULL,
  review  VARCHAR(255),
  post_id BIGINT,
  CONSTRAINT post_comment_pk PRIMARY KEY (id)
);

ALTER TABLE post_comment
  ADD CONSTRAINT post_comment_post_id_fk FOREIGN KEY (post_id) REFERENCES post;

CREATE SEQUENCE post_details_seq
  START 1
  INCREMENT 50;

CREATE TABLE post_details
(
  id         BIGINT NOT NULL,
  created_by VARCHAR(255),
  created_on TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT post_details_pk PRIMARY KEY (id)
);

ALTER TABLE post_details
  ADD CONSTRAINT post_details_post_id_fk foreign key (id) references post;

CREATE SEQUENCE tag_seq
  START 1
  INCREMENT 50;

CREATE TABLE tag
(
  id   BIGINT NOT NULL,
  name VARCHAR(255),
  CONSTRAINT tag_pk PRIMARY KEY (id)
);

CREATE TABLE post_tag
(
  post_id BIGINT NOT NULL,
  tag_id  BIGINT NOT NULL
);
ALTER TABLE post_tag
  ADD CONSTRAINT post_tag_tag_id_fk FOREIGN KEY (tag_id) references tag;
ALTER TABLE post_tag
  ADD CONSTRAINT post_tag_post_id_fk FOREIGN KEY (post_id) references post;