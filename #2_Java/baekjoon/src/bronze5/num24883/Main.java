package bronze5.num24883;

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
		
		// readLine() 및 charAt() 메서드를 사용해 입력 받은 알파벳을 변수 alphabet에 할당
		char alphabet = in.readLine().charAt(0);
		
		// 주어진 알파벳이 'n' 또는 'N'인 경우 'Naver D2' 출력
		if (alphabet == 'n' || alphabet == 'N') {
			out.write("Naver D2");
			
		// 주어진 알파벳이 'n' 또는 'N'이 아닌 경우 'Naver Whale' 출력
		} else {
			out.write("Naver Whale");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}