package bronze2.num15813;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이름의 길이를 변수 nameLen에 할당
		int nameLen = Integer.parseInt(in.readLine());
		
		// readLine() 메서드를 사용해 입력 받은 이름을 변수 name에 할당
		String name = in.readLine();
		
		// 이름 점수를 저장할 변수 score 초기화
		int score = 0;
		
		// for 반복문을 사용해 각 글자의 점수를 이름 점수에 합산
		for (int idx = 0; idx < nameLen; idx++)
			score += name.charAt(idx) - 'A' + 1;

		// valueOf() 및 write() 메서드를 사용해 이름 점수를 출력
		out.write(String.valueOf(score));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}