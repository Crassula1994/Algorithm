package bronze2.num02581;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 상한과 하한을 각 변수에 할당
		int lowerLimit = Integer.parseInt(in.readLine());
		int upperLimit = Integer.parseInt(in.readLine());
		
		// 소수의 합과 최솟값을 저장할 각 변수 초기화
		int sum = 0;
		int minimum = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int num = lowerLimit; num < upperLimit + 1; num++) {
			
			// 2인 경우 소수의 합 및 최솟값 갱신
			if (num == 2) {
				sum += num;
				minimum = 2;
			
			// 2가 아닌 경우
			} else {
				
				// for 반복문을 사용해 소수인지 검사
				for (int i = 2; i < num; i++) {
					
					// 소수가 아닌 경우 반복문 탈출
					if (num % i == 0)
						break;
					
					// 소수인 경우 소수의 합 갱신
					if (i == num - 1) {
						sum += num;
						
						// 최솟값인 경우 최솟값 갱신
						if (minimum == 0)
							minimum = num;
					}
				}
			}
		}
		
		// 소수가 없는 경우 -1 출력
		if (sum == 0) {
			out.write(String.valueOf(-1));

		// 소수가 있는 경우 write() 메서드를 사용해 소수의 개수 및 최솟값 출력
		} else {
			out.write(sum + "\n" + minimum);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}