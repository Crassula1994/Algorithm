package silver5.num15779;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 seqLength에 할당
		int seqLength = Integer.parseInt(in.readLine());
		
		// 지그재그 부분 수열의 길이 및 최대 길이를 저장할 각 변수 초기화
		int length = 0;
		int maxLength = 0;
		
		// 입력 받은 수열을 저장할 배열 sequence 초기화
		int[] sequence = new int[seqLength];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 부분 수열을 순회
		for (int idx = 0; idx < sequence.length - 2; idx++) {
			
			// 마지막 부분 수열이거나 지그재그 부분 수열이 아닌 경우
			if (!zigzagChecker(sequence[idx], sequence[idx + 1], sequence[idx + 2])) {
					
				// max() 메서드를 사용해 지그재그 부분 수열의 최대 길이를 갱신
				maxLength = Math.max(length + 2, maxLength);
				
				// 지그재그 부분 수열의 길이를 초기화
				length = 0;
				
				// 다음 부분 수열을 순회
				continue;
			}
			
			// 지그재그 부분 수열의 길이를 갱신
			length++;
			
			// 마지막 부분 수열인 경우 지그재그 부분 수열의 최대 길이를 갱신
			if (idx == sequence.length - 3)
				maxLength = Math.max(length + 2, maxLength);
		}
		
		// valueOf() 및 write() 메서드를 사용해 지그재그 부분 수열의 최대 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// zigzagChecker() 메서드 정의
	public static boolean zigzagChecker(int firstElement, int secondElement, int thirdElement) {
		
		// 지그재그 부분 수열의 첫 번째 조건을 만족하지 않는 경우 false 반환
		if (firstElement <= secondElement && secondElement <= thirdElement)
			return false;
		
		// 지그재그 부분 수열의 두 번째 조건을 만족하지 않는 경우 false 반환
		if (firstElement >= secondElement && secondElement >= thirdElement)
			return false;
		
		// 지그재그 부분 수열의 조건을 모두 만족하는 경우 true 반환
		return true;
	}
}