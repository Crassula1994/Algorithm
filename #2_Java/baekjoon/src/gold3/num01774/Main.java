package gold3.num01774;

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
	
	// Path 클래스 정의
	public static class Path implements Comparable<Path> {
		
		// 통로가 연결하는 신과 그 길이를 저장할 각 변수 초기화
		int startGod;
		int endGod;
		double length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Path(int startGod, int endGod, double length) {
			this.startGod = startGod;
			this.endGod = endGod;
			this.length = length;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Path anotherPath) {
			
			// 비교 대상의 길이보다 더 작은 경우 -1 반환
			if (this.length < anotherPath.length)
				return -1;
			
			// 비교 대상의 길이보다 더 큰 경우 1 반환
			if (this.length > anotherPath.length)
				return 1;

			// 비교 대상의 길이와 같은 경우 0 반환
			return 0;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 신의 근원 신을 저장할 배열 rootGod 초기화
		int[] rootGod;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int godNum) {
			
			// 근원 신을 저장할 배열 rootGod 초기화
			rootGod = new int[godNum + 1];
			
			// for 반복문을 사용해 각 신의 근원 신을 초기화
			for (int idx = 1; idx < rootGod.length; idx++)
				rootGod[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int god) {
			
			// 해당 신의 근원 신이 자기 자신인 경우 자기 자신을 반환
			if (rootGod[god] == god)
				return god;
			
			// find() 메서드를 재귀 호출해 해당 신의 근원 신을 반환
			return rootGod[god] = find(rootGod[god]);
		}
		
		// union() 메서드 정의
		public void union(int godA, int godB) {
			
			// find() 메서드를 사용해 두 신의 근원 신을 각 변수에 할당
			int rootA = find(godA);
			int rootB = find(godB);
			
			// 두 신의 근원 신이 다른 경우 근원 신을 갱신
			if (rootA != rootB)
				rootGod[find(Math.max(rootA, rootB))] = find(Math.min(rootA, rootB));
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 우주신들의 개수와 통로의 개수를 각 변수에 할당
		int godNum = Integer.parseInt(st.nextToken());
		int pathNum = Integer.parseInt(st.nextToken());
		
		// 각 우주신의 좌표를 저장할 2차원 배열 gods 초기화
		double[][] gods = new double[godNum + 1][2];
		
		// for 반복문을 사용해 입력 받은 각 우주신의 좌표를 순회
		for (int idx = 1; idx < gods.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 우주신의 좌표를 2차원 배열 gods에 저장
			gods[idx][0] = Double.parseDouble(st.nextToken());
			gods[idx][1] = Double.parseDouble(st.nextToken());
		}
		
		// 각 통로의 정보를 저장할 PriorityQueue 객체 paths 초기화
		PriorityQueue<Path> paths = new PriorityQueue<>();
		
		// for 반복문을 사용해 각 우주신을 연결하는 통로를 순회
		for (int s = 1; s < godNum; s++) {
			for (int e = s + 1; e <= godNum; e++) {
				
				// pow() 및 sqrt() 메서드를 사용해 통로의 길이를 계산해 변수 length에 할당
				double length = Math.sqrt(Math.pow(gods[s][0] - gods[e][0], 2) + Math.pow(gods[s][1] - gods[e][1], 2));
				
				// offer() 메서드를 사용해 각 통로의 정보를 paths에 추가
				paths.offer(new Path(s, e, length));
			}
		}
		
		// 모든 우주신을 연결하기 위해 필요한 최소의 통로 길이를 저장할 변수 minLength 초기화
		double minLength = 0;
		
		// 각 우주신의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(godNum);
		
		// for 반복문을 사용해 이미 연결된 각 통로를 순회
		for (int path = 0; path < pathNum; path++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 연결된 두 우주신을 각 변수에 할당
			int godA = Integer.parseInt(st.nextToken());
			int godB = Integer.parseInt(st.nextToken());
			
			// union() 메서드를 호출해 두 우주신을 연결
			connection.union(godA, godB);
		}
		
		// while 반복문을 사용해 paths가 빌 때까지 순회
		while (!paths.isEmpty()) {
			
			// poll() 메서드를 사용해 가장 길이가 짧은 통로를 변수 path에 할당
			Path path = paths.poll();
			
			// 두 우주신 사이에 연결이 존재하지 않는 경우
			if (connection.find(path.startGod) != connection.find(path.endGod)) {
				
				// 두 우주신을 연결
				connection.union(path.startGod, path.endGod);
				
				// 우주신을 연결하는 최소의 통로 길이를 갱신
				minLength += path.length;
			}
		}
		
		// format() 및 write() 메서드를 사용해 모든 우주신을 연결하기 위해 필요한 최소의 통로 길이를 출력
		out.write(String.format("%.2f", minLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}