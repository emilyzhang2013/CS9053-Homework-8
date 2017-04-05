## CS9053-Homework-8

This assignment is mainly to be familiar with using Java Collections to design algorithms. It composed by two tasks.

1. Derive a proper non-overlapped job schedule to hold maximum number of job for a single contanier.

2. Make an extension to the above task that derive the maximum total value of non-overlapped job schedule from the job list.

There are two java files.

- Job.java, which is a POJO type of job.
- LambdaScheduler.java, which is the implementation of the first task.
- LambdaWeightedScheduler.java, which is the implementation of the second task.

Note: The type of start time and end time are Long. The format is 'yearmonthdatehourminute'. So, please type such as '201604011000'. Time should be 24-hour system.