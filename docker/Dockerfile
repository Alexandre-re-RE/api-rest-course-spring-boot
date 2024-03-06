FROM alpine:latest

# Add a new user
RUN adduser -D expernet

# Create a directory and set permissions
RUN mkdir -p /home/expernet/app && \
    chown -R expernet:expernet /home/expernet

# Install required packages
RUN apk add --no-cache openjdk17 nano openssh-server

# Expose port 8083
EXPOSE 8083
EXPOSE 22
