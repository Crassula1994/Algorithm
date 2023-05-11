package silver5.num01789;

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
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 자연수의 합을 변수 targetNum에 할당
		long targetNum = Long.parseLong(in.readLine());
		
		// 더하는 자연수 및 자연수의 합을 저장할 각 변수 초기화
		long number = 0;
		long sum = 0;
		
		// while 반복문을 사용해 해당 자연수의 합이 입력 받은 자연수의 합보다 클 때까지 순회
		while (sum < targetNum) {
			
			// 더하는 자연수를 갱신
			number++;
			
			// 자연수의 합을 갱신
			sum += number;
		}
		
		// 더한 자연수의 합이 입력 받은 자연수의 합보다 큰 경우 자연수를 갱신
		if (sum > targetNum)
			number--;
		
		// valueOf() 및 write() 메서드를 사용해 자연수 개수의 최댓값을 출력
		out.write(String.valueOf(number));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}