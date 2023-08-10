package bronze2.num02747;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 피보나치 수의 순서를 변수 order에 할당
		int order = Integer.parseInt(in.readLine());
		
		// 해당 피보나치 수를 저장할 배열 fibonacci 초기화
		int[] fibonacci = new int[order + 1];
		
		// 첫 번째 피보나치 수를 초기화
		fibonacci[1] = 1;
		
		// for 반복문을 사용해 각 피보나치 수를 갱신
		for (int idx = 2; idx <= order; idx++)
			fibonacci[idx] = fibonacci[idx - 1] + fibonacci[idx - 2];
		
		// valueOf() 및 write() 메서드를 사용해 해당 순서의 피보나치 수를 출력
		out.write(String.valueOf(fibonacci[order]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}