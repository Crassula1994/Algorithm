package bronze2.num14624;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 입력 받은 정수가 짝수인 경우 'I LOVE CBNU'를 출력
		if ((number & 1) == 0) {
			out.write("I LOVE CBNU");
			
		// 입력 받은 정수가 홀수인 경우
		} else {
			
			// 전북대학교 심볼의 세로 길이를 저장할 변수 height 초기화
			int height = (number + 1) >> 1;
			
			// StringBuilder 객체를 불러와 변수 sb에 할당
			StringBuilder sb = new StringBuilder();
			
			// for 반복문을 사용해 전북대학교 심볼의 가장 윗부분을 sb에 추가
			for (int n = 0; n < number; n++)
				sb.append("*");
			
			// append() 메서드를 사용해 줄바꿈을 sb에 추가
			sb.append("\n");
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < height; r++) {
				
				// for 반복문을 사용해 해당 칸에 해당하는 심볼을 sb에 저장
				for (int c = 1; c <= height + r; c++)
					sb.append((c == height - r || c == height + r) ? "*" : " ");
				
				// append() 메서드를 사용해 줄바꿈을 sb에 추가
				sb.append("\n");
			}
			
			// toString() 및 write() 메서드를 사용해 전북대학교 심볼을 출력
			out.write(sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}