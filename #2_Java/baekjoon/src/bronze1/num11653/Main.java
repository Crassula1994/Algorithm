package bronze1.num11653;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 소인수분해의 결과을 저장할 변수 remains 초기화
		int remains = number;
		
		// while 반복문을 사용해 소인수 분해의 결과가 1이 될 때까지 순회
		while (remains > 1) {
			
			// 숫자를 나눌 소인수 primeNum을 초기화
			int primeNum = 2;
			
			// while 반복문을 사용해 나누어 떨어질 때까지 순회
			while (true) {
				
				// 소인수로 나누어 떨어지는 경우 소인수 출력 후 반복문 탈출
				if (remains % primeNum == 0) {
					out.write(primeNum + "\n");
					break;
				}
				
				// 소인수로 나누어 떨어지지 않는 경우 소인수 조정
				primeNum++;
			}
			
			// 해당 소인수로 나눈 값을 소인수 분해의 결과로 갱신
			remains /= primeNum;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}