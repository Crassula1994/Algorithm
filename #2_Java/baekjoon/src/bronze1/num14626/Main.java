package bronze1.num14626;

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
		
		// readLine() 메서드를 사용해 입력 받은 ISBN 숫자를 변수 codeISBN에 할당
		String codeISBN = in.readLine();
		
		// 훼손된 숫자에 곱해지는 가중치, 각 일련번호에 가중치를 곱한 합을 저장할 각 변수 초기화
		int targetMultiplier = 0;
		int sum = 0;
		
		// for 반복문을 사용해 ISBN의 각 자릿수를 순회
		for (int idx = 0; idx < 13; idx++) {
			
			// charAt() 메서드를 사용해 해당 자릿수와 현재 자릿수에 곱해지는 가중치를 각 변수에 할당
			int digit = codeISBN.charAt(idx) - '0';
			int multiplier = ((idx & 1) == 1) ? 3 : 1;
			
			// 해당 자릿수가 훼손된 숫자인 경우 훼손된 숫자에 곱해지는 가중치를 갱신 후 다음 숫자를 순회
			if (digit < 0) {
				targetMultiplier = multiplier;
				continue;
			}
			
			// 각 일련번호에 가중치를 곱한 합을 갱신
			sum += digit * multiplier;
		}
		
		// for 반복문을 사용해 가능한 각 훼손된 숫자를 순회
		for (int digit = 0; digit < 10; digit++) {
			
			// 훼손된 숫자를 찾은 경우 해당 훼손된 숫자를 출력 후 반복문 탈출
			if ((sum + digit * targetMultiplier) % 10 == 0) {
				out.write(String.valueOf(digit));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}