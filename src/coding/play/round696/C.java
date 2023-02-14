package coding.play.round696;

import java.awt.*;
import java.beans.BeanInfo;
import java.util.*;

public class C {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            boolean isposs=false;
            Integer[] arr=new Integer[2*n];
            for (int j=0;j<2*n;j++) arr[j]= sc.nextInt();
            Arrays.sort(arr,Collections.reverseOrder());
            for (int j=0;j<2*n;j++){
                HashMap<Integer,Integer> map=new HashMap<>();
                for (Integer aa:arr) map.put(aa,map.getOrDefault(aa,0)+1);
                ArrayList<Pair> points=new ArrayList<>();
                boolean ok=true;
                int max=arr[0];
                int took=arr[j];
                map.put(took,map.getOrDefault(took,0)-1);
                map.put(max,map.getOrDefault(max,0)-1);
                for (int p=1;p<2*n;p++){
                    if (p==j||map.get(arr[p])<=0) continue;
                    map.put(arr[p],map.getOrDefault(arr[p],0)-1);
                    int lookFor=max-arr[p];
                    if (map.getOrDefault(lookFor,0)>0){
                        max=arr[p];
                        points.add(new Pair(lookFor,arr[p]));
                        map.put(lookFor,map.get(lookFor)-1);

                    }
                    else {
                        ok=false;
                    }
                }
                if (ok){
                    System.out.println("YES");
                    System.out.println(arr[0]+took);
                    System.out.println(arr[0]+" "+took);
                    for (Pair pp:points) System.out.println(pp.a+" "+pp.b);
                    isposs=true;
                    break;
                }





            }
            if (!isposs) System.out.println("NO");

        }


    }
    static class  Pair{
        int a,b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
