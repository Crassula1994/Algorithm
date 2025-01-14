package bronze5.num28444;

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
		
		// 입력 받은 숫자를 저장할 배열 numbers 초기화
		int[] numbers = new int[5];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// 수식을 계산한 결과를 변수 result에 저장
		int result = numbers[0] * numbers[1] - numbers[2] * numbers[3] * numbers[4];
		
		// valueOf() 및 write() 메서드를 사용해 수식을 계산한 결과를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}