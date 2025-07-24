
// TC - n! * n
// SC - n
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Set<Integer> iStore = new HashSet<>();
        findPerm(nums, nums.length, iStore, result, subset);
        return result;
    }

    public void findPerm(int[] nums, int len, Set<Integer> iStore, List<List<Integer>> result, List<Integer> subset) {
        if (len == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (iStore.contains(i))
                continue;
            iStore.add(i);
            subset.add(nums[i]);
            findPerm(nums, len - 1, iStore, result, subset);
            subset.remove(subset.size() - 1);
            iStore.remove(i);
        }
        return;
    }
}

// TC - n! * n
// SC - 1
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPerm(nums, result, 0);
        return result;
    }

    public void findPerm(int[] nums, List<List<Integer>> result, int ind) {
        if (ind == nums.length) {
            List<Integer> a = new ArrayList<>();
            for (int i=0;i<nums.length;i++) a.add(nums[i]);
            result.add(a);
        }
        for (int i=ind;i<nums.length;i++) {
            swap(ind, i, nums);
            findPerm(nums, result, ind+1);
            swap(i, ind, nums);
        }
        return;
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
