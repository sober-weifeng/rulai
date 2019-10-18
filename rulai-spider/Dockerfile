FROM java:8
RUN mkdir -p /opt/soft/rulai/jar/
VOLUME ["/tmp", "/opt/soft/rulai/log"]
ADD target/rulai-spider-0.0.1-SNAPSHOT.jar /opt/soft/rulai/jar/rulai-spider.jar
RUN bash -c 'touch /opt/soft/rulai/jar/rulai-spider.jar'

EXPOSE 8001

ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://10.0.10.1:3306/db_cookbook?Unicode=true&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=true", "-Dlogging.file=/opt/soft/rulai/log/rulai-spider.log", "-jar", "/opt/soft/rulai/jar/rulai-spider.jar"]