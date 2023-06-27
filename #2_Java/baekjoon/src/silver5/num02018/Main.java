package silver5.num02018;

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
		
		// 입력 받은 정수까지의 각 자연수를 저장할 배열 naturalNumbers 초기화
		int[] naturalNumbers = new int[number];
		
		// for 반복문을 사용해 각 정수까지의 자연수를 배열 naturalNumbers에 저장
		for (int idx = 0; idx < naturalNumbers.length; idx++)
			naturalNumbers[idx] = idx + 1;
		
		// 입력 받은 정수를 만들 수 있는 연속된 자연수의 합과 그 가짓수, 연속된 자연수의 시작과 끝을 저장할 각 변수 초기화
		int sum = 1;
		int count = 0;
		int start = 0;
		int end = 0;
		
		// while 반복문을 사용해 연속된 자연수의 시작과 끝이 모두 마지막에 도달할 때까지 순회
		while (start < number) {
			
			// 연속된 자연수의 합이 목표로 하는 정수와 같은 경우 연속된 자연수의 합의 가짓수 갱신
			if (sum == number)
				count++;
			
			// 연속된 자연수의 합이 목표로 하는 정수보다 크거나 연속된 자연수의 끝이 끝에 도달한 경우
			if (sum > number || end == number - 1) {
				
				// 연속된 자연수의 시작 및 자연수의 합을 갱신
				sum -= naturalNumbers[start++];
				
			// 연속된 자연수의 합이 목표로 하는 정수보다 작은 경우
			} else if (sum < number) {
				
				// 연속된 자연수의 끝 및 자연수의 합을 갱신
				sum += naturalNumbers[++end];
				
			// 연속된 자연수의 합이 목표로 하는 정수와 같은 경우
			} else {
				
				// 연속된 자연수의 시작 및 끝, 연속된 자연수의 합을 갱신
				sum += naturalNumbers[++end] - naturalNumbers[start++];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 정수를 만들 수 있는 연속된 자연수의 합의 가짓수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}