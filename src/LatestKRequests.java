/*
Given n request ids as an array of strings, requests, and an integer k, after all requests are received,
find the k most recent requests. Report the answer in order of most recent to least recent.

Example
Suppose

n = 5
requests = ["item1", "item2", "item3", "item1", "item3"]
k = 3

Starting from the right and moving left, collecting distinct requests, there is "item3" followed by "item1".
Skip the second instance of "item3" and find "item2".

The answer is:
["item3", "item1", "item2"]

Function Description
--------------------
Complete the function getLatestKRequests in the editor below.
getLatestKRequests takes the following arguments:
str requests[n]: the request ids
int k: the number of requests to report

Returns
-------
str[k]: the k most recent requests
 */
/*
Given n request ids as an array of strings requests and an integer k, return the k most recent distinct requests
in order from most recent → least recent.
Example:
n = 5
requests = ["item1", "item2", "item3", "item1", "item3"]
k = 3

From the right side (most recent first):
item3 → add
item1 → add
item3 → skip (already added)
item2 → add

Result:
["item3", "item1", "item2"]
 */
import java.util.*;

public class LatestKRequests {

    public static List<String> getLatestKRequests(String[] requests, int k) {
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = requests.length - 1; i >= 0; i--) {
            if (!seen.contains(requests[i])) {
                seen.add(requests[i]);
                result.add(requests[i]);
            }

            if (result.size() == k) {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] requests = {"item1", "item2", "item3", "item1", "item3"};
        int k = 3;

        System.out.println(getLatestKRequests(requests, k));
    }
}