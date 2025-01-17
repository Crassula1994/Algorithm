package silver5.num08611;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		BigInteger number = new BigInteger(in.readLine());
		
		// 팰린드롬이 되는 진법과 해당 진법으로 변환한 결과를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 진법을 순회
		outer: for (int radix = 2; radix <= 10; radix++) {
			
			// toString() 메서드를 사용해 해당 진법으로 변환한 결과를 변수 result에 할당
			String result = number.toString(radix);
			
			// for 반복문을 사용해 해당 숫자의 각 자릿수를 순회
			for (int idx = 0; idx < result.length() / 2; idx++) {
				
				// 해당 자릿수의 숫자가 다른 경우 다음 진법을 순회
				if (result.charAt(idx) != result.charAt(result.length() - idx - 1))
					continue outer;
			}
			
			// append() 메서드를 사용해 팰린드롬이 되는 진법과 해당 진법으로 변환한 결과를 sb에 저장
			sb.append(radix).append(" ").append(result).append("\n");
		}
		
		// length(), toString(), write() 메서드를 사용해 팰린드롬이 되는 진법과 해당 진법으로 변환한 결과를 출력
		out.write((sb.length() == 0) ? "NIE" : sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}