package bronze5.num05597;

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
		
		// 각 출석번호를 담을 배열 numbers 초기화
		int[] numbers = new int[30];
		
		// for 반복문을 사용해 입력된 출석번호의 각 줄을 순회 
		for (int line = 0; line < 28; line++)
			
			// readLine() 및 parseInt() 메서드를 사용해 과제를 제출한 출석번호의 값을 1로 변경
			numbers[(Integer.parseInt(in.readLine())) - 1] = 1;
			
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int i = 0; i < 30; i++) {
			
			// 과제를 제출하지 않은 출석번호를 출력
			if (numbers[i] == 0)
				out.write((i + 1) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}