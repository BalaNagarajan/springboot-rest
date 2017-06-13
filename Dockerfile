FROM centos
RUN yum install -y java
EXPOSE 8080

VOLUME /tmp
ADD /soa-facade-0.0.1-SNAPSHOT.jar soa-facade.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/soa-facade.jar"]