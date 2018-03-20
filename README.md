To create a single an executable JAR with dependencies:
mvn clean compile assembly:single
Compile goal should be added before assembly:single or otherwise the code on your own project is not included.