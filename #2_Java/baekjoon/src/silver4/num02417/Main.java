package silver4.num02417;

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
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		long number = Long.parseLong(in.readLine());
		
		// 입력 받은 정수의 정수 제곱근을 찾기 위해 제곱근의 범위를 나타낼 각 변수 초기화
		long start = 0;
		long end = number;
		
		// while 반복문을 사용해 정수 제곱근을 찾을 때까지 순회
		while (start < end) {
			
			// 제곱근 범위의 중간에 위치한 숫자를 계산해 변수 mid에 할당
			long mid = (start + end) / 2;
			
			// 해당 숫자의 제곱이 입력 받은 제곱보다 작은 경우 범위의 시작을 갱신
			if (Math.pow(mid, 2) < number) {
				start = mid + 1;
				
			// 해당 숫자의 제곱이 입력 받은 제곱보다 크거나 같은 경우 범위의 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 정수 제곱근을 출력
		out.write(String.valueOf(end));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}