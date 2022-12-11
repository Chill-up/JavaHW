/*
Реализовать функцию возведения числа а в степень b.
a, b ∈ Z (множеству целых чисел). Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено

входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000
 */

package Homework.HW01;
import java.io.*;
import java.util.Scanner;

public class HW01 {
    public static double myPow(int num, int deg) {
        double result = 1;
        if (num == 0 & deg == 0) {
            return result = -1;
        }
        else if (deg == 1) {
            result = num;
        }
        else if (deg == 0) {
            result = 1;
        }
        else if (deg > 1) {
            for (int i = 0; i < deg; i++) {
                result = result * num;
            }
        }
        else {
            for (int i = 0; i > deg; i--) {
                result = result / num;
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        int a = 0;
        int b = 0;
        FileReader file_read = new FileReader("d:/Learn/GB/Разработчик/Java/Homework/HW01/input.txt");
        Scanner scan = new Scanner(file_read);
        while (scan.hasNextLine()) {
            String data_line = scan.nextLine();
            String[] data_file = data_line.split(" ");
            if (data_file[0].equals("a")) {
                a = Integer.parseInt(data_file[1]);
            } 
            else if (data_file[0].equals("b")) {
                b = Integer.parseInt(data_file[1]);
            }
            }
        scan.close();
        file_read.close();
        
        double res = myPow(a, b);
        if (res == -1) {
            System.out.println("Не определено");
        }
        else {
            System.out.println("Число " + a + " в степени " + b + " равно " + res);
        }
       FileWriter file_write = new FileWriter("d:/Learn/GB/Разработчик/Java/Homework/HW01/output.txt", false);
       file_write.write(String.valueOf(res));
       file_write.close();
    }
}
