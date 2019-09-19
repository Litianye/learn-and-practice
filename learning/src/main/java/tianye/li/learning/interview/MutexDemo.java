package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-22
 */


import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-22
 **/

public class MutexDemo {
    public static Mutex mutex = new Mutex();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        List<Integer> tmp = new ArrayList<>();
//        tmp.add(2);
//        tmp.add(3);
//        tmp.add(4);
//        tmp.add(5);
//        tmp.add(6);
//
//        list.add(tmp);
//
//        System.out.println(list.get(0).get(2) == 2);

//        for (int i=0; i<10; i++) {
//            Thread thread = new Thread() {
//                @Override
//                public void run() {
//                    mutex.lock();
//                    try {
//                        Thread.sleep(5);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        mutex.unlock();
//                    }
//                }
//            };
//            thread.start();
//        }
//
//        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        lock.readLock().lock();
//        try {
//            lock.readLock().unlock();
//            lock.writeLock().lock();
//
//            lock.readLock().lock();
//        }finally {
//            lock.writeLock().unlock();
//        }
//
//        try {
//
//        }finally {
//            lock.readLock().unlock();
//        }

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        List<Character> def = new ArrayList<>();
        for (Character c: strs[0].toCharArray()) {
            def.add(c);
        }

        for (int i=1; i<strs.length-1; i++) {
            for (int j=0; j<def.size() && j<strs[i].length(); j++) {
                if (def.get(j) != strs[i].charAt(j)) {
                    def.subList(j, def.size()).clear();
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (Character c: def) {
            sb.append(c);
        }

        return sb.toString();
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];
        rs[0] = 0;
        rs[1] = numbers.length-1;

        while (rs[0] < rs[1]) {
            if (rs[0] + rs[1] > target) {
                rs[1] = rs[1]-1;
            }else if (rs[0] + rs[1] < target) {
                rs[0] = rs[0]+1;
            }else {
                rs[1] = rs[1]+1;
                rs[0] = rs[0]+1;
                return rs;
            }
        }

        return rs;
    }

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        int add = 0;

        for (int i = a.length()-1 , j = b.length() -1; i>=0|| j>=0; i--, j--) {
            int sum = add;
            sum += i>=0 ? a.charAt(i) -'0' : 0;
            sum += j>=0 ? b.charAt(j) -'0' : 0;
            stringBuilder.append(sum%2);
            add = sum/2;
        }

        stringBuilder.append((add==1) ? add : "");
        return stringBuilder.reverse().toString();
    }

    public int strStr(String haystack, String needle) {
        for (int i=0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int tmp = i;
                for (int j=0; j<needle.length(); j++) {
                    if (haystack.charAt(tmp) == needle.charAt(j)) {
                        tmp++;
                    }
                }
                if (tmp-i == needle.length()) return i;
            }
        }
        return -1;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        for (int i=1; i<=numRows; i++) {
            int[] tmp = new int[i];
            tmp[0] = 1;
            tmp[i-1] = 1;
            for (int j=1; j<i-1; j++) {
                List<Integer> l = list.get(i-2);
            }
            System.out.println(Arrays.toString(tmp));
            list.add(new ArrayList(Arrays.asList(tmp)));
        }

        return list;
    }

}
