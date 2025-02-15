package silver5.num14730;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 항의 개수를 변수 termNum에 할당
		int termNum = Integer.parseInt(in.readLine());
		
		// f'(1)의 값을 저장할 변수 result 초기화
		int result = 0;
		
		// while 반복문을 사용해 각 항을 순회
		while (termNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 항의 계수와 차수를 각 변수에 할당
			int coefficient = Integer.parseInt(st.nextToken());
			int degree = Integer.parseInt(st.nextToken());
			
			// f'(1)의 값을 갱신
			result += coefficient * degree;
		}
		
		// valueOf() 및 write() 메서드를 사용해 f'(1)의 값을 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}