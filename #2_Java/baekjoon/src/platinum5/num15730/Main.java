package platinum5.num15730;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 땅의 크기, 수영장에 채울 수 있는 물의 양을 나타낼 각 변수 초기화
	static int height;
	static int width;
	static int maxAmount = 0;
	
	// 각 땅의 높이를 저장할 2차원 배열 land 초기화
	static int[][] land;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 땅의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 각 땅의 높이를 저장할 2차원 배열 land 초기화
		land = new int[height + 2][width + 2];
		
		// for 반복문을 사용해 배열 land의 각 행을 순회
		for (int r = 1; r <= height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 땅의 높이를 배열 land에 저장
			for (int c = 1; c <= width; c++)
				land[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// poolMaker() 메서드를 호출해 수영장에 채울 수 있는 물의 양을 갱신
		poolMaker();
		
		// valueOf() 및 write() 메서드를 사용해 수영장에 채울 수 있는 물의 양를 출력
		out.write(String.valueOf(maxAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// poolMaker() 메서드 정의
	public static void poolMaker() {
		
		// 채울 수 있는 물의 높이를 저장할 각 2차원 배열 초기화
		int[][] maxHeight = new int[height + 2][width + 2];
		
		// for 반복문을 사용해 배열 maxHeight의 각 행과 열을 순회하며 최대값으로 초기화
		for (int r = 1; r <= height; r++) {
			for (int c = 1; c <= width; c++)
				maxHeight[r][c] = Integer.MAX_VALUE;
		}
		
		// while 반복문을 사용해 더 이상 채울 수 있는 물의 높이가 갱신되지 않을 때까지 순회
	    while (true) {
	    	
	    	// 물의 높이가 갱신되었는지를 나타낼 변수 canRenew 초기화
	        boolean canRenew = false;
	        
	        // for 반복문을 사용해 배열 maxHeight의 각 행과 열을 순회
	        for (int r = 1; r <= height; r++) {
	            for (int c = 1; c <= width; c++) {
	            	
	            	// 채울 수 있는 물의 높이가 땅의 높이와 같은 경우 다음 위치를 순회
	                if (land[r][c] == maxHeight[r][c])
	                	continue;
	                
	                // 인접한 위치 중 가장 최소로 채울 수 있는 물의 높이를 변수 minHeight에 할당
	                int minHeight = Integer.MAX_VALUE;
	                
	                // for 반복문을 사용해 인접한 위치를 순회
	                for (int d = 0; d < 4; d++) {
	                	
	                	// 인접한 위치의 좌표를 각 변수에 할당
	                    int nr = r + dr[d];
	                    int nc = c + dc[d];
	                    
	                    // min() 메서드를 사용해 인접한 위치 중 가장 최소로 채울 수 있는 물의 높이를 갱신
	                    minHeight = Math.min(maxHeight[nr][nc], minHeight);
	                }
	                
	                // 현재 최대 물의 높이가 최소로 채울 수 있는 물의 높이보다 높은 경우
	                if (maxHeight[r][c] > minHeight) {
	                	
	                	// max() 메서드를 사용해 최대로 채울 수 있는 물의 높이를 갱신
	                	maxHeight[r][c] = Math.max(land[r][c], minHeight);
	                	
	                	// 물의 높이를 갱신하였으므로 canRenew 변수 갱신
	                	canRenew = true;
	                }
	            }
	        }
	        
	        // 더 이상 물의 높이를 갱신할 수 없는 경우 반복문 탈출
	        if (!canRenew)
	        	break;
	    }
		
		// for 반복문을 사용해 배열 maxHeight의 각 행과 열을 순회하며 채울 수 있는 물의 양을 갱신
		for (int r = 1; r <= height; r++) {
			for (int c = 1; c <= width; c++)
				maxAmount += maxHeight[r][c] - land[r][c];
		}
	}
}