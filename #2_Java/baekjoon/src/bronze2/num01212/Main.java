package bronze2.num01212;

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
		
		// readLine() 메서드를 사용해 입력 받은 8진수 숫자를 변수 number에 할당
		String number = in.readLine();
		
		// 각 숫자가 나타내는 값을 2진수로 변환한 결과를 저장할 배열 binaryNotation 초기화
		String[] binaryNotation = {"000", "001", "010", "011", "100", "101", "110", "111"};
		
		// 2진법으로 변환한 결과를 저장할 변수 result 초기화
		String result = "";
		
		// for 반복문을 사용해 각 자리 숫자를 순회하며 2진수로 변환한 결과를 변수 result에 할당
		for (int idx = 0; idx < number.length(); idx++)
			result += binaryNotation[number.charAt(idx) - '0'];
		
		// 0인 경우 0을 출력
		if (result.equals("000")) {
			out.write("0");
		
		// 0이 아닌 경우
		} else {
			
			// 처음으로 1이 시작되는 위치를 저장할 변수 startIdx 초기화
			int startIdx = 0;
			
			// for 반복문을 사용해 결과의 각 위치를 순회
			for (int idx = 0; idx < result.length(); idx++) {
				
				// 해당 위치의 숫자가 1인 경우 1이 시작되는 위치를 갱신 후 반복문 탈출
				if (result.charAt(idx) == '1') {
					startIdx = idx;
					break;
				}
			}
			
			// for 반복문을 사용해 2진수로 변환한 결과를 출력
			for (int idx = startIdx; idx < result.length(); idx++)
				out.write(result.charAt(idx));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}