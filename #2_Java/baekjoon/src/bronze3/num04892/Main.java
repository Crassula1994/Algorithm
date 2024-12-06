package bronze3.num04892;

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
		
		// 테스트 케이스 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 친구가 생각한 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (number == 0)
				break;
			
			// 친구가 생각한 숫자가 홀수인 경우 'odd' 및 n4를 출력
			if ((number & 1) == 1) {				
				out.write(String.format("%d. odd %d\n", ++testCase, (number * 3 + 1) / 6));
				
			// 친구가 생각한 숫자가 짝수인 경우 'even' 및 n4를 출력
			} else {
				out.write(String.format("%d. even %d\n", ++testCase, number / 2));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}