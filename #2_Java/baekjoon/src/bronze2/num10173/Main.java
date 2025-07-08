package bronze2.num10173;

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
		
		// while 반복문을 사용해 각 문장을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// 입력의 마지막인 경우 반복문 탈출
			if (sentence.equals("EOI"))
				break;
			
			// toUpperCase(), contains(), write() 메서드를 사용해 해당 문장에 숨겨진 니모가 있는지 여부를 출력
			out.write((sentence.toUpperCase().contains("NEMO")) ? "Found" : "Missing");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}