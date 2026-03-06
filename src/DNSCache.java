/*
A Domain Name System (DNS) translates domain names to IP addresses which are then used by browsers to load internet resources.
For quicker DNS lookups, browsers often store a number of recent DNS queries in a DNS cache.
Retrieving data from the cache is often faster than retrieving it from a DNS server.
This task aims to simulate DNS resolution and determine the time taken to process different URLs.

Assume that the DNS cache can store a maximum of the cache_size most recent DNS requests, i.e., URL-IP mappings.
The cache is initially empty. It takes cache_time units of time to fetch data from the DNS cache,
and server_time units of time to fetch data from the DNS server.

Given a list of n URLs visited as an array of strings, urls, determine the minimum time taken to resolve each DNS request.

Note: New DNS requests are dynamically added to the cache. If the cache exceeds cache_size, remove the least recently
used URL-IP mapping.
 */

/*
Problem Summary
==============
You have:
        - n functions with IDs 0 to n-1
        - A single-threaded CPU
        - Execution logs that show when functions start and end
Because the CPU is single-threaded:
        - If a new function starts while another is running → the current function pauses (preempted).
        - When the new function finishes → the previous function resumes.
Your task:
👉 Return the exclusive execution time of each function.

Exclusive time = time spent in the function excluding time spent in child function calls.

Log Format
----------
Each log looks like:          function_id:start:timestamp
                              function_id:end:timestamp
Ex:
n = 2

logs = [
"0:start:0",
"1:start:2",
"1:end:5",
"0:end:6"
]

Execution Timeline
time: 0 1 2 3 4 5 6
      |---0---|
          |---1---|

 Explanation:

Function 0 starts at 0
Function 1 starts at 2 → function 0 pauses
Function 1 ends at 5
Function 0 resumes
Function 0 ends at 6
Exclusive times:
               Function 0 = (0→2) + (6→6) = 3
               Function 1 = (2→5) = 4
Result: [3,4]
 */
/*
Key Idea (Stack)
----------------
Use a stack because functions behave like nested calls.

Stack keeps track of currently running functions.
We also track the previous timestamp.
 */
import java.util.*;

public class DNSCache {

    public static int getMinTime(int cache_size, int cache_time, int server_time, String[] urls) {
        int totalTime = 0;

        LinkedList<String> cache = new LinkedList<>();

        for (String url : urls) {

            if (cache.contains(url)) {
                // Cache hit
                totalTime += cache_time;

                cache.remove(url);
                cache.addLast(url); // mark as recently used
            } else {
                // Cache miss
                totalTime += server_time;

                if (cache_size > 0) {
                    if (cache.size() == cache_size) {
                        cache.removeFirst(); // remove LRU
                    }
                    cache.addLast(url);
                }
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int cache_size = 3;
        int cache_time = 2;
        int server_time = 5;

        String[] urls = {"google.com","yahoo.com","google.com","bing.com","yahoo.com"};

        System.out.println(getMinTime(cache_size, cache_time, server_time, urls));
    }
}
/*
In the Java solution using LinkedList (as shown earlier), the most recent URL is always kept at the end of the list. The list behaves like an LRU cache.

1️⃣ Where the most recent URL is stored ?
The most recently used URL is stored at the end of the list using:
      cache.addLast(url);

So the rightmost element in the LinkedList is the most recent URL.

Example: [a.com, b.com, c.com]          Here:
                                        a.com → Least Recently Used (LRU)
                                        c.com → Most Recently Used (MRU)
2️⃣ Where the URL is added ?
Whenever a URL is accessed (hit or miss), it is added to the end of the cache:
      cache.addLast(url);
This means it becomes the most recently used URL.

3️⃣ When a URL is already present (Cache Hit)
We first remove the old position and then add it to the end to mark it as most recent.

            cache.remove(url);
            cache.addLast(url);

4️⃣ When cache is full (Cache Miss)
We remove the least recently used URL, which is at the front of the list:
          cache.removeFirst();
Then add the new URL at the end:
          cache.addLast(url);
 */