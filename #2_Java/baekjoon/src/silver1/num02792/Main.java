package silver1.num02792;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 아이들의 수 및 색상의 수를 각 변수에 할당
		int childNum = Integer.parseInt(st.nextToken());
		int colorNum = Integer.parseInt(st.nextToken());
		
		// 질투심의 최솟값을 찾기 위한 질투심의 범위를 나타낼 각 변수 초기화
		int low = 1;
		int high = 0;
		
		// 보석의 각 색상별 개수를 저장할 배열 gems 초기화
		int[] gems = new int[colorNum];
		
		// for 반복문을 사용해 보석의 각 색상을 순회
		for (int idx = 0; idx < gems.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 보석의 각 색상별 개수를 배열 gems에 저장
			gems[idx] = Integer.parseInt(in.readLine());
			
			// max() 메서드를 사용해 가능한 질투심의 최댓값을 갱신
			high = Math.max(gems[idx], high);
		}
		
		// while 반복문을 사용해 질투심의 최솟값을 찾을 때까지 순회
		while (low < high) {
			
			// 가능한 질투심 범위의 중간값을 계산해 변수 mid에 할당
			int mid = (low + high) / 2;
			
			// 해당 값으로 보석을 나누어 주었을 때 필요한 아이들의 수를 저장할 변수 count 초기화
			long count = 0;
			
			// for 반복문을 사용해 해당 값으로 보석을 나누어 주었을 때 필요한 아이들의 수를 갱신
			for (int idx = 0; idx < gems.length; idx++)
				count = (gems[idx] % mid == 0) ? count + gems[idx] / mid : count + gems[idx] / mid + 1;
			
			// 필요한 아이들의 수가 실제 아이들의 수보다 많은 경우 질투심 범위의 최솟값을 갱신
			if (count > childNum) {
				low = mid + 1;
				
			// 필요한 아이들의 수가 실제 아이들의 수보다 적거나 같은 경우 질투심 범위의 최댓값을 갱신
			} else {
				high = mid;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 질투심의 최솟값을 출력
		out.write(String.valueOf(high));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}