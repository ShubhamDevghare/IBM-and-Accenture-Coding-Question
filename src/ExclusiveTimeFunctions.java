/*
When multiple tasks are executed on a single-threaded CPU, the tasks are scheduled based on the principle of pre-emption.
When a higher-priority task arrives in the execution queue, then the lower-priority task is pre-empted, i.e.,
its execution is paused until the higher-priority task is complete.

There are n functions to be executed on a single-threaded CPU, with each function having a unique ID between 0 and n − 1.

Given an integer n, representing the number of functions to be executed,
and an execution log as an array of strings logs of size m, determine the exclusive times of each of the functions.

Exclusive time is the sum of execution times for all calls to a function excluding the time spent in other functions
that it calls.

Each log entry is a string formatted as:
{function_id}:{start|end}:{timestamp}

function_id → ID of the function
"start" → indicates the start of the function execution
"end" → indicates the end of the function execution
timestamp → the time at which the event occurs
Return an array answer of size n, where answer[i] represents the exclusive time of the function with ID i.
 */
import java.util.*;

public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {

            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {

                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime;
                }

                stack.push(id);
                prevTime = time;

            } else { // end

                result[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return result;
    }
}