package silver3.num02986;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 해당 숫자를 나누어 떨어지게 만드는, 자기 자신이 아닌 가장 큰 약수를 저장할 변수 maxDivisor 초기화
		int maxDivisor = 1;
		
		// for 반복문을 사용해 각 숫자의 가능한 인수를 순회
		for (int divisor = 2; divisor * divisor <= number; divisor++) {
			
			// 해당 인수가 입력 받은 숫자의 인수인 경우 자기 자신이 아닌 가장 큰 약수를 갱신 후 반복문 탈출
			if (number % divisor == 0) {
				maxDivisor = number / divisor;
				break;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 자기 자신이 아닌 가장 큰 약수와의 차이를 출력
		out.write(String.valueOf(number - maxDivisor));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}