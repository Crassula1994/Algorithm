package gold4.num11054;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 입력 받은 수열, 해당 위치까지 가장 긴 증가하는 부분 수열의 길이를 저장할 각 배열 초기화
		int[] sequence = new int[length];
		int[] leftSeq = new int[length];
		int[] rightSeq = new int[length];
		int[] bitonicSeq = new int[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 sequence의 각 원소에 숫자를 저장
		for (int idx = 0; idx < length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 가장 긴 바이토닉 부분 수열의 길이를 저장할 변수 maxLength 초기화
		int maxLength = 1;
		
		// for 반복문을 사용해 각 수열의 값을 순회
		for (int idx = 0; idx < sequence.length; idx++) {
			
			// 부분 수열의 길이를 1로 초기화
			leftSeq[idx] = 1;
			
			// for 반복문을 사용해 해당 수열의 값 이전의 값을 순회
			for (int prev = 0; prev < idx; prev++) {
				
				// 해당 값이 현재 값보다 작은 경우 가장 긴 증가하는 부분 수열의 길이를 모두 갱신
				if (sequence[prev] < sequence[idx])
					leftSeq[idx] = Math.max(leftSeq[prev] + 1, leftSeq[idx]);
			}
		}
		
		// for 반복문을 사용해 각 수열의 값을 순회
		for (int idx = sequence.length - 1; idx >= 0; idx--) {
			
			// 부분 수열의 길이를 1로 초기화
			rightSeq[idx] = 1;
			
			// for 반복문을 사용해 해당 수열의 값 이후의 값을 순회
			for (int next = sequence.length - 1; next > idx; next--) {
				
				// 해당 값이 현재 값보다 작은 경우 가장 긴 증가하는 부분 수열의 길이를 모두 갱신
				if (sequence[next] < sequence[idx])
					rightSeq[idx] = Math.max(rightSeq[next] + 1, rightSeq[idx]);
			}
			
			// 바이토닉 부분 수열의 값을 저장
			bitonicSeq[idx] = leftSeq[idx] + rightSeq[idx] - 1;
			
			// max() 메서드를 사용해 가장 긴 바이토닉 부분 수열의 길이를 갱신
			maxLength = Math.max(bitonicSeq[idx], maxLength);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 긴 바이토닉 부분 수열의 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}