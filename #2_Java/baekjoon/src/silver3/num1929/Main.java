package silver3.num1929;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상한과 하한을 각 변수에 할당
		int lowerLimit = Integer.parseInt(st.nextToken());
		int upperLimit = Integer.parseInt(st.nextToken());
		
		// 배열의 하한이 1인 경우 2로 변경
		if (lowerLimit == 1)
			lowerLimit++;
		
		// 하한부터 상한까지의 수를 저장할 배열 numbers 초기화
		int[] numbers = new int[upperLimit - lowerLimit + 1];
		
		// for 반복문을 사용해 하한부터 상한까지의 수를 배열에 저장
		for (int idx = 0, num = lowerLimit; idx < numbers.length; idx++)
			numbers[idx] = num++;
		
		// for 반복문을 사용해 소수인지 차례로 검사
		for (int pNum = 2; pNum <= Math.sqrt(upperLimit); pNum++) {
			
			// for 반복문을 사용해 배열 numbers의 각 값을 순회
			for (int idx = 0; idx < numbers.length; idx++) {
				
				// 배열의 수가 0인 경우 검사하지 않고 넘기기
				if (numbers[idx] == 0)
					continue;

				// 소수가 아닌 경우를 검사해 0으로 변경
				if (numbers[idx] != pNum && numbers[idx] % pNum == 0)
					numbers[idx] = 0;
			}
		}
		
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int idx = 0; idx < numbers.length; idx++) {
			
			// 소수인 경우 출력
			if (numbers[idx] != 0)
				out.write(numbers[idx] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}