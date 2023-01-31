package bronze5.num14681;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 할당
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		// 제1사분면인 경우 '1' 출력
		if (x > 0 && y > 0) {
			System.out.println(1);
		
		// 제2사분면인 경우 '2' 출력
		} else if (x < 0 && y > 0) {
			System.out.println(2);

		// 제3사분면인 경우 '3' 출력
		} else if (x < 0 && y < 0) {
			System.out.println(3);
					
		// 제4사분면인 경우 '4' 출력
		} else {
			System.out.println(4);				
		}
		
		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}