https://stackoverflow.com/questions/574594/how-can-i-create-an-executable-jar-with-dependencies-using-maven

To create a single an executable JAR with dependencies:
mvn clean compile assembly:single
Compile goal should be added before assembly:single or otherwise the code on your own project is not included.


To create a single jar file:
http://www.baeldung.com/executable-jar-with-maven


jboss-service
--------------------------------------------------------------------------------
http://middlewaremagic.com/jboss/?p=366
http://middlewaremagic.com/jboss/?p=307
