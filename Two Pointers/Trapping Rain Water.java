class Solution {
    public int trap(int[] height) {
      int result = 0;
      int[] maxLeft = maxLeft(height);
      int[] maxRight = maxRight(height);

      for(int i=0;i<height.length -1;i++){
        int storedWater = Math.min(maxLeft[i], maxRight[i]) - height[i];
        if (storedWater > 0) {
          result+=storedWater;
        }
      }
      return result;
  }

  public int[] maxLeft(int[] heights) {
    int[] maxLeft = new int[heights.length];
    int max = 0;
    for(int i=0;i<heights.length-1;i++) {
      maxLeft[i] = max;
      max = Math.max(heights[i], max);
    }
    return maxLeft;
  }

  public int[] maxRight(int[] heights) {
    int[] maxRight = new int[heights.length];
    int max = 0;
    for(int i=heights.length-1;i>0;i--) {
      maxRight[i] = max;
      max = Math.max(heights[i], max);
    }
    return maxRight;
  }
}
