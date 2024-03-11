package Polyaeva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static int SIZE = 8000;
    public static int NUMBERS = 256;
    public static int THREAD = 5;

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        creation(array);
        //printArray(thread);
        long startTs = System.currentTimeMillis();
       sum(array);
        long endTs = System.currentTimeMillis();
        System.out.println("Time: " + (endTs - startTs) + "ms");
        startTs = System.currentTimeMillis();
        System.out.println(sumRecursion(array, array.length));
        endTs = System.currentTimeMillis();
        System.out.println("Time: " + (endTs - startTs) + "ms");

        List<Thread> threads = new ArrayList<>(THREAD);
        for (int i = 0; i < THREAD; i++) {
            Thread thread = new Thread(()->sum(array));
            threads.add(thread);
            thread.start();
        }
    }

    public static int[] creation(int[] array) {
        //  int[] thread = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(NUMBERS);
        }
        return array;
    }

    public static void printArray(int[] thread) {
        System.out.println(Arrays.toString(thread));
    }

    public static void sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println(sum);
    }

    public static int sumRecursion(int[] array, int length) {
        if (length<=0){
            return 0;
        }
        return sumRecursion(array, length-1)+array[length-1];
    }
}


