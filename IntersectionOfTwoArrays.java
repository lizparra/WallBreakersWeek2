class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> combined = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        
        for(int i = 0; i < nums2.length; i++){
            combined.add(nums2[i]);
        }
        
        for(int i = 0; i < nums1.length; i++){
            if(combined.contains(nums1[i])){
                result.add(nums1[i]);
            }
        }
        
        int index = 0;
        int[] answer = new int[result.size()];
        for(Integer i: result){
            answer[index] = i;
            index++;
        }
        return answer;
    }
}
