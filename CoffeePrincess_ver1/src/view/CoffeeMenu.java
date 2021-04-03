package view;

import java.util.Scanner;

import controller.CoffeeManager;
import model.exception.CoffeeException;
import model.vo.Coffee;

public class CoffeeMenu {
	public static CoffeeManager cm=new CoffeeManager();
	
	public static void showMenu() {
		Scanner sc=new Scanner(System.in);
		
		do {
			initMenu(3.0);
			System.out.print("메뉴 확인:");
			int sel=sc.nextInt();
			
			switch(sel) {
			case 1:
				insertCoffee();
				break;
			case 2:
				selectCoffeeOne();
			case 3:
				updateCoffee();
			case 4:
				deleteCoffee();
			case 5:
				selectCoffeeAll();
			case 6:
				System.out.print("정말 종료하시겠습니까?(Y/N):");
				if(sc.next().toUpperCase().charAt(0)=='Y') {
					cm.close();
					
					return;
				}else {
					System.out.println("메뉴를 다시 불러옵니다.");
				}
			}
			
		}while(true);
	}
	
	public static void initMenu(double version) {
		System.out.println("==길동이의 커피 프린세스 버젼"+version+"==");
		System.out.println("-----------------------");
		System.out.println("1.아메리카노");
		System.out.println("2.카페라떼");
		System.out.println("3.카푸치노");
		System.out.println("-----------------------");
		System.out.println("1.커피주문");
		System.out.println("2.주문번호 확인");
		System.out.println("3.주문 내용 변경");
		System.out.println("4.주문 취소");
		System.out.println("5.주문 전체 내역 확인");
		System.out.println("6.프로그램 종료");
	}
	
	public static void insertCoffee() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("----메뉴----");
		System.out.println("1. 아메리카노");
		System.out.println("2. 카페라떼");
		System.out.println("3. 카푸치노");
		
		System.out.print("메뉴 확인 :");
		int sel=sc.nextInt();
		
		System.out.print("주문 잔 수 : ");
		int cups=sc.nextInt();
		
		System.out.println("주문 정보 확인 : ");
		System.out.println(cm.insertCoffee(new Coffee(sel,cups)));
	}
	
	public static void selectCoffeeOne() {
		Scanner sc=new Scanner(System.in);
		System.out.print("주문 번호 확인 : ");
		int orderNo=sc.nextInt();
		try {
			System.out.println("현재 주문 내역 : ");
			System.out.println(cm.verifyCoffee(orderNo));
		}catch(CoffeeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateCoffee() {
		Scanner sc=new Scanner(System.in);
		System.out.print("주문 번호 확인 : ");
		int orderNo=sc.nextInt();
		
		try {
			System.out.println("주문 내역 확인");
			// 기존 주문 내역을 보여 준다
			System.out.println(cm.verifyCoffee(orderNo));
			System.out.println("----메뉴----");
			System.out.println("1. 아메리카노");
			System.out.println("2. 카페라떼");
			System.out.println("3. 카푸치노");
			
			System.out.print("메뉴 확인 :");
			int sel=sc.nextInt();
			
			System.out.print("주문 잔 수 : ");
			int cups=sc.nextInt();
			cm.updateCoffee(orderNo,new Coffee(sel,cups));// 업데이트 해준다
		}catch(CoffeeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteCoffee() {
		Scanner sc=new Scanner(System.in);
		System.out.print("주문 번호 확인 : ");
		int orderNo=sc.nextInt();
		
		try {
			System.out.println("주문 내역 확인");
			System.out.println(cm.verifyCoffee(orderNo-1));
			System.out.print("정말 취소하겠습니까?(Y/N)");
			if(sc.next().toUpperCase().charAt(0) == 'Y') {
				cm.deleteCoffee(orderNo-1);//
				System.out.println("주문이 정상적으로 취소되었습니다.");
			}else {
				System.out.println("메인으로 돌아갑니다.");
			}
		}catch(CoffeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void selectCoffeeAll() {
		
		for(Coffee co : cm.getOrderList()) {
			System.out.println(co);
		}
	}
	
}











