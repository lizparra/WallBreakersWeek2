class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int max = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
            if(hash.get(s.charAt(i)) > max){
                max = hash.get(s.charAt(i));
            }
        }
        
        List<Character>[] bucket = new List[max + 1];
        
        for(Character c: hash.keySet()){
            if(bucket[hash.get(c)] == null){
                bucket[hash.get(c)] = new ArrayList<>();
            }
            bucket[hash.get(c)].add(c);
        }
        
        StringBuilder str = new StringBuilder();
        for(int i = max; i >= 0; i--){
            if(bucket[i] != null){
                for(Character c: bucket[i]){
                    for(int j = 0; j < hash.get(c); j++){
                        str.append(c);
                    }
                }
            }
        }
        
        return str.toString();
    }
}
