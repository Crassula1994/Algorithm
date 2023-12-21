package bronze1.num01356;

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
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		String number = in.readLine();
		
		// 한 자리 숫자인 경우 유진수가 아니므로 'NO' 출력
		if (number.length() < 2) {
			out.write("NO");
			
		// 한 자리 이상의 숫자인 경우
		} else {
			
			// 해당 숫자가 유진수인지를 나타낼 변수 isFit 초기화
			boolean isFit = false;
			
			// for 반복문을 사용해 해당 숫자를 두 부분으로 나누는 경우를 순회
			for (int idx = 1; idx < number.length(); idx++) {
				
				// substring() 메서드를 사용해 해당 숫자를 두 부분으로 나눠 각 변수에 할당
				String leftNum = number.substring(0, idx);
				String rightNum = number.substring(idx);
				
				// 각 부분의 곱의 합을 저장할 각 변수 초기화
				int leftSum = 1;
				int rightSum = 1;
				
				// for 반복문을 사용해 왼쪽 부분의 곱의 합을 갱신
				for (int leftIdx = 0; leftIdx < leftNum.length(); leftIdx++)
					leftSum *= leftNum.charAt(leftIdx) - '0';
				
				// for 반복문을 사용해 오른쪽 부분의 곱의 합을 갱신
				for (int rightIdx = 0; rightIdx < rightNum.length(); rightIdx++)
					rightSum *= rightNum.charAt(rightIdx) - '0';
				
				// 두 부분의 곱의 합이 같은 경우 유진수이므로 isFit 변수 갱신 후 반복문 탈출
				if (leftSum == rightSum) {
					isFit = true;
					break;
				}
			}
			
			// 유진수인 경우 'YES' 출력
			if (isFit) {
				out.write("YES");
				
			// 유진수가 아닌 경우 'NO' 출력
			} else {
				out.write("NO");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}