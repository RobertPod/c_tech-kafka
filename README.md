# Apache Kafka sample application

## Prerequisites

Before running the project

Download Kafka from https://kafka.apache.org/quickstart

Extract it in a directory **(only on windows)** with the shortest possible path.

We will be using there single broker, single producer and single consumer
in that particular configuration

For windows I recommend using PowerShell

## Example 1: Integration with our spring-boot application 

*1. Run Zookeeper using command*  

**Linux**
```
./bin/zookeeper-server-start.sh ./config/zookeeper.properties
```

**Windows**
```
./bin/windows/zookeeper-server-start.bat ./config/zookeeper.properties
```

*2. Start Kafka server (broker)*  

**Linux**
```
./bin/kafka-server-start.sh ./config/server.properties
```

**Windows**
```
./bin/windows/kafka-server-start.bat ./config/server.properties
```

## Example 2: Creating topic's and starting own consumer and producer in a command line interface 

**Before step 1 repeat 2 steps from _Example 1_**


*1. Create example topic named "test"*  

**Linux**
```
./bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
```

**Windows**
```
./bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
```
 
### 
*2. Create producer*  

**Linux**
```
./bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test
```

**Windows**
```
./bin/windows/kafka-console-producer.bat --bootstrap-server localhost:9092 --topic test
```

### 
*3. Create consumer*  

**Linux**
```
 ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```

**Windows**
```
 ./bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning
```