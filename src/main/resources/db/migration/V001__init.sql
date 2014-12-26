CREATE SEQUENCE house_seq START 1 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS house (
  id      BIGINT DEFAULT nextval('house_seq') PRIMARY KEY,
  name    VARCHAR(100) UNIQUE       NOT NULL,
  address VARCHAR(100) UNIQUE       NOT NULL
);
CREATE INDEX house_name_idx ON house (name);

CREATE SEQUENCE floor_seq START 1 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS floor (
  id       BIGINT DEFAULT nextval('floor_seq') PRIMARY KEY,
  house_id BIGINT REFERENCES house (id)
);
CREATE INDEX floor_house_idx ON floor (house_id);

CREATE SEQUENCE room_seq START 1 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS room (
  id       BIGINT DEFAULT nextval('room_seq') PRIMARY KEY,
  tenant   VARCHAR(64) NULL,
  floor_id BIGINT REFERENCES floor (id)
);
CREATE INDEX room_floor_idx ON room (floor_id);