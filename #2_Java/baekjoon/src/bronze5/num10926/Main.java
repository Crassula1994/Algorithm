package bronze5.num10926;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// next() 메서드를 사용해 입력 받은 아이디를 변수 id에 할당
		String id = sc.next();
		
		// 준하의 놀람을 출력
		System.out.println(id + "??!");

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}