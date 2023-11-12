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
Then in browser http://localhost:8080

## Change port
Via env variables
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
docker buildx build -t java-app-kube:v1 .
docker run -p 5000:8080 java-app-kube:v1
```
Then in browser http://localhost:5000

Once happy
```
APPVER="java-app-kube:v1"
docker buildx build --platform=linux/amd64 -t ${APPVER} .
docker tag ${APPVER} philip11/${APPVER}
docker push philip11/${APPVER}

```


# the login below not needed often
docker login --username=philip11
docker push philip11/cachedemo:latest


TODO: try via via maven, see
https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/htmlsingle/#build-image
