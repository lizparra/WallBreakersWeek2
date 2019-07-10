class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> cabin = new HashMap<>();
        HashSet<String> ban = new HashSet<>();
        
        String[] strArr = paragraph.toLowerCase().split("[\\p{Punct}\\s]+");
        
        for(String str: banned){
            ban.add(str);
        }
        
        for(String str: strArr){
            if(cabin.containsKey(str)){
                cabin.put(str, cabin.get(str) + 1);
            } else {
                if(!ban.contains(str)){
                    cabin.put(str, 1);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(String s: cabin.keySet()){
            if(cabin.get(s) > max){
                max = cabin.get(s);
            }
        }
        
        for(String s: cabin.keySet()){
            if(cabin.get(s) == max){
                return s;
            }
        }
         return null;
    }
}
