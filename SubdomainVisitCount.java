class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        int number;
        for(int i = 0; i < cpdomains.length; i++){
            String[] split = cpdomains[i].split(" ");
            number = Integer.parseInt(split[0]);
            if(hash.containsKey(split[1])){
                hash.put(split[1], hash.get(split[1]) + number);
            } else {
                hash.put(split[1], number);
            }
            StringBuilder str;
            for(int j = 0; j < split[1].length(); j++){
                if(split[1].charAt(j) == '.'){
                    str = new StringBuilder(split[1].substring(j+1));
                    if(hash.containsKey(str.toString())){
                        hash.put(str.toString(), hash.get(str.toString()) + number);
                    } else {
                        hash.put(str.toString(), number);
                    }
                }
            }
        }
        
        for(String str: hash.keySet()){
            list.add(hash.get(str) + " " + str);
        }
        
        return list;
    }
}
