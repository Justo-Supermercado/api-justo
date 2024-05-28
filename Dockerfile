FROM openjdk:17-alpine
VOLUME /tmp
ENV IMG_PATH=/img
EXPOSE 8080
RUN mkdir -p /img
ADD ./target/api-justo-0.0.1-SNAPSHOT.jar justo.jar
ENTRYPOINT ["java", "-jar", "/justo.jar"]