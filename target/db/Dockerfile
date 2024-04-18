# Use the latest MySQL image
FROM mysql

# Set the working directory
WORKDIR /tmp

# Assuming you want to use your own SQL files, adjust these paths:
# Copy your SQL files to the working directory of the container. Adjust the paths as needed.
COPY ./*.sql /tmp/
# Optionally, if you have .dump files
# COPY ./*.dump /tmp/

# Copy the main SQL file to docker-entrypoint-initdb.d for database initialization.
COPY world.sql /docker-entrypoint-initdb.d

# Set the root password for MySQL
ENV MYSQL_ROOT_PASSWORD password
