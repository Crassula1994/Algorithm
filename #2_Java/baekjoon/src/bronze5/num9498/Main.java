package bronze5.num9498;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 시험 점수를 변수 score에 할당
		int score = sc.nextInt();
		
		// 시험 점수가 90점 ~ 100점인 경우 'A' 출력
		if (score >= 90) {
			System.out.println("A");
		
		// 시험 점수가 80점 ~ 89점인 경우 'B' 출력
		} else if (score >= 80) {
			System.out.println("B");
		
		// 시험 점수가 70점 ~ 79점인 경우 'C' 출력
		} else if (score >= 70) {
			System.out.println("C");
			
		// 시험 점수가 60점 ~ 69점인 경우 'D' 출력
		} else if (score >= 60) {
			System.out.println("D");
			
		// 시험 점수가 60점 미만인 경우 'F' 출력
		} else {
			System.out.println("F");				
		}
		
		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}