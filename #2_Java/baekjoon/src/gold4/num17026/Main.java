package gold4.num17026;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 산봉우리의 개수를 변수 peakNum에 할당
		int peakNum = Integer.parseInt(in.readLine());
		
		// 베시가 구분할 수 있는 산의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 산봉우리의 밑변을 저장할 2차원 배열 peaks 초기화
		int[][] peaks = new int[peakNum][2];
		
		// for 반복문을 사용해 각 산봉우리를 순회
		for (int idx = 0; idx < peaks.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 산봉우리의 좌표를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// 각 산봉우리의 밑변을 2차원 배열 peaks에 저장
			peaks[idx][0] = coordinateX - coordinateY;
			peaks[idx][1] = coordinateX + coordinateY;
		}
		
		// sort() 메서드를 사용해 각 산봉우리의 밑변을 시작 위치를 기준으로 오름차순, 끝 위치를 기준으로 내림차순으로 정렬
		Arrays.sort(peaks, (p1, p2) -> {
			return (p1[0] == p2[0]) ? p2[1] - p1[1] : p1[0] - p2[0];
		});
		
		// for 반복문을 사용해 각 산봉우리를 순회
		for (int idx = 0, prevEnd = -1; idx < peaks.length; idx++) {
			
			// 현재 산이 이전 산에 포함되어 베시가 구분할 수 없는 경우 다음 산봉우리를 순회
			if (peaks[idx][1] <= prevEnd)
				continue;
			
			// 베시가 구분할 수 있는 산의 개수 및 이전 산의 끝 위치를 갱신
			count++;
			prevEnd = peaks[idx][1];
		}
		
		// valueOf() 및 write() 메서드를 사용해 베시가 구분할 수 있는 산의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}