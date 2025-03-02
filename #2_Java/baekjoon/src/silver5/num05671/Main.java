package silver5.num05671;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 해당 숫자가 반복되는 숫자가 있는지 여부를 저장할 배열 isUnique 초기화
	static Boolean[] isUnique = new Boolean[5001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 테스트 케이스를 저장할 변수 testCase 초기화
		String testCase;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while ((testCase = in.readLine()) != null) {
			
			// 선영이의 새 호텔에 있을 수 있는 최대 방의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(testCase);
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 호텔 방의 시작 번호와 끝 번호를 각 변수에 할당
			int startNumber = Integer.parseInt(st.nextToken());
			int endNumber = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int number = startNumber; number <= endNumber; number++) {
				
				// 해당 숫자가 반복되는 숫자가 없는 경우 선영이의 새 호텔에 있을 수 있는 최대 방의 개수를 갱신
				if (numberChecker(number))
					count++;
			}
			
			// write() 메서드를 사용해 선영이의 새 호텔에 있을 수 있는 최대 방의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberChecker() 메서드 정의
	public static boolean numberChecker(int number) {
		
		// 해당 숫자가 반복되는 숫자가 있는지 여부를 이미 확인한 경우 해당 결과를 반환
		if (isUnique[number] != null)
			return isUnique[number];
		
		// 각 자릿수의 등장 여부를 저장할 배열 digits 초기화
		boolean[] digits = new boolean[10];
		
		// 남은 숫자를 저장할 변수 remains 초기화
		int remains = number;
		
		// while 반복문을 사용해 각 숫자의 자릿수를 순회
		while (remains > 0) {
			
			// 현재 자릿수를 변수 digit에 할당
			int digit = remains % 10;
			
			// 해당 자릿수가 이미 등장한 경우 false를 반환
			if (digits[digit])
				return isUnique[number] = false;
			
			// 해당 자릿수의 등장 여부 및 현재 숫자를 갱신
			digits[digit] = true;
			remains /= 10;
		}

		// 해당 숫자가 반복되는 숫자가 없는 경우 true를 반환
		return isUnique[number] = true;
	}
}