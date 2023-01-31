package bronze5.num25304;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 총 금액과 물건 수를 각 변수에 할당
		int totalPrice = sc.nextInt();
		int goods = sc.nextInt();
		
		// 계산한 총 금액을 나타낼 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 상품을 순회
		for (int i = 0; i < goods; i++) {
			
			// nextInt() 메서드를 사용해 입력 받은 금액과 수량을 각 변수에 할당
			int price = sc.nextInt();
			int quantity = sc.nextInt();
			
			// 총 금액에 해당 물건의 금액을 더해 갱신
			sum += price * quantity;
		}
		
		// 입력 받은 총 금액과 계산한 총 금액이 일치하는 경우 'Yes' 출력
		if (totalPrice == sum) {
			System.out.println("Yes");
			
		// 입력 받은 총 금액과 계산한 총 금액이 일치하지 않는 경우 'No' 출력
		} else {
			System.out.println("No");
		}
		
		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}