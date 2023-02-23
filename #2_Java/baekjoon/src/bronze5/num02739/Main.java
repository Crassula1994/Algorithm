package bronze5.num02739;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 구구단 숫자를 변수 num에 할당
		int num = sc.nextInt();
		
		// for 반복문을 사용해 정해진 출력 형식대로 구구단을 출력
		for (int i = 1; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}