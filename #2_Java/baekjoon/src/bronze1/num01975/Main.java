package bronze1.num01975;

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
		
		// 각 숫자의 진법 변환 시 연속된 0의 개수를 저장할 배열 zeroCounts 초기화
		int[] zeroCounts = new int[1001];
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 2; number < zeroCounts.length; number++) {
			
			// for 반복문을 사용해 각 숫자에 해당하는 진법을 순회
			for (int radix = 2; radix <= number; radix++) {
				
				// 진법 변환 시 남은 숫자를 저장할 변수 curNumber 초기화
				int curNumber = number;
			
				// while 반복문을 사용해 해당 진법 변환 시 연속된 0의 개수를 갱신
				while (curNumber % radix == 0) {
					zeroCounts[number]++;
					curNumber /= radix;
				}
			}
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스에 대하여 진법 변환 시 연속된 0의 개수의 총합을 출력
		while (testCase-- > 0)
			out.write(zeroCounts[Integer.parseInt(in.readLine())] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}