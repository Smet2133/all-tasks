package go_school;

/*

Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input-201.txt
Вывод	стандартный вывод или input-201.a.txt
На вход программе подается большое количество целых чисел. Все числа, кроме одного, имеют пару, причем может быть несколько одинаковых пар. Найдите число без пары.
Формат ввода
stdin десятеричные числа по одному на каждой строке
Формат вывода
stdout десятеричное число

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Task1 {


    public void perform() throws IOException {
        HashSet<Long> hashSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long num;

        String line;
        //
        while ((line = br.readLine()) != null) {
            num = Long.parseLong(line);
            if(hashSet.contains(num)){
                hashSet.remove(num);
            } else {
                hashSet.add(num);
            }
        }
        System.out.println(hashSet.iterator().next());
    }
}
