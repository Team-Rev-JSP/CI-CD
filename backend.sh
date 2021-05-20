#!/bin/bash
echo 'hi'
sudo rm -rf /usr/local/tomcat/webapps/ROOT/backend

sudo cp /var/lib/jenkins/workspace/backend /usr/local/tomcat/webapps/ROOT/

sh /usr/local/tomcat/bin/shutdown.sh

sh /usr/local/tomcat/bin/startup.sh
