package bronze2.num08320;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정사각형의 수를 변수 squares에 할당
		int squares = Integer.parseInt(in.readLine());
		
		// 만들 수 있는 직사각형의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 직사각형의 변의 길이를 순회
		for (int w = 1; w <= Math.abs(squares); w++) {
			
			// for 반복문을 사용해 다른 변의 길이를 순회하며 직사각형의 개수 갱신
			for (int h = w; h <= squares / w; h++)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 직사각형의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}