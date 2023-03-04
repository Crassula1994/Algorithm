package silver3.num01904;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 2진 수열의 가짓수를 저장할 배열 seqCnt 초기화
	static int[] seqCnt = new int[1000001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// fill() 메서드를 사용해 배열 seqCnt의 각 원소 값을 -1로 초기화
		Arrays.fill(seqCnt, -1);
		
		// sequenceCounter() 메서드를 호출해 2진 수열의 가짓수를 변수 result에 할당
		int result = sequenceCounter(number);
			
		// valueOf() 및 write() 메서드를 사용해 2진 수열의 가짓수를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// sequenceCounter() 메서드 정의
	public static int sequenceCounter(int number) {
		
		// 2 이하의 숫자가 입력된 경우 그대로 반환
		if (number < 3) {
			return seqCnt[number] = number;
			
		// 이미 저장된 값이 있는 경우 이를 반환
		} else if (seqCnt[number] != -1) {
			return seqCnt[number];
			
		// 저장된 값이 없는 경우 연산 수행 후 결과 저장
		} else {
			return seqCnt[number] = (sequenceCounter(number - 1) + sequenceCounter(number - 2)) % 15746;
		}
	}
}