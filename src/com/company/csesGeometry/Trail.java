package com.company.csesGeometry;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Trail {
    public static void main(String[] args) {
        Students[] students=new Students[5];
        students[0]=new Students("S","D",1);
        students[1]=new Students("Y","Y",2);
        students[2]=new Students("Y","Y",1);
        students[3]=new Students("T","H",4);
        students[4]=new Students("R","G",5);
        //Arrays.sort(students);

       // Arrays.sort(students,new Comparetorr());

        Arrays.sort(students,(a,b)-> a.rollNo-b.rollNo);
        for (int i=0;i<students.length;i++){
            System.out.println(students[i].name+"  "+students[i].location+"  "+students[i].rollNo);
        }


    }
    static class Comparetorr implements Comparator<Students>{

        @Override
        public int compare(Students o1, Students o2) {
           return o1.rollNo- o2.rollNo;
        }
    }

     static class Students {
        String name;
        String location;
        int rollNo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getRollNo() {
            return rollNo;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        public Students(String name, String location, int rollNo) {
            this.name = name;
            this.location = location;
            this.rollNo = rollNo;
        }

        public Students() {
        }


         public int compareTo(  Students  o) {
            if (this.name.equals(o.name)){
                if (this.location.equals(o.location)){
                    return this.rollNo-o.rollNo;

                }
                else {
                    return this.location.compareTo(o.location);
                }

            }
            else {
                return this.name.compareTo(o.name);
            }

           // return this.rollNo-o.rollNo;
         }
     }

}
