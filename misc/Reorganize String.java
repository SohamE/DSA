class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue(
            (a,b) -> freq.get(b) - freq.get(a)
        );
        maxHeap.addAll(freq.keySet());

        Character prev = null;
        int prevCount = 0;
        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Character c = maxHeap.poll();
            result.append(c);
            freq.put(c, freq.get(c) - 1);
            
            if(prevCount > 0) {
                maxHeap.offer(prev);
            }
            prev = c;
            prevCount = freq.get(c);
        } 
        return (result.length() == s.length()) ? result.toString() : "";
    }
}
