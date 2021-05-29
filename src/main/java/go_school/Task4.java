package go_school;

/*

E. 2 канала
Ограничение времени	2 секунды
Ограничение памяти	64Mb
Ввод	см формат ввода
Вывод	см формат вывода
Необходимо написать функцию func Merge2Channels(f func(int) int, in1 <-chan int, in2 <- chan int, out chan<- int, n int) в package main.
Описание ее работы:
n раз сделать следующее

прочитать по одному числу из каждого из двух каналов in1 и in2, назовем их x1 и x2.
вычислить f(x1) + f(x2)
записать полученное значение в out
Функция Merge2Channels должна быть неблокирующей, сразу возвращая управление.
Функция f может работать долгое время, ожидая чего-либо или производя вычисления.

Формат ввода
Количество итераций передается через аргумент n.
Целые числа подаются через аргументы-каналы in1 и in2.
Функция для обработки чисел перед сложением передается через аргумент f.
Формат вывода
Канал для вывода результатов передается через аргумент out.

Примечания
Отправлять задачу необходимо под компилятором Make. Решения, выдающие неверный ответ, могут по техническим причинам получать вердикт Runtime Error. Медленные решения получают вердикт Idleness Limit, стоит рассматривать это как превышение времени исполнения.


*/

import java.io.IOException;
import java.util.Scanner;

public class Task4 {

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
