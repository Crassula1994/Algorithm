package bronze5.num15733;

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
		
		// write() 메서드를 사용해 정해진 문구를 출력
		out.write("I'm Sexy");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}