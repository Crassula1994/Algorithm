package bronze3.num01284;

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

		// while 반복문을 사용해 각 호수판의 숫자를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 호수 번호를 변수 number에 할당
			String number = in.readLine();
			
			// 해당 호수 번호가 0인 경우 반복문 탈출
			if (number.equals("0"))
				break;
			
			// length() 메서드를 사용해 호수판의 여백을 반영하고, 필요 너비를 저장할 변수 width 초기화
			int width = number.length() + 1;
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int idx = 0; idx < number.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 자릿수를 변수 cipher에 할당
				char cipher = number.charAt(idx);
				
				// 해당 숫자가 0인 경우 필요 너비에 4를 추가
				if (cipher == '0') {
					width += 4;
					
				// 해당 숫자가 1인 경우 필요 너비에 2를 추가
				} else if (cipher == '1') {
					width += 2;
					
				// 나머지 숫자인 경우 필요 너비에 3을 추가
				} else {
					width += 3;
				}
			}
			
			// write() 메서드를 사용해 필요 너비를 출력
			out.write(width + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}