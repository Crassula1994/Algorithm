package bronze2.num2750;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 해당 숫자의 등장 여부를 확인할 배열 numbers 초기화
		int[] numbers = new int[2001];
		
		// for 반복문을 사용해 입력 받은 각 숫자를 순회
		for (int i = 0; i < length; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력받은 숫자를 변수 num에 할당
			int num = Integer.parseInt(in.readLine());

			// 해당 숫자를 배열 numbers에 추가
			numbers[num + 1000]++;
		}

		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int idx = 0; idx < numbers.length; idx++) {
			
			// 해당 숫자가 등장한 경우 출력
			if (numbers[idx] != 0)
				out.write((idx - 1000) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}