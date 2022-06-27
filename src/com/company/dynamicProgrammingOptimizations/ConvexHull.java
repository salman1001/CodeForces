package com.company.dynamicProgrammingOptimizations;

import java.io.*;
import java.util.*;

public class ConvexHull extends PrintWriter {


    void solve()  {
        int n = sc.nextInt();
        a = new long[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        long[] b = new long[n];
        for(int i = 0; i < n; i++) b[i] = sc.nextInt();

        ConvexHullTrickMin lines = new ConvexHullTrickMin();


        long dp = 0L;
        lines.addLine(b[0],  0L);
        for(int i = 1; i < n; i++) {
            dp = lines.query(a[i]);
            lines.addLine(b[i], dp);
        }
        println(dp);
    }

    long[] a;


    //  Solution() throws FileNotFoundException { super(new File("output.txt")); }
//  InputReader sc = new InputReader(new FileInputStream("test_input.txt"));
    ConvexHull() { super(System.out); }
    InputReader sc = new InputReader(System.in);
    static class InputReader {
        InputReader(InputStream in) { this.in = in; } InputStream in;

        private byte[] buf = new byte[16384];
        private int    curChar;
        private int    numChars;


        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }

    public static void main(String[] $) {
        new Thread(null, new Runnable() {
            public void run() {
                long start = System.nanoTime();
                try {ConvexHull solution = new ConvexHull(); solution.solve(); solution.flush();}
                catch (Exception e) {e.printStackTrace(); System.exit(1);}
                System.err.println((System.nanoTime()-start)/1E9);
            }
        }, "1", 1 << 27).start();

    }
}

class Rational implements Comparable<Rational> {
    private long a;
    private long b;

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public Rational() {
        a = 0;
        b = 1;
    }

    public static boolean checkLessRational(long a1, long b1, long a2, long b2) {
        long tsn = a1;
        long tsd = b1;
        long tsq = a1 / b1;
        long tsr = a1 % b1;

        long rsn = a2;
        long rsd = b2;
        long rsq = a2 / b2;
        long rsr = a2 % b2;

        int reverse = 0;


        while (tsr < 0) {
            tsr += tsd;
            --tsq;
        }
        while (rsr < 0) {
            rsr += rsd;
            --rsq;
        }

        // Loop through and compare each variable's continued-fraction components
        for (; ; ) {
            // The quotients of the current cycle are the continued-fraction
            // components.  Comparing two c.f. is comparing their sequences,
            // stopping at the first difference.
            if (tsq != rsq) {
                // Since reciprocation changes the relative order of two variables,
                // and c.f. use reciprocals, the less/greater-than test reverses
                // after each index.  (Start w/ non-reversed @ whole-number place.)
                return reverse != 0 ? tsq > rsq : tsq < rsq;
            }

            // Prepare the next cycle
            reverse ^= 1;

            if ((tsr == 0) || (rsr == 0)) {
                // At least one variable's c.f. expansion has ended
                break;
            }

            tsn = tsd;
            tsd = tsr;
            tsq = tsn / tsd;
            tsr = tsn % tsd;
            rsn = rsd;
            rsd = rsr;
            rsq = rsn / rsd;
            rsr = rsn % rsd;
        }

        // Compare infinity-valued components for otherwise equal sequences
        if (tsr == rsr) {
            // Both remainders are zero, so the next (and subsequent) c.f.
            // components for both sequences are infinity.  Therefore, the sequences
            // and their corresponding values are equal.
            return false;
        } else {

            // Exactly one of the remainders is zero, so all following c.f.
            // components of that variable are infinity, while the other variable
            // has a finite next c.f. component.  So that other variable has the
            // lesser value (modulo the reversal flag!).
            return (tsr != 0) != (reverse != 0);

        }
    }

    public Rational(long a, long b) {
        this.a = a;
        this.b = b;
        if (b == 0) throw new RuntimeException();
        reduce();
    }

    public void reduce() {
        long g = LongMath.gcd(Math.abs(a), Math.abs(b));
        if (b < 0) g = -g;
        this.a /= g;
        this.b /= g;
    }


    public int compareTo(Rational o) {
        int ret = -1;
        if (a == o.a && b == o.b) ret = 0;
        else if (!checkLessRational(a, b, o.a, o.b)) ret = 1;

        return ret;
        //return Long.compare(LongMath.checkedMultiply(this.a, o.b), LongMath.checkedMultiply(o.a, this.b));
    }


    public String toString() {
        return +a + "/" + b;
    }


