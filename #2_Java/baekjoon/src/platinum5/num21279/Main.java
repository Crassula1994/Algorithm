package platinum5.num21279;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Mineral 클래스 정의
	static class Mineral {
		
		// 광물의 좌표 및 아름다운 정도를 나타낼 각 변수 초기화
		int coordinateX;
		int coordinateY;
		int beauty;
		
		// 인자를 입력 받는 생성자 정의
		public Mineral(int coordinateX, int coordinateY, int beauty) {
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
			this.beauty = beauty;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 광물의 개수 및 호석이가 가진 돈을 각 변수에 할당
		int mineralNum = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		// 각 X좌표별 광물을 저장할 배열 minerals 초기화
		@SuppressWarnings("unchecked")
		List<Mineral>[] minerals = new ArrayList[100001];
		
		// for 반복문을 사용해 각 X좌표별 광물을 저장할 List 객체 초기화
		for (int idx = 0; idx < minerals.length; idx++)
			minerals[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 광물의 정보를 순회
		for (int m = 0; m < mineralNum; m++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 광물의 좌표 및 아름다운 정도를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			int beauty = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 x좌표에 해당 광물을 추가
			minerals[coordinateX].add(new Mineral(coordinateX, coordinateY, beauty));
		}
		
		// 호석이가 파산하지 않으면서 얻을 수 있는 광물들의 아름다운 정도의 합 및 그 최댓값을 저장할 각 변수 초기화
		long sum = 0;
		long maxSum = 0;
		
		// 각 X좌표까지 최대로 채굴할 수 있는 광물을 저장할 PriorityQueue 객체 possibleMinerals 초기화
		PriorityQueue<Mineral> possibleMinerals = new PriorityQueue<>((m1, m2) -> {
			return m2.coordinateY - m1.coordinateY;
		});
		
		// for 반복문을 사용해 각 X좌표를 차례로 순회
		for (int x = 0; x <= 100000; x++) {
			
			// 해당 좌표에 광물이 존재하지 않는 경우 다음 좌표를 순회
			if (minerals[x].isEmpty())
				continue;
			
			// for 반복문을 사용해 해당 X좌표에 위치한 모든 광물을 순회
			for (Mineral mineral : minerals[x]) {
				
				// offer() 메서드를 사용해 해당 광물을 possibleMinerals에 추가
				possibleMinerals.offer(mineral);
				
				// 광물들의 아름다운 정도의 합을 갱신
				sum += mineral.beauty;
			}
			
			// 이전 좌표와 Y좌표가 동일한지를 나타내는 변수 isSameY 초기화
			boolean isSameY = false;
			
			// while 반복문을 사용해 호석이가 가진 돈을 초과하지 않을 때까지 순회
			while (possibleMinerals.size() > money || isSameY) {
				
				// poll() 메서드를 사용해 해당 광물을 변수 mineral에 할당
				Mineral mineral = possibleMinerals.poll();
				
				// 이전 광물과 Y좌표가 동일한지에 따라 isSameY 변수 갱신
				isSameY = (!possibleMinerals.isEmpty() && mineral.coordinateY == possibleMinerals.peek().coordinateY) ? true : false;
				
				// 해당 광물의 아름다운 정도를 총합에서 제거
				sum -= mineral.beauty;
			}
			
			// max() 메서드를 사용해 호석이가 파산하지 않으면서 얻을 수 있는 광물들의 아름다운 정도의 합의 최댓값을 갱신
			maxSum = Math.max(sum, maxSum);
		}
		
		// valueOf() 및 write() 메서드를 사용해 호석이가 파산하지 않으면서 얻을 수 있는 광물들의 아름다운 정도의 합의 최댓값을 출력
		out.write(String.valueOf(maxSum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}