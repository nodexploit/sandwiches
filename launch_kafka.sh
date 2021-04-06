#!/usr/bin/env bash

~/work/apps/kafka/bin/zookeeper-server-start.sh ~/work/apps/kafka/config/zookeeper.properties &
sleep 5s
~/work/apps/kafka/bin/kafka-server-start.sh ~/work/apps/kafka/config/server.properties &