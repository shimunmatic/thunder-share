#!/bin/bash

echo "Stoping postgres docker image"
sudo docker kill thunder-share-postgres

echo "Stoping pgAdmin docker image" 
sudo docker kill pgadmin

echo "Starting postgres docker image..."
echo "-----------------------------------------------------------------------------"

sudo docker start thunder-share-postgres

echo "Starting pgAdmin docker image..."
echo "-----------------------------------------------------------------------------"

sudo docker start pgadmin

echo "------------------------------------------------------------------------------"

echo "enjoy DOCKER!"
echo "Thunder Share team!"
