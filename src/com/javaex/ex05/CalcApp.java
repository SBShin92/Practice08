package com.javaex.ex05;

import java.util.Scanner;

public class CalcApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = "";
        String[] splitLine = new String[3];
        int a = 0;
        int b = 0;
        int sum = 0;

        while (true) {
            System.out.printf(">> ");
            inputLine = sc.nextLine().trim();
            if (inputLine.equals("/q")) {
                break ;
            }
            splitLine = inputLine.split(" ");
            if (isValue(splitLine)) {
                try {
                    sum = calculator(Integer.parseInt(splitLine[0]),
                            Integer.parseInt(splitLine[2]),
                            splitLine[1]);
                    System.out.println(">> " + sum);
                } catch (ArithmeticException e) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
            }
            else
                System.out.println("알 수 없는 연산입니다.");
        }
        System.out.println("종료합니다.");
        sc.close();
    }

    private static boolean isValue(String[] splitLine) {
        try {
            if (splitLine[0] == null || splitLine[1] == null || splitLine[2] == null);
            Integer.parseInt(splitLine[0]);
            Integer.parseInt(splitLine[2]);
        } catch (NumberFormatException e) {
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
    private static int calculator(int a, int b, String operator) {
        Add add = new Add();
        Sub sub = new Sub();
        Mul mul = new Mul();
        Div div = new Div();
        int val = 0;

        switch (operator) {
            case "+": {
                add.setValue(a, b);
                val = add.calculate();
                break;
            }
            case "-": {
                sub.setValue(a, b);
                val = sub.calculate();
                break;
            }
            case "*": {
                mul.setValue(a, b);
                val = mul.calculate();
                break;
            }
            case "/": {
                div.setValue(a, b);
                val = div.calculate();
                break;
            }
        }
        return val;
    }
}
