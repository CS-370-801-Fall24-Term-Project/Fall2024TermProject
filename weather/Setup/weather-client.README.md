# Deploying the weather-client

To deploy the weather client create the production version of the client app

1. Run the command to create the production version of the code from the
    client's directory root (weather/client/weather-client):

    npm run build

2. Copy the build directory to the directory for hosting.
    (note: you can copy to any directory, but /var/www/SomeDir is appropriate).

3. Add a virtual host configuration file for nginx to use. Add the [weather-client](weather-client)
    file to /etc/nginx/sites-available.

4. Create a symbolic link from the sites-available to the sites-enabled to enable the site:
    sudo ln -s /etc/nginx/sites-available/weather-client /etc/nginx/sites-enabled/

5. Verify nginx configuration
    sudo nginx -t

6. Restart nginx
    sudo systemctl reload nginx

### Note: if you have a firewall enabled you must allow port 8088 for this example defined in [weather-client](weather-client)


## Other commands:

### start nginx 
sudo systemctl start nginx

### stop nginx 
sudo systemctl stop nginx

### reload nginx 
sudo systemctl reload nginx

### status of nginx 
sudo systemctl status nginx

### view the nginx error log
sudo cat /var/log/nginx/error.log