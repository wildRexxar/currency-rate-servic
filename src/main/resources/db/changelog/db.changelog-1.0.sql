--liquibase formatted sql

--changeset skavysh_ilya:1
CREATE SCHEMA IF NOT EXISTS currency_rate;

--changeset skavysh_ilya:2
SET SCHEMA currency_rate;

--changeset skavysh_ilya:3
CREATE TABLE RATE ( id INT NOT NULL, date DATE, abbreviation VARCHAR(8) NOT NULL, name VARCHAR(64) NOT NULL, scale INT default 1, officialRate VARCHAR(16) NOT NULL);
