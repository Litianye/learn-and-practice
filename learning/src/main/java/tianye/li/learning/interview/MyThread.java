package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-20
 */


import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: learn_and_practice
 *
 * @description: my thread
 *
 * @author: litianye
 *
 * @create: 2019-08-20
 **/

public class MyThread{
//    public static void main(String[] args) {
//        Thread previousThread = Thread.currentThread();
//        for (int i = 1; i <= 10; i++) {
//            Thread curThread = new JoinThread(previousThread);
//            curThread.start();
//            previousThread = curThread;
//        }
//
//
//    }

    public static void main(String []args) throws Exception {
        System.out.println(run("LSRRSLLSLRLLSRRSRSRRLSRSRRSSRSRRLRRRSLSRRRLRRSRRSSSRLSSRSLRLRLSLLSSLLRSLSRRRLSRL"));
    }


    private static String run(String input) {
        if (!input.contains("S")) return "bounded";
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) != 'S') {
                if (stack.isEmpty()) {
                    stack.push(input.charAt(i));
                }else {
                    if (stack.peek() != input.charAt(i)) {
                        stack.pop();
                    }else {
                        stack.push(input.charAt(i));
                        if (stack.size() == 4 && i!=input.length()-1) {
                            stack.clear();
                        }
                    }
                }
            }
        }

        if (stack.isEmpty()) return "unbounded";
        else return "bounded";
    }

//    private static String run (String input) {
//        int direction = 0;
//        int[] steps = new int[4];
//        for (int i=0; i<input.length(); i++) {
//            if (input.charAt(i) == 'S') {
//                steps[direction] ++;
//                steps[4-direction] --;
//            }else if (input.charAt(i) == 'R') {
//                direction ++;
//            }else if (input.charAt(i) == 'L') {
//                if (direction==0) direction=3;
//                else direction--;
//            }
//        }
//        return "233";
//    }

    private static int exe(String input) {
        List<Integer> list = new ArrayList<>();
        String[] parts = input.split("-");
        for (String part: parts) {
            String[] nums = part.split("\\+");
            int sum = 0;
            for (String num: nums) {
                int tmp = Integer.parseInt(num);
                sum += tmp;
            }
            list.add(sum);
        }

        if (parts.length == 1) return list.get(0);
        int result = list.get(0);
        for (int i=0; i<list.size(); i++) {
            result -= list.get(i);
        }
        return result;
    }

    private static int fib(int n) {
        if (n == 1) return 1;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for (int i=2; i<n; i++) {
            result[i] = result[i-1]+result[i-2];
            if (result[i]>999999) {
                result[i] = result[i]-1000000;
            }
        }
        return result[n-1];
    }


    private static int test(int n) {
        if (n == 1) return 1;
        return (n%2 == 1) ? 0 : test(n/2);
    }

    private static int change(String n) {
        char[] str = n.toCharArray();
        char pre = '0';
        int count = 0;
        for (int i=0; i<str.length; i++) {
            while (i<str.length && str[i] == pre) {
                i++;
            }
            if (i<str.length) {
                pre = str[i];
                count ++;
            }
        }
        return count;
    }



    static class JoinThread extends Thread {

        private Thread thread;
        ThreadLocal threadLocal;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public <K, V> Pair<K, V> reflectTest(K key, V val) {
        return new Pair<>(key, val);
    }

}
