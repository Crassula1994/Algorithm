package silver5.num01769;

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
		
		// readLine() 메서드를 사용해 입력 받은 큰 자연수를 변수 numStr에 할당
		String numStr = in.readLine();
		
		// 해당 자연수를 한 자리 자연수가 될 때까지 변환한 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 해당 자연수가 한 자리 자연수가 될 때까지 순회
		while (numStr.length() > 1) {
			
			// 해당 자연수의 모든 자릿수를 더해 변환한 결과를 저장할 변수 number 초기화
			int number = 0;
			
			// for 반복문을 사용해 자연수의 모든 자릿수를 더해 변환한 결과를 갱신
			for (int idx = 0; idx < numStr.length(); idx++)
				number += numStr.charAt(idx) - '0';
			
			// valueOf() 메서드를 사용해 변환한 결과를 문자열로 변환해 갱신
			numStr = String.valueOf(number);
			
			// 해당 자연수를 한 자리 자연수가 될 때까지 변환한 횟수를 갱신
			count++;
		}
		
		// write() 메서드를 사용해 해당 자연수를 한 자리 자연수가 될 때까지 변환한 횟수를 출력
		out.write(count + "\n");
		
		// 해당 자연수가 3의 배수인 경우 'YES' 출력
		if ((numStr.charAt(0) - '0') % 3 == 0) {
			out.write("YES");
			
		// 해당 자연수가 3의 배수가 아닌 경우 'NO' 출력
		} else {
			out.write("NO");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}