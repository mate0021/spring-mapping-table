FROM mysql

ENV MYSQL_ROOT_PASSWORD=admin

COPY mysql_scripts/init.sql /docker-entrypoint-initdb.d
