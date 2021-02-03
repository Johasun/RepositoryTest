package kr.or.bit;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	static final int SIZE = 6; // 로또의 길이
	static final int MAX = 45; // 랜덤 숫자 범위
	private int[] numbers;
	private Scanner scanner;
	private Random r;
	
	public Lotto() {
		numbers = new int[SIZE];
		scanner = new Scanner(System.in);
		r = new Random();
	}
	
	public int menu() {
		System.out.println(" ");
		System.out.println("*******************");
		System.out.println("**1. 당첨 예상번호 추출하기**");
		System.out.println("**2. 프로그램 종료 ^^! ^^!**");
		System.out.println("*******************");

		System.out.println("원하는 메뉴번호를 입력하세요: ");
		
		int menu = 0;
		do {
			  try {
					    menu = Integer.parseInt(scanner.nextLine());
						if(menu >= 1 && menu <= 2) {
							break;
						}else {
							throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
						}
			  }catch (Exception e) {
				  System.out.println(e.getMessage());
				  System.out.println("1번 혹은 2번 값을 입력해주세요: ");
			  }
		}while(true);
		return menu;
		
	}
	
	public void selectLottoNumbers() { // 추출하기

		for(int i = 0; i<numbers.length; i++) {
			int random = (int)(Math.random()*MAX)+1; // 랜덤번호 추출
			
			boolean extract = removeOverlap(random); // true / false 값 받기
			
			if(!extract) { // 이미 배열에 있는 숫자라면 (false값)
				i--; 
				
			} else  { // 없으면 
				numbers[i] = random; // 배열에 넣어주기
			}
		}
		sortLotto(numbers);
		print(numbers);
	}
	
	private boolean removeOverlap(int randomNumbers) { // 중복제거
		boolean result = true;
		
		for(int i = 0; i<numbers.length; i++) {
			if(randomNumbers == numbers[i]) {
				result = false;
			}
		}
		
		return result; 
	}
	
	private void sortLotto(int[] numbers) { // 정렬
		for(int i = 0; i<numbers.length-1; i++) {
			if(numbers[i]>numbers[i+1]) {
				int temp = numbers[i];
				numbers[i]=numbers[i+1];
				numbers[i+1]=temp;
				i=-1;
			}
		}
	}
	
	private void print(int[] numbers) { // 출력하기
		int average = 0;
		int sum = 0;
		for(int i = 0; i<numbers.length; i++) {
			sum += numbers[i];
			if( i == numbers.length-1) {
				average = sum / numbers.length;
			}
		}
		System.out.println("평균 : "+average);
		System.out.println("[ 선택한 Lotto 번호 ]");
		for(int i = 0; i<numbers.length; i++) {
			System.out.printf("[%2d]", numbers[i]);
		}
	}

}
	
