package silver3.num03474;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 정수까지의 팩토리얼에 포함된 소인수 2와 5의 개수를 저장할 각 변수 초기화
			int countTwo = 0;
			int countFive = 0;
			
			// for 반복문을 사용해 해당 정수까지의 팩토리얼에 포함된 소인수 2의 개수를 갱신
			for (int factor = 2; factor <= number; factor *= 2)
				countTwo += number / factor;
			
			// for 반복문을 사용해 해당 정수까지의 팩토리얼에 포함된 소인수 5의 개수를 갱신
			for (int factor = 5; factor <= number; factor *= 5)
				countFive += number / factor;
			
			// min() 및 write() 메서드를 사용해 해당 정수까지의 팩토리얼 오른쪽 끝에 있는 0의 개수를 출력
			out.write(Math.min(countTwo, countFive) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}