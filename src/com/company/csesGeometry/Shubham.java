package com.company.csesGeometry;

public class Shubham {
    public static boolean checker(String A, String B){
        if(A==null || B==null)
            return false;

        String longer = A.length()>B.length() ? A : B;
        String shorter = A.length()<=B.length() ? A : B;

        int j = 0;
        for (int i = 0; i < longer.length() && j < shorter.length(); i++) {
            if (longer.charAt(i) == shorter.charAt(j))
                j++;
        }

        if(j==shorter.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        String A = "abcd";
        String B = "abcd";
        if (checker(B,A)==true){
            for (int i=1;i<A.length();i++) {
                if (A.charAt(0)!=A.charAt(i)) {
                    System.out.println("True");
                    return;
                }
            }
        }
        System.out.println("False");
    }
}
