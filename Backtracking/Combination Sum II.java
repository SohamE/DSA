class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        // to have all subsets in asc order, helps to remove duplicate in recursion.
        Arrays.sort(candidates);
        findSum(result, subset, 0, target, candidates);
        return result;
    }

    public void findSum(List<List<Integer>> result, List<Integer> subset, int start, int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // To remove duplicates, as the array is sorted.
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                subset.add(candidates[i]);
                findSum(result, subset, i + 1, newTarget, candidates);
                subset.remove(subset.size() - 1);
            }
        }
        return;
    }
}
