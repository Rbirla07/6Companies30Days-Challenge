public class NumberPattern {
    public static String printMinNumberForPattern(String S){
        // code here
        StringBuilder sb  = new StringBuilder();
        int min = 1;
        int max = S.length() + 1;
        int i = 0;
        while(i< S.length()){
            if(S.charAt(i) == 'I'){
                sb.append(min);
                min++;
            }
            if(S.charAt(i) == 'D'){
                sb.append(max);
                max--;
            }
            i++;
        }
        if(S.charAt(i-1) == 'I'){
            sb.append(max);
        }
        if(S.charAt(i-1) == 'D'){
            sb.charAt(min);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printMinNumberForPattern("D"));
    }

}
