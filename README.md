#Mars
1. **Requirements**
	* Java 8 Update 131 or higher (8u131+), 64-bit
	* Maven 3.5.0+ (for building)
	* Scala 2.11.8

2. **Project Structure**

	```
	 mars(root)
	 +- rest(offer the RESTful Web Service)
	 |
	 +- dal
	 |
	 +- common
	``` 
	 
3. **Building Mars**

	Mars is a standard Maven project. Simply run the following command from the project root directory:
	
	```
	mvn clean scala:compile install -DskipTests
	```
4. **Running Mars in your IDE**

	After building Mars for the first time, you can load the project into your IDE and run the server.
		
	We recommend using IntelliJ IDEA. Because Mars is a standard Maven project, you can import it into your IDE using the root pom.xml file.
		
	In IntelliJ, choose Open Project from the Quick Start box or choose Open from the File menu and select the root pom.xml file.
		
	After opening the project in IntelliJ, double check that the Java SDK is properly configured for the project:
	* Open the File menu and select Project Structure
	* In the SDKs section, ensure that a 1.8 JDK is selected (create one if none exist)
	* In the Project section, ensure the Project language level is set to 8.0 as Mars makes use of several Java 8 language features