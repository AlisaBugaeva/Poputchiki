FROM gcr.io/distroless/java:11

COPY ./target/poputchiki-app.jar /app/poputchiki-app.jar

EXPOSE 8081

WORKDIR /app
CMD ["/app/poputchiki-app.jar"]