package gold3.num16235;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// Tree 클래스 정의
	static class Tree implements Comparable<Tree> {
		
		// 나무의 위치 및 그 나이를 저장할 각 변수 초기화
		int row;
		int column;
		int age;
		
		// 매개변수를 입력 받는 생성자 정의
		public Tree(int row, int column, int age) {
			this.row = row;
			this.column = column;
			this.age = age;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Tree anotherTree) {
			return this.age - anotherTree.age;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 땅의 크기, 나무의 수, 나무 육성 시간을 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int treeNum = Integer.parseInt(st.nextToken());
		int targetYear = Integer.parseInt(st.nextToken());
		
		// 겨울에 추가하는 양분 및 현재 땅의 양분을 저장할 각 2차원 배열 초기화
		int[][] nutrients = new int[size][size];
		int[][] land = new int[size][size];
		
		// 현재 살아 있는 나무를 저장할 List 객체 trees 초기화
		List<Tree> trees = new ArrayList<>();
		
		// for 반복문을 사용해 각 땅의 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 땅의 열을 순회
			for (int c = 0; c < size; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 겨울에 추가하는 양분을 2차원 배열 nutrients에 저장
				nutrients[r][c] = Integer.parseInt(st.nextToken());
				
				// 현재 땅의 양분을 초기화
				land[r][c] = 5;
			}
		}
		
		// for 반복문을 사용해 각 나무를 순회
		for (int tree = 0; tree < treeNum; tree++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 나무의 위치 및 나이를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken()) - 1;
			int column = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 현재 나무의 정보를 trees에 저장
			trees.add(new Tree(row, column, age));
		}
		
		// for 반복문을 사용해 각 연도를 순회
		for (int year = 0; year < targetYear; year++) {
			
			// sort() 메서드를 사용해 현재 나무를 나이 순으로 오름차순 정렬
			Collections.sort(trees);
			
			// 살아 있는 나무를 저장할 List 객체 liveTrees 초기화
			List<Tree> liveTrees = new ArrayList<>();
			
			// 죽은 나무, 번식하는 나무를 저장할 각 Queue 객체 초기화
			Queue<Tree> deadTrees = new LinkedList<>();
			Queue<Tree> breedingTrees = new LinkedList<>();
			
			// for 반복문을 사용해 각 나무를 순회
			for (Tree tree : trees) {
				
				// 해당 나무의 나이만큼 양분을 먹을 수 있는 경우
				if (land[tree.row][tree.column] >= tree.age) {
					
					// 해당 땅의 양분 및 나무의 나이를 갱신
					land[tree.row][tree.column] -= tree.age;
					tree.age++;
					
					// add() 메서드를 사용해 자란 나무를 liveTrees에 추가
					liveTrees.add(tree);
					
					// 해당 나무의 나이가 5의 배수인 경우 breedingTrees에 해당 나무 추가
					if (tree.age % 5 == 0)
						breedingTrees.offer(tree);
					
				// 해당 나무의 나이만큼 양분을 먹을 수 없는 경우 deadTrees에 해당 나무를 추가
				} else {
					deadTrees.offer(tree);
				}
			}
			
			// for 반복문을 사용해 죽은 나무가 있던 칸에 양분을 추가
			for (Tree deadTree : deadTrees)
				land[deadTree.row][deadTree.column] += deadTree.age / 2;
			
			// for 반복문을 사용해 번식할 나무를 순회
			for (Tree breedingTree : breedingTrees) {
				
				// for 반복문을 사용해 해당 나무의 인접한 위치를 순회
				for (int d = 0; d < 8; d++) {
					
					// 해당 나무의 인접한 위치를 각 변수에 할당
					int nr = breedingTree.row + dr[d];
					int nc = breedingTree.column + dc[d];
					
					// 해당 위치가 땅의 범위를 벗어나는 경우 다음 위치를 순회
					if (nr < 0 || nr >= size || nc < 0 || nc >= size)
						continue;
					
					// add() 메서드를 사용해 새로운 나무를 liveTrees에 추가
					liveTrees.add(new Tree(nr, nc, 1));
				}
			}
			
			// for 반복문을 사용해 각 땅에 양분을 추가
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++)
					land[r][c] += nutrients[r][c];
			}
			
			// 겨울까지 살아 있는 나무를 trees에 갱신
			trees = liveTrees;
		}
		
		// size(), valueOf(), write() 메서드를 사용해 목표한 시간이 지난 후 살아남은 나무의 수를 출력
		out.write(String.valueOf(trees.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}