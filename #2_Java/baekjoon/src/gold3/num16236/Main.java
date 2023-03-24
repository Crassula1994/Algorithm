package gold3.num16236;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 공간의 크기 및 아기 상어가 스스로 물고기를 잡아먹을 수 있는 시간을 저장할 각 변수 초기화
	static int size;
	static int maxTime = 0;
	
	// 공간의 상태를 저장할 배열 map 초기화
	static int[][] map;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 공간의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 공간의 상태를 저장할 배열 map 초기화
		map = new int[size][size];
		
		// 아기 상어의 위치를 저장할 배열 startLoc 초기화
		int[] startLoc = new int[2];
		
		// for 반복문을 사용해 배열 map의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 map의 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 공간의 상태를 변수 map에 저장
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 값이 아기 상어의 위치인 경우 이를 배열 startLoc에 저장
				if (map[r][c] == 9) {
					startLoc[0] = r;
					startLoc[1] = c;
				}
			}
		}
			
		// fishCatcher() 메서드를 호출해 아기 상어가 스스로 물고기를 잡아먹을 수 있는 시간을 변수 maxTime에 갱신
		fishCatcher(startLoc, 0, 2);
			
		// valueOf() 및 write() 메서드를 사용해 아기 상어가 스스로 물고기를 잡아먹을 수 있는 시간을 출력
		out.write(String.valueOf(maxTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// fishCatcher() 메서드 정의 
	public static void fishCatcher(int[] startLoc, int fishEaten, int sharkSize) {
		
		// 해당 위치의 방문 여부를 저장할 2차원 배열 visited 초기화
		boolean[][] visited = new boolean[size][size];
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<int[]> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 입력 받은 시작 위치를 visitList에 추가 및 방문 처리
		visitList.offer(startLoc);
		visited[startLoc[0]][startLoc[1]] = true;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 계산할 값을 변수 currentLoc에 할당
			int[] currentLoc = visitList.poll();
			
			// 해당 값이 최종 결과와 동일한 경우 반복문 탈출
			if (currentVal == finalVal)
				break;

			// 각 명령어를 수행한 결과를 각 변수에 할당
			int resultD = (2 * currentVal) % 10000;
			int resultS = (currentVal == 0) ? 9999 : currentVal - 1;
			int resultL = (currentVal % 1000) * 10 + currentVal / 1000;
			int resultR = (currentVal / 10) + (currentVal % 10) * 1000;
			
			// 'D' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultD] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultD);
				calculated[resultD] = calculated[currentVal] + "D";
			}
			
			// 'S' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultS] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultS);
				calculated[resultS] = calculated[currentVal] + "S";
			}
			
			// 'L' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultL] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultL);
				calculated[resultL] = calculated[currentVal] + "L";
			}
			
			// 'R' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultR] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultR);
				calculated[resultR] = calculated[currentVal] + "R";
			}
		}
	}
}