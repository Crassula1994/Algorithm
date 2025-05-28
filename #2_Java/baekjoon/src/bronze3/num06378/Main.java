package bronze3.num06378;

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
		
		// while 반복문을 사용해 각 양의 정수를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 양의 정수를 변수 numberString에 할당
			String numberString = in.readLine();
			
			// 모든 양의 정수를 확인한 경우 반복문 탈출
			if (numberString.equals("0"))
				break;
			
			// 해당 정수의 각 자릿수를 더한 값을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 해당 정수의 각 자릿수의 합을 갱신
			for (int idx = 0; idx < numberString.length(); idx++)
				sum += numberString.charAt(idx) - '0';
			
			// while 반복문을 사용해 해당 정수의 디지털 루트를 찾을 때까지 순회
			while (sum >= 10) {
				
				// 현재 정수의 각 자릿수의 합을 저장할 변수 newSum 초기화
				int newSum = 0;
				
				// while 반복문을 사용해 현재 정수의 각 자릿수의 합을 갱신
				while (sum > 0) {
					newSum += sum % 10;
					sum /= 10;
				}
				
				// 해당 정수의 각 자릿수를 더한 값를 갱신
				sum = newSum;
			}
			
			// write() 메서드를 사용해 해당 정수의 디지털 루트를 출력
			out.write(sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}