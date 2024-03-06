# Dockerfile
FROM ubuntu:latest

EXPOSE 8083

#Installation des diférents packages
RUN apt-get update && apt-get upgrade -y && apt-get install -y openjdk-17-jdk openjdk-17-jre nano openssh-server

#Restart ssh server
RUN service ssh restart

#Permit root login
RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

#Restart ssh server
RUN service ssh restart

RUN echo "root" | passwd --stdin root
