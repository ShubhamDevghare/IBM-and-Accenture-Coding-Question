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