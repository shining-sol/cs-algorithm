import java.util.*;
import java.io.*;

class 폭행몬 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> poket = new HashSet<>();
        for(int n : nums){
            poket.add(n);
        }

        int maxP = nums.length /2;
        answer = Math.min(poket.size(),maxP);

        return answer;
    }
}