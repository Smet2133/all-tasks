package _main;

import Understanding.ExceptionCheckedAndUncheckedUnderstanding;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //new Task3().perform();
//        new Main().perform();
        new ExceptionCheckedAndUncheckedUnderstanding().a1();
    }

    public void perform() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        char[] bigger;
        char[] smaller;

        if (str1.length() > str2.length()) {
            bigger = str1.toCharArray();
            smaller = str2.toCharArray();
        } else {
            bigger = str2.toCharArray();
            smaller = str1.toCharArray();
        }

        int sum;
        int buf = 0;
        int i = smaller.length - 1;
        int j = i + bigger.length - smaller.length;
        for (; i >= 0; i--, j--){
            sum = Character.digit(smaller[i], 10) + Character.digit(bigger[j], 10) + buf;
            buf = sum / 10;
            bigger[j] = Character.forDigit(sum % 10, 10);
        }

        for (i = bigger.length - smaller.length - 1; i >= 0; i --){
            sum = Character.digit(bigger[i], 10)  + buf;
            buf = sum / 10;
            bigger[i] = Character.forDigit(sum % 10, 10);
            if (buf == 0){
                break;
            }
        }

        if (buf == 1) {
            System.out.print("1");
        }

        for (i = 0; i < bigger.length; i++){
            System.out.print(bigger[i]);
        }
        System.out.println();

    }
}