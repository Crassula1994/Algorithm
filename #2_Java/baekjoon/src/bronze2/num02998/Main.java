package bronze2.num02998;

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
		
		// readLine(), 메서드를 사용해 입력 받은 2진수를 변수 binaryString에 할당
		String binaryString = in.readLine();
		
		// while 반복문을 사용해 2진수의 길이가 3의 배수가 되도록 갱신
		while (binaryString.length() % 3 != 0)
			binaryString = "0" + binaryString;
		
		// 2진수를 8진수로 변환한 결과를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 세 자리를 순회
		for (int startIdx = 0; startIdx < binaryString.length(); startIdx += 3) {
			
			// 현재 8진수의 자릿수를 저장할 변수 digit 초기화
			int digit = 0;
			
			// for 반복문을 사용해 현재 8진수의 자릿수를 갱신
			for (int idx = startIdx, multiplier = 4; idx < startIdx + 3; idx++) {
				digit += (binaryString.charAt(idx) - '0') * multiplier;
				multiplier /= 2;
			}
			
			// append() 메서드를 사용해 현재 8진수의 자릿수를 sb에 추가
			sb.append(digit);
		}
		
		// toString() 및 write() 메서드를 사용해 2진수를 8진수로 변환한 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}