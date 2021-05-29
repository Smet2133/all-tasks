package go_school;

/*

F. Сумма двух
Ограничение времени	1.5 секунд
Ограничение памяти	64Mb
Ввод	input.txt
Вывод	output.txt
Дано целое положительное число "target". Также дана последовательность из целых положительных чисел. Необходимо записать в выходной файл "1", если в последовательности есть два числа сумма, которых равна значению "target" или "0" если таких нет.

Формат ввода
5

1 7 3 4 7 9

Формат вывода
1

Примечания
Все числа используемы в задаче находятся в диапазоне 0 < N < 999999999
                                                            1000000000

Название входной файл: input.txt

Название выходной файл: output.txt

*/

import java.io.*;
import java.util.BitSet;
import java.util.HashSet;

public class Task2 {

    /*
    saving all numbers in bit array. no more than target/2 bits
     */
    public void perform() throws IOException {
        HashSet<Integer> hashSet = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        int cacheNum, num, target, halfTarget;
        boolean exists = false;

        target = Integer.parseInt(reader.readLine());
        halfTarget = target / 2;
        BitSet bitSet = new BitSet(halfTarget + 1);


        int dig;
        cacheNum = 0;
        while ((dig = reader.read()) != -1 ) {
            if (Character.isDigit(dig)) {
                cacheNum = cacheNum * 10 + Character.digit(dig, 10);
                continue;
            }
            //System.out.println(cacheNum);
            num = cacheNum;
            cacheNum = 0;

            if (num >= target) {
                continue;
            }

            if (num < halfTarget) {
                bitSet.set(num);
            } else {
                if (bitSet.get(target - num)) {
                    exists = true;
                    break;
                }
                if (halfTarget == num) {
                    bitSet.set(num);
                }
            }

        }

        PrintStream printStream = new PrintStream("output.txt");
        if (!exists){
            printStream.println("0");
        } else {
            printStream.println("1");
        }
    }

    public void perform_memory_limit() throws IOException {
        HashSet<Integer> hashSet = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        PrintStream printStream = new PrintStream("output.txt");

        int target;
        int num;
        boolean exists = false;

        target = Integer.parseInt(reader.readLine());
        for (String str :  reader.readLine().split(" ")){
            num = Integer.parseInt(str);
            if (num < target) {
                if(hashSet.contains(target - num)){
                    exists = true;
                    printStream.println("1");
                    break;
                } else {
                    hashSet.add(num);
                }
            }
        }

        if (!exists){
            printStream.println("0");
        }
    }
}
