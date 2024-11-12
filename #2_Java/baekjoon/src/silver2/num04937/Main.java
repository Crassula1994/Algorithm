package silver2.num04937;

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
		
		// while 반복문을 사용해 각 정수를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 모든 정수를 확인한 경우 반복문 탈출
			if (number == -1)
				break;
			
			// 해당 정수를 소인수로 나눈 나머지, 해당 정수가 급수에 속하는지 여부를 저장할 각 변수 초기화
			int remain = number;
			boolean isSeries = number > 1;
			
			// for 반복문을 사용해 해당 숫자의 가능한 인수를 모두 순회
			outer: for (int factor = 2; factor * factor <= number; factor++) {
				
				// while 반복문을 사용해 해당 인수로 나누어 떨어질 때까지 순회
				while (remain % factor == 0) {
					
					// 해당 소인수의 마지막 숫자가 3이 아닌 경우 해당 숫자가 급수에 속하는지 여부를 갱신 후 반복문 탈출
					if (factor % 10 != 3) {
						isSeries = false;
						break outer;
					}
					
					// 해당 숫자를 인수로 나누어 갱신
					remain /= factor;
				}
				
				// 가능한 인수를 모두 찾은 경우 반복문 탈출
				if (remain == 1)
					break;
			}
			
			// 남은 소인수가 3이 아닌 경우 해당 숫자가 급수에 속하는지 여부를 갱신
			if (isSeries && remain > 1 && remain % 10 != 3)
				isSeries = false;
			
			// write() 메서드를 사용해 해당 숫자가 급수에 속하는지 여부를 출력
			out.write((isSeries) ? number + " YES" : number + " NO");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}