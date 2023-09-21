FROM openjdk:20
#Setting up source directory
WORKDIR /src

#Copy all to src
COPY ./ .

#Create jar from source (without runing unittest)
RUN ./mvnw clean package -DskipTests=true

# Copy the jar file into our app
COPY ./target/bfjava2023-spring-0.0.1-SNAPSHOT.jar /app/webapi.jar

# Setting up work directory
WORKDIR /app

RUN chmod +x ./webapi.jar
RUN rm -r ../src

EXPOSE 8080

CMD ["java", "-jar", "webapi.jar"]
