package bronze3.num06131;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 제곱 수의 차이를 변수 difference에 할당
		int difference = Integer.parseInt(in.readLine());
		
		// 상근이의 힌트 조건을 만족하는 두 정수 쌍의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 작은 정수를 순회
		for (int numberB = 1; numberB <= 500; numberB++) {
			
			// sqrt() 메서드를 사용해 더 큰 정수의 제곱과 그 정수를 계산해 각 변수에 할당
			int squareA = numberB * numberB + difference;
			int numberA = (int) Math.sqrt(squareA);
			
			// 상근이의 힌트 조건을 만족하는 두 정수 쌍을 찾은 경우 그 개수를 갱신
			if (numberA * numberA == squareA)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 상근이의 힌트 조건을 만족하는 두 정수 쌍의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}