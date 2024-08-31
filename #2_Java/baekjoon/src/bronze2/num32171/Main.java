package bronze2.num32171;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 건설하고자 하는 건물의 수를 변수 buildingNum에 할당
		int buildingNum = Integer.parseInt(in.readLine());
		
		// 설치할 울타리의 각 위치를 저장할 배열 location 초기화
		int[] location = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		
		// for 반복문을 사용해 각 건물을 순회
		for (int building = 0; building < buildingNum; building++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 건물의 각 꼭짓점의 좌표를 순회
			for (int idx = 0; idx < 4; idx++) {
				
				// nextToken(), parseInt(), min(), max() 메서드를 사용해 울타리의 위치를 갱신
				location[idx] = (idx < 2)
						? Math.min(Integer.parseInt(st.nextToken()), location[idx])
						: Math.max(Integer.parseInt(st.nextToken()), location[idx]);
			}
			
			// 울타리 공사 시에 드는 비용을 계산해 변수 cost에 할당
			int cost = (location[2] - location[0] + location[3] - location[1]) * 2;
			
			// write() 메서드를 사용해 울타리 공사 시에 드는 비용을 출력
			out.write(cost + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}