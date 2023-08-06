package gold4.num16234;

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
	
	// 땅의 크기, 인구 차이의 하한 및 상한, 인구 이동이 발생하는 일수, 인구 이동이 있는지 여부를 나타낼 각 변수 초기화
	static int size;
	static int lowerBound;
	static int upperBound;
	static int dayCount = -1;
	static boolean isMoved = true;
	
	// 인접한 위치를 나타내는 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 입력 받은 인구의 상태 및 연합 형성 여부를 저장할 각 2차원 배열 초기화
	static int[][] population;
	static boolean[][] united;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 땅의 크기 및 인구 차이의 하한 및 상한을 각 변수에 할당
		size = Integer.parseInt(st.nextToken());
		lowerBound = Integer.parseInt(st.nextToken());
		upperBound = Integer.parseInt(st.nextToken());
		
		// 입력 받은 인구의 상태를 저장할 2차원 배열 population 초기화
		population = new int[size][size];
		
		// for 반복문을 사용해 땅의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 인구의 상태를 배열 population에 저장
			for (int c = 0; c < size; c++)
				population[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// while 반복문을 사용해 더 이상 인구 이동이 없을 때까지 순회
		while (isMoved) {
			
			// 인구 이동이 발생하는 일수 갱신
			dayCount++;
			
			// 인구 이동이 있는지 여부를 초기화
			isMoved = false;
			
			// 각 나라의 연합 형성 여부를 저장할 2차원 배열 united 초기화
			united = new boolean[size][size];
			
			// for 반복문을 사용해 각 나라를 순회
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					
					// 해당 나라가 아직 연합을 형성하지 않은 경우 populationRenewer 메서드 호출
					if (!united[r][c])
						populationRenewer(r, c);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 인구 이동이 발생하는 일수를 출력
		out.write(String.valueOf(dayCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// populationRenewer() 메서드 정의
	public static void populationRenewer(int startRow, int startCol) {
		
		// 연합의 인구 수를 저장할 변수 totalPop 초기화
		int totalPop = population[startRow][startCol];
		
		// 다음에 연합할 위치, 연합이 형성된 국가를 각각 저장할 Queue 객체 초기화
		Queue<int[]> uniteList = new LinkedList<>();
		Queue<int[]> union = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 각 Queue에 추가 및 연합 형성 처리
		uniteList.offer(new int[] {startRow, startCol});
		union.offer(new int[] {startRow, startCol});
		united[startRow][startCol] = true;
		
		// while 반복문을 사용해 uniteList가 빌 때까지 순회
		while (!uniteList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 국가를 배열 currentNation에 할당
			int[] currentNation = uniteList.poll();
			
			// for 반복문을 사용해 해당 국가와 인접한 국가를 순회
			for (int d = 0; d < 4; d++) {
				
				// 해당 국가와 인접한 국가의 위치를 각 변수에 할당
				int nr = currentNation[0] + dr[d];
				int nc = currentNation[1] + dc[d];
				
				// 해당 국가가 땅의 범위를 벗어났거나 이미 연합을 형성했던 경우 다음 국가를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size || united[nr][nc])
					continue;
				
				// abs() 메서드를 사용해 인접한 국가와 현재 국가의 인구 차이를 계산해 변수 difference에 할당
				int difference = Math.abs(population[currentNation[0]][currentNation[1]] - population[nr][nc]);
				
				// 두 나라의 인구 차이가 상한과 하한 사이에 있는 경우
				if (difference >= lowerBound && difference <= upperBound) {
					
					// 연합의 인구 수 및 연합에 속한 국가의 수를 갱신
					totalPop += population[nr][nc];
					
					// offer() 메서드를 사용해 시작 위치를 각 Queue에 추가 및 연합 형성 처리
					uniteList.offer(new int[] {nr, nc});
					union.offer(new int[] {nr, nc});
					united[nr][nc] = true;
				}
			}
		}
		
		// 연합에 속한 국가가 2개 이상인 경우
		if (union.size() > 1) {
			
			// 인구 이동이 있는지 여부를 갱신
			isMoved = true;
			
			// size() 메서드를 사용해 각 연합에 속한 국가의 인구 수를 계산해 변수 unionPop에 할당
			int unionPop = totalPop / union.size();
			
			// while 반복문을 사용해 union이 빌 때까지 순회
			while (!union.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 확인 중인 국가를 배열 currentNation에 할당
				int[] currentNation = union.poll();
				
				// 해당 국가의 인구를 갱신
				population[currentNation[0]][currentNation[1]] = unionPop;
			}
		}
	}
}