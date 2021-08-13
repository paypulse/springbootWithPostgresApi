FROM tomcat:8.5.46-jdk8

RUN cd /usr/local/tomcat/webapps/
COPY ./target/crmTestExample-0.0.1.war  /usr/local/tomcat/webapps/crmTestExample-0.0.1.war


CMD ["/usr/local/tomcat/bin/startup.sh", "run"]





