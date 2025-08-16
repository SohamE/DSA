class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = -1;
        while (sum != target) {
            sum = numbers[left] + numbers[right];
            if (sum > target)
                right--;
            if (sum < target)
                left++;
        }
        return new int[] { left+1, right+1 };
    }
}
