package num2884;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 알람 시각을 분으로 변환해 변수 time에 할당
		int time = (sc.nextInt() * 60) + sc.nextInt();

		// 알람 시각이 0시 45분 이전인 경우 전날 시각을 출력
		if ((time - 45) < 0) {
			System.out.println((1395 + time) / 60 + " " + (1395 + time) % 60);		
			
		// 알람 시각이 0시 45분 이후인 경우 해당 날짜의 시각을 출력
		} else {
			System.out.println((time - 45) / 60 + " " + (time - 45) % 60);
		}
		
		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}