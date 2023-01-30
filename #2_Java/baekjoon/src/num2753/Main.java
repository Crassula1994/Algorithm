package num2753;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
 
    // main() 메서드 정의
    public static void main(String[] args) {
     
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 연도를 변수 year에 할당
		int year = sc.nextInt();
		
		// 윤년일 경우 '1'을 출력
		if (year % 4 == 0 && (year % 400 == 0 || year % 100 !=0)) {
			System.out.println(1);
			
		// 윤년이 아닐 경우 '0'을 출력
		} else {
			System.out.println(0);
		}
		
		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
    }
}