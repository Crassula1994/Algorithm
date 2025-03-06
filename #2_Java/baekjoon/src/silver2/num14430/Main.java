package silver2.num14430;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 WOOK이 탐사할 영역의 세로 길이와 가로 길이를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 해당 위치까지 WOOK이 수집할 수 있는 최대 광석의 개수를 저장할 2차원 배열 maxCounts 초기화
		int[][] maxCounts = new int[height + 1][width + 1];
		
		// for 반복문을 사용해 탐사할 영역의 각 행을 순회
		for (int r = 1; r <= height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 탐사할 위치까지 WOOK이 수집할 수 있는 최대 광석의 개수를 갱신
			for (int c = 1; c <= width; c++)
				maxCounts[r][c] = Math.max(maxCounts[r - 1][c], maxCounts[r][c - 1]) + Integer.parseInt(st.nextToken());
		}
		
		// valueOf() 및 write() 메서드를 사용해 WOOK이 수집할 수 있는 최대 광석의 개수를 출력
		out.write(String.valueOf(maxCounts[height][width]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}