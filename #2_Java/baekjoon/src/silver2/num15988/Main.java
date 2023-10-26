package silver2.num15988;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 정수를 1, 2, 3의 합으로 나타내는 방법의 수를 저장할 배열 counts 초기화
		long[] counts = new long[1000001];
					
		// 1, 2, 3일 때 1, 2, 3의 합으로 나타내는 방법의 수를 초기화
		counts[1] = 1;
		counts[2] = 2;
		counts[3] = 4;
					
		// for 반복문을 사용해 입력 받을 수 있는 숫자까지의 방법의 수를 갱신
		for (int idx = 4; idx <= 1000000; idx++)
			counts[idx] = (counts[idx - 1] + counts[idx - 2] + counts[idx - 3]) % 1000000009;
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());

			// write() 메서드를 사용해 입력 받은 숫자를 1, 2, 3의 합으로 나타내는 방법의 수를 출력
			out.write(counts[number] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}