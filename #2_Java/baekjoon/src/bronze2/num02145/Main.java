package bronze2.num02145;

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
		
		// while 반복문을 사용해 각 숫자를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도겸이가 주는 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 0이 입력된 경우 반복문 탈출
			if (number == 0)
				break;
			
			// while 반복문을 사용해 자릿수의 합이 한 자릿수가 될 때까지 순회
			while (number >= 10) {
				
				// 각 자릿수의 합을 저장할 변수 digitSum 초기화
				int digitSum = 0;
				
				// while 반복문을 사용해 각 자릿수의 합을 갱신
				while (number > 0) {
					digitSum += number % 10;
					number /= 10;
				}
				
				// 현재 숫자를 자릿수의 합으로 갱신
				number = digitSum;
			}
			
			// write() 메서드를 사용해 한 자릿수 결과를 출력
			out.write(number + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}