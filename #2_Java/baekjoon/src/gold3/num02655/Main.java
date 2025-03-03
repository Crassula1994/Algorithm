package gold3.num02655;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Brick 클래스 정의
	static class Brick implements Comparable<Brick> {
		
		// 해당 벽돌의 번호, 밑면의 넓이, 높이, 무게를 저장할 각 변수 초기화
		int number;
		int area;
		int height;
		int weight;
		
		// 매개변수를 입력 받는 생성자 정의
		public Brick(int number, int area, int height, int weight) {
			this.number = number;
			this.area = area;
			this.height = height;
			this.weight = weight;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Brick anotherBrick) {
			
			// 벽돌의 밑면의 넓이를 기준으로 오름차순 정렬
			return this.area - anotherBrick.area;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 벽돌의 수를 변수 brickNum에 할당
		int brickNum = Integer.parseInt(in.readLine());
		
		// 각 벽돌의 정보 및 각 벽돌을 사용했을 때의 최대 높이를 저장할 각 배열 초기화
		Brick[] bricks = new Brick[brickNum];
		int[] maxHeights = new int[brickNum];
		
		// 가장 높은 벽돌 탑에 사용된 벽돌을 저장할 List 객체 towerBricks 초기화
		List<Integer> towerBricks = new ArrayList<>();
		
		// for 반복문을 사용해 각 벽돌의 정보를 순회
		for (int idx = 0; idx < bricks.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 벽돌의 밑면의 넓이, 높이, 무게를 각 변수에 할당
			int area = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 해당 벽돌의 정보를 배열 bricks에 저장
			bricks[idx] = new Brick(idx + 1, area, height, weight);
		}
		
		// sort() 메서드를 사용해 각 벽돌을 밑면의 넓이를 기준으로 오름차순 정렬
		Arrays.sort(bricks);
		
		// 가장 높은 벽돌 탑의 높이를 저장할 변수 maxHeight 초기화
		int maxHeight = 0;
		
		// for 반복문을 사용해 각 벽돌을 순회
		for (int cur = 0; cur < bricks.length; cur++) {
			
			// 해당 벽돌을 사용했을 때 최대 높이를 초기화
			maxHeights[cur] = bricks[cur].height;
			
			// for 반복문을 사용해 해당 벽돌보다 밑면의 넓이가 더 작은 벽돌을 순회
			for (int prev = 0; prev < cur; prev++) {
				
				// 이전 벽돌이 현재 벽돌보다 무게가 더 무거운 경우 다음 벽돌을 순회
				if (bricks[prev].weight > bricks[cur].weight)
					continue;
				
				// max() 메서드를 사용해 해당 벽돌을 사용했을 때 최대 높이를 갱신
				maxHeights[cur] = Math.max(maxHeights[prev] + bricks[cur].height, maxHeights[cur]);
			}
			
			// max() 메서드를 사용해 가장 높은 벽돌 탑의 높이를 갱신
			maxHeight = Math.max(maxHeights[cur], maxHeight);
		}
		
		// for 반복문을 사용해 각 벽돌을 순회
		for (int idx = maxHeights.length - 1; idx >= 0; idx--) {
			
			// 해당 벽돌이 가장 높은 벽돌 탑의 높이와 일치하지 않는 경우 다음 벽돌을 순회
			if (maxHeights[idx] != maxHeight)
				continue;
			
			// add() 메서드를 사용해 해당 벽돌의 번호를 towerBricks에 저장
			towerBricks.add(bricks[idx].number);
			
			// 가장 높은 벽돌 탑의 높이를 갱신
			maxHeight -= bricks[idx].height;
		}
		
		// size() 및 write() 메서드를 사용해 가장 높은 벽돌 탑에 사용된 벽돌의 개수를 출력
		out.write(towerBricks.size() + "\n");
		
		// for 반복문을 사용해 가장 높은 벽돌 탑에 사용된 벽돌의 번호를 출력
		for (int idx = towerBricks.size() - 1; idx >= 0; idx--)
			out.write(towerBricks.get(idx) + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}