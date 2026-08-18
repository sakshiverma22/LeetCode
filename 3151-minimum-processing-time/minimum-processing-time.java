import java.util.*;

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        // Convert processorTime to a primitive array and sort ascending
        int n = processorTime.size();
        Integer[] proc = processorTime.toArray(new Integer[0]);
        Arrays.sort(proc); // ascending: earliest-available processor first

        // Convert tasks to array and sort descending: slowest task first
        Integer[] task = tasks.toArray(new Integer[0]);
        Arrays.sort(task, (a, b) -> b - a);

        int answer = 0;
        int taskIdx = 0; // pointer into descending-sorted tasks array

        for (int i = 0; i < n; i++) {
            // The first task in this processor's group of 4 is the largest (sorted descending)
            int finishTime = proc[i] + task[taskIdx];
            answer = Math.max(answer, finishTime);
            taskIdx += 4; // move to next group of 4 tasks
        }

        return answer;
    }
}