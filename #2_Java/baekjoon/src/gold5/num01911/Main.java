package gold5.num01911;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 물웅덩이의 개수와 널빤지의 길이를 각 변수에 할당
		int puddleNum = Integer.parseInt(st.nextToken());
		int boardLength = Integer.parseInt(st.nextToken());
		
		// 물웅덩이를 덮기 위해 필요한 널빤지의 최소 개수, 현재 널빤지가 놓인 마지막 위치를 저장할 각 변수 초기화
		int minCount = 0;
		int lastBoard = -1;
		
		// 각 웅덩이의 정보를 저장할 2차원 배열 puddles 초기화
		int[][] puddles = new int[puddleNum][2];
		
		// for 반복문을 사용해 각 웅덩이의 정보를 순회
		for (int idx = 0; idx < puddleNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 웅덩이의 정보를 2차원 배열 puddles에 저장
			puddles[idx][0] = Integer.parseInt(st.nextToken());
			puddles[idx][1] = Integer.parseInt(st.nextToken());			
		}
		
		// sort() 메서드를 사용해 각 웅덩이의 시작 위치를 기준으로 오름차순 정렬
		Arrays.sort(puddles, (p1, p2) -> {
			return p1[0] - p2[0];
		});
		
		// for 반복문을 사용해 각 웅덩이를 순회
		for (int idx = 0; idx < puddleNum; idx++) {
			
			// max() 메서드를 사용해 널빤지를 놓기 시작할 위치를 갱신
			lastBoard = Math.max(puddles[idx][0], lastBoard);
			
			// while 반복문을 사용해 널빤지가 웅덩이를 모두 덮을 때까지 순회
			while (lastBoard < puddles[idx][1]) {
				
				// 널빤지의 끝 위치와 물웅덩이를 덮기 위해 필요한 널빤지의 최소 개수를 갱신
				lastBoard += boardLength;
				minCount++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 물웅덩이를 덮기 위해 필요한 널빤지의 최소 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}