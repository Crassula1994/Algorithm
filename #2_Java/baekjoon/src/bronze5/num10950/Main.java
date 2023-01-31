package bronze5.num10950;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = sc.nextInt();
		
		// 각 덧셈 결과를 저장할 배열 result 초기화
		int[] result = new int[testCase];
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// nextInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 할당
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 덧셈 결과를 배열에 저장
			result[i] = a + b;
		}
		
		// for 반복문을 사용해 배열의 각 원소를 출력
		for (int element : result)
			System.out.println(element);

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}