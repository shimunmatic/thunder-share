### STAGE 1: Build ###
FROM node:12-alpine AS build
WORKDIR /usr/src/app
RUN apk update && apk add yarn
COPY package.json ./
COPY yarn.lock ./
RUN yarn install
COPY . .
RUN yarn build:docker

### STAGE 2: Run ###
FROM nginx:alpine
EXPOSE 80
COPY nginx/nginx.conf /etc/nginx/nginx.conf
RUN rm -rf /usr/share/nginx/html/*
WORKDIR /usr/share/nginx/html
COPY --from=build /usr/src/app/dist/client /usr/share/nginx/html