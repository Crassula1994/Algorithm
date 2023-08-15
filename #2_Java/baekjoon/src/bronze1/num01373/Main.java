package bronze1.num01373;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// readLine() 메서드를 사용해 입력 받은 2진수 숫자를 변수 number에 할당
		String number = in.readLine();
		
		// 해당 숫자의 길이가 3으로 나누었을 때 나머지가 1인 경우 '00'을 추가
		if (number.length() % 3 == 1) {
			number = "00" + number;
		
		// 해당 숫자의 길이가 3으로 나누었을 때 나머지가 2인 경우 '0'을 추가
		} else if (number.length() % 3 == 2) {
			number = "0" + number;
		}
		
		// 각 숫자가 나타내는 값을 8진수로 변환한 결과를 저장할 Map 객체 binaryNotation 초기화
		Map<String, String> binaryNotation = new HashMap<>();
		
		// put() 메서드를 사용해 각 숫자마다 8진수로 변환한 결과를 binaryNotation에 저장
		binaryNotation.put("000", "0");
		binaryNotation.put("001", "1");
		binaryNotation.put("010", "2");
		binaryNotation.put("011", "3");
		binaryNotation.put("100", "4");
		binaryNotation.put("101", "5");
		binaryNotation.put("110", "6");
		binaryNotation.put("111", "7");
		
		// for 반복문을 사용해 각 자리 숫자를 순회하며 8진수로 변환한 결과를 sb에 저장
		for (int idx = 0; idx < number.length(); idx += 3)
			sb.append(binaryNotation.get(number.substring(idx, idx + 3)));

		// toString() 및 write() 메서드를 사용해 8진수로 변환한 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}