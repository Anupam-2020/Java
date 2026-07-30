# (Create a Docker network)
docker network create postgres

# (Start the postgreSQL service)
docker run -d \
    --name postgres_container \
    -e POSTGRES_USER=abc
    -e POSTGRES_PASSWORD=xyz \
    -e PGDATA=/data/postgres \
    -v postgres: /data/postgres \
    -p 5432:5432 \
    --network postgres \
    --restart unless-stopped \
    postgres:14

# (Start the pgAdmin service)
docker run -d \
    --name pgadmin_container \
    -e PGADMIN_DEFAULT_EMAIL=pgadmin4@pgadmin.org \
    -e PGADMIN_DEFAULT_PASSWORD=admin \
    -e PGADMIN_CONFIG_SERVER_MODE=false \
    -v pgadmin:/var/lib/pgadmin \
    -p 5050:80 \
    --network postgres \
    --restart unless-stopped \
    dpage/pgadmin4