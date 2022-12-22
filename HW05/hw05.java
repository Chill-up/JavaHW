package Homework.HW05;

import java.util.Scanner;

public class hw05 {
    public static int triangleNumber(int num) {
        if (num == 1) {
            return 1;
        } else {
            return (num + triangleNumber(num - 1));
        }
    }

    // public static void printTriangleNumber(int num) {
    //     for (int i = 0; i < triangleNumber(num); i++){
    //         for(int j = 0; j <= i; j++)
    //         System.out.print(0);
    //         System.out.println("");
    //     }
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число, для которого хотите построить треугольное число: ");
        int num = sc.nextInt();
        sc.close();
        System.out.printf("%d-е треугольное число = %d\n", num, triangleNumber(num));
        //printTriangleNumber(num);
    }
}
