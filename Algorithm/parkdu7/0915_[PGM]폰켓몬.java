import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n*2 ; i ++){
            if(!map.containsKey(nums[i])) map.put(nums[i], 1);
            else{
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }
        if(map.size() < n) answer = map.size();
        else answer = n;
        
        return answer;
    }
}
