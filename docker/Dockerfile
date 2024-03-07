FROM alpine

#default args for user
ARG APP_USER=expernet
ARG APP_PASSWORD=JdhVv1XlqwMt5Hp

# Install required packages
RUN apk update && \
    apk add --no-cache openssh-server openjdk17 nano && \
    rm -rf /var/cache/apk/* && \
    ssh-keygen -A

# Add a new user
RUN adduser -D $APP_USER

# Create a directory and set permissions
RUN mkdir -p /home/$APP_USER/app && \
    chown -R $APP_USER:$APP_USER /home/$APP_USER \
    && echo "$APP_USER:$APP_PASSWORD" | chpasswd

COPY /docker/restart.sh /home/$APP_USER/app/

RUN chmod +x /home/$APP_USER/app/restart.sh && \
    chown -R $APP_USER:$APP_USER /home/$APP_USER

RUN echo 'PasswordAuthentication yes' >> /etc/ssh/sshd_config

# Expose port 8083
EXPOSE 8083
EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]