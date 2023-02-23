package silver5.num01427;

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

		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 숫자를 배열 charArray에 할당
		char[] charArray = in.readLine().toCharArray();
		
		// 각 숫자의 등장 여부를 확인할 배열 numbers 초기화
		int[] numbers = new int[10];
		
		// for 반복문을 사용해 배열 charArray의 각 숫자의 개수를 numbers에 추가
		for (int idx = 0; idx < charArray.length; idx++)
			numbers[charArray[idx] - '0']++;

		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int idx = numbers.length - 1; idx >= 0; idx--) {
			
			// 해당 숫자가 등장한 경우
			if (numbers[idx] != 0) {
				
				// for 반복문을 사용해 해당 숫자의 개수만큼 출력
				for (int i = 0; i < numbers[idx]; i++)
					out.write(String.valueOf(idx));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}