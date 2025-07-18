class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        getAllSubsets(nums, 0, subset, result);
        return result;
    }

    public void getAllSubsets(int[] nums, int index, List<Integer> subset,List<List<Integer>> result) {
        if (index > nums.length - 1) {
            // This takes N TC.
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        getAllSubsets(nums, index+1, subset, result);
        subset.remove(subset.size() - 1);
        getAllSubsets(nums, index+1, subset, result);
    }
}

// Total recursive calls
// n = number of nodes = total recursive calls.
// n = 1 + 2 + 4 + 8 ... + 2^h
// n  
// ∑2^h = 2^0 + 2^1 + 2^2 + 2^3 + ... + 2^h;
// 0

// n = 2^(h+1) - 1 / (r - 1) = 2^(h+1) - 1/ (2 - 1) = 2^(h+1) - 1;

// n = 2^(h+1) - 1;

// n ≡ 2^(h+1)
// log n ≡ h + 1
// h ≡ log n; -> height of bst ≡ Timecomplexity of bst.
// n = 2^h -> TC of all recursive calls made in decision tree ≡ nodes of decision tree ≡ h is same as the length of subset given.


