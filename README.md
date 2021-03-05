1. Run zookeeper

`bin/zookeeper-server-start.sh config/zookeeper.properties &`

2. Run kafka broker

`bin/kafka-server-start.sh config/server.properties &`

3. Create topic with partitions

`bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic user-deleted-events --partitions 1`

4. List kafka topics

`bin/kafka-topics.sh --list --bootstrap-server localhost:9092`

5. List kafka groups for all topics

`bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list`

6. List offset of a specific consumer group

` bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group order-group`