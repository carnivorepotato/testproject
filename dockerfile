FROM maven:3.8.3-openjdk-17
RUN mkdir /app
ADD . /app
WORKDIR /app
EXPOSE 1010
RUN mvn install
CMD ["mvn", "spring-boot:run"]