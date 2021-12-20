FROM node:12-alpine3.12 AS build
WORKDIR /webStoreApp
COPY package-json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.19.0-alpine AS dev-stage
COPY --from=build /webStore/build /share/nginx/html
EXPOSE 80
CMD [ "nginx","-g","daemon off;" ]

