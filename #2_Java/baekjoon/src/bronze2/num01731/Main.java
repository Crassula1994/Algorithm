package bronze2.num01731;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 수열의 원소를 저장할 배열 sequence 초기화
		int[] sequence = new int[length];
		
		// for 반복문을 사용해 입력 받은 수열의 원소를 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(in.readLine());
		
		// 해당 수열이 등차수열인 경우 수열의 다음 원소를 출력
		if (sequence[2] - sequence[1] == sequence[1] - sequence[0]) {
			out.write(String.valueOf(sequence[length - 1] + sequence[1] - sequence[0]));
			
		// 해당 수열이 등비수열인 경우 수열의 다음 원소를 출력
		} else {
			out.write(String.valueOf(sequence[length - 1] * (sequence[1] / sequence[0])));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}