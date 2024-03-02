# java-app-kube
Spring boot rest app on Kubernetes

## Test locally
```
mvn clean package
```
Then
```
java -jar target/appkube-1.jar    
```
Then in browser http://localhost:8090

## Change port
The above port is configure in application.properties
```
server.port=8090
```
One can change it many ways, for example via env variables
```
SERVER_PORT=8888 java -jar target/appkube-1.jar
```
Via JVM system property
```
java -Dserver.port=8888 -jar target/appkube-1.jar 
```
Via command line arg
```
java -jar target/appkube-1.jar --server.port=8888
```

## Containerize

```
VER=v3
APP=java-app-kube
docker buildx build -t ${APP}:${VER} .
docker run -p 5000:8090 ${APP}:${VER}
```
Then in browser http://localhost:5000

Once happy
```
# May need to rebuild as per below if you plan to use it on EC2, not on your Mac.
# docker buildx build --platform=linux/amd64 -t ${APP}:${VER} .
docker tag ${APP}:${VER} philip11/${APP}:${VER}
# the login below is just one time
docker login --username=philip11
docker push philip11/${APP}:${VER}
```

TODO: try via via maven, see
https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/htmlsingle/#build-image

## Kubernetes
On Mac, install multipass, start up some VMs, install and configure microk8s on them, etc, etc

Separate Google doc has notes how to do it and hit the app started up below:
```
kubectl apply -f kube/deploy.yml
kubectl apply -f kube/service.yml
```

## History
v1 and v2 still work but were built with openjdk:17-jdk which is no longer supported

v3 was built for amd64 architecture (so will not run on Mac)

Note that "docker buildx build" in theory can take comma separate list of platforms in
--platform but does not work on my Mac installation.

