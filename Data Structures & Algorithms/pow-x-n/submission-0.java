class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        for (int i = 0; i < Math.abs(n); i ++) {
            ans = ans * x;
        }

        return n >= 0 ? ans : 1 / ans;
    }
}
