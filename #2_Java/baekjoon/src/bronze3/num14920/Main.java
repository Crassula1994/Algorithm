package bronze3.num14920;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 초항 값을 변수 term에 할당
		int term = Integer.parseInt(in.readLine());
		
		// 1이 되는 항의 순서를 저장할 변수 targetOrder 초기화
		int targetOrder = 1;
		
		// while 반복문을 사용해 수열이 1이 될 때까지 순회
		while (term != 1) {
			
			// 1이 되는 항의 순서를 갱신
			targetOrder++;
			
			// 현재 항이 짝수인 경우 현재 항을 갱신
			if ((term & 1) == 0) {
				term /= 2;
				
			// 현재 항이 홀수인 경우 현재 항을 갱신
			} else {
				term = term * 3 + 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 1이 되는 항의 순서를 출력
		out.write(String.valueOf(targetOrder));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}