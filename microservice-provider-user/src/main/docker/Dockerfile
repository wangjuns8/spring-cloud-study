
#基于java:8-jre
FROM java:8-jre
#把jar包copy到的工作目录下
COPY ./microservice-provider-user/target/microservice-provider-user.jar /work/project/microservice-provider-user.jar
# 指定当前操作目录
WORKDIR /work/project
#容器启动后执行的操作
CMD java -jar microservice-provider-user.jar