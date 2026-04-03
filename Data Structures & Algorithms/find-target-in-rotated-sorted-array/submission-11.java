class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {

            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            
 if (nums[l] <= nums[mid]) {
                // Step 2: Check if target is in the sorted left half
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1; // Search left
                } else {
                    l = mid + 1; // Search right (in the unsorted part)
                }
            } 
            // Case 2: The right half [mid...r] is sorted
            else {
                // Step 2: Check if target is in the sorted right half
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1; // Search right
                } else {
                    r = mid - 1; // Search left (in the unsorted part)
                }
            }
        }
        return -1;
    }
}