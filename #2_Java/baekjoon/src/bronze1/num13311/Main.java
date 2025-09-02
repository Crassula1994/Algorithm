package bronze1.num13311;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;  
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// write() 메서드를 사용해 행운의 편지에 적힌 문제의 정답을 출력
		out.write("-1");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}