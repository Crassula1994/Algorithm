package bronze2.num03052;

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
		
		// 42로 나눈 나머지의 개수를 저장할 배열 remains 초기화
		int[] remains = new int[42];
		
		// 서로 다른 나머지의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 입력된 숫자의 각 줄을 순회
		for (int line = 0; line < 10; line++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 42로 나눈 나머지를 변수 remain에 할당
			int remain = Integer.parseInt(in.readLine()) % 42;
			
			// 해당 나머지의 개수가 1 증가하도록 개수 조정
			remains[remain] += 1;
		}

		// for 반복문을 사용해 배열 remains의 각 원소를 순회
		for (int remain : remains) {
			
			// 나머지가 존재하는 경우 count 변수 조정
			if (remain != 0)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 서로 다른 나머지의 개수 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}