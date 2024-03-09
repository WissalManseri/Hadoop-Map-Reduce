**✨ Hadoop:**

Hadoop is an open-source framework developed by the Apache Foundation for distributed storage and processing of large volumes of data across clusters of servers. It is designed to be scalable, reliable, and fault-tolerant, making it an ideal solution for processing massive datasets.

**✨ Hadoop MapReduce:**

MapReduce is a programming model and a key component of the Hadoop framework. It enables parallel and distributed processing of large datasets across a cluster of servers. The MapReduce model consists of two main stages: the "map" phase, where data is filtered and transformed into key-value pairs, and the "reduce" phase, where the data is aggregated and processed to produce a final result.

**✨ License:**

Hadoop is distributed under the Apache License 2.0, an open-source license that allows users to modify, distribute, and use the software for both commercial and non-commercial purposes, subject to certain conditions.


______________________________________________

          ## Execution Commands

### Step 1: Set up Hadoop

          ```bash
          sudo groupadd supergroup
          sudo usermod -aG supergroup hduser
          sudo /usr/local/hadoop/sbin/./start-all.sh
          
### Step 2: Prepare HDFS


          hadoop fs -ls /
          hadoop fs -mkdir /GradeAnalysisProject

### Step 3: Upload Dataset to HDFS

          hadoop fs -put /home/ubuntu22r/student_records.txt /GradeAnalysisProject/

### Step 4: Compile and Package Java Code
          export HADOOP_CLASSPATH=$(hadoop classpath)
          javac -classpath $HADOOP_CLASSPATH -d GradeAnalysisProject/classes GradeAnalysisProject/src/*.java
          jar -cvf GradeAnalysis.jar -C GradeAnalysisProject/classes .

### Step 5: Run the MapReduce Job
          hadoop jar GradeAnalysis.jar GradeAnalysisDriver /GradeAnalysisProject/student_records.txt /output/grade_analysis

### Step 6: View Output
          hadoop fs -cat /output/grade_analysis/part-r-00000

______________________________________________

- Note : 
Ensure that Hadoop is properly installed and configured before running the program.
Replace "/home/ubuntu22r/student_records.txt" with the path to your dataset.
Adjust paths and commands as needed based on your Hadoop setup.

- Don’t forget to adjust the paths and commands according to your specific Hadoop configuration. You can also add more details about specific program steps, dependencies, prerequisites, etc., as needed.



**✨ Conclusion:**

In conclusion, Hadoop and Hadoop MapReduce are powerful technologies for distributed processing of massive datasets. Their ability to efficiently handle large volumes of data across server clusters has revolutionized the field of Big Data, enabling businesses and organizations to extract valuable insights from their data. Hadoop's open-source license promotes innovation and collaboration within the developer community, contributing to its widespread adoption across various industries.
