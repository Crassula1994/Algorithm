package silver3.num09095;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 숫자를 1, 2, 3의 합으로 나타내는 방법의 수를 저장할 배열 caseCnt 초기화
	static int[] caseCnt = new int[11];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 1, 2, 3이 입력된 경우 방법의 수 초기화
		caseCnt[1] = 1;
		caseCnt[2] = 2;
		caseCnt[3] = 4;
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// caseFinder() 메서드를 호출해 그 결과를 변수 result에 할당
			int result = caseFinder(number);
			
			// write() 메서드를 사용해 결과를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// caseFinder() 메서드 정의
	public static int caseFinder(int number) {
		
		// 해당 값이 이미 존재하는 경우 해당 값 반환
		if (caseCnt[number] != 0) {
			return caseCnt[number];
		
		// 해당 값이 존재하지 않는 경우 caseFinder() 메서드 재귀호출
		} else {
			caseCnt[number] = caseFinder(number - 1) + caseFinder(number - 2) + caseFinder(number - 3);
			return caseCnt[number];
		}
	}
}