    public int hashCode() {
        return Long.hashCode(a) ^ Long.hashCode(b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Rational) {
            return this.compareTo((Rational) obj) == 0;
        }
        return false;
    }

}

final class MathPreconditions {
    static long checkNonNegative(String role, long x) {
        if (x < 0) {
            throw new IllegalArgumentException(role + " (" + x + ") must be >= 0");
        }
        return x;
    }

    static void checkNoOverflow(boolean condition) {
        if (!condition) {
            throw new ArithmeticException("overflow");
        }
    }

    private MathPreconditions() {
    }

}

final class LongMath {
    public static long gcd(long a, long b) {
        /*
         * The reason we require both arguments to be >= 0 is because otherwise, what do you return on
         * gcd(0, Long.MIN_VALUE)? BigInteger.gcd would return positive 2^63, but positive 2^63 isn't an
         * int.
         */
        MathPreconditions.checkNonNegative("a", a);
        MathPreconditions.checkNonNegative("b", b);
        if (a == 0) {
            // 0 % b == 0, so b divides a, but the converse doesn't hold.
            // BigInteger.gcd is consistent with this decision.
            return b;
        } else if (b == 0) {
            return a; // similar logic
        }
        /*
         * Uses the binary GCD algorithm; see http://en.wikipedia.org/wiki/Binary_GCD_algorithm. This is
         * >60% faster than the Euclidean algorithm in benchmarks.
         */
        int aTwos = Long.numberOfTrailingZeros(a);
        a >>= aTwos; // divide out all 2s
        int bTwos = Long.numberOfTrailingZeros(b);
        b >>= bTwos; // divide out all 2s
        while (a != b) { // both a, b are odd
            // The key to the binary GCD algorithm is as follows:
            // Both a and b are odd. Assume a > b; then gcd(a - b, b) = gcd(a, b).
            // But in gcd(a - b, b), a - b is even and b is odd, so we can divide out powers of two.

            // We bend over backwards to avoid branching, adapting a technique from
            // http://graphics.stanford.edu/~seander/bithacks.html#IntegerMinOrMax

            long delta = a - b; // can't overflow, since a and b are nonnegative

            long minDeltaOrZero = delta & (delta >> (Long.SIZE - 1));
            // equivalent to Math.min(delta, 0)

            a = delta - minDeltaOrZero - minDeltaOrZero; // sets a to Math.abs(a - b)
            // a is now nonnegative and even

            b += minDeltaOrZero; // sets b to min(old a, b)
            a >>= Long.numberOfTrailingZeros(a); // divide out all 2s, since 2 doesn't divide b
        }
        return a << Math.min(aTwos, bTwos);
    }

    public static long checkedAdd(long a, long b) {
        long result = a + b;
        MathPreconditions.checkNoOverflow((a ^ b) < 0 | (a ^ result) >= 0);
        return result;
    }

    public static long checkedMultiply(long a, long b) {
        // Hacker's Delight, Section 2-12
        int leadingZeros =
                Long.numberOfLeadingZeros(a)
                        + Long.numberOfLeadingZeros(~a)
                        + Long.numberOfLeadingZeros(b)
                        + Long.numberOfLeadingZeros(~b);
        /*
         * If leadingZeros > Long.SIZE + 1 it's definitely fine, if it's < Long.SIZE it's definitely
         * bad. We do the leadingZeros check to avoid the division below if at all possible.
         *
         * Otherwise, if b == Long.MIN_VALUE, then the only allowed values of a are 0 and 1. We take
         * care of all a < 0 with their own check, because in particular, the case a == -1 will
         * incorrectly pass the division check below.
         *
         * In all other cases, we check that either a is 0 or the result is consistent with division.
         */
        if (leadingZeros > Long.SIZE + 1) {
            return a * b;
        }
        MathPreconditions.checkNoOverflow(leadingZeros >= Long.SIZE);
        MathPreconditions.checkNoOverflow(a >= 0 | b != Long.MIN_VALUE);
        long result = a * b;
        MathPreconditions.checkNoOverflow(a == 0 || result / a == b);
        return result;
    }

    private LongMath() {
    }

}

class ConvexHullTrickMin {
    private static final Rational MIN_VALUE = new Rational(Long.MIN_VALUE + 2, 1);
    private TreeSet<ConvexHullTrickMin.Line> hull = new TreeSet<>();
    private ConvexHullTrickMin.Line forQueryLine;

    public ConvexHullTrickMin() {
        forQueryLine = new ConvexHullTrickMin.Line(0, 0);
        forQueryLine.isQuery = true;
    }

