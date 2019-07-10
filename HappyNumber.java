class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int sum;
        int remain;
        while (inLoop.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n%10;
                sum = sum + (remain*remain);
                n /= 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
        }
        return false;

    }
}
