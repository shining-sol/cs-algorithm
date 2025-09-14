import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        Set<Integer> kinds = new HashSet<>();
        for (int x : nums) kinds.add(x);
        return Math.min(kinds.size(), n / 2);
    }
}
