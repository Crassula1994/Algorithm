package gold4.num10476;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 갤러리를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 미술관의 세로 길이와 닫아야 하는 방의 수를 각 변수에 할당
			int height = Integer.parseInt(st.nextToken());
			int closureCount = Integer.parseInt(st.nextToken());
			
			// 마지막 미술관의 정보까지 확인한 경우 반복문 탈출
			if (height == 0 && closureCount == 0)
				break;
			
			// 미술관 각 방의 가치를 저장할 2차원 배열 roomValues 초기화
			int[][] roomValues = new int[height + 1][2];
			
			// 지금까지 닫은 방의 수, 각 줄에서 가능한 경우의 수에서 가장 높은 가치를 저장할 3차원 배열 maxValues 초기화
			int[][][] maxValues = new int[height + 1][closureCount + 1][3];
 			
			// for 반복문을 사용해 입력 받은 미술관의 각 방을 순회
			for (int r = 1; r <= height; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 방의 가치를 배열 roomValues에 저장
				roomValues[r][0] = Integer.parseInt(st.nextToken());
				roomValues[r][1] = Integer.parseInt(st.nextToken());
			}
			
			// 첫 번째 줄에서 두 방을 모두 닫지 않은 경우의 가장 높은 가치를 갱신
			maxValues[1][0][0] = roomValues[1][0] + roomValues[1][1];
			
			// 닫아야 하는 방의 수가 1개 이상인 경우 해당 줄에서 한쪽 방을 닫은 경우의 가장 높은 가치를 갱신
			if (closureCount > 0) {
				maxValues[1][1][1] = roomValues[1][1];
				maxValues[1][1][2] = roomValues[1][0];
			}
			
			// for 반복문을 사용해 각 줄을 순회
			for (int r = 2; r <= height; r++) {
				
				// for 반복문을 사용해 지금까지 닫은 각 방의 개수를 순회
				for (int count = 0; count <= closureCount; count++) {
					
					// 두 방을 모두 닫지 않을 수 있는 경우, 그 경우의 가장 높은 가치를 갱신
					if (r > count)
						maxValues[r][count][0] = Math.max(maxValues[r - 1][count][0],
								Math.max(maxValues[r - 1][count][1], maxValues[r - 1][count][2]))
								+ roomValues[r][0] + roomValues[r][1];
					
					// 닫은 방의 개수가 0개인 경우 다음 방의 개수를 순회
					if (count == 0)
						continue;
					
					// max() 메서드를 사용해 현재 줄의 닫은 방의 개수에서 한쪽 방을 닫은 경우의 가장 높은 가치를 갱신
					maxValues[r][count][1] = Math.max(maxValues[r - 1][count - 1][0], maxValues[r - 1][count - 1][1])
							+ roomValues[r][1];
					maxValues[r][count][2] = Math.max(maxValues[r - 1][count - 1][0], maxValues[r - 1][count - 1][2])
							+ roomValues[r][0];
				}
			}
			
			// max() 메서드를 사용해 대중에게 공개될 수 있는 가치의 최대합을 변수 maxValue에 할당
			int maxValue = Math.max(maxValues[height][closureCount][0],
					Math.max(maxValues[height][closureCount][1], maxValues[height][closureCount][2]));
			
			// write() 메서드를 사용해 대중에게 공개될 수 있는 가치의 최대합을 출력
			out.write(maxValue + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}