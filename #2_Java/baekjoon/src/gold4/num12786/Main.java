package gold4.num12786;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 나무의 개수 및 T기능의 제한 횟수를 각 변수에 할당
		int treeNum = Integer.parseInt(in.readLine());
		int limitT = Integer.parseInt(in.readLine());
		
		// 규환이가 마지막 나무까지 통과할 때 필요한 최소 T기능 사용횟수를 저장할 변수 minCount 초기화
		int minCount = Integer.MAX_VALUE;
		
		// 각 나무에 뚫린 구멍의 위치 및 해당 위치에서 T기능 사용횟수를 저장할 각 2차원 배열 초기화
		boolean[][] holes = new boolean[treeNum + 1][21];
		int[][] minCounts = new int[treeNum + 1][21];
		
		// for 반복문을 사용해 각 나무를 순회
		for (int idx = 1; idx <= treeNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구멍의 개수를 변수 holeNum에 할당
			int holeNum = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 각 구멍의 위치를 2차원 배열 holes에 저장
			while (holeNum-- > 0)
				holes[idx][Integer.parseInt(st.nextToken())] = true;
		}
		
		// for 반복문을 사용해 각 위치에서 최소 T기능 사용횟수를 초기화
		for (int r = 0; r <= treeNum; r++)
			Arrays.fill(minCounts[r], Integer.MAX_VALUE);
		
		// 시작 위치 및 시작 위치에서의 최소 T기능 사용횟수를 각 2차원 배열에 초기화
		holes[0][1] = true;
		minCounts[0][1] = 0;
		
		// for 반복문을 사용해 각 나무를 순회
		for (int tree = 0; tree < treeNum; tree++) {
			
			// for 반복문을 사용해 각 나무의 높이를 순회
			for (int height = 1; height <= 20; height++) {
				
				// 해당 위치에 구멍이 존재하지 않는 경우 다음 위치를 순회
				if (!holes[tree][height])
					continue;
				
				// O기능을 사용할 수 있는 경우 이동할 위치에서 최소 T기능 사용횟수를 갱신
				if (holes[tree + 1][height])
					minCounts[tree + 1][height]
							= Math.min(minCounts[tree][height], minCounts[tree + 1][height]);
				
				// A기능을 사용할 수 있는 경우 이동할 위치에서 최소 T기능 사용횟수를 갱신
				if (height < 20 && holes[tree + 1][height + 1])
					minCounts[tree + 1][height + 1]
							= Math.min(minCounts[tree][height], minCounts[tree + 1][height + 1]);
				
				// B기능을 사용할 수 있는 경우 이동할 위치에서 최소 T기능 사용횟수를 갱신
				if (holes[tree + 1][Math.min(2 * height, 20)])
					minCounts[tree + 1][Math.min(2 * height, 20)]
							= Math.min(minCounts[tree][height], minCounts[tree + 1][Math.min(2 * height, 20)]);
				
				// C기능을 사용할 수 있는 경우 이동할 위치에서 최소 T기능 사용횟수를 갱신
				if (height > 1 && holes[tree + 1][height - 1])
					minCounts[tree + 1][height - 1]
							= Math.min(minCounts[tree][height], minCounts[tree + 1][height - 1]);
				
				// T기능을 사용할 수 있는 경우
				if (minCounts[tree][height] < limitT) {
					
					// for 반복문을 사용해 다음 나무에 위치한 각 구멍을 순회
					for (int nextHeight = 1; nextHeight <= 20; nextHeight++) {
						
						// 해당 위치에 구멍이 존재하지 않는 경우 다음 위치를 순회
						if (!holes[tree + 1][nextHeight])
							continue;
						
						// 해당 위치에서 최소 T기능 사용횟수를 갱신
						minCounts[tree + 1][nextHeight]
								= Math.min(minCounts[tree][height] + 1, minCounts[tree + 1][nextHeight]);
					}
				}
			}
		}
		
		// for 반복문을 사용해 규환이가 마지막 나무까지 통과할 때 필요한 최소 T기능 사용횟수를 갱신
		for (int height = 1; height <= 20; height++)
			minCount = Math.min(minCounts[treeNum][height], minCount);
		
		// valueOf() 및 write() 메서드를 사용해 규환이가 마지막 나무까지 통과할 때 필요한 최소 T기능 사용횟수를 출력
		out.write((minCount == Integer.MAX_VALUE) ? String.valueOf(-1) : String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}