#!/bin/bash

nombrecontenedor=$1
versiondeimagen=$2
nombredeimagen=$3
puerto=$4
directorio=/swarm/BUILD_RUN_SERVICES/$nombrecontenedor


### Verify if service exist, if true: delete, if not: create new service from scratch
if  docker service ps $nombrecontenedor  ; then
    echo -e $'\n\t\tService is running already... removing  '$nombrecontenedor'...\n'
    docker service rm $nombrecontenedor && sleep 5
else
   echo -e $'*************************************\n'
   echo -e $'\n\t\tService not active, starting...\n'
fi

### Create and Run containers
echo -e "Creating container... $nombrecontenedor  from image  $nombredeimagen:$versiondeimagen \n"

docker service create --name $nombrecontenedor \
 --restart-condition on-failure \
 --limit-memory 1G \
 --mount type=bind,src=/etc/localtime,target=/etc/localtime \
 --network microsrv \
 -p $puerto:$puerto \
 -e ENVIRONMENT=production \
 --update-delay 60s \
 --update-parallelism 1 \
 --replicas 1 \
 $nombredeimagen:$versiondeimagen

###Check error
if [ $? -ne 0 ]; then
echo -e "\nError to create container $?, pleae check the sintaxis\n"
exit 1
else
echo "Container created succesfully!"
fi
