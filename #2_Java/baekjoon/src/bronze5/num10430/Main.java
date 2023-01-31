package bronze5.num10430;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 할당
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		// (a + b) % c, ((a % c) + (b % c)) % c, (a × b) % c, ((a % c) × (b % c)) % c의 결과를 각각 출력
		System.out.println((a + b) % c);
		System.out.println(((a % c) + (b % c)) % c);
		System.out.println((a * b) % c);
		System.out.println(((a % c) * (b % c)) % c);

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}