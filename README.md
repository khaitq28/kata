Kata is amazing and best way to improve your coding, refactoring, design skills ! 

Here are some of my solutions to kata exercises, mostly from https://codingdojo.org, and https://kata-log.rocks/

1. Movie Rental 
https://codingdojo.org/kata/movie-rental/

2. Employee Report
https://codingdojo.org/kata/Employee-Report/

3. Tennis Game:
https://codingdojo.org/kata/Tennis/
4. Social network
5. Task List 
6. Leap Year
7. Manhattan Distance
8. Trip Service
9. Score keeper
10. Tell Don't Ask Kata: https://kata-log.rocks/tell-dont-ask-kata

....

and some from https://kata-log.rocks/


### 2 kinds of exercises: 
+ OOP/Kata code from scratch
+ Refactoring from an unclean version

---------------------------

And some question for System design interview :

Here’s the list of the questions I asked previously related to **task scheduling**, **resource management**, **distributed systems**, **scalability**, memory-constrained algorithms, and **real-time processing**:

#### Task Scheduling and Resource Management
1. **Design a task scheduler that executes tasks based on priority but prevents high-priority tasks from starving low-priority tasks.**
2. **Implement a system that schedules tasks with different deadlines (real-time tasks). How would you ensure tasks are completed before their deadlines while managing system resources efficiently?**
3. **How would you design a job scheduling system where jobs arrive continuously, but some jobs require more resources (e.g., CPU, memory) than others? Prioritize jobs based on available resources and fairness.**
4. **Create a rate limiter to handle incoming API requests where some users can have higher request rates than others. How do you prevent abuse while ensuring fairness?**
5. **Design a priority-based print job queue for a large organization. How do you ensure that lower-priority print jobs eventually get printed without being starved by higher-priority jobs?**

#### Memory-Constrained Algorithms
6. **You are given a log file of 50GB on disk, but your program has only 2GB of RAM. Design an efficient algorithm to find the top 10 most frequent log entries.**
7. **Given a dataset of 20 million records that doesn’t fit into memory, how would you efficiently sort the data? Explain the steps and how you manage the limited memory.**
8. **Design an algorithm to merge 100 sorted files, each 1GB in size, using only 1GB of RAM. How would you efficiently combine these into a single sorted output?**
9. **You have 100 million unique integers, but only 512MB of memory to work with. How would you sort them efficiently?**
10. **You need to compute the median of a dataset that’s too large to fit into memory. How do you approach this problem with limited resources?**

#### Distributed Systems and Scalability
11. **Design a distributed email marketing system that sends personalized emails to millions of users. How do you handle failures, retries, and optimize the sending rate?**
12. **Design a distributed log processing system that continuously processes and aggregates large volumes of log data from multiple servers. How do you handle limited memory on each processing node?**
13. **How would you design a URL shortening service like bit.ly, which has to scale to billions of URLs, while ensuring short URL uniqueness and fast lookups?**
14. **Imagine you are building a system to process large batches of orders in an e-commerce platform. Some orders are urgent, and others are normal. How do you design the system to ensure urgent orders are processed first, while normal orders are not indefinitely delayed?**
15. **Design a load balancer that distributes incoming traffic to multiple backend servers. How would you handle scenarios where some servers are overloaded, while others are underutilized?**

#### Disk I/O and External Memory Processing
16. **You have a huge dataset of 100GB of transactions stored in a database. How would you efficiently calculate the total sum of these transactions if your program can only load 1GB into memory at a time?**
17. **Design an algorithm that can find the largest 10 numbers in a dataset that’s much larger than your available memory (e.g., a 100GB file on disk with 1GB RAM).**
18. **You have a 10TB log file on disk, but only 4GB of RAM. How would you efficiently find and remove duplicate log entries from the file?**
19. **Design a system to sort terabytes of data distributed across multiple machines with limited memory on each machine. How do you optimize the network and disk I/O?**
20. **How would you index a massive file stored on disk, where only a portion of the file can be loaded into memory at any given time? How do you ensure fast lookups with minimal memory usage?**

#### Data Streaming and Real-Time Processing
21. **How would you design a system that monitors real-time stock prices and generates alerts for certain conditions (e.g., when the price drops by 10%) with minimal delay?**
22. **You need to process a continuous stream of sensor data, but the amount of data far exceeds your memory capacity. How do you design the system to process the stream and generate insights without losing any data?**
23. **Imagine you’re tasked with designing a live leaderboard system that tracks the top 100 scores in a video game. The system must handle millions of incoming score updates per second with limited memory. How do you ensure real-time accuracy and scalability?**
24. **Design a system to compute real-time analytics on social media posts (e.g., tracking the most trending hashtags in the last 10 minutes). The volume of posts exceeds your memory capacity. How do you approach this?**
25. **You need to aggregate the average and max values from a continuous data stream, but the data far exceeds available memory. How would you design this system to ensure accurate results with limited resources?**

These questions test your ability to think about **scalability, resource management**, and **system optimization** when faced with real-world constraints.
