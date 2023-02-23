package silver5.num01978;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 소수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int i = 0; i < length; i++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 숫자를 변수 num에 할당
			int num = Integer.parseInt(st.nextToken());
			
			// 2인 경우 소수의 개수 갱신
			if (num == 2) {
				count++;
			
			// 2가 아닌 경우
			} else {
				
				// for 반복문을 사용해 소수인지 검사
				for (int j = 2; j < num; j++) {
					
					// 소수가 아닌 경우 반복문 탈출
					if (num % j == 0)
						break;
					
					// 소수인 경우 소수의 개수 갱신
					if (j == num - 1)
						count++;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 소수의 개수 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}