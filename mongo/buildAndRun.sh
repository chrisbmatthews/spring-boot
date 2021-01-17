#!/usr/bin/env bash
docker build -t customer-mongo:latest .
docker rm -f customer-mongo
docker run -d -p 27018:27017 --name customer-mongo customer-mongo:latest