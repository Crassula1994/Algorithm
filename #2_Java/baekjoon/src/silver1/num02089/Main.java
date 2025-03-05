package silver1.num02089;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 10진법의 수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 주어진 숫자가 0인 경우 sb에 0을 추가
		if (number == 0) {
			sb.append(0);
		
		// 주어진 숫자가 0이 아닌 경우
		} else {
			
			// while 반복문을 사용해 해당 숫자가 0이 될 때까지 순회
			while (number != 0) {
				
				// 해당 숫자를 -2로 나눈 나머지를 변수 reaminder에 할당
				int remainder = number % -2;
				
				// 해당 숫자를 -2로 나눈 몫으로 숫자를 갱신
				number /= -2;
				
				// 나머지가 -1인 경우 나머지가 양수가 되도록 나머지와 몫을 갱신
				if (remainder == -1) {
					remainder += 2;
					number += 1;
				}
				
				// append() 메서드를 사용해 sb에 -2로 나눈 나머지를 추가
				sb.append(remainder);
			}
		}
		
		// reverse(), toString(), write() 메서드를 사용해 -2진법으로 변환한 결과를 출력
		out.write(sb.reverse().toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}