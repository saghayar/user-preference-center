- Running application in local docker container :
1.  `gradle clean build && gradle config-service:docker discovery-service:docker gateway-service:docker store-preference-service:docker fetch-preferences-service:docker` -  will build application and create docker images
2.  `docker-compose up` will run application locally



- Running application to k8s cluster :

1.  `cd k8s `

2.  `sh apply-all.sh`



- Monitoring deployments & services in k8s cluster:
`minikube dashboard` (local minikube cluster in my case)

Note :
/k8s folder has kubernetes deployment files, images already pushed to DockerHub.

In case you want to re-push them please update Dockerhub username in build.gradle files and then execute 
-   `gradle config-service:dockerPushDockerHub discovery-service:dockerPushDockerHub gateway-service:dockerPushDockerHub store-preference-service:dockerPushDockerHub fetch-preferences-service:dockerPushDockerHub`
