package bronze5.num10699;

// 필요한 패키지 불러오기
import java.time.LocalDate;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) {
		
		// now() 메서드를 사용해 현재 날짜를 변수 today에 할당
		LocalDate today = LocalDate.now();
		
		// 현재 날짜를 'YYYY-MM-DD' 형식으로 출력
		System.out.println(today);
	}
}