package bronze2.num15829;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine()); 
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 hashing에 저장
		char[] hashing = in.readLine().toCharArray();
		
		// 해시 값을 저장할 변수 hashValue 초기화
		long hashValue = 0;
		
		// 각 자릿수에 값에 곱해줄 값을 저장할 변수 multiplier 초기화
		long multiplier = 1;
		
		// for 반복문을 사용해 배열 hashing의 각 문자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 문자를 정수로 치환해 변수 num에 할당
			long num = hashing[idx] - 'a' + 1;
			
			// 자릿수에 multiplier를 곱해 해시 값을 갱신
			hashValue += num * multiplier;
			
			// 31을 곱하고 주어진 정수로 나눈 나머지로 multiplier의 값을 갱신
			multiplier = (multiplier * 31) % 1234567891;
		}
		
		// 해시 값을 주어진 정수로 나눈 나머지로 갱신
		hashValue %= 1234567891;
			
		// valueOf() 및 write() 메서드를 사용해 해시 값 출력
		out.write(String.valueOf(hashValue));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}