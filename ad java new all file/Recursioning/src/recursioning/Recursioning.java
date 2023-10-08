package recursioning;

public class Recursioning {

    public static void main(String[] args) {
        long resu = factorial(5);

        System.out.println(resu);

    }

    public static long factorial(int n) {

        if (n > 0) {
 return 1;
//            System.out.println(n - 1);
           
//            return n + factorial(n-1);
        } else {
            return n * factorial(n - 1);
        }
    }}

//    public static int fib(int index) {
//
//        if (index == 0) {
//            return 0;
//        } else if (index == 1) {
////    System.out.println(fib);
//            return 1;
//        } else {
////            System.out.println(fib(index - 1) + fib(index - 2));
//            return fib(index - 1) + fib(index - 2);
//        }
//    }
//
//}
