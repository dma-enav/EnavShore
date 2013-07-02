# EnavShore #

E-navigation shore service applications

## Prerequisites ##

* Java JDK 1.7
* Maven 3.x
* JBoss 7.1.x (Maven setup to deploy to JBoss)
* MySQL (Maven configures JBoss datasource to use MySQL)

MySQL module needs to be installed in JBoss: 
<http://www.mastertheboss.com/jboss-datasource/how-to-configure-a-datasource-with-jboss-7>
Or use e-navigation deployment project:
<https://github.com/dma-dk/enav-appsrv>


## Building ##

	mvn clean install

## MySQL setup ##



## Configuring JBoss ##

Start JBoss and add resources like data sources to JBoss with the following command
	
	mvn install -Pjboss-configure -P<env>

The default environment is development.

## Deployment ##

Applications deploy

	mvn jboss-as:deploy


	

