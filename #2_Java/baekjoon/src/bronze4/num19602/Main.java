package bronze4.num19602;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 간식의 수로 계산한 보리의 행복 점수를 변수 score에 할당
		int score = Integer.parseInt(in.readLine()) + Integer.parseInt(in.readLine()) * 2 + Integer.parseInt(in.readLine()) * 3;
		
		// write() 메서드를 사용해 보리가 행복한지 여부를 출력
		out.write((score >= 10) ? "happy" : "sad");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}