package bronze1.num02846;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 sequenceNum에 할당
		int sequenceNum = Integer.parseInt(in.readLine());
		
		// 수열을 저장할 배열 sequence 초기화
		int[] sequence = new int[sequenceNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 높이를 배열 sequence에 저장
		for (int idx = 0; idx < sequenceNum; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 가장 큰 오르막의 크기, 이전의 최소 높이를 저장할 각 변수 초기화
		int maxSize = Integer.MIN_VALUE;
		int bottom = sequence[0];
		
		// for 반복문을 사용해 각 높이를 순회
		for (int idx = 1; idx < sequence.length; idx++) {
			
			// 현재 높이가 이전 오르막의 크기보다 높은 경우 다음 높이를 순회
			if (sequence[idx] > sequence[idx - 1])
				continue;
			
			// max() 메서드를 사용해 가장 큰 오르막의 크기를 갱신
			maxSize = Math.max(sequence[idx - 1] - bottom, maxSize);
			
			// 이전의 최소 높이를 갱신
			bottom = sequence[idx];
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 큰 오르막의 크기를 출력
		out.write(String.valueOf(maxSize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}