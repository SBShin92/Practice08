package com.javaex.ex06;

public class PointApp {

	public static void main(String[] args) {
		
		Point p1 = new Point(2, 3);
		Point p2 = new Point(2, 3);
		Point p3 = new Point(5, 3);
		Point p4 = p1;
		
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);
		System.out.println(p3 == p4);
		System.out.println(p4 == p1);		
		System.out.println(p1.equals(p2));
		System.out.println(p4.equals(p1));
	}

}
/*
1. p1과 p4는 같은 인스턴스를 참조하고 있지만, p2와 p3는 다른 인스턴스를 참조한다.
2. 자바 객체는 기본적으로 Object 객체를 상속받기 때문에 Object 메소드를 사용할 수 있다.
3. 그러나, Point의 객체가 동일한 지를 비교해버리기 때문에 각각의 값을 비교하는 equals를 오버라이딩해야 한다.

false
false
false
true
false
true
 */

