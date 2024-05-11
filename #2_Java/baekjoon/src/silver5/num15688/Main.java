package silver5.num15688;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 각 숫자를 저장할 배열 sequence 초기화
		int[] sequence = new int[numberCnt];
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 배열 sequence를 비내림차순으로 정렬
		Arrays.sort(sequence);
		
		// for 반복문을 사용해 비내림차순으로 정렬한 숫자를 출력
		for (int number : sequence)
			out.write(number + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}