package silver1.num02688;

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
		
		// 각 자릿수별 줄어들지 않은 수의 개수를 저장할 배열 totalCounts 초기화
		long[] totalCounts = new long[65];
		
		// 각 자릿수와 그 시작 숫자에 따라 줄어들지 않는 수의 개수를 저장할 2차원 배열 counts 초기화
		long[][] counts = new long[65][10];
		
		// for 반복문을 사용해 한 자리 수의 줄어들지 않는 수의 개수를 갱신
		for (int number = 0; number < 10; number++)
			counts[1][number] = 1;
		
		// for 반복문을 사용해 각 자리 수를 순회
		for (int digit = 2; digit < 65; digit++) {
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int curNum = 0; curNum < 10; curNum++) {
				
				// for 반복문을 사용해 각 자릿수와 그 시작 숫자에 따라 줄어들지 않는 수의 개수를 갱신
				for (int prevNum = curNum; prevNum < 10; prevNum++)
					counts[digit][curNum] += counts[digit - 1][prevNum];
			}
		}

		// for 반복문을 사용해 각 자릿수를 순회
		for (int digit = 1; digit < 65; digit++) {
			
			// for 반복문을 사용해 각 자릿수별 줄어들지 않은 수의 개수를 갱신
			for (int number = 0; number < 10; number++)
				totalCounts[digit] += counts[digit][number];
		}
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자릿수를 변수 digit에 할당
			int digit = Integer.parseInt(in.readLine());
			
			// write() 메서드를 사용해 입력 받은 자릿수의 줄어들지 않은 수의 개수를 출력
			out.write(totalCounts[digit] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}