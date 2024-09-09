package gold3.num24337;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 건물의 개수, 가희와 단비가 볼 수 있는 건물의 개수를 각 변수에 할당
		int buildingNum = Integer.parseInt(st.nextToken());
		int gahuiCnt = Integer.parseInt(st.nextToken());
		int danbiCnt = Integer.parseInt(st.nextToken());
		
		// 가희와 단비가 볼 수 있는 각 건물의 개수에 맞는 건물 높이 설정이 불가능한 경우 -1을 출력
		if (gahuiCnt + danbiCnt > buildingNum + 1) {
			out.write(String.valueOf(-1));
			
		// 가희와 단비가 볼 수 있는 각 건물의 개수에 맞는 건물 높이 설정이 가능한 경우
		} else {
			
			// 보이지 않는 건물의 수 및 가희와 단비가 모두 볼 수 있는 건물의 위치를 나타낼 각 변수 초기화
			int unvisibleCnt = buildingNum - gahuiCnt - danbiCnt + 1;
			int limit = (gahuiCnt >= danbiCnt) ? gahuiCnt : gahuiCnt - 1;
		
			// 각 건물의 높이를 저장할 배열 heights 초기화
			int[] heights = new int[gahuiCnt + danbiCnt - 1];

			// for 반복문을 사용해 가희가 볼 수 있는 건물의 높이를 배열 heights에 저장
			for (int idx = 0, height = 1; idx < limit; idx++)
				heights[idx] = height++;
			
			// for 반복문을 사용해 단비가 볼 수 있는 건물의 높이를 배열 heights에 저장
			for (int idx = heights.length - 1, height = 1; idx >= limit; idx--)
				heights[idx] = height++;
			
			// for 반복문을 사용해 각 건물의 높이를 순회
			for (int idx = 0; idx < heights.length; idx++) {
				
				// 보이지 않는 건물을 출력해야 하는 경우
				if ((gahuiCnt > 1 && idx == 0) || (gahuiCnt == 1 && idx == 1) || heights.length == 1) {
					
					// while 반복문을 사용해 보이지 않는 건물을 출력
					while (unvisibleCnt-- > 0)
						out.write(1 + " ");
				}
				
				// write() 메서드를 사용해 각 건물의 높이를 출력
				out.write(heights[idx] + " ");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}