package silver3.num04923;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 격자의 인접한 위치를 저장할 Map 객체 grid 초기화
	static Map<Integer, List<Integer>> grid = new HashMap<>();
	static int[][] locations = {
		{2, 9}, {1, 3}, {2, 4, 11}, {3, 5}, {4, 6, 13}, {5, 7}, {6, 15}, {9, 18}, {1, 8, 10}, {9, 11, 20},
		{3, 10, 12}, {11, 13, 22}, {5, 12, 14}, {13, 15, 24}, {7, 14, 16}, {15, 26}, {18, 28}, {8, 17, 19},
		{18, 20, 30}, {10, 19, 21}, {20, 22, 32}, {12, 21, 23}, {22, 24, 34}, {14, 23, 25}, {24, 26, 36},
		{16, 25, 27}, {26, 38}, {17, 29}, {28, 30, 39}, {19, 29, 31}, {30, 32, 41}, {21, 31, 33}, {32, 34, 43},
		{23, 33, 35}, {34, 36, 45}, {25, 35, 37}, {36, 38, 47}, {27, 37}, {29, 40}, {39, 41, 48}, {31, 40, 42},
		{41, 43, 50}, {33, 42, 44}, {43, 45, 52}, {35, 44, 46}, {45, 47, 54}, {37, 46}, {40, 49}, {48, 50},
		{42, 49, 51}, {50, 52}, {44, 51, 53}, {52, 54}, {46, 53}
	};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// for 반복문을 사용해 각 격자의 위치를 순회
		for (int idx = 0; idx < locations.length; idx++) {
			
			// put() 메서드를 사용해 해당 격자의 번호를 grid에 추가
			grid.put(idx + 1, new ArrayList<>());
			
			// for 반복문을 사용해 해당 격자에 인접한 위치를 grid에 저장
			for (int adjLoc : locations[idx])
				grid.get(idx + 1).add(adjLoc);
		}
		
		// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 0이 입력된 경우 반복문 탈출
			if (st.countTokens() == 1)
				break;
			
			// 첫 번째 플레이어가 두 번째 플레이어의 피라미드를 가둘 수 있는지 여부를 저장할 변수 isTrapped 초기화
			boolean isTrapped = false;
			
			// 각 플레이어의 피라미드 위치를 저장할 각 배열 초기화
			int[] pyramidsF = new int[6];
			int[] pyramidsS = new int[6];
			
			// 현재 피라미드가 놓여 있는 위치를 저장할 Set 객체 occupied 초기화
			Set<Integer> occupied = new HashSet<>();
			
			// for 반복문을 사용해 첫 번째 플레이어의 피라미드 위치를 순회
			for (int idx = 0; idx < pyramidsF.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 피라미드 위치를 배열 pyramidsF에 저장
				pyramidsF[idx] = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 현재 피라미드가 놓인 위치를 occupied에 추가
				occupied.add(pyramidsF[idx]);
			}
				
			// for 반복문을 사용해 두 번째 플레이어의 피라미드 위치를 순회
			for (int idx = 0; idx < pyramidsS.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 피라미드 위치를 배열 pyramidsS에 저장
				pyramidsS[idx] = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 현재 피라미드가 놓인 위치를 occupied에 추가
				occupied.add(pyramidsS[idx]);
			}
			
			// for 반복문을 사용해 첫 번째 플레이어의 각 피라미드를 순회
			outer: for (int pyramidF : pyramidsF) {
				
				// for 반복문을 사용해 해당 피라미드를 이동할 수 있는 위치를 순회
				for (int nextLocF : grid.get(pyramidF)) {
					
					// 해당 위치에 이미 피라미드가 존재해 이동할 수 없는 경우 다음 위치를 순회
					if (occupied.contains(nextLocF))
						continue;
					
					// 첫 번째 플레이어가 피라미드를 이동시킨 후 피라미드가 놓인 위치를 저장할 Set 객체 newOccupied 초기화
					Set<Integer> newOccupied = new HashSet<>(occupied);
					
					// remove() 및 add() 메서드를 사용해 첫 번째 플레이어가 이동시킨 피라미드의 위치를 newOccupied에 저장
					newOccupied.remove(pyramidF);
					newOccupied.add(nextLocF);
					
					// for 반복문을 사용해 두 번째 플레이어의 피라미드를 순회
					for (int pyramidS : pyramidsS) {
						
						// 모든 위치가 점유되었는지 여부를 나타낼 변수 allOccupied 초기화
						boolean allOccupied = true;
						
						// for 반복문을 사용해 해당 피라미드를 이동할 수 있는 위치를 순회
						for (int nextLocS : grid.get(pyramidS)) {
							
							// 해당 위치가 점유되지 않은 경우 모든 위치가 점유되었는지 여부를 갱신 후 반복문 탈출
							if (!newOccupied.contains(nextLocS)) {
								allOccupied = false;
								break;
							}
						}
						
						// 모든 위치가 점유된 경우 첫 번째 플레이어가 두 번째 플레이어의 피라미드를 가둘 수 있는지 여부를 갱신 후 반복문 탈출
						if (allOccupied) {
							isTrapped = true;
							break outer;
						}
					}
				}
			}
			
			// write() 메서드를 사용해 테스트 케이스의 번호 및 첫 번째 플레이어가 두 번째 플레이어의 피라미드를 가둘 수 있는지 여부를 출력
			out.write(++testCase + ". ");
			out.write((isTrapped) ? "TRAPPED" : "FREE");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}