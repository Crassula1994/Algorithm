package gold3.num04386;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Line 클래스 정의
	public static class Line implements Comparable<Line> {
		
		// 별자리를 이루는 선이 이은 별, 그 비용을 저장할 각 변수 초기화
		int startStar;
		int endStar;
		double cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Line(int startStar, int endStar, double cost) {
			this.startStar = startStar;
			this.endStar = endStar;
			this.cost = cost;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Line anotherLine) {
			
			// 비교 대상의 비용보다 더 작은 경우 -1 반환
			if (this.cost < anotherLine.cost)
				return -1;
			
			// 비교 대상의 비용보다 더 큰 경우 1 반환
			if (this.cost > anotherLine.cost)
				return 1;

			// 비교 대상의 비용과 같은 경우 0 반환
			return 0;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 별의 부모 별을 저장할 배열 rootStar 초기화
		int[] rootStar;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int starNum) {
			
			// 부모 별을 저장할 배열 rootStar 초기화
			rootStar = new int[starNum + 1];
			
			// for 반복문을 사용해 각 정점의 부모 정점을 초기화
			for (int idx = 1; idx < rootStar.length; idx++)
				rootStar[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int star) {
			
			// 해당 별의 부모 별이 자기 자신이 아닌 경우 find() 메서드 재귀 호출
			if (rootStar[star] != star)
				rootStar[star] = find(rootStar[star]);
			
			// 해당 별의 부모 별을 반환
			return rootStar[star];
		}
		
		// union() 메서드 정의
		public void union(int star1, int star2) {
			
			// 두 정점을 연결
			rootStar[find(star1)] = find(star2);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 별의 개수를 변수 starNum에 할당
		int starNum = Integer.parseInt(in.readLine());
		
		// 각 별의 좌표를 저장할 2차원 배열 stars 초기화
		double[][] stars = new double[starNum + 1][2];
		
		// for 반복문을 사용해 입력 받은 각 별의 좌표를 순회
		for (int idx = 1; idx < stars.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 별의 좌표를 2차원 배열 stars에 저장
			stars[idx][0] = Double.parseDouble(st.nextToken());
			stars[idx][1] = Double.parseDouble(st.nextToken());
		}
		
		// 각 별자리를 이루는 선의 정보를 저장할 PriorityQueue 객체 lines 초기화 
		PriorityQueue<Line> lines = new PriorityQueue<>();
		
		// for 반복문을 사용해 각 별자리를 이루는 선을 순회
		for (int s = 1; s < starNum; s++) {
			for (int e = s + 1; e <= starNum; e++) {
				
				// pow() 및 sqrt() 메서드를 사용해 두 별 사이의 거리를 계산해 변수 distance에 할당
				double distance = Math.sqrt(Math.pow(stars[s][0] - stars[e][0], 2) + Math.pow(stars[s][1] - stars[e][1], 2));
				
				// offer() 메서드를 사용해 각 별자리를 이루는 선의 정보를 lines에 추가
				lines.offer(new Line(s, e, distance));
			}
		}
		
		// 별자리를 만드는 최소 비용 및 별자리를 이은 선의 개수를 저장할 각 변수 초기화
		double minCost = 0;
		int lineCnt = 0;
		
		// 각 별의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(starNum);
		
		// while 반복문을 사용해 lines가 빌 때까지 순회
		while (!lines.isEmpty()) {
			
			// 모든 별자리를 잇기 위해 필요한 선을 모두 선택한 경우 반복문 탈출
			if (lineCnt == starNum - 1)
				break;
			
			// poll() 메서드를 사용해 가장 비용이 적은 별자리를 이은 선을 변수 line에 할당
			Line line = lines.poll();
			
			// 두 별 사이에 연결이 존재하지 않는 경우
			if (connection.find(line.startStar) != connection.find(line.endStar)) {
				
				// 두 별을 연결
				connection.union(line.startStar, line.endStar);
				
				// 별자리를 만드는 최소 비용 및 별자리를 이은 선의 개수를 갱신
				minCost += line.cost;
				lineCnt++;
			}
		}
		
		// format() 및 write() 메서드를 사용해 별자리를 만드는 최소 비용을 출력
		out.write(String.format("%.2f", minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}