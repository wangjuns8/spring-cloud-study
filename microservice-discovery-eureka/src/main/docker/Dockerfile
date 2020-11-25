
#基于java:8-jre
FROM java:8-jre
#把jar包copy到的工作目录下
COPY ./microservice-discovery-eureka/target/microservice-discovery-eureka.jar /work/project/microservice-discovery-eureka.jar
# 指定当前操作目录
WORKDIR /work/project
#容器启动后执行的操作
CMD java -jar microservice-discovery-eureka.jar