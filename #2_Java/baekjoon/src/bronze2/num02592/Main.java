package bronze2.num02592;

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
		
		// 각 숫자의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[100];
		
		// 최빈값과 그 개수, 숫자의 합을 저장할 각 변수 초기화
		int mode = -1;
		int maxCnt = 0;
		int sum = 0;
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int n = 0; n < 10; n++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 숫자의 개수를 갱신
			counter[number / 10]++;
			
			// 숫자의 합을 갱신
			sum += number;
		}
		
		// write() 메서드를 사용해 평균을 출력
		out.write(sum / 10 + "\n");
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int idx = 0; idx < counter.length; idx++) {
			
			// 해당 숫자의 개수가 현재까지의 최빈값의 개수보다 많은 경우
			if (counter[idx] > maxCnt) {
				
				// 최빈값의 개수 및 최빈값 갱신
				maxCnt = counter[idx];
				mode = idx * 10;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 최빈값을 출력
		out.write(String.valueOf(mode));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}