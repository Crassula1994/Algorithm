package bronze4.num16017;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 전화번호의 각 자릿수를 저장할 배열 digits 초기화
	static int[] digits = new int[4];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 입력 받은 전화번호의 각 자릿수를 배열 digits에 저장
		for (int idx = 0; idx < digits.length; idx++)
			digits[idx] = Integer.parseInt(in.readLine());
		
		// 해당 전화번호가 텔레마케터의 번호인 경우 'ignore' 출력
		if (telemarketerChecker()) {
			out.write("ignore");
			
		// 해당 전화번호가 텔레마케터의 번호가 아닌 경우 'answer' 출력
		} else {
			out.write("answer");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// telemarketerChecker() 메서드 정의
	public static boolean telemarketerChecker() {
		
		// 첫 번째 자리가 8 또는 9가 아닌 경우 false 반환
		if (digits[0] != 8 && digits[0] != 9)
			return false;
		
		// 마지막 자리가 8 또는 9가 아닌 경우 false 반환
		if (digits[3] != 8 && digits[3] != 9)
			return false;
		
		// 두 번째 자리와 세 번째 자리가 다른 경우 false 반환
		if (digits[1] != digits[2])
			return false;
		
		// 해당 전화번호가 텔레마케터의 번호인 경우 true 반환
		return true;
	}
}