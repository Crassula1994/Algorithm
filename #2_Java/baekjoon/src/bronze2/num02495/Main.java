package bronze2.num02495;

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
		
		// for 반복문을 사용해 각 정수를 순회
		for (int number = 0; number < 3; number++) {
			
			// 같은 숫자가 연속하여 나오는 길이 및 가장 긴 길이를 저장할 각 변수 초기화
			int length = 1;
			int maxLength = 1;
			
			// readLine() 및 toCharArray() 메서드를 사용해 해당 숫자의
			char[] numArray = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int idx = 1; idx < numArray.length; idx++) {
				
				// 앞 숫자와 같은 경우 같은 숫자가 연속하여 나오는 길이를 갱신
				if (numArray[idx] == numArray[idx - 1]) {
					length++;
				
				// 앞 숫자와 다른 경우
				} else {
					
					// max() 메서드를 사용해 같은 숫자가 연속하여 나오는 가장 긴 길이를 갱신
					maxLength = Math.max(length, maxLength);
					
					// 같은 숫자가 연속하여 나오는 길이를 초기화
					length = 1;
				}
				
				// 마지막 자릿수인 경우 같은 숫자가 연속하여 나오는 가장 긴 길이를 갱신
				if (idx == numArray.length - 1)
					maxLength = Math.max(length, maxLength);
			}
			
			// write() 메서드를 사용해 같은 숫자가 연속하여 나오는 가장 긴 길이를 출력
			out.write(maxLength + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}