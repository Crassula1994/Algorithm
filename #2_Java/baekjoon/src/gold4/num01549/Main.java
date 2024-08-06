package gold4.num01549;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 두 부분 수열의 최소 차이와 그 때 부분수열의 길이를 저장할 각 변수 초기화
		long minDifference = Long.MAX_VALUE;
		int minLength = 0;
		
		// 입력 받은 수열의 누적 합을 저장할 배열 sequenceSum 초기화
		long[] sequenceSum = new long[size + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열의 누적 합을 배열 sequenceSum에 저장
		for (int idx = 1; idx < sequenceSum.length; idx++)
			sequenceSum[idx] = sequenceSum[idx - 1] + Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 가능한 부분 수열의 길이를 순회
		for (int length = 1; length <= size / 2; length++) {
			
			// for 반복문을 사용해 가능한 첫 번째 부분 수열을 순회
			for (int sub1 = 1; sub1 <= size - 2 * length + 1; sub1++) {
				
				// 첫 번째 부분 수열의 합을 계산해 변수 sumSub1에 할당
				long sumSub1 = sequenceSum[sub1 + length - 1] - sequenceSum[sub1 - 1];
				
				// for 반복문을 사용해 가능한 두 번째 부분 수열을 순회
				for (int sub2 = sub1 + length; sub2 <= size - length + 1; sub2++) {
					
					// 두 번째 부분 수열의 합을 계산해 변수 sumSub2에 할당
					long sumSub2 = sequenceSum[sub2 + length - 1] - sequenceSum[sub2 - 1];
					
					// abs() 메서드를 사용해 두 부분 수열의 차이를 변수 difference에 할당
					long difference = Math.abs(sumSub1 - sumSub2);
					
					// 두 부분 수열의 차이가 저장된 최소 차이보다 큰 경우 다음 부분 수열의 조합을 순회
					if (difference > minDifference)
						continue;
					
					// 두 부분 수열의 최소 차이와 그 때 부분수열의 길이를 갱신
					minDifference = difference;
					minLength = length;
				}
			}
		}
		
		// write() 메서드를 사용해 두 부분 수열의 최소 차이와 그 때 부분수열의 길이를 출력
		out.write(minLength + "\n" + minDifference);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}