package bronze1.num29196;

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
		
		// readLine() 및 substring() 메서드를 사용해 입력 받은 소수의 소수부를 변수 decimalString에 할당
		String decimalString = in.readLine().substring(2);
		
		// append() 메서드를 사용해 조건을 만족하는 분수가 언제나 존재하므로 'YES'를 sb에 저장
		sb.append("YES\n");
		
		// parseInt() 및 append() 메서드를 사용해 분수의 분자와 분모의 가장 첫 번째 자릿수를 sb에 저장
		sb.append(Integer.parseInt(decimalString)).append(" 1");
		
		// for 반복문을 사용해 분모의 나머지 자릿수를 sb에 저장
		for (int digit = 0; digit < decimalString.length(); digit++)
			sb.append("0");
		
		// toString() 및 write() 메서드를 사용해 소수를 분수로 바꾼 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}