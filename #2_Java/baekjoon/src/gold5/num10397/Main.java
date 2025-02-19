package gold5.num10397;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 원래 문자열을 배열 originalString에 할당
		char[] originalString = in.readLine().toCharArray();
		
		// 서브쓰리잉(Substhreeng)의 개수를 저장할 변수 totalCount 초기화
		long totalCount = 0;
		
		// for 반복문을 사용해 문자열의 각 문자를 순회
		for (int idx = 0; idx < originalString.length; idx++) {
			
			// 해당 문자가 알파벳 소문자인 경우 다음 문자를 순회
			if (!Character.isDigit(originalString[idx]))
				continue;
			
			// 현재 부분 문자열의 각 자릿수의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// 현재 부분 문자열의 각 자릿수까지의 합을 3으로 나눈 나머지의 등장 횟수를 저장할 배열 modCounts 초기화
			int[] modCounts = {1, 0, 0};
			
			// while 반복문을 사용해 각 자릿수를 순회
			while (idx < originalString.length && Character.isDigit(originalString[idx])) {
				
				// 현재 자릿수를 변수 digit에 할당
				int digit = originalString[idx++] - '0';
				
				// 현재 부분 문자열의 각 자릿수의 합 및 서브쓰리잉의 개수를 갱신
				sum += digit;
				totalCount += modCounts[sum % 3];
				
				// 현재 부분 문자열의 각 자릿수까지의 합을 3으로 나눈 나머지의 등장 횟수를 갱신
				modCounts[sum % 3]++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 서브쓰리잉의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}