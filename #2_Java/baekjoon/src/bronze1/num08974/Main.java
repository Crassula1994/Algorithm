package bronze1.num08974;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구간의 시작과 끝을 각 변수에 할당
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// 해당 수열의 누적 합을 저장할 배열 sequenceSum 초기화
		int[] sequenceSum = new int[1001];
		
		// for 반복문을 사용해 배열 sequenceSum의 각 원소를 순회
		for (int idx = 1, num = 1, cnt = 0; idx <= 1000; idx++) {
			
			// 숫자의 개수를 갱신
			cnt++;
			
			// 누적 합을 갱신
			sequenceSum[idx] = sequenceSum[idx - 1] + num;
			
			// 개수와 숫자가 같을 때 개수를 초기화하고 숫자를 갱신
			if (cnt == num) {
				cnt = 0;
				num++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 구간에 속하는 숫자의 합을 출력
		out.write(String.valueOf(sequenceSum[end] - sequenceSum[start - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}