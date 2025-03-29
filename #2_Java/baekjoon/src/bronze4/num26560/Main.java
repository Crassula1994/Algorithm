package bronze4.num26560;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문장의 수를 변수 sentenceNum에 할당
		int sentenceNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 문장을 순회
		while (sentenceNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// length(), charAt(), write() 메서드를 사용해 마침표를 찍은 문장을 출력
			out.write((sentence.charAt(sentence.length() - 1)) == '.' ? sentence : sentence + ".");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}