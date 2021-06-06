#!/bin/bash
sudo rm -rf /usr/local/tomcat/webapps/ROOT

sudo cp -ra /var/lib/jenkins/workspace/backend/ROOT.war /usr/local/tomcat/webapps/

sudo sh /usr/local/tomcat/bin/shutdown.sh

sudo sh /usr/local/tomcat/bin/startup.sh
