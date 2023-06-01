#!/bin/bash
set -e
set -u

echo "  Creating operator database 'ku-users'"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
CREATE DATABASE "ku_users";
CREATE USER ku_users_release WITH PASSWORD 'postgres' SUPERUSER;
ALTER DATABASE ku_users OWNER TO ku_users_release;
\connect ku_users
SET ROLE ku_users_release;
CREATE SCHEMA users;
ALTER ROLE ku_users_release SET search_path TO users, public;

CREATE USER ku_users_app WITH PASSWORD 'postgres';
GRANT CONNECT ON DATABASE ku_users TO ku_users_app;
GRANT USAGE ON SCHEMA users TO ku_users_app;
ALTER DEFAULT PRIVILEGES IN SCHEMA users GRANT ALL ON TABLES TO ku_users_app;
ALTER DEFAULT PRIVILEGES IN SCHEMA users GRANT ALL ON SEQUENCES TO ku_users_app;
ALTER ROLE ku_users_app SET search_path TO users, public;
EOSQL

echo "  Creating operator database 'ku-devices'"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
CREATE DATABASE "ku_devices";
CREATE USER ku_devices_release WITH PASSWORD 'postgres' SUPERUSER;
ALTER DATABASE ku_devices OWNER TO ku_devices_release;
\connect ku_devices
SET ROLE ku_devices_release;
CREATE SCHEMA devices;
ALTER ROLE ku_devices_release SET search_path TO devices, public;

CREATE USER ku_devices_app WITH PASSWORD 'postgres';
GRANT CONNECT ON DATABASE ku_devices TO ku_devices_app;
GRANT USAGE ON SCHEMA devices TO ku_devices_app;
ALTER DEFAULT PRIVILEGES IN SCHEMA devices GRANT ALL ON TABLES TO ku_devices_app;
ALTER DEFAULT PRIVILEGES IN SCHEMA devices GRANT ALL ON SEQUENCES TO ku_devices_app;
ALTER ROLE ku_devices_app SET search_path TO devices, public;
EOSQL

