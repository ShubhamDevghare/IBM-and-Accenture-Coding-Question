/*
Implement a simple prototype service to find the difference between two JSON (JavaScript Object Notation) objects.
To keep the prototype simple, a JSON will contain only key-value pairs and no nested objects or arrays in it.
Given two JSON strings, json1 and json2, find the list of keys for which the values are different.
If a key is present in only one of the JSONs, it should not be considered in the result.
The list of keys should be sorted in lexicographically ascending order.

Example
Suppose
json1 = {"hello":"world","hi":"hello","you":"me"}
json2 = {"hello":"world","hi":"helloo","you":"me"}

The only common key where the values differ is "hi". Hence the answer is:
["hi"]

Function Description
--------------------
Complete the function getJSONDiff in the editor below.
getJSONDiff has the following parameter(s):
json1: the first JSON string
json2: the second JSON string

Returns:
string[] : a sorted list of keys that have different associated values in the two JSONs
 */

/*
Java Solution for getJSONDiff
Approach :
1.Convert both JSON strings into Map<String, String>.
2.Iterate over keys of the first map.
3.Check:
key exists in both maps
   values are different
   Store such keys in a list.
4.Sort the list lexicographically.
5.Time Complexity: O(n log n) (sorting)
 */
import java.util.*;

public class JSONDiff {

    public static List<String> getJSONDiff(String json1, String json2) {

        Map<String, String> map1 = parseJSON(json1);
        Map<String, String> map2 = parseJSON(json2);

        List<String> result = new ArrayList<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && !map1.get(key).equals(map2.get(key))) {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }

    private static Map<String, String> parseJSON(String json) {
        Map<String, String> map = new HashMap<>();

        json = json.substring(1, json.length() - 1); // remove { }
        String[] pairs = json.split(",");

        for (String pair : pairs) {
            String[] kv = pair.split(":");
            String key = kv[0].trim().replace("\"", "");
            String value = kv[1].trim().replace("\"", "");

            map.put(key, value);
        }
        return map;
    }
    public static void main(String[] args) {

        String json1 = "{\"hello\":\"world\",\"hi\":\"hello\",\"you\":\"me\"}";
        String json2 = "{\"hello\":\"world\",\"hi\":\"helloo\",\"you\":\"me\"}";

        System.out.println(getJSONDiff(json1, json2));
    }
}