    public void addLine(long a, long b) {
        ConvexHullTrickMin.Line l = new ConvexHullTrickMin.Line(a, b);
        ConvexHullTrickMin.Line it = hull.ceiling(l);
        ConvexHullTrickMin.Line pre, next;
        if (it != null && l.a == it.a) {
            if (it.b <= l.b) return;
            else {
                it.b = b;
                l = it;
            }
        } else {
            if ((pre = hull.lower(l)) != null
                    && (next = hull.higher(l)) != null
                    && ConvexHullTrickMin.Line.bad(pre, l, next)) {
                return;
            }
            hull.add(l);
        }

        pre = null;
        next = null;
        NavigableSet<ConvexHullTrickMin.Line> headSet = hull.headSet(l, false);
        Iterator<ConvexHullTrickMin.Line> iter = headSet.descendingIterator();
        Iterator<ConvexHullTrickMin.Line> iter2 = headSet.descendingIterator();
        ConvexHullTrickMin.Line l3 = l, l2, l1;

        int cnt = 0;
        if (iter.hasNext()) {
            l2 = iter.next();
            pre = l2;


            while (iter.hasNext()) {
                l1 = iter.next();
                if (ConvexHullTrickMin.Line.bad(l1, l2, l3)) {
                    cnt++;
                    l2 = l1;
                    pre = l2;
                } else {
                    break;
                }
            }
            for (int i = 0; i < cnt; ++i) {
                iter2.next();
                iter2.remove();
            }
        }

        l1 = l;

        NavigableSet<ConvexHullTrickMin.Line> tailSet = hull.tailSet(l, false);
        iter = tailSet.iterator();
        iter2 = tailSet.iterator();

        if (iter.hasNext()) {
            l2 = iter.next();
            next = l2;
            cnt = 0;
            while (iter.hasNext()) {
                l3 = iter.next();

                if (ConvexHullTrickMin.Line.bad(l1, l2, l3)) {
                    cnt++;
                    l2 = l3;
                    next = l2;
                } else {
                    break;
                }
            }
            for (int i = 0; i < cnt; ++i) {
                iter2.next();
                iter2.remove();
            }
        }

        if (pre != null) {
            l.p = ConvexHullTrickMin.Line.intersect(pre, l);

        } else {
            l.p = MIN_VALUE;
        }

        if (next != null) {
            next.p = ConvexHullTrickMin.Line.intersect(l, next);
        }
    }

    public long query(long x) {
        forQueryLine.x = x;
        ConvexHullTrickMin.Line it = hull.lower(forQueryLine);
        if (it == null) throw new RuntimeException();

        return it.calc(x);
    }

    private static class Line implements Comparable<ConvexHullTrickMin.Line> {
        long a;
        long b;
        Rational p;
        boolean isQuery = false;
        long x = 0;

        public Line(long a, long b) {
            this.a = a;
            this.b = b;
        }


        public int compareTo(ConvexHullTrickMin.Line o) {
            if (isQuery) {
                int ret = -1;
                if (x == o.p.getA() && o.p.getB() == 1) ret = 1;
                else if (!Rational.checkLessRational(x, 1, o.p.getA(), o.p.getB())) ret = 1;
                return ret;
            } else
                return Long.compare(o.a, a);
        }

        static boolean bad(ConvexHullTrickMin.Line l1, ConvexHullTrickMin.Line l2, ConvexHullTrickMin.Line l3) {

            long a1 = l2.b - l1.b;
            long b1 = l1.a - l2.a;

            long a2 = l3.b - l1.b;
            long b2 = l1.a - l3.a;


            long g = LongMath.gcd(Math.abs(a1), Math.abs(b1));
            if (b1 < 0) g = -g;
            a1 /= g;
            b1 /= g;

            g = LongMath.gcd(Math.abs(a2), Math.abs(b2));
            if (b2 < 0) g = -g;
            a2 /= g;
            b2 /= g;

            if (a1 == a2 && b1 == b2) return true;
            return Rational.checkLessRational(a2, b2, a1, b1);
        }

        static Rational intersect(ConvexHullTrickMin.Line l1, ConvexHullTrickMin.Line l2) {
            return new Rational(l1.b - l2.b, l2.a - l1.a);
        }

        public long calc(long x) {
            return LongMath.checkedAdd(LongMath.checkedMultiply(a, x), b);
        }

    }

}

class ConvexHullTrickMax extends ConvexHullTrickMin {
    public ConvexHullTrickMax() {
        super();
    }


    public void addLine(long a, long b) {
        super.addLine(-a, -b);
    }


    public long query(long x) {
        return -super.query(x);
    }

}