package bronze1.num1259;

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
		
		// while 반복문을 사용해 각 줄을 모두 순회
		while (true) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 숫자를 배열 numArray에 저장
			char[] numArray = in.readLine().toCharArray();
			
			// 입력 받은 배열의 첫 자리가 0인 경우 반복문 탈출
			if (numArray[0] == '0')
				break;
			
			// 입력 받은 배열이 한 자리 수인 경우 'yes' 출력 후 다음으로 넘기기
			if (numArray.length == 1) {
				out.write("yes\n");
				continue;
			}
			
			// for 반복문을 사용해 자릿수의 절반을 차례로 순회
			for (int idx = 0; idx < numArray.length / 2; idx++) {
				
				// 대칭이 되는 자릿수의 값이 다른 경우 'no' 출력 후 반복문 탈출
				if (numArray[idx] != numArray[numArray.length - idx - 1]) {
					out.write("no\n");
					break;
				}
				
				// 대칭이 되는 자릿수의 값이 같은 경우 'yes' 출력
				if (idx == numArray.length / 2 - 1)
					out.write("yes\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}