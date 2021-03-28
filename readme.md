<h1>Prerequiste<h1>
You need a hazelcast cluster running

```docker run -e HZ_NETWORK_PUBLICADDRESS=192.168.99.100:5701 -p 5701:5701 hazelcast/hazelcast:latest

docker run -e HZ_NETWORK_PUBLICADDRESS=192.168.99.100:5702 -p 5702:5701 hazelcast/hazelcast:latest

docker run \
  -e MC_INIT_CMD="./bin/mc-conf.sh cluster add -H=/data -ma 192.168.99.100:5701 -cn dev" \
  -p 8080:8080 hazelcast/management-center:latest```