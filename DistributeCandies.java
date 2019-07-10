class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        
        for(int i = 0; i < candies.length; i++){
            kinds.add(candies[i]);
        }
        
        if(kinds.size() > (candies.length/2)){
            return candies.length/2;
        } else {
            return kinds.size();
        }
    }
}
