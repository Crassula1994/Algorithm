package silver2.num16401;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 과자의 길이를 저장할 배열 biscuits 초기화
	static int[] biscuits;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 조카의 수와 과자의 수를 각 변수에 할당
		int sibkidNum = Integer.parseInt(st.nextToken());
		int biscuitNum = Integer.parseInt(st.nextToken());
		
		// 가장 긴 과자의 길이 및 각 과자의 길이의 총합을 저장할 각 변수 초기화
		int maxLength = 0;
		long totalLength = 0;
		
		// 각 과자의 길이를 저장할 배열 biscuits 초기화
		biscuits = new int[biscuitNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 과자의 길이를 순회
		for (int idx = 0; idx < biscuitNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 과자의 길이를 배열 biscuits에 저장
			biscuits[idx] = Integer.parseInt(st.nextToken());
			
			// max() 메서드를 사용해 가장 긴 과자의 길이 및 각 과자의 길이의 총합을 갱신
			maxLength = Math.max(biscuits[idx], maxLength);
			totalLength += biscuits[idx];
		}
		
		// 모든 조카에게 같은 길이의 막대 과자를 나눠줄 수 없는 경우 0을 출력
		if (totalLength < sibkidNum) {
			out.write(String.valueOf(0));
			
		// 모든 조카에게 같은 길이의 막대 과자를 나눠줄 수 있는 경우
		} else {
			
			// 이분탐색에 필요한 양 구간의 시작과 끝 값을 저장할 각 변수 초기화
			int start = 1;
			int end = maxLength + 1;
			
			// while 반복문을 사용해 모든 조카에게 줄 수 있는 막대 과자의 최대 길이를 찾을 때까지 순회
			while (start < end) {
				
				// 이분탐색에 필요한 중간 값을 계산해 변수 mid에 할당
				int mid = (start + end) / 2;
				
				// biscuitCounter() 메서드를 호출해 해당 길이로 만들 수 있는 과자의 개수를 변수 count에 할당
				long count = biscuitCounter(mid);
				
				// 해당 길이로 만들 수 있는 과자의 개수가 조카의 수보다 많거나 같은 경우
				if (count >= sibkidNum) {
					start = mid + 1;
					
				// 해당 길이로 만들 수 있는 과자의 개수가 조카의 수보다 적은 경우
				} else {
					end = mid;
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 출력
			out.write(String.valueOf(end - 1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// biscuitCounter() 메서드 정의
	public static long biscuitCounter(int length) {
		
		// 과자의 개수를 저장할 변수 count 초기화
		long count = 0;
		
		// for 반복문을 사용해 과자의 개수를 갱신
		for (int idx = 0; idx < biscuits.length; idx++)
			count += biscuits[idx] / length;
		
		// 과자의 개수를 반환
		return count;
	}
}