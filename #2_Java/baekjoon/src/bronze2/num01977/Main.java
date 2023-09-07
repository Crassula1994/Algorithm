package bronze2.num01977;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 하한과 상한을 각 변수에 할당
		int lowerLimit = Integer.parseInt(in.readLine());
		int upperLimit = Integer.parseInt(in.readLine());
		
		// 완전제곱수의 합 및 그 중 최솟값을 저장할 각 변수 초기화
		int sum = 0;
		int minNum = -1;
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int n = 1; n <= 100; n++) {
			
			// 해당 완전 제곱수를 변수 number에 할당
			int number = n * n;
			
			// 완전 제곱수가 자연수의 하한과 상한 사이에 위치할 경우
			if (number >= lowerLimit && number <= upperLimit) {
				
				// 최소 완전제곱수인 경우 최솟값을 갱신
				if (sum == 0)
					minNum = number;
				
				// 완전제곱수의 합을 갱신
				sum += number;
			}
		}
		
		// 완전제곱수가 없는 경우 -1을 출력
		if (sum == 0) {
			out.write(String.valueOf(minNum));
		
		// 완전제곱수가 존재하는 경우 그 합과 최솟값을 출력
		} else {
			out.write(sum + "\n" + minNum);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}