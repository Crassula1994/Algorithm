package gold3.num14890;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도의 크기와 경사로의 길이를 저장할 각 변수 초기화
	static int size;
	static int length;
	
	// 각 칸의 높이를 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기와 경사로의 길이를 각 변수에 할당
		size = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());
		
		// 지나갈 수 있는 길의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 칸의 높이를 저장할 2차원 배열 map 초기화
		map = new int[size][size];
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸의 높이를 2차원 배열 map에 저장
			for (int c = 0; c < size; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 지나갈 수 있는 길의 개수를 갱신
		for (int idx = 0; idx < size; idx++) {
			count = (roadChecker(idx, true)) ? count + 1 : count;
			count = (roadChecker(idx, false)) ? count + 1 : count;
		}
		
		// valueOf() 및 write() 메서드를 사용해 지나갈 수 있는 길의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// roadChecker() 메서드 정의
	public static boolean roadChecker(int order, boolean isRow) {
		
		// 각 길의 높이와 경사로 설치 여부를 저장할 각 배열 초기화
		int[] heights = new int[size];
		boolean[] installed = new boolean[size];
		
		// for 반복문을 사용해 각 길의 높이를 갱신
		for (int idx = 0; idx < heights.length; idx++)
			heights[idx] = (isRow) ? map[order][idx] : map[idx][order];
		
		// for 반복문을 사용해 각 칸을 순회
		for (int idx = 0; idx < heights.length; idx++) {
			
			// 첫 칸이거나 이전 칸의 높이와 같은 경우 다음 칸을 순회
			if (idx == 0 || heights[idx] == heights[idx - 1])
				continue;
			
			// 해당 칸의 높이가 이전 칸의 높이와 2 이상 차이가 나는 경우 false 반환
			if (Math.abs(heights[idx] - heights[idx - 1]) > 1)
				return false;
			
			// 높이가 더 낮아진 경우
			if (heights[idx] < heights[idx - 1]) {
				
				// 경사로가 지도의 범위를 벗어나 설치할 수 없는 경우 false 반환
				if (idx + length - 1 >= size)
					return false;
				
				// for 반복문을 사용해 경사로가 설치될 곳을 순회
				for (int ramp = idx; ramp < idx + length; ramp++) {
					
					// 해당 위치에 이미 경사로가 설치되어 있는 경우 false 반환
					if (installed[ramp])
						return false;
					
					// 경사로가 설치될 곳의 높이가 다른 경우 false 반환
					if (heights[ramp] != heights[idx])
						return false;
					
					// 경사로를 설치
					installed[ramp] = true;
				}
				
			// 높이가 더 높아진 경우
			} else {
				
				// 경사로가 지도의 범위를 벗어나 설치할 수 없는 경우 false 반환
				if (idx - length < 0)
					return false;
				
				// for 반복문을 사용해 경사로가 설치될 곳을 순회
				for (int ramp = idx - 1; ramp >= idx - length; ramp--) {
					
					// 해당 위치에 이미 경사로가 설치되어 있는 경우 false 반환
					if (installed[ramp])
						return false;
					
					// 경사로가 설치될 곳의 높이가 다른 경우 false 반환
					if (heights[ramp] != heights[idx - 1])
						return false;
					
					// 경사로를 설치
					installed[ramp] = true;
				}
			}
		}
				
		// 해당 길을 지나갈 수 있는 경우 true 반환
		return true;
	}
}