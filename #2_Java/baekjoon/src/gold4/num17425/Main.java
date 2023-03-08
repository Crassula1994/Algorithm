package gold4.num17425;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 숫자의 약수 합을 저장할 배열 divisorSums 초기화
		long[] divisorSums = new long[1000001];
		
		// fill() 메서드를 사용해 배열의 초기값을 1로 초기화
		Arrays.fill(divisorSums, 1);
		
		// for 반복문을 사용해 1000000까지의 숫자를 순회
		for (int n = 2; n <= 1000000; n++) {
			
			// 배수를 구하는 데 사용할 숫자를 저장할 변수 multiplier 초기화
			int multiplier = 1;
			
			// while 반복문을 사용해 해당 숫자의 배수에 값을 갱신
			while (n * multiplier <= 1000000)
				divisorSums[n * multiplier++] += n;
			
			// 해당 숫자의 약수 합을 갱신
			divisorSums[n] += divisorSums[n - 1];
		}
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// write() 메서드를 사용해 약수의 합을 출력
			out.write(divisorSums[number] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}