package com.javaex.ex05;

import java.util.Scanner;

public class CalcApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine;
        String[] splitLine;
        int sum ;

        while (true) {
            System.out.print(">> ");
            inputLine = sc.nextLine().trim();
            if (inputLine.equals("/q")) {
                break ;
            }

            /* Whitespace 모두 제거 후 숫자와 숫자가 아닌 문자 별로 스플릿 */
            inputLine = inputLine.replaceAll("\\s", ""); // 모든 Whitespace 제거
            splitLine = inputLine.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)"); // 숫자->문자, 문자->숫자 될 때마다 스플릿

            /* Whitespace 기준으로 Split */
//            splitLine = inputLine.split("\\s+"); // Whitespace 기준으로 스플릿
            if (isValue(splitLine)) {
                try {
                    sum = calculator(Integer.parseInt(splitLine[0]),
                            Integer.parseInt(splitLine[2]),
                            splitLine[1]);
                    System.out.println(">> " + sum);
                } catch (ArithmeticException e) {
                    System.err.println("연산할 수 없습니다.");
                } catch (Exception e) {
                    e.printStackTrace();
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
            if (splitLine[0] != null && splitLine[1] != null && splitLine[2] != null);
            Integer.parseInt(splitLine[0]);
            Integer.parseInt(splitLine[2]);
            if (splitLine[1].equals("+") ||
                    splitLine[1].equals("-") ||
                    splitLine[1].equals("*") ||
                    splitLine[1].equals("/"))
                return true;
        } catch (NumberFormatException e) {
        } catch (ArrayIndexOutOfBoundsException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private static int calculator(int a, int b, String operator) throws ArithmeticException {
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
