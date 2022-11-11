package com.company.graphsOnceAgain

import kotlin.jvm.JvmStatic
import java.util.Collections
import java.io.BufferedReader
import java.util.StringTokenizer
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList

object ANewYearTransportation {
    var fs = FastScanner()
    @JvmStatic
    fun main(args: Array<String>) {
//        int n= fs.nextInt();int t= fs.nextInt();
//        int[] arr=fs.readArray(n-1);
//        boolean reached=false;
//        int curPos=1;
//        for (int i=0;i<n-1;i++){
//            if (i==curPos-1){
//                curPos+=arr[curPos-1];
//                if (curPos==t){
//                    reached=true;
//                }
//            }
//
//        }
//        System.out.println(reached?"YES":"NO");
//        do {
//            println("hi")
//        } while (true)
    }

    fun sort(a: IntArray) {
        val l = ArrayList<Int>()
        for (i in a) l.add(i)
        Collections.sort(l)
        for (i in a.indices) a[i] = l[i]
    }

    class FastScanner {
        var br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer("")
        operator fun next(): String {
            while (!st.hasMoreTokens()) try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return st.nextToken()
        }

        fun nextInt(): Int {
            return next().toInt()
        }

        fun readArray(n: Int): IntArray {
            val a = IntArray(n)
            for (i in 0 until n) a[i] = nextInt()
            return a
        }

        fun nextLong(): Long {
            return next().toLong()
        }
    }
}