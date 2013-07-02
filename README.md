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

TODO

## Configuring JBoss ##

To configure data sources and other resources run

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

Applications deploy

	mvn jboss-as:deploy


	

