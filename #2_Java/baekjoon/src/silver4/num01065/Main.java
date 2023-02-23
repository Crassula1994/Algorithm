package silver4.num01065;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 num에 할당
		int num = Integer.parseInt(in.readLine());
		
		// 입력 받은 숫자가 1000인 경우 999와 결과가 같으므로 숫자 조정
		if (num == 1000)
			num--;
		
		// 한수의 개수를 저장할 변수 count 초기화
		int count = 99;
		
		// 입력 받은 숫자가 100 미만인 경우 모든 숫자가 한수이므로 입력 받은 값을 그대로 출력
		if (num < 100) {
			out.write(String.valueOf(num));
		
		// 입력 받은 숫자가 100 이상인 경우
		} else {
			
			// for 반복문을 사용해 100 이상부터 입력 받은 숫자까지 순회			
			for (int i = 100; i < num + 1; i++) {
				
				// 각 자리의 숫자를 저장할 각 변수를 할당
				int hundreds = i / 100;
				int tens = (i % 100) / 10;
				int units = i % 10;

				// 각 숫자의 차이가 같은 경우 한수의 개수를 갱신
				if ((hundreds - tens) == (tens - units))
					count++;
			}
			
			// valueOf() 및 write() 메서드를 사용해 한수의 개수를 출력
			out.write(String.valueOf(count));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}