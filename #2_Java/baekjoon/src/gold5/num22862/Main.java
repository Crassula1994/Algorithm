package gold5.num22862;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이 및 삭제할 수 있는 횟수를 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int delCnt = Integer.parseInt(st.nextToken());
		
		// 입력 받은 수열의 각 원소가 짝수인지를 저장할 배열 isEven 초기화
		boolean[] isEven = new boolean[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 isEven의 각 원소를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 원소가 짝수인 경우 저장된 값 갱신
			if (Integer.parseInt(st.nextToken()) % 2 == 0)
				isEven[idx] = true;
		}
		
		// 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 저장할 변수 maxLength 초기화
		int maxLength = Integer.MIN_VALUE;

		// 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 탐색하기 위해 필요한 각 변수 초기화
		int start = 0;
		int end = 0;
		int deleted = 0;
		
		// while 반복문을 사용해 끝 인덱스가 배열의 마지막에 도달할 때까지 순회
		while (end < length) {
			
			// 해당 숫자가 짝수인 경우
			if (isEven[end]) {
				
				// 끝 인덱스 조정
				end++;
				
				// max() 메서드를 사용해 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 갱신
				maxLength = Math.max(end - start - deleted, maxLength);
			
			// 해당 숫자가 홀수이고, 삭제할 수 있는 횟수가 남은 경우
			} else if (deleted < delCnt) {
				
				// 삭제할 수 있는 횟수 및 끝 인덱스 조정
				deleted++;
				end++;
				
				// max() 메서드를 사용해 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 갱신
				maxLength = Math.max(end - start - deleted, maxLength);
				
			// 해당 숫자가 홀수이고, 삭제할 수 있는 횟수가 가득 찬 경우
			} else {
				
				// 첫 인덱스의 숫자가 홀수인 경우 삭제할 수 있는 횟수 갱신
				if (!isEven[start])
					deleted--;
				
				// 첫 인덱스 조정
				start++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}