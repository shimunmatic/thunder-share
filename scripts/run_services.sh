echo "Running images..."

sudo docker pull dpage/pgadmin4
sudo docker run -p 80:80 -e "PGADMIN_DEFAULT_EMAIL=user@domain.com" -e "PGADMIN_DEFAULT_PASSWORD=SuperSecret" --name pgadmin -d dpage/pgadmin4
sudo docker pull postgres
sudo docker run --name thunder-share-postgres -p 5432:5432 -v /home/shimun/docker/postgresql:/var/lib -e POSTGRES_PASSWORD=thunder -d postgres -c config_file=~/docker/postgresql/postgresql.conf
