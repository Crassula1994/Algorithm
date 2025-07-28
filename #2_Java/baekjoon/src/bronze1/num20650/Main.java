package bronze1.num20650;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 엘시가 베시에게 알려 준 일곱 개의 정수를 저장할 배열 numbers 초기화
		int[] numbers = new int[7];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 엘시가 베시에게 알려 준 일곱 개의 정수를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 엘시가 베시에게 알려 준 일곱 개의 정수를 오름차순으로 정렬
		Arrays.sort(numbers);
		
		// write() 메서드를 사용해 정수 A, B, C를 차례로 출력
		out.write(numbers[0] + " " + numbers[1] + " " + (numbers[6] - numbers[1] - numbers[0]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}