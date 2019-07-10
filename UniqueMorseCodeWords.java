class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hash = new HashSet<>();
        StringBuilder s = new StringBuilder("");
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                int index = words[i].charAt(j) - 'a';
                s = s.append(morseArr[index]);
            }
            if(!hash.contains(s.toString())){
                hash.add(s.toString());
            }
            s.setLength(0);
        }
               
        return hash.size();
    }
}
