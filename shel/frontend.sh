#!/bin/bash
sudo rm -rf /usr/local/tomcat/webapps/ROOT/frontend

sudo cp -ra /var/lib/jenkins/workspace/frontend /usr/local/tomcat/webapps/ROOT/

sudo sh /usr/local/tomcat/bin/shutdown.sh

sudo sh /usr/local/tomcat/bin/startup.sh
