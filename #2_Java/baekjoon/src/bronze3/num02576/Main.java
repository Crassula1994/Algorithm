package bronze3.num02576;

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
		
		// 홀수의 합 및 가장 작은 홀수를 저장할 각 변수 초기화
		int sum = 0;
		int minValue = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int n = 0; n < 7; n++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 숫자가 짝수인 경우 다음 숫자를 순회
			if (number % 2 == 0)
				continue;
			
			// min() 메서드를 사용해 가장 작은 홀수를 갱신하고, 홀수의 합을 갱신
			minValue = Math.min(number, minValue);
			sum += number;
		}
		
		// 홀수가 존재하지 않는 경우 -1을 출력
		if (sum == 0) {
			out.write(String.valueOf(-1));
		
		// 홀수가 존재하는 경우 홀수의 합 및 최소의 홀수를 출력
		} else {
			out.write(sum + "\n" + minValue);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}