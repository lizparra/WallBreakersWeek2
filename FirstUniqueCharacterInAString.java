class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0 || s == null){
            return -1;
        }
        
        HashMap<Character, Integer> arr = new HashMap<>();
        HashSet<Character> hash = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            if(arr.containsKey(s.charAt(i))){
                arr.remove(s.charAt(i));
                hash.add(s.charAt(i));
            } else if(!hash.contains(s.charAt(i))){
                arr.put(s.charAt(i), i);     
            }
        }
        
        if(arr.size() == 0){
            return -1;
        }
        
        int index = 0;
        boolean first = true;
        for(Integer i: arr.values()){
            if(first){
                index = i;
                first = false;
            }
            if(i < index){
                index = i;
            }
        } 
        
        return index;
    }
}
