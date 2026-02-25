class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        targetSum(candidates, target, subset, result, 0);
        return result;
    }

    public void targetSum(int[] candidates, int target, List<Integer> subset, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        subset.add(candidates[index]);
        targetSum(candidates, target-candidates[index], subset, result, index);
        subset.remove(subset.size() - 1);
        targetSum(candidates, target, subset, result, index+1);
        return;
    }
}
