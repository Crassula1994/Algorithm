package bronze5.num8393;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 숫자를 변수 num에 할당
		int num = sc.nextInt();
		
		// 덧셈 결과를 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 입력 받은 숫자까지의 총합을 도출
		for (int i = 0; i < num; i++)
			sum += i + 1;
		
		// 총합을 출력
		System.out.println(sum);

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}