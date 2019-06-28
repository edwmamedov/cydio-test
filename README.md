# cydio-test

**Problem #1:**

You are given a file formatted like this:
```
CUSIP
Price
Price
Price
…
CUSIP
Price
Price
CUSIP
Price
Price
Price
…
Price
CUSIP
Price
…
```
Think of it as a file of price ticks for a set of bonds identified by their CUSIPs.
You can assume a CUSIP is just an 8-character alphanumeric string.
Each CUSIP may have any number of prices (e.g., 95.752, 101.255) following it in sequence, one per line.
For each CUSIP, the prices can be considered to be ordered by time in ascending order, earliest to latest.
Write a Java program that will print the closing (or latest) price for each CUSIP in the file.
Please include any tests you might use to validate your solutions.
Since the file may contain millions of rows, DO NOT assume the entire file can fit in memory.

**Problem #2:**

Write a Java program that that accepts an array of integers, and prints out the distinct pairs of these integers that sum to 7. For example,
If the input is [1, 2, 3, 4, 5, 6], the output could be (1,6), (2, 5), (3, 4), or (6,1), (5, 2), (4,3). Different combinations of the same pair of numbers e.g, (1, 6) and (6, 1) are not distinct. In this case, you should only print (1, 6) or (6, 1) but not both of them
