// https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/description/
public class MinMaxOf2Arrays {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low= 1;
        long high= Integer.MAX_VALUE;
        long output = high;
        long lcm = ((long) divisor1 * (long) divisor2) / gcd(divisor1, divisor2);
        while(low <= high){
            long mid = low+(high - low)/2;
            int x = (int) (mid - mid/divisor1);
            int y = (int) (mid - mid/divisor2);
            int z = (int) (mid - mid/lcm);
            if(x< uniqueCnt1 || y < uniqueCnt2 || z< uniqueCnt1+uniqueCnt2){
                low = mid + 1;
            }else{
                output = Math.min(output, mid);
                high = mid -1;
            }

        }

        return(int) output;
    }
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
