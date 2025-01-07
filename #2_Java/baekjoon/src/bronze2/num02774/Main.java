package bronze2.num02774;

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
			
			// 입력 받은 숫자의 아름다운 정도를 저장할 변수 beautyLevel 초기화
			int beautyLevel = 0;
			
			// readLine() 메서드를 사용해 입력 받은 아름다운 정도를 알고 싶은 숫자를 변수 numberString에 할당
			String numberString = in.readLine();
			
			// 각 숫자가 등장했는지 여부를 나타낼 배열 digits 초기화
			boolean[] digits = new boolean[10];
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int idx = 0; idx < numberString.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 숫자를 변수 digit에 할당
				int digit = numberString.charAt(idx) - '0';
				
				// 해당 숫자가 이미 등장한 경우 다음 숫자를 순회
				if (digits[digit])
					continue;
				
				// 해당 숫자가 이미 등장했는지 여부 및 입력 받은 숫자의 아름다운 정도를 갱신
				digits[digit] = true;
				beautyLevel++;
			}
			
			// write() 메서드를 사용해 입력 받은 숫자의 아름다운 정도를 출력
			out.write(beautyLevel + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}