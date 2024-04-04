package com.javaex.ex04;

import java.util.Scanner;

public class SumApp {

	public static void main(String[] args) {
		
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 공백으로 구분해서 입력하세요");
		String numLine = sc.nextLine();

		//코드를 작성하세요
		String[] numStringArray = numLine.trim().split("\\s+");
		try {
			for (String numString: numStringArray) {
				sum += Integer.parseInt(numString);
			}
			System.out.println("합:" + sum);
		} catch (NumberFormatException e) {
			System.err.println("숫자만 입력하세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
