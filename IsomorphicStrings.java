class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1){
            return true;
        }
        
        HashMap<Character, Character> hash = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            if(hash.containsKey(s.charAt(i))){
                if(t.charAt(i) != hash.get(s.charAt(i))){
                    return false;
                }
            } else {
                if(hash.containsValue(t.charAt(i))){
                    return false;
                }
                hash.put(s.charAt(i), t.charAt(i));
            }
        }
        
        return true;
    }
}
