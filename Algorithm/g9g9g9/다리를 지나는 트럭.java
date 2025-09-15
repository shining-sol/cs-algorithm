import java.util.*;

class Solution {
    static class Truck {
        int w;
        int exitTime; 
        Truck(int w, int exitTime) {
            this.w = w; this.exitTime = exitTime; 
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new ArrayDeque<>();
        int time = 0;
        int onBridge = 0;
        int i = 0;       

        while (i < truck_weights.length || !bridge.isEmpty()) {
            time++; 

            
            if (!bridge.isEmpty() && bridge.peek().exitTime == time) {
                onBridge -= bridge.poll().w;
            }

            
            if (i < truck_weights.length) {
                int w = truck_weights[i];
                if (onBridge + w <= weight && bridge.size() < bridge_length) {
                    onBridge += w;
                    bridge.offer(new Truck(w, time + bridge_length));
                    i++;
                }
            }
        }

        return time;
    }
}

