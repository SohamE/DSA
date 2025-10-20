class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int[] hxyBar = minMax(hBars);
        int[] vxyBar = minMax(vBars);
        int val = Math.min(hxyBar[1] - hxyBar[0] + 2, vxyBar[1] - vxyBar[0] + 2);
        return val * val;
    }

    public int[] minMax(int[] arr) {
        int maxStart = 0;
        int maxEnd = 0;
        int start = 0;
        int maxLen = 0;
        int end = 1;
        while (end < arr.length) {
            if (arr[end] == arr[end - 1] + 1) {
                if (end - start + 1 > maxLen) {
                    maxStart = start;
                    maxEnd = end;
                }
                maxLen = Math.max(maxLen, end - start + 1);
            } else {
                start = end;
            }
            end++;
        }
        return new int[] { arr[maxStart], arr[maxEnd] };
    }
}
