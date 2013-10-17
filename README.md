# EnavShore #

E-navigation shore service collection

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

TODO

## Configuring JBoss ##

To configure data sources and other resources run

	cd enav-shore-services
	mvn install -Pjboss-configure

The resources are configured with properties that needs to be defined. E.g:

<pre>
msi.database.url
msi.database.user
msi.database.password
</pre>

Default values will be used if properties are not given (often localhost for data sources).

To define the properties different approaches can be used:

**Define properties in Maven `settings.xml`**

Example:
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">

	<profiles>
		<profile>
			<activation>
				<activeByDefault>true</activeByDefault>					
			</activation>
			<properties>
				<msi.database.url>jdbc:mysql://localhost:3306/msi</msi.database.url>
				<msi.database.user>msi</msi.database.user>
				<msi.database.password>msi</msi.database.password>
			</properties>
		</profile>
	</profiles>
</settings>
```

**Make separate `settings.xml` and provide with `-s` option to Maven**

	mvn -s settings-prod.xml install -Pjboss-configure 

**Give properties on command line**

	mvn install -Pjboss-configure -D"msi.database.url=jdbc:mysql://10.0.0.3:3306/msi" ...	

## Deployment ##

The deployments are done from within the `enav-shore-services` folder

Deploy

	mvn jboss-as:deploy

Undeploy

	mvn jboss-as:undeploy

## Remote configuration and deployment ##

To configure and deploy on remote JBoss instance the following propeties can be used

	jboss-as.hostname
	jboss-as.port
	jboss-as.username
	jboss-as.password
	
Examples

	mvn install -Pjboss-configure -Djboss-as.hostname=appsrv-alpha.e-navigation.net
	mvn jboss-as:deploy -Djboss-as.hostname=appsrv-alpha.e-navigation.net
	
## Testing ##

Arquillian tests using a remote container must be named

	*TestRemote.java
	
They are run using

	mvn clean test -Parq-jbossas-remote
	
## Client module ##

TODO used by clients

## Webclient module ##

Deploy webclient module

    cd enav-shore-webclient
    mvn clean jboss-as:deploy

Access on URL

    /client/
