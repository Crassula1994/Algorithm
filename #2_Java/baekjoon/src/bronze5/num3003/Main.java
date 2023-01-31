package bronze5.num3003;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 각 체스 말의 개수를 입력 받아 필요한 피스의 수를 각 변수에 할당
		int king = 1 - sc.nextInt();
		int queen = 1 - sc.nextInt();
		int rook = 2 - sc.nextInt();
		int bishop = 2 - sc.nextInt();
		int knight = 2 - sc.nextInt();
		int pawn = 8 - sc.nextInt();
		
		// 필요한 피스의 수를 차례로 출력
		System.out.println(king + " " + queen + " " + rook + " " + bishop + " " + knight + " " + pawn);

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}