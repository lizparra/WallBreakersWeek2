class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        
        if(pattern.length() != strArr.length){
            return false;
        }
        
        HashMap<Character, String> hash = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            if(hash.containsKey(pattern.charAt(i))){
                if(hash.get(pattern.charAt(i)).equals(strArr[i])){
                    continue;
                } else {
                    return false;
                }
            } else {
                if(hash.containsValue(strArr[i])){
                    return false;
                }
                hash.put(pattern.charAt(i), strArr[i]);
            }
        }
        
        return true;
    }
}
