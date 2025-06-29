package bronze1.num20154;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 알파벳 대문자의 획수를 저장할 배열 alphabets 초기화
	static int[] alphabets = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 inputString에 할당
		String inputString = in.readLine();
		
		// 문자열에 사용된 알파벳 대문자의 획수 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 문자열에 사용된 알파벳 대문자의 획수 합을 갱신
		for (int idx = 0; idx < inputString.length(); idx++)
			sum += alphabets[inputString.charAt(idx) - 'A'];
		
		// write() 메서드를 사용해 마지막 남은 수가 홀수인지 짝수인지 여부를 출력
		out.write(((sum & 1) == 1) ? "I'm a winner!" : "You're the winner?");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}