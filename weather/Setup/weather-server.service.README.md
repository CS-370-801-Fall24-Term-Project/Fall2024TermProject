# Deploying Production Server to SystemD

1. Build the production version of the server, by running this from the server app root.
    mvn clean package

2. Copy the production Jar from the server app's ./target directory to /var/www/weather-server.
    (note: you can copy to any directory, but /var/www/SomeDir is appropriate).

3. Create and add the [weather-server.service](weather-server.service) file in the
    /etc/systemd/system/ directory.

4. Reload SystemD:
    sudo systemctl daemon-reload

5. Start the service:
    sudo systemctl start weather-server.service

6. Enable the service on-Boot:
    sudo systemctl enable weather-server.service
    
## Other Commands:
### start the service
    sudo systemctl start weather-server.service

### stop the service
    sudo systemctl start weather-server.service

### check status of the service
    sudo systemctl status weather-server.service


### run the server jar manually
    java -jar [file name].jar