package gold5.num22301;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			String number = in.readLine();
			
			// palindromeMaker() 및 write() 메서드를 사용해 해당 숫자 이상인 팰린드롬인 수를 출력
			out.write(palindromeMaker(number) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeMaker() 메서드 정의
	public static String palindromeMaker(String number) {
		
		// length() 메서드를 사용해 입력 받은 숫자의 길이, 해당 숫자의 중간 위치, 숫자 올림이 필요한지 여부를 각 변수에 할당
		int length = number.length();
		int midLeft = (length - 1) / 2;
		int midRight = length / 2;
		boolean isRoundedUp = false;
		
		// toCharArray() 메서드를 사용해 입력 받은 숫자의 자릿수를 저장할 배열 digits 초기화
		char[] digits = number.toCharArray();
		
		// for 반복문을 사용해 각 대칭인 숫자 쌍을 순회
		for (int left = midLeft, right = midRight; left >= 0; left--, right++) {
			
			// 왼쪽의 숫자가 더 큰 경우 숫자 올림이 필요 없으므로 반복문 탈출
			if (digits[left] > digits[right]) {
				break;
			
			// 오른쪽의 숫자가 더 큰 경우 숫자 올림이 필요한지 여부를 갱신 후 반복문 탈출
			} else if (digits[left] < digits[right]) {
				isRoundedUp = true;
				break;
			}
		}
		
		// 숫자 올림이 필요한 경우
		if (isRoundedUp) {
			
			// for 반복문을 사용해 중간을 기준으로 왼쪽의 자릿수를 거꾸로 순회
			for (int idx = midLeft, nextDigit = 1; idx >= 0 && nextDigit > 0; idx--) {
				
				// 현재 올림한 자릿수를 변수 curDigit에 할당
				int curDigit = digits[idx] - '0' + nextDigit;
				
				// 현재 올림한 자릿수 및 다음 자릿수에 더할 숫자를 갱신
				digits[idx] = (char) ((curDigit % 10) + '0');
				nextDigit = curDigit / 10;
			}
		}
		
		// for 반복문을 사용해 중간에서 왼쪽의 자릿수를 기준으로 해당 숫자를 팰린드롬인 수로 변환
		for (int left = midLeft, right = midRight; left >= 0; left--, right++)
			digits[right] = digits[left];
		
		// 해당 숫자 이상인 팰린드롬인 수를 반환
		return new String(digits);
	}
}