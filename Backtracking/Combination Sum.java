class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        targetSum(candidates, target, subset, result, 0);
        return result;
    }

    public void targetSum(int[] candidates, int target, List<Integer> subset, List<List<Integer>> result, int prevIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = prevIndex; i < candidates.length; i++) {
            int val = target - candidates[i];
            if (val >= 0) {
                subset.add(candidates[i]);
                targetSum(candidates, val, subset, result, i);
                subset.remove(subset.size() - 1);
            }
        }
        return;
    }
}
