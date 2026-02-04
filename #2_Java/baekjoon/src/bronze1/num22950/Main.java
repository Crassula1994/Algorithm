package bronze1.num22950;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이진수의 자릿수, 이진수, 나누는 수의 지수를 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String binaryString = in.readLine();
		int exponent = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 해당 이진수가 나누는 수로 나누어 떨어지는지 여부를 출력
		out.write((binaryChecker(length, binaryString, exponent)) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// binaryChecker() 메서드 정의
	public static boolean binaryChecker(int length, String binaryString, int exponent) {
		
		// min() 메서드를 사용해 해당 이진수에서 확인 범위를 변수 range에 할당
		int range = Math.min(length, exponent);
			
		// for 반복문을 사용해 각 이진수의 자릿수를 순회
		for (int idx = 0; idx < range; idx++) {
			
			// 해당 자릿수가 1인 경우 나누어 떨어지지 않으므로 false 반환
			if (binaryString.charAt(length - idx - 1) == '1')
				return false;
		}
		
		// 해당 이진수가 나누어 떨어지는 경우 true 반환
		return true;
	}
}