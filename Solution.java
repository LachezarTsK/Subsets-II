import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    /*
    Applying bitmask to generate all possible combinations. 
    In order to avoid duplicate combinations, they are added to a set, 
    thus the method returns only unique combinations.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        int lowerBounadry = (int) Math.pow(2, nums.length);
        int upperBounadry = (int) Math.pow(2, nums.length + 1);

        for (int i = lowerBounadry; i < upperBounadry; i++) {

            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> combination = new ArrayList<>();

            for (int bit = 0; bit < bitmask.length(); bit++) {
                if (bitmask.charAt(bit) == '1') {
                    combination.add(nums[bit]);
                }
            }
            result.add(combination);
        }
        return new ArrayList(result);
    }
}
