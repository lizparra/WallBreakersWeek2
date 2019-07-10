class Solution {
    public char findTheDifference(String s, String t) {
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        
        for(int i = 0; i < t.length(); i++){
            if(list.contains(t.charAt(i))){
                list.remove(new Character(t.charAt(i)));
            } else {
                return t.charAt(i);
            }
        }
        
        return 'a';
    }
}
