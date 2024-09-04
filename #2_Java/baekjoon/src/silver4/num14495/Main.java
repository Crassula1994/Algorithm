package silver4.num14495;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 피보나치 비스무리한 수열을 저장할 배열 sequence 초기화
		long[] sequence = new long[number + 1];
		
		// for 반복문을 사용해 피보나치 비스무리한 수열의 각 원소를 갱신
		for (int idx = 1; idx < sequence.length; idx++)
			sequence[idx] = (idx < 4) ? 1 : sequence[idx - 1] + sequence[idx - 3];
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 숫자의 순서에 해당하는 피보나치 비스무리한 수열의 원소를 출력
		out.write(String.valueOf(sequence[number]));
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}