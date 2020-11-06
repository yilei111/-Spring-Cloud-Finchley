# Docker image for springboot file run
# VERSION 0.0.1
# Author: yi
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER yi <yi@gmail.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD eureka-server-0.0.1-SNAPSHOT.jar app.jar
# 运行jar包
#RUN bash -c 'touch /app.jar'
#执行项目 app.jar。为了缩短 Tomcat 启动时间，添加一个系统属性指向 “/dev/./urandom” 作为 Entropy Source
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]