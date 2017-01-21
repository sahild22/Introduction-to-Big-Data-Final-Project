# Introduction-to-Big-Data-Final-Project

##Commands to run Oozie Workflow on Fully Distributed Mode:

1) Copy the Oozie folder and all flight data onto AWS instance.

2) Access the instance from Terminal using the given command
```
ssh -i "key1.pem" ec2-user@ec2-35-163-67-151.us-west-2.compute.amazonaws.com
```
3) Format The NameNode
```
hadoop/bin/hadoop namenode -format
```
4) Start Hadoop Services
```
hadoop/sbin/start-dfs.sh
hadoop/sbin/start-yarn.sh
```
5) Put the folder containing all input files on the HDFS
```
hadoop/bin/hadoop fs -put flightData input1
```
6) Put Oozie folder on hdfs
```
hadoop/bin/hadoop fs -put oozie flight
```
7) Check oozie status using following command:
```
oozie admin -oozie http://172.31.16.104:8080/oozie -status
```
8) Execute following command to run oozie workflow:
```
oozie job -oozie http://172.31.16.104:11000/oozie -config job.properties -run
```
9) To check the status of oozie job:
```
oozie job -oozie http://172.31.16.104:11000/oozie -info <job_Id>
```
