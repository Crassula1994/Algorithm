package gold2.num32957;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 순열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// min(i, A[i])의 최댓값, max(i, A[i])의 최솟값, 얻을 수 있는 순열의 최대 가치를 저장할 각 변수 초기화
		int maxDiff = 0;
		int minDiff = Integer.MAX_VALUE;
		long maxValue = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 순열의 원소를 순회
		for (int idx = 1; idx <= length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 순열의 원소를 변수 element에 할당
			int element = Integer.parseInt(st.nextToken());
			
			// min() 및 max() 메서드를 사용해 min(i, A[i])의 최댓값, max(i, A[i])의 최솟값을 갱신
			maxDiff = Math.max(Math.min(idx, element), maxDiff);
			minDiff = Math.min(Math.max(idx, element), minDiff);
			
			// abs() 메서드를 사용해 얻을 수 있는 순열의 최대 가치 갱신 
			maxValue += Math.abs(element - idx);
		}
		
		// max() 메서드를 사용해 두 원소를 교환했을 때 얻을 수 있는 순열의 최대 가치 갱신
		maxValue += 2 * Math.max(0, maxDiff - minDiff);
		
		// valueOf() 및 write() 메서드를 사용해 얻을 수 있는 순열의 최대 가치를 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}