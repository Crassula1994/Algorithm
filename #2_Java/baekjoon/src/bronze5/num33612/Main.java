package bronze5.num33612;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 피갤컵이 열린 연도와 월을 저장한 배열 eventYears 초기화
		String[] eventYears = {"2024 8", "2025 3", "2025 10", "2026 5", "2026 12"};
		
		// readLine(), parseInt(), write() 메서드를 사용해 피갤컵이 열리는 연도와 월을 출력
		out.write(eventYears[Integer.parseInt(in.readLine()) - 1]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}