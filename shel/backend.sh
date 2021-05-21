#!/bin/bash
echo 'hi'
sudo rm -rf /usr/local/tomcat/webapps/ROOT/backend

sudo cp -ra /var/lib/jenkins/workspace/backend/backend /usr/local/tomcat/webapps/ROOT/

sudo sh /usr/local/tomcat/bin/shutdown.sh

sudo sh /usr/local/tomcat/bin/startup.sh
