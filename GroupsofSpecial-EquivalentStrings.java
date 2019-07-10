class Solution {
    private String hash(String a){
        char[][] count = new char[2][26];
        
        Arrays.fill(count[0],'a');
        Arrays.fill(count[1],'a');  
        
        int index =0;
        
        for(char c : a.toCharArray()){
            count[index%2][c-'a']++;
            index++;
        }
       return (new String(count[0]))+"_"+(new String(count[1]));
    }
    
    public int numSqpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for(String aString: A){
            set.add(hash(aString));
        }
        return set.size();
    }
}
