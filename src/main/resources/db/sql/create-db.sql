
CREATE TABLE IF NOT EXISTS AUTHOR (
  AUTHOR_ID VARCHAR(36) PRIMARY KEY,
  FIRST_NAME VARCHAR(20),
  FATHER_NAME VARCHAR(30),
  LAST_NAME VARCHAR(20),
  BOOK_ID  VARCHAR(36)
);
CREATE TABLE IF NOT EXISTS BOOK (
  BOOK_ID VARCHAR(36) PRIMARY KEY,
  BOOK_NAME VARCHAR(40),
  PUBLISHING_DATE VARCHAR(15),
  BOOK_LANGUAGE VARCHAR(20),
  PUBLISHINGHOUSE_ID VARCHAR(36)
);
CREATE TABLE IF NOT EXISTS PUBLISHINGHOUSE (
  PUBLISHINGHOUSE_ID VARCHAR(36) PRIMARY KEY,
  HOUSE_NAME VARCHAR(25)
);
CREATE TABLE IF NOT EXISTS STORE (
  STORE_ID VARCHAR(36) PRIMARY KEY,
  STORE_NAME VARCHAR(25),
  STREET_NAME VARCHAR(25),
  NUMBEROF_HOUSE VARCHAR(5)
);
CREATE TABLE IF NOT EXISTS HELPTABLE (
  TABLE_ID   VARCHAR(36) PRIMARY KEY,
  BOOK_ID VARCHAR(36),
  STORE_ID VARCHAR(36)
);