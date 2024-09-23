package bronze2.num32279;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 수열의 원소를 저장할 배열 sequence 초기화
		int[] sequence = new int[length + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 양의 정수를 각 변수에 할당
		int numberP = Integer.parseInt(st.nextToken());
		int numberQ = Integer.parseInt(st.nextToken());
		int numberR = Integer.parseInt(st.nextToken());
		int numberS = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 첫 번째 원소를 배열 sequence에 저장
		sequence[1] = Integer.parseInt(in.readLine());
		
		// 수열의 원소의 합을 저장할 변수 totalSum 초기화
		int totalSum = sequence[1];
		
		// for 반복문을 사용해 각 수열의 원소를 순회
		for (int idx = 2; idx < sequence.length; idx++) {
			
			// 해당 수열의 원소를 갱신 후 배열 sequence에 저장
			sequence[idx] = ((idx & 1) == 1)
					? numberR * sequence[idx / 2] + numberS : numberP * sequence[idx / 2] + numberQ;
			
			// 수열의 원소의 합을 갱신
			totalSum += sequence[idx];
		}
		
		// valueOf() 및 write() 메서드를 사용해 수열의 원소의 합을 출력
		out.write(String.valueOf(totalSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}