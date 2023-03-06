package silver3.num09461;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {

	// 파도반 수열을 저장할 배열 sequences 초기화
	static long[] sequences = new long[101];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 1, 2, 3인 경우의 파도반 수열 초기화
		sequences[1] = 1;
		sequences[2] = 1;
		sequences[3] = 1;
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// padovan() 메서드를 호출해 그 결과를 변수 result에 할당
			long result = padovan(number);
			
			// write() 메서드를 사용해 파도반 수열의 결과를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// padovan() 메서드 정의
	public static long padovan(int number) {
		
		// 해당 수열이 저장되어 있는 경우 해당 수열 반환
		if (number == 0 || sequences[number] != 0) {
			return sequences[number];
		
		// 해당 수열이 저장되어 있지 않은 경우
		} else {
			
			// padovan() 메서드를 재귀 호출해 저장 후 해당 수열 반환
			sequences[number] = padovan(number - 2) + padovan(number - 3);
			return sequences[number];
		}
	}
}