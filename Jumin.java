import java.util.Scanner;

class Jumin {
	//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
	//main 함수 Scanner 사용 주민번호 입력받고
	//앞:6자리 뒷:7자리
	//입력값 : 123456-1234567 
	//1. 자리수 체크 (기능)함수 (14 ok) return true , false 
	//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수 return true, false
	//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수 void 출력
	//3개의 함수 static 
	
	// 입력값 : 123456-1234567
	
	static void main() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("주민번호를 입력해주세요: ");
		System.out.println("예) 123456-1234567");
		String input = scanner.nextLine();
		
		while(true) {
			if(!juminCheck(input)) {
				System.out.println("주민번호 자리수 오류");
				main();
				break;
			}
			if(!backNumberCheck(input)) {
				System.out.println("뒷번호 첫번째 자리가 1~4 값이 아닙니다.");
				main();
				break;
			} else {
				print(input);
				break;
			}
		}
	}
	
	static boolean juminCheck(String input) {
		// 자리수 체크(기능)함수 (14 ok) return true, false
		boolean result = false;
		if(input.length()==14 && input.substring(6,7).equals("-")) {
			result = true;
		}
		return result;
	}
	
	static boolean backNumberCheck(String input) {
		// 뒷번호 첫번째 자리값 1~4 까지의 값만 허용 가능함수 return true, false
		boolean result = false; // 7번째 자리값
		int sevenNumber = Integer.parseInt(input.substring(7, 8));
		if(sevenNumber>=1 && sevenNumber<=4) {
			result = true;
		}
		
		return result;
	}
	
	static void print(String input) {
		// 뒷번호 첫번째 자리값을 가지고 1,3 남자 2,4 여자 출력 기능함수
		String num = input.substring(7, 8);
		if(num.equals("1") || num.equals("3")) {
			System.out.println("남자입니다.");
		} else {
			System.out.println("여자입니다.");
		}
		
		
	}
	
	
}
