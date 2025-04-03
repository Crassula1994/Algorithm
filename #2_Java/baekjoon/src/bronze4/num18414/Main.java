package bronze4.num18414;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목표 정수와 정수의 범위를 각 변수에 할당
		int targetNumber = Integer.parseInt(st.nextToken());
		int startNumber = Integer.parseInt(st.nextToken());
		int endNumber = Integer.parseInt(st.nextToken());
		
		// 목표 정수가 정수의 범위에 포함된 경우 목표 정수를 출력
		if (targetNumber >= startNumber && targetNumber <= endNumber) {
			out.write(String.valueOf(targetNumber));
			
		// 목표 정수가 정수의 범위보다 작은 경우 정수의 범위의 시작 값을 출력
		} else if (targetNumber < startNumber) {
			out.write(String.valueOf(startNumber));
			
		// 목표 정수가 정수의 범위보다 큰 경우 정수의 범위의 끝 값을 출력
		} else {
			out.write(String.valueOf(endNumber));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}