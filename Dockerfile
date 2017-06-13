FROM centos
RUN yum install -y java
EXPOSE 8080

VOLUME /tmp
ADD /spring-boot-rest-0.0.1-SNAPSHOT.jar spring-boot-rest.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-rest.jar"]