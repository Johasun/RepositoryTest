import kr.or.bit.Lotto;

public class Ex20_Lotto {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		
		
		while(true) {
			switch (lotto.menu()) {
			case 1 : lotto.selectLottoNumbers();
				break;
			case 2 : System.out.println("Good Lucky");
			System.exit(0); // 강제종료
			}
			
		}
	}
}
