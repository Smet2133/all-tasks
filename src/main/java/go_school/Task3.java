package go_school;

/*
D. Сложение чисел
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод
Вывод	стандартный вывод
Даны два неотрицательных числа A и B (числа могут содержать до 1000 цифр). Вам нужно вычислить их сумму.

Формат ввода
Первая строка ввода содержит числа A и B, разделенные пробелом

Формат вывода
Результат сложения двух чисел нужно вывести на отдельной строке.
*/

import java.io.*;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;

public class Task3 {


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

    public void perform_memory_limit() throws IOException {

    }
}
