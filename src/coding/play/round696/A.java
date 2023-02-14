package coding.play.round696;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            String b= sc.next();
            StringBuilder stringBuilder=new StringBuilder("1");
            StringBuilder stringBuilderfinal=new StringBuilder();
            if (b.charAt(0)=='0') stringBuilderfinal.append('1');
            else stringBuilderfinal.append('2');

            for (int j=1;j<n;j++){
                char ch=b.charAt(j);
                if (stringBuilderfinal.charAt(j-1)=='2'){
                    if (ch=='0'){
                        stringBuilderfinal.append('1');
                        stringBuilder.append('1');
                    }
                    else {
                        stringBuilderfinal.append('1');
                        stringBuilder.append('0');

                    }
                }
                else if (stringBuilderfinal.charAt(j-1)=='1'){
                    if (ch=='0'){
                        stringBuilderfinal.append('0');
                        stringBuilder.append('0');

                    }
                    else {
                        stringBuilderfinal.append('2');
                        stringBuilder.append('1');

                    }

                }
                else {
                    if (ch=='1'){
                        stringBuilderfinal.append('2');
                        stringBuilder.append('1');
                    }
                    else {
                        stringBuilderfinal.append('1');
                        stringBuilder.append('1');
                    }


                }

            }
            System.out.println(stringBuilder);
           // System.out.println(stringBuilderfinal);

        }

    }
}
