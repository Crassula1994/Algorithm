package bronze5.num18108;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 불기 연도를 변수 buddhaEraYear에 할당
		int buddhaEraYear = sc.nextInt();
		
		// 서기 연도로 변환한 결과를 출력
		System.out.println(buddhaEraYear - 543);

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}