### Kafka

#### Books / Articles

* [*Kafka: The Definitive Guide, Real-Time Data and Stream Processing at Scale*](https://www.confluent.io/resources/kafka-the-definitive-guide-v2/) - notes for it at [book-notes -> kafka](https://book-notes.accel.dk/kafka/)
* [Apache Kafka in a Nutshell](https://medium.com/swlh/apache-kafka-in-a-nutshell-5782b01d9ffb) Architecture, Use Cases, and a Getting Started guide — rolled into one
* [*Effective Kafka*, Emil Koutanov](https://leanpub.com/effectivekafka) - by the author of Kafdrop
* [Setting Up Your Local Event-Driven Environment Using Kafka Docker](https://betterprogramming.pub/your-local-event-driven-environment-using-dockerised-kafka-cluster-6e84af09cd95)
* [Contrasting NATS with Apache Kafka](https://itnext.io/contrasting-nats-with-apache-kafka-1d3bdb9aa767)
* [7 part series on, Microservices, Event Systems and Kafka](https://www.confluent.io/blog/data-dichotomy-rethinking-the-way-we-treat-data-and-services/) *The Data Dichotomy: Rethinking the Way We Treat Data and Services*

#### Installing

* [Confluent Docker Images](https://docs.confluent.io/platform/current/installation/docker/image-reference.html)

#### Demos / POCs / Examples

* [Confluent Platform Demo (cp-demo)](https://docs.confluent.io/platform/current/tutorials/cp-demo/docs/index.html) and the github repo [confluentinc/cp-demo](https://github.com/confluentinc/cp-demo)
* [Confluent Demos](https://github.com/confluentinc/demo-scene) - Scripts and samples to support Confluent Platform talks

#### Monitoring

* [Kafdrop – Kafka Web UI](https://github.com/obsidiandynamics/kafdrop)
  * [Reintroducing Kafdrop 3](https://codeburst.io/reintroducing-kafdrop-3-9a85ca3674b6?gi=ab349dca8d2d)
  * [Kafdrop: I can see you, Protobuf](https://www.chrlogs.com/2021/02/kafdrop-i-can-see-you-protobuf.html) - describing the usage of protobuf schemas in Kafdrop
  * [Open-Source Web UI for Apache Kafka](https://hackernoon.com/kafdrop-2b4l32r7) - a quick run through of the Kafdrop GUI
* [CMAK](https://github.com/yahoo/CMAK) - previously known as *Kafka Manager*

#### Schema Registry

* [Github ->  Confluent Schema Registry for Kafka](https://github.com/confluentinc/schema-registry)
* [Schema Registry Overview](https://docs.confluent.io/platform/current/schema-registry/index.html)
* [Schema Registry Tutorials](https://docs.confluent.io/platform/current/schema-registry/schema_registry_tutorial.html#schema-registry-tutorial)
* [Add Schema Registry to Kafka in Your Local Docker Environment](https://betterprogramming.pub/adding-schema-registry-to-kafka-in-your-local-docker-environment-49ada28c8a9b)
  * Tutorial of starting and configuring the Schema Registry in docker compose

#### Kafka Connect

* [How to Use Single Message Transforms in Kafka Connect](https://www.confluent.io/blog/kafka-connect-single-message-transformation-tutorial-with-examples/)
* [The Simplest Useful Kafka Connect Data Pipeline in the World…or Thereabouts – Part 1](https://www.confluent.io/blog/simplest-useful-kafka-connect-data-pipeline-world-thereabouts-part-1/)
  * streaming data from MySql into kafka and into ElasticSearch
  * a webcast on this POC [From Zero to Hero with Kafka Connect](https://databricks.com/session_eu20/from-zero-to-hero-with-kafka-connect) - [slides](https://talks.rmoff.net/ioHuht/from-zero-to-hero-with-kafka-connect#s9qHSEu) and [demo code](https://github.com/confluentinc/demo-scene/tree/master/kafka-connect-zero-to-hero)
* [Kafka Connect Deep Dive – Error Handling and Dead Letter Queues](https://www.confluent.io/blog/kafka-connect-deep-dive-error-handling-dead-letter-queues/)
* [Kafka Connect Deep Dive – JDBC Source Connector](https://www.confluent.io/blog/kafka-connect-deep-dive-jdbc-source-connector/)
* [Debezium](https://debezium.io/)
  * connectors for Mysql, PostgreSQL and more based on log based CDC (change data capture)
  * [Mysql tutorial](https://github.com/debezium/debezium-examples/tree/main/tutorial#using-mysql)
