package gold3.num31854;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 부등호 퍼즐의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 부등호 퍼즐의 대소 관계, 각 칸보다 더 작은 값을 갖는 인접한 칸의 개수를 저장할 각 배열 초기화
	static List<Integer>[] relations;
	static int[] bigCounts;
	
	// 부등호 퍼즐의 각 격자판에 들어갈 숫자를 저장할 2차원 배열 grid 초기화
	static int[][] grid;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부등호 퍼즐의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 부등호 퍼즐의 대소 관계, 각 칸보다 더 작은 값을 갖는 인접한 칸의 개수를 저장할 각 배열 초기화
		relations = new ArrayList[size * size];
		bigCounts = new int[size * size];
		
		// 부등호 퍼즐의 각 격자판에 들어갈 숫자를 저장할 2차원 배열 grid 초기화
		grid = new int[size][size];
		
		// for 반복문을 사용해 부등호 퍼즐의 대소 관계를 저장할 List 객체 초기화
		for (int idx = 0; idx < relations.length; idx++)
			relations[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸 사이의 부등호를 순회
			for (int c = 0; c < size - 1; c++) {
				
				// 연결하는 두 칸의 번호를 각 변수에 할당
				int leftCell = r * size + c;
				int rightCell = leftCell + 1;
				
				// 해당 부등호가 '>'인 경우 대소 관계 및 더 작은 값을 갖는 인접한 칸의 개수를 갱신
				if (st.nextToken().equals(">")) {
					relations[rightCell].add(leftCell);
					bigCounts[leftCell]++;
				
				// 해당 부등호가 '<'인 경우 대소 관계 및 더 작은 값을 갖는 인접한 칸의 개수를 갱신
				} else {
					relations[leftCell].add(rightCell);
					bigCounts[rightCell]++;
				}
			}
		}
		
		// for 반복문을 사용해 각 행 사이를 순회
		for (int r = 0; r < size - 1; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸의 부등호를 순회
			for (int c = 0; c < size; c++) {
				
				// 연결하는 두 칸의 번호를 각 변수에 할당
				int upCell = r * size + c;
				int downCell = upCell + size;
				
				// 해당 부등호가 '>'인 경우 대소 관계 및 더 작은 값을 갖는 인접한 칸의 개수를 갱신
				if (st.nextToken().equals(">")) {
					relations[downCell].add(upCell);
					bigCounts[upCell]++;
				
				// 해당 부등호가 '<'인 경우 대소 관계 및 더 작은 값을 갖는 인접한 칸의 개수를 갱신
				} else {
					relations[upCell].add(downCell);
					bigCounts[downCell]++;
				}
			}
		}
		
		// gridMaker() 메서드를 호출해 격자판의 각 숫자를 갱신
		gridMaker();
		
		// for 반복문을 사용해 격자판의 각 칸의 숫자를 출력
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				out.write(grid[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gridMaker() 메서드 정의
	public static void gridMaker() {
		
		// 격자판에 저장할 숫자를 나타낼 변수 number 초기화
		int number = 1;
		
		// 다음에 확인할 격자판의 칸을 저장할 Queue 객체 cellList 초기화
		Queue<Integer> cellList = new LinkedList<>();
		
		// for 반복문을 사용해 각 격자판의 칸을 순회
		for (int idx = 0; idx < bigCounts.length; idx++) {
			
			// 인접한 칸들과 비교했을 때 가장 작은 칸인 경우 해당 칸을 cellList에 추가
			if (bigCounts[idx] == 0)
				cellList.offer(idx);
		}
		
		// while 반복문을 사용해 cellList가 빌 때까지 순회
		while (!cellList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 격자판의 칸을 변수 curCell에 할당
			int curCell = cellList.poll();
			
			// 해당 칸에 들어갈 숫자를 2차원 배열 grid에 저장
			grid[curCell / size][curCell % size] = number++;
			
			// for 반복문을 사용해 현재 격자판보다 큰 인접한 각 칸을 순회
			for (int nextCell : relations[curCell]) {
				
				// 해당 칸의 더 작은 값을 갖는 인접한 칸의 개수를 갱신
				bigCounts[nextCell]--;
				
				// 해당 칸이 현재 칸을 제외했을 때 인접한 칸들과 비교했을 때 가장 작은 칸인 경우 cellList에 추가
				if (bigCounts[nextCell] == 0)
					cellList.offer(nextCell);
			}
		}
	}
}