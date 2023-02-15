package silver2.num18111;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 땅의 크기 및 인벤토리의 블록 개수를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int inventory = Integer.parseInt(st.nextToken());
		
		// 각 땅의 높이를 저장할 2차원 배열 land 초기화
		int[][] land = new int[height][width];
		
		// 주어진 땅의 높이 중 가장 높은 고도와 가장 낮은 고도를 저장할 변수 초기화
		int maxAltitude = Integer.MIN_VALUE;
		int minAltitude = Integer.MAX_VALUE;
		
		// 땅을 고르는 데 걸리는 시간을 저장할 minTime 초기화
		int minTime = Integer.MAX_VALUE;
		
		// 땅의 최적 높이를 저장할 변수 bestAltitude 초기화
		int bestAltitude = 0;
		
		// for 반복문을 사용해 땅의 세로를 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 땅의 가로를 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 땅의 높이를 배열 land에 저장
				land[r][c] = Integer.parseInt(st.nextToken());
				
				// 가장 높은 고도 및 가장 낮은 고도 갱신
				maxAltitude = (land[r][c] > maxAltitude) ? land[r][c] : maxAltitude;
				minAltitude = (land[r][c] < minAltitude) ? land[r][c] : minAltitude;
			}
		}
		
		// for 반복문을 사용해 가장 낮은 고도에서 가장 높은 고도까지 순회
		for (int alt = minAltitude; alt < maxAltitude + 1; alt++) {
			
			// 소요 시간 및 보유 블록 수를 저장할 각 변수 초기화
			int time = 0;
			int blocks = inventory;
			
			// for 반복문을 사용해 각 땅을 순회
			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
					
					// 땅의 고도가 기준 고도보다 높은 경우 시간 갱신 및 블록 수 갱신
					if (land[r][c] > alt) {
						time += (land[r][c] - alt) * 2;
						blocks += land[r][c] - alt;
					
					// 땅의 고도가 기준 고도보다 낮은 경우 시간 갱신 및 블록 수 갱신
					} else if (land[r][c] < alt) {
						time += alt - land[r][c];
						blocks -= alt - land[r][c];
					}
				}
			}
			
			// 블록 수가 음수가 아닌 경우 최소 소요 시간 및 최적 높이 갱신
			if (blocks >= 0 && time <= minTime) {
				minTime = time;
				bestAltitude = alt;
			}
		}
		
		// write() 메서드를 사용해 최소 소요 시간 및 최적 높이를 출력
		out.write(minTime + " " + bestAltitude);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}