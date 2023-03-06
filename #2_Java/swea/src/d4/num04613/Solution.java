package d4.num04613;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// 국기의 행과 열 수를 나타내는 각 변수 초기화
	static int height;
	static int width;

    // 국기의 색상을 저장할 2차원 배열 flag 초기화
    static char[][] flag;

	// 새로 칠해야 하는 칸의 개수를 저장할 PriorityQueue 객체 minHeap 초기화
    static PriorityQueue<Integer> minHeap;

    // ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for(int tc = 1; tc <= testCase; tc++) {

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 국기의 행과 열 수를 각 변수에 할당
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());

			// 국기의 색상을 저장할 2차원 배열 flag 초기화
			flag = new char[height][width];

			// 새로 칠해야 하는 칸의 개수를 저장할 PriorityQueue 객체 minHeap 초기화
			minHeap = new PriorityQueue<>();
        	
			// for 반복문을 사용해 배열 flag의 각 행을 순회
			for (int r = 0; r < height; r++) {

				// readLine() 메서드를 사용해 입력 받은 국기의 각 행을 변수 line에 할당
				String line = in.readLine();

				// for 반복문을 사용해 배열 flag의 각 열을 순회하며 각 색상을 저장
				for(int c = 0; c < width; c++)
					flag[r][c] = line.charAt(c);
			}

			// flagMaker() 메서드를 호출해 모든 경우의 수를 minHeap에 저장
			flagMaker('W', 0, 0);
            
			// poll() 메서드를 사용해 새로 칠해야 하는 칸의 최솟값을 변수 minCnt에 할당
			int minCnt = minHeap.poll();

			// write() 메서드를 사용해 새로 칠해야 하는 칸의 최솟값을 출력
			out.write("#" + tc + " " + minCnt + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// flagMaker() 메서드 정의
	public static void flagMaker(char color, int line, int sum) {
    
		// 새로 칠해야 하는 칸의 개수를 저장할 변수 count 초기화
		int count = sum;
	    
		// for 반복문을 사용해 해당 행의 각 색상을 순회
		for (int c = 0; c < width; c++) {
	    	
			// 해당 행의 색상이 칠해야 하는 색과 다른 경우 새로 칠해야 하는 칸의 개수 갱신
			if (flag[line][c] != color)
				count++;
		}
	    
		// 해당 행이 마지막 행인 경우 minHeap에 새로 칠해야 하는 칸의 개수 저장 후 메서드 종료
		if (line == height - 1) {
			minHeap.offer(count);
			return;
		}
	    
		// 해당 행의 색상이 흰색이고 마지막에서 세 번째 행 이하인 경우
		if (color == 'W' && line < height - 3) {
	    
			// 다음 행을 흰색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('W', line + 1, count);
	    	
			// 다음 행을 파란색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('B', line + 1, count);
	    	
		// 해당 행의 색상이 흰색이고 마지막에서 세 번째 행인 경우
		} else if (color == 'W' && line == height - 3) {
	    	
			// 다음 행을 파란색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('B', line + 1, count);
	    	
		// 해당 행의 색상이 파란색이고 마지막에서 두 번째 행 이하인 경우
		} else if (color == 'B' && line < height - 2) {
    
			// 다음 행을 파란색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('B', line + 1, count);
	    	
			// 다음 행을 붉은색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('R', line + 1, count);
	    
		// 해당 행의 색상이 파란색이고 마지막에서 두 번째 행인 경우
		} else if (color == 'B' && line == height - 2) {
	    	
			// 다음 행을 붉은색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('R', line + 1, count);

		// 해당 행의 색상이 붉은색인 경우
		} else {
	    	
			// 다음 행을 붉은색으로 칠했을 때를 가정하여 flagMaker() 메서드 재귀 호출
			flagMaker('R', line + 1, count);
		}
	}
}