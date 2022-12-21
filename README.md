# A test project

## What is done:

> - Consumes XML file via REST POST
> - XML validation
> - Saves all into persistent H2 Database
> - Producing easy-to-work-with JSONs via REST GET
> - Works in Docker

## TODO:
> - Docker Postgres DB integration not working yet
> - Unit tests


## How to start the app: 
>## Local
>  - Cd into project root
> - Run "mvn clean install spring-boot:run"
> - It uses port 1010 on localhost
> - Use Postman for testing

>## Docker
> - Be sure Docker is running
> - Cd into project root 
> - Run "docker-compose up --build app"