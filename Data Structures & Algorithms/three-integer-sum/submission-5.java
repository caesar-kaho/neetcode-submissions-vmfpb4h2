
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // Iterate with the first pointer 'i'
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element to avoid processing the same starting number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Use two pointers for the rest of the array
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int currentSum = nums[left] + nums[right];

                if (currentSum == target) {
                    // Found a triplet!
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // CRITICAL: After finding a valid triplet, move the pointers
                    // past all subsequent duplicates of the current left and right values.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move to the next unique pair
                    left++;
                    right--;
                    
                } else if (currentSum < target) {
                    left++;
                } else { // currentSum > target
                    right--;
                }
            }
        }
        return res;
    }
}