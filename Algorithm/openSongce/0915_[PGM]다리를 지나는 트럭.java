import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>();
        int time = 0, idx = 0, onBridgeWeight = 0;

        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++;

            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                onBridgeWeight -= bridge.poll()[0];
            }

            if (idx < truck_weights.length) {
                int next = truck_weights[idx];
                if (bridge.size() < bridge_length && onBridgeWeight + next <= weight) {
                    onBridgeWeight += next;
                    bridge.offer(new int[]{next, time + bridge_length});
                    idx++;
                }
            }
        }
        return time;
    }
}
