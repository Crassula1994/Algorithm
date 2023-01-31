package bronze3.num2525;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 현재 시각을 분으로 변환해 변수 time에 할당
		int time = (sc.nextInt() * 60) + sc.nextInt();
		
		// nextInt() 메서드를 사용해 입력 받은 조리시간을 변수 cookingTime에 할당
		int cookingTime = sc.nextInt();

		// 조리 이후의 시각이 명일인 경우 명일 시각을 출력
		if ((time + cookingTime) >= 1440) {
			System.out.println((time + cookingTime - 1440) / 60 + " " + (time + cookingTime - 1440) % 60);		

		// 조리 이후의 시각이 당일인 경우 당일 시각을 출력
		} else {
			System.out.println((time + cookingTime) / 60 + " " + (time + cookingTime) % 60);
		}

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}