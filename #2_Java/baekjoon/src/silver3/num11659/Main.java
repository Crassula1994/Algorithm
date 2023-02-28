package silver3.num11659;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수 및 합을 구해야 하는 개수를 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int calcNum = Integer.parseInt(st.nextToken());		
		
		// 숫자의 누적합을 저장할 배열 sequence 초기화
		int[] sequence = new int[length + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 sequence의 각 원소를 순회
		for (int idx = 1; idx <= length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// 배열 sequence에 누적 합을 저장
			sequence[idx] = sequence[idx - 1] + number;
		}
		
		// for 반복문을 사용해 각 구간을 순회
		for (int r = 0; r < calcNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구간의 시작과 끝을 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());		
			
			// 구간 합을 계산해 해당 값을 변수 sum에 할당
			int sum = sequence[end] - sequence[start - 1];
			
			//  write() 메서드를 사용해 구간 합을 출력
			out.write(sum + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}