package silver1.num02502;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 할머니가 넘어온 날, 호랑이에게 준 떡의 개수를 각 변수에 할당
		int targetDay = Integer.parseInt(st.nextToken());
		int targetCnt = Integer.parseInt(st.nextToken());
		
		// 각 날짜에 준 떡의 개수를 첫째 날과 둘째 날 준 떡의 개수로 나누어 저장할 2차원 배열 counts 초기화
		int[][] counts = new int[targetDay + 1][2];
		
		// 할머니가 넘어온 날이 3일 째인 경우 첫째 날과 둘째 날에 준 떡의 개수를 출력
		if (targetDay == 3) {
			out.write(1 + "\n" + (targetCnt - 1));
			
		// 할머니가 넘어온 날이 4일 이상인 경우
		} else {
			
			// 첫째 날과 둘째 날에 준 떡의 개수를 초기화
			counts[1][0] = 1;
			counts[2][1] = 1;
			
			// for 반복문을 사용해 할머니가 넘어온 날까지 떡의 개수를 갱신
			for (int idx = 3; idx < counts.length; idx++) {
				counts[idx][0] = counts[idx - 1][0] + counts[idx - 2][0];
				counts[idx][1] = counts[idx - 1][1] + counts[idx - 2][1];
			}
			
			// 가능한 둘째 날의 떡의 개수를 순회
			for (int secondCnt = targetCnt / counts[targetDay][1]; secondCnt > 0; secondCnt--) {
				
				// 남은 떡의 개수를 변수 remains에 할당
				int remains = targetCnt - secondCnt * counts[targetDay][1];
				
				// 남은 떡이 없는 경우 다음 개수를 순회
				if (remains == 0)
					continue;
				
				// 첫째 날의 떡의 개수를 만들 수 있는 경우
				if (remains % counts[targetDay][0] == 0) {
					
					// 첫째 날의 떡의 개수를 계산해 변수 firstCnt에 할당
					int firstCnt = remains / counts[targetDay][0];
					
					// write() 메서드를 사용해 첫째 날과 둘째 날의 떡의 개수를 출력
					out.write(firstCnt + "\n" + secondCnt);
					
					// 반복문 탈출
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}