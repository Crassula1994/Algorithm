package silver1.num31739;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 격자판의 세로 및 가로 크기, 모기의 수, 우정이의 체력, 우정이와 아름이가 잡을 수 있는 최대 모기 수를 각 변수에 할당
	static int height;
	static int width;
	static int mosquitoNum;
	static int strength;
	static int maxCountA = 0;
	static int maxCountB = 0;
	
	// 각 모기의 제거 여부를 나타낼 배열 killed 초기화
	static boolean[] killed;
	
	// 모기의 정보가 저장된 격자판을 나타낼 2차원 배열 grid 초기화 
	static List<Integer>[][] grid;
	
	// 모기가 존재하는 위치를 저장할 Map 객체 mosquitos 초기화
	static Map<Integer, Location> mosquitos = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Location 클래스 정의
	public static class Location {
		
		// 각 좌표를 나타낼 각 변수 초기화
		int row;
		int column;
		
		// 매개변수를 입력 받는 생성자 정의
		public Location(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 격자판의 세로 및 가로 크기, 모기의 수, 우정이의 체력,
		아름이가 형성하는 전기장의 세기를 각 변수에 할당 */
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		mosquitoNum = Integer.parseInt(st.nextToken());
		strength = Integer.parseInt(st.nextToken());
		int intensity = Integer.parseInt(st.nextToken());
		
		// 모기의 정보가 저장된 격자판을 나타낼 2차원 배열 grid 초기화
		grid = new ArrayList[height + 1][width + 1];
		
		// for 반복문을 사용해 각 위치에 있는 모기의 정보를 저장할 List 객체 초기화
		for (int r = 0; r <= height; r++) {
			for (int c = 0; c <= width; c++)
				grid[r][c] = new ArrayList<>();
		}
		
		// for 반복문을 사용해 입력 받은 각 모기의 정보를 순회
		for (int mosquito = 0, number = 0; mosquito < mosquitoNum; mosquito++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 모기의 정보를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			int stamina = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 모기의 위치와 그 체력을 2차원 배열 grid에 저장
			grid[row][column].add(stamina);
			
			// 모기가 존재하는 경우 mosquitos에 그 위치를 저장
			if (grid[row][column].size() == 1)
				mosquitos.put(number++, new Location(row, column));
		}
		
		// size() 메서드를 사용해 각 모기의 제거 여부를 나타낼 배열 killed 초기화
		killed = new boolean[mosquitos.size()];
		
		// for 반복문을 사용해 모기가 있는 위치를 순회
		for (int number = 0; number < mosquitos.size(); number++) {
			
			// 모든 모기를 잡을 수 있는 경우 반복문 탈출
			if (maxCountA == mosquitoNum)
				break;
			
			// mosquitoKiller() 메서드를 호출해 우정이가 잡을 수 있는 최대 모기 수를 갱신
			mosquitoKiller(number, grid[mosquitos.get(number).row][mosquitos.get(number).column].size(), 0);
		}
		
		// for 반복문을 사용해 격자판의 각 위치를 순회
		for (int r = 1; r <= height; r++) {
			for (int c = 1; c <= width; c++) {
			
				// 해당 위치에서 전기장을 형성했을 때 아름이가 잡는 모기의 수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 각 모기의 위치를 순회
				for (int number = 0; number < mosquitos.size(); number++) {
					
					// get(), abs() 메서드를 사용해 해당 위치까지의 거리를 계산하고 변수 distance에 할당
					int distance = Math.abs(mosquitos.get(number).row - r) + Math.abs(mosquitos.get(number).column - c);
					
					// for 반복문을 사용해 해당 위치의 각 모기를 순회
					for (int stamina : grid[mosquitos.get(number).row][mosquitos.get(number).column]) {
						
						// 해당 모기를 잡을 수 있는 경우 아름이가 잡는 모기의 수를 갱신
						if (intensity >= distance * stamina)
							count++;
					}
				}
				
				// max() 메서드를 사용해 아름이가 잡을 수 있는 최대 모기 수를 갱신
				maxCountB = Math.max(count, maxCountB);
			}
		}
		
		// write() 메서드를 사용해 우정이와 아름이가 잡을 수 있는 최대 모기 수를 출력
		out.write(maxCountA + " " + maxCountB);
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// mosquitoKiller() 메서드 정의
	public static void mosquitoKiller(int curLoc, int killCount, int time) {
		
		// 이동 시간이 우정이의 체력을 초과하는 경우 메서드 종료
		if (time > strength)
			return;
		
		// max() 메서드를 사용해 우정이가 잡을 수 있는 최대 모기 수를 갱신
		maxCountA = Math.max(killCount, maxCountA);
		
		// 현재 위치의 모기를 잡은 것으로 처리
		killed[curLoc] = true;
		
		// for 반복문을 사용해 각 모기의 위치를 순회
		for (int nextLoc = 0; nextLoc < mosquitos.size(); nextLoc++) {
			
			// 해당 모기를 이미 잡은 경우 다음 모기를 순회
			if (killed[nextLoc])
				continue;
			
			// get(), size(), abs() 메서드를 사용해 다음 위치까지의 거리와 잡을 모기의 수를 계산하고 각 변수에 할당
			int count = grid[mosquitos.get(nextLoc).row][mosquitos.get(nextLoc).column].size();
			int distance = Math.abs(mosquitos.get(curLoc).row - mosquitos.get(nextLoc).row)
					+ Math.abs(mosquitos.get(curLoc).column - mosquitos.get(nextLoc).column);
						
			// mosquitoKiller() 메서드 재귀 호출
			mosquitoKiller(nextLoc, killCount + count, time + distance);
		}
		
		// 현재 위치의 모기를 잡지 않은 것으로 원상 복구
		killed[curLoc] = false;
	}
}