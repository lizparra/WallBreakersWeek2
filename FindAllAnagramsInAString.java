public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        int[] arr = new int[256];
        
        for(int i = 0; i < p.length(); i++){
            arr[p.charAt(i)]++;
        }
        
        int left = 0;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            if(arr[s.charAt(right)] >= 1){
                count++;
            }
            arr[s.charAt(right)]--;
            
            while(count == p.length()){
                if((right - left + 1) == p.length()){
                    result.add(left);
                }
                if(arr[s.charAt(left)] >= 0){
                    count--;
                }
                arr[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}
