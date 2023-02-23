package silver1.num02564;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 블록의 크기를 각 변수에 할당
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 상점의 개수를 변수 shopNum에 할당
		int shopNum = Integer.parseInt(in.readLine());
		
		// 각 상점 및 경비원의 위치를 저장할 2차원 배열 location 초기화
		int[][] location = new int[shopNum + 1][2];
		
		// 왼쪽 모서리를 기준으로 했을 때의 거리를 저장할 배열 distance 초기화
		int[] distance =new int[shopNum + 1];
		
		// 최단 거리의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 배열 location의 각 원소를 순회
		for (int idx = 0; idx < location.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 위치를 배열 location에 할당
			location[idx][0] = Integer.parseInt(st.nextToken());
			location[idx][1] = Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 동서남북의 위치에 따라 구분
			switch (location[idx][0]) {
			
				// 북쪽인 경우 배열 location에 거리 계산 후 조건문 탈출
				case 1:
					distance[idx] = location[idx][1];
					break;
					
				// 남쪽인 경우 배열 location에 거리 계산 후 조건문 탈출
				case 2:
					distance[idx] = 2 * width + height - location[idx][1];
					break;
					
				// 서쪽인 경우 배열 location에 거리 계산 후 조건문 탈출
				case 3:
					distance[idx] = 2 * (width + height) - location[idx][1];
					break;
					
				// 동쪽인 경우 배열 location에 거리 계산
				case 4:
					distance[idx] = width + location[idx][1];
			}
		}
		
		// for 반복문을 사용해 배열 distance의 각 상점 위치를 순회
		for (int idx = 0; idx < distance.length - 1; idx++) {
			
			// abs() 메서드를 사용해 경비원과의 거리를 계산해 변수 between에 할당
			int between = Math.abs(distance[idx] - distance[distance.length - 1]);
			
			// 더 가까운 거리로 갱신
			between = (between > width + height) ? 2 * (width + height) - between : between;
			
			// 최단 거리의 합 갱신
			sum += between;
		}
		
		// valueOf() 및 write() 메서드를 사용해 최단 거리의 합 출력
		out.write(String.valueOf(sum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}