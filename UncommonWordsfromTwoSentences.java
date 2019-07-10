class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> words = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        String[] arr1 = A.split(" ");
        String[] arr2 = B.split(" ");
        
        for(int i = 0; i < arr1.length; i++){
            if(repeated.contains(arr1[i])){
                continue;
            }
            
            if(!words.add(arr1[i])){
                repeated.add(arr1[i]);
                words.remove(arr1[i]);
            }
        }
        
        for(int i = 0; i < arr2.length; i++){
            if(repeated.contains(arr2[i])){
                continue;
            }
            
            if(!words.add(arr2[i])){
                repeated.add(arr2[i]);
                words.remove(arr2[i]);
            }
        }

        String[] arr = new String[words.size()];
        int i = 0;
        for(String x: words){
            arr[i++] = x;
        }
        
        return arr;
    }
}
