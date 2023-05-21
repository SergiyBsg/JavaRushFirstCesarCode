## Getting started ###

### Install requirements on Ubuntu ###
* sudo apt-get update
* sudo apt-get install openjdk-18-jdk
* sudo apt-get install maven
* setup JAVA_HOME for your environment

### Install requirements on Mac OSX ###
* Download and install JDK: http://www.oracle.com/technetwork/java/javase/downloads/index.html

### Setup environment ###
* Clone lexx from stash
* Switch branch to develop

### Setup IntelliJ ###
* Create new project in IntelliJ
* Choose java module
* Click "new" in SDK and choose "JDK"
* Browse to /System/Library/Java/JavaVirtualMachines and choose the 18 .jdk
* Set the project location to the Lexx directory
* Check that "maven integration" is installed under plugins in IntelliJ