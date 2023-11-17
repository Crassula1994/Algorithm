package bronze1.num14659;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 활잡이의 수를 변수 bowmanNum에 할당
		int bowmanNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 봉우리의 높이를 저장할 배열 mountains 초기화
		int[] mountains = new int[bowmanNum];
		
		// 현재까지 가장 높은 봉우리의 높이, 가장 많이 처치한 적의 숫자, 처치한 적의 숫자를 저장할 각 변수 초기화
		int maxHeight = 0;
		int maxCount = 0;
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 봉우리를 순회
		for (int idx = 0; idx < mountains.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 봉우리의 높이를 mountains에 저장
			mountains[idx] = Integer.parseInt(st.nextToken());
			
			// 현재 봉우리의 높이가 현재까지 가장 높은 봉우리의 높이보다 높은 경우
			if (mountains[idx] > maxHeight) {
				
				// 가장 높은 봉우리를 갱신
				maxHeight = mountains[idx];
				
				// max() 메서드를 사용해 가장 많이 처치한 적의 숫자를 갱신
				maxCount = Math.max(count, maxCount);
				
				// 처치한 적의 숫자를 초기화
				count = 0;
				
			// 현재 봉우리의 높이가 현재까지 가장 높은 봉우리의 높이보다 낮은 경우 처치한 적의 숫자를 갱신
			} else {
				count++;
			}
			
			// 마지막 봉우리인 경우 가장 많이 처치한 적의 숫자를 갱신
			if (idx == bowmanNum - 1)
				maxCount = Math.max(count, maxCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 처치할 수 있는 적의 최대 숫자를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}