package silver3.num11726;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 직사각형을 타일로 채우는 방법의 수를 저장할 배열 caseCnt 초기화
	static int[] caseCnt = new int[1001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 1, 2가 입력된 경우 방법의 수 초기화
		caseCnt[1] = 1;
		caseCnt[2] = 2;
		
		// caseFinder() 메서드를 호출해 그 결과를 변수 result에 할당
		int result = caseFinder(number) % 10007;
			
		// valueOf() 및 write() 메서드를 사용해 결과를 출력
		out.write(String.valueOf(result));
		
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
			caseCnt[number] = (caseFinder(number - 1) + caseFinder(number - 2)) % 10007;
			return caseCnt[number];
		}
	}
}