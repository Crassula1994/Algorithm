package bronze2.num05363;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문장의 개수를 변수 sentenceNum에 할당
		int sentenceNum = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 문장을 순회
		while (sentenceNum-- > 0) {
			
			// readLine() 및 split() 메서드를 사용해 입력 받은 문장의 단어를 배열 sentence에 저장
			String[] sentence = in.readLine().split(" ");
			
			// for 반복문을 사용해 해당 문장을 요다의 말로 바꾼 결과를 sb에 저장
			for (int idx = 2; idx < sentence.length + 2; idx++)
				sb.append(sentence[idx % sentence.length]).append(" ");
			
			// append() 메서드를 사용해 다음 문장으로 넘어가기 위한 줄바꿈 기호를 sb에 저장
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 문장을 요다의 말로 바꾼 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}