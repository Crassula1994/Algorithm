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
			
			// readLine() 메서드를 사용해 입력 받은 숫자를 배열 originNumber에 할당
			char[] originNumber = in.readLine().toCharArray();
			
			// palindromeMaker() 및 write() 메서드를 사용해 해당 숫자 이상인 팰린드롬인 수를 출력
			out.write(palindromeMaker(originNumber) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeMaker() 메서드 정의
	public static String palindromeMaker(char[] originNumber) {
		
		// 입력 받은 숫자의 길이를 변수 length에 할당
		int length = originNumber.length;
		
		// 해당 숫자 이상인 팰린드롬인 수를 저장할 배열 targetNumber 초기화
		char[] targetNumber = new char[length];
		
		// for 반복문을 사용해 해당 숫자 이상인 팰린드롬인 수를 초기화
		for (int idx = 0; idx < length / 2; idx++) {
			targetNumber[idx] = originNumber[idx];
			targetNumber[length - idx - 1] = originNumber[idx];
		}
		
		// 숫자의 길이가 홀수인 경우 가운데 숫자를 배열 targetNumber에 저장
		if ((length & 1) == 1)
			targetNumber[length / 2] = originNumber[length / 2];
		
		// while 반복문을 사용해 만든 팰린드롬인 수가 주어진 숫자 이상일 때까지 순회
		
		
		// 해당 숫자 이상인 팰린드롬인 수를 반환
		return new String(targetNumber);
	}
}