- ## Running application in local docker container

  -`gradle clean build && gradle config-service:docker discovery-service:docker gateway-service:docker store-preference-service:docker fetch-preferences-service:docker` -  will build application and create docker images
  -`docker-compose up` will run application locally




- ## Running application in k8s cluster :

  -`cd k8s `

  -`sh apply-all.sh`


## Note :

/k8s folder has kubernetes deployment files, images already pushed to DockerHub.

In case you want to re-push them please update Dockerhub username in build.gradle file then execute below
  `gradle config-service:dockerPushDockerHub discovery-service:dockerPushDockerHub gateway-service:dockerPushDockerHub store-preference-service:dockerPushDockerHub fetch-preferences-service:dockerPushDockerHub`
