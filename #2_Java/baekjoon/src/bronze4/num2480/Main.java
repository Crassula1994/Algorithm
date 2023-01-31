package bronze4.num2480;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 주사위 눈을 각 변수에 할당
		int diceA = sc.nextInt();
		int diceB = sc.nextInt();
		int diceC = sc.nextInt();

		// 같은 눈이 세 개가 나온 경우 상금 출력
		if (diceA == diceB && diceB == diceC) {
			System.out.println(10000 + diceA * 1000);
		
		// 같은 눈이 두 개가 나온 경우 상금 출력
		} else if (diceA == diceB || diceA == diceC) {
			System.out.println(1000 + diceA * 100);
		} else if (diceB == diceC) {
			System.out.println(1000 + diceB * 100);	

		// 같은 눈이 없는 경우 상금 출력
		} else {
			System.out.println(Math.max(Math.max(diceA, diceB), diceC) * 100);
		}

		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
	}
}