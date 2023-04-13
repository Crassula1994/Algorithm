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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// readLine() 메서드를 사용해 입력 받은 8진수 숫자를 변수 number에 할당
		String number = in.readLine();
		
		// 각 숫자가 나타내는 값을 2진수로 변환한 결과를 저장할 배열 binaryNotation 초기화
		String[] binaryNotation = {"000", "001", "010", "011", "100", "101", "110", "111"};
		
		// for 반복문을 사용해 각 자리 숫자를 순회하며 2진수로 변환한 결과를 sb에 저장
		for (int idx = 0; idx < number.length(); idx++)
			sb.append(binaryNotation[number.charAt(idx) - '0']);
		
		// 입력 받은 8진수가 0인 경우 0을 출력
		if (number.equals("0")) {
			out.write(number);
		
		// 입력 받은 8진수가 0이 아닌 경우
		} else {
					
			// while 반복문을 사용해 가장 앞의 숫자가 0이 아닐 때까지 앞의 값을 삭제
			while (sb.charAt(0) == '0')
				sb.deleteCharAt(0);

			// toString() 및 write() 메서드를 사용해 2진수로 변환한 결과를 출력
			out.write(sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}