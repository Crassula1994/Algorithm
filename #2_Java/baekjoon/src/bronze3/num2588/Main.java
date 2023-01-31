package bronze3.num2588;

// 필요한 패키지 불러오기
import java.util.Scanner;

// Main 클래스 정의
public class Main {
 
    // main() 메서드 정의
    public static void main(String[] args) {
     
		// Scanner 객체를 불러와 변수 sc에 할당
		Scanner sc = new Scanner(System.in);
		
		// nextInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 할당
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// 각 자릿수 연산의 결과를 차례로 출력
		System.out.println(num1 * (num2 % 10));
		System.out.println(num1 * ((num2 / 10) % 10));
		System.out.println(num1 * (num2 / 100));
		System.out.println(num1 * num2);
		
		// close() 메서드를 사용해 Scanner 객체 종료
		sc.close();
    }
}