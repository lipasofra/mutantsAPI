FROM openjdk:11
ARG JAR_FILE=out/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
CMD gunicorn --bind 0.0.0.0:$8081 wsgi