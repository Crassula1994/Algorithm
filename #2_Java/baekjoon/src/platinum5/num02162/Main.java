package platinum5.num02162;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 선분 그룹의 대표 선분과 해당 그룹에 속한 선분의 개수를 저장할 각 배열 초기화
	static int[] rootLine;
	static int[] counts;
	
	// 각 선분 그룹의 대표 선분을 저장할 Set 객체 groups 초기화
	static Set<Integer> groups = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Point 클래스 정의
	public static class Point {
		
		// 해당 점의 좌표를 저장할 각 변수 초기화
		int x;
		int y;
		
		// 매개변수를 입력 받는 생성자 정의
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선분의 개수를 변수 lineNum에 할당
		int lineNum = Integer.parseInt(in.readLine());
		
		// 가장 크기가 큰 그룹에 속한 선분의 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 선분 그룹의 대표 선분과 해당 그룹에 속한 선분의 개수를 저장할 각 배열 초기화
		rootLine = new int[lineNum];
		counts = new int[lineNum];
		
		// 각 선분의 양 끝점 좌표를 저장할 2차원 배열 lines 초기화
		Point[][] lines = new Point[lineNum][2];
		
		// for 반복문을 사용해 각 선분의 좌표를 순회
		for (int idx = 0; idx < lines.length; idx++) {
			
			// 각 선분의 대표 선분과 해당 그룹에 속한 선분의 개수를 갱신
			rootLine[idx] = idx;
			counts[idx] = 1;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점을 배열 lines에 저장
			lines[idx][0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			lines[idx][1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// for 반복문을 사용해 두 선분의 쌍을 순회
		for (int lineA = 0; lineA < lineNum - 1; lineA++) {
			for (int lineB = lineA + 1; lineB < lineNum; lineB++) {
			
				// 두 선분이 교차하는 경우 groupMaker() 메서드를 호출해 선분 그룹을 형성
				if (lineChecker(lines[lineA][0], lines[lineA][1], lines[lineB][0], lines[lineB][1]))
					groupMaker(lineA, lineB);
			}
		}
		
		// for 반복문을 사용해 각 선분을 순회
		for (int idx = 0; idx < lineNum; idx++) {
			
			// lineFinder() 메서드를 호출해 해당 선분의 대표 선분을 변수 root에 할당
			int root = lineFinder(idx);
			
			// add() 메서드를 사용해 해당 선분의 대표 선분을 groups에 추가
			groups.add(root);
			
			// max() 메서드를 사용해 가장 크기가 큰 그룹에 속한 선분의 개수를 갱신
			maxCount = Math.max(counts[root], maxCount);			
		}
		
		// size() 및 write() 메서드를 사용해 그룹의 수 및 가장 크기가 큰 그룹에 속한 선분의 개수를 출력
		out.write(groups.size() + "\n" + maxCount);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// lineChecker() 메서드 정의
	public static boolean lineChecker(Point point1, Point point2, Point point3, Point point4) {
		
		// ccwCalculator() 메서드를 호출해 그 결과를 각 변수에 할당
		int isCrossed1 = ccwCalculator(point1, point2, point3) * ccwCalculator(point1, point2, point4);
		int isCrossed2 = ccwCalculator(point3, point4, point1) * ccwCalculator(point3, point4, point2);
		
		// 두 선분이 일직선 상에 위치하는 경우
		if (isCrossed1 == 0 && isCrossed2 == 0) {
			
			// 두 선분이 서로 겹치기 위한 각 조건을 계산해 각 변수에 할당
			boolean condition1 = Math.min(point1.x, point2.x) <= Math.max(point3.x, point4.x);
			boolean condition2 = Math.min(point3.x, point4.x) <= Math.max(point1.x, point2.x);
			boolean condition3 = Math.min(point1.y, point2.y) <= Math.max(point3.y, point4.y);
			boolean condition4 = Math.min(point3.y, point4.y) <= Math.max(point1.y, point2.y);
			
			// 두 선분이 교차하는지 여부를 반환
			return condition1 && condition2 && condition3 && condition4;
		}
		
		// 두 선분이 교차하는지 여부를 반환
		return isCrossed1 <= 0 && isCrossed2 <= 0;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ccwCalculator() 메서드 정의
	public static int ccwCalculator(Point point1, Point point2, Point point3) {
		
		// 세 점을 이은 직선의 방향를 나타내는 값을 계산해 변수 direction에 할당
		int direction = (point2.x - point1.x) * (point3.y - point1.y) - (point3.x - point1.x) * (point2.y - point1.y);
		
		// 세 점을 이은 직선의 방향이 일직선인 경우 0을 반환
		if (direction == 0)
			return 0;
		
		// 세 점을 이은 직선의 방향이 시계 방향인지 반시계 방향인지에 따라 -1 또는 1을 반환
		return direction < 0 ? -1 : 1;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// groupMaker() 메서드 정의
	public static void groupMaker(int lineA, int lineB) {
		
		// lineFinder() 메서드를 호출해 두 선분의 대표 선분을 각 변수에 할당
		int rootA = lineFinder(lineA);
		int rootB = lineFinder(lineB);
		
		// 두 선분의 대표 선분이 다른 경우 대표 선분 및 그룹에 속한 선분의 개수를 갱신
		if (rootA != rootB) {
			rootLine[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
			counts[Math.min(rootA, rootB)] += counts[Math.max(rootA, rootB)];
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// lineFinder() 메서드 정의
	public static int lineFinder(int line) {
		
		// 자기 자신이 대표 선분인 경우 자기 자신을 반환
		if (rootLine[line] == line)
			return line;
		
		// lineFinder() 메서드를 재귀 호출해 대표 선분을 찾아 반환
		return rootLine[line] = lineFinder(rootLine[line]);
	}
}