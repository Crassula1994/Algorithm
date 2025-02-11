package gold5.num03019;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 블록별 떨어뜨리는 방법을 저장할 Map 객체 blocks 초기화
	static Map<Integer, int[][]> blocks = new HashMap<>();
	
	// put() 메서드를 사용해 각 블록별 떨어뜨리는 방법을 blocks에 저장
	static {
		blocks.put(1, new int[][] {{0}, {0, 0, 0, 0}});
		blocks.put(2, new int[][] {{0, 0}});
		blocks.put(3, new int[][] {{1, 0}, {0, 0, 1}});
		blocks.put(4, new int[][] {{0, 1}, {1, 0, 0}});
		blocks.put(5, new int[][] {{1, 0}, {0, 0, 0}, {0, 1}, {1, 0, 1}});
		blocks.put(6, new int[][] {{2, 0}, {0, 0, 0}, {0, 0}, {0, 1, 1}});
		blocks.put(7, new int[][] {{0, 2}, {0, 0, 0}, {0, 0}, {1, 1, 0}});
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 필드의 열의 수 및 떨어뜨려야 하는 블록의 번호를 각 변수에 할당
		int columnNum = Integer.parseInt(st.nextToken());
		int blockNum = Integer.parseInt(st.nextToken());
		
		// 블록을 떨어뜨리는 방법의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 필드의 각 칸의 높이를 저장할 배열 heights 초기화
		int[] heights = new int[columnNum];
		
		// get() 메서드를 사용해 해당 블록의 떨어뜨리는 방법을 2차원 배열 methods에 할당
		int[][] methods = blocks.get(blockNum);
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 필드의 각 칸의 높이를 배열 heights에 저장
		for (int idx = 0; idx < heights.length; idx++)
			heights[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 방법을 순회
		for (int[] method : methods) {
			
			// 해당 방법을 적용하기 위한 칸의 개수를 변수 length에 할당
			int length = method.length;
			
			// for 반복문을 사용해 각 시작 칸을 순회
			for (int idx = 0; idx < columnNum - length + 1; idx++) {
				
				// 해당 방법을 적용하기 위한 기본 높이, 해당 방법으로 떨어뜨리는 게 가능한지 여부를 저장할 각 변수를 초기화
				int baseHeight = heights[idx] - method[0];
				boolean isPossible = true;
				
				// for 반복문을 사용해 해당 방법을 적용할 각 칸을 순회
				for (int cell = idx; cell < idx + length; cell++) {
					
					// 해당 칸의 높이에 해당 방법을 적용할 수 없는 경우 해당 방법으로 떨어뜨리는 게 가능한지 여부를 갱신 후 반복문 탈출
					if (baseHeight + method[cell - idx] != heights[cell]) {
						isPossible = false;
						break;
					}
				}
			
				// 해당 방법으로 떨어뜨리는 게 가능한 경우 블록을 떨어뜨리는 방법의 수를 갱신
				if (isPossible)
					count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 블록을 떨어뜨리는 방법의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}