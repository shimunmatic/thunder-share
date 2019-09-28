FROM node:10-alpine AS builder
WORKDIR /app
COPY package.json ./
COPY yarn.lock ./
RUN yarn
RUN yarn global add @angular/cli@latest
COPY . .
RUN yarn build:prod

FROM nginx:alpine
COPY --from=builder /app/dist/thundershare-portal /usr/share/nginx/html
COPY --from=builder /app/nginx/default.conf /etc/nginx/conf.d/default.conf
