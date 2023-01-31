package bronze5.num1110;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 num에 할당
		int num = Integer.parseInt(in.readLine());
		
		// 사이클의 길이를 나타내는 변수 cycle 초기화
		int cycle = 0;
		
		// 연산 결과를 담을 변수 tempNum 초기화
		int tempNum = num;
		
		// while 반복문을 사용해 원래 수가 나올 때까지 순회
		while (true) {
		
			// 숫자가 10보다 작은 경우 연산 수행
			if (tempNum < 10) {
				tempNum *= 11;
				
			// 숫자가 10보다 큰 경우 연산 수행
			} else {
				int firstNum = tempNum % 10;
				int secondNum = ((tempNum / 10) + (tempNum % 10)) % 10;
				tempNum = firstNum * 10 + secondNum;
			}
			
			// 사이클의 길이 조정
			cycle += 1;
			
			// 원래 숫자와 같아진 경우 반복문 탈출
			if (tempNum == num)
				break;
		}
		
		// valueOf() 및 write() 메서드를 사용해 사이클의 길이를 출력
		out.write(String.valueOf(cycle));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}