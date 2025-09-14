import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<truck_weights.length; i++){
            while(true){
                if(q.size() == bridge_length){
                    w -= q.poll();
                }

                else if(q.isEmpty()){
                    q.add(truck_weights[i]);
                    w = truck_weights[i];
                    answer++;
                    break;
                }

                else{
                    if(w+truck_weights[i] <= weight){
                        q.add(truck_weights[i]);
                        w = w + truck_weights[i];
                        answer++;
                        break;
                    }
                    else{
                        q.add(0);
                        answer++;
                    }
                }
        
            }

        }
        return answer + bridge_length;
    }
}
