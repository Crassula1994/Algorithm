package bronze1.num31067;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 트랙의 수와 트랙을 늘릴 수 있는 길이를 각 변수에 할당
		int trackNum = Integer.parseInt(st.nextToken());
		int addLength = Integer.parseInt(st.nextToken());
		
		// 다오가 트랙의 길이를 점점 증가하도록 만들기 위해 필요한 시행의 최소 횟수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 각 트랙의 길이를 저장할 배열 tracks 초기화
		int[] tracks = new int[trackNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 트랙을 순회
		for (int idx = 0; idx < tracks.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 트랙의 길이를 배열 tracks에 저장
			tracks[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 트랙이 첫 번째 트랙이거나 이전 트랙보다 긴 경우 다음 트랙을 순회
			if (idx == 0 || tracks[idx] > tracks[idx - 1])
				continue;
			
			// 현재 트랙의 길이를 늘려 트랙의 길이와 필요한 시행의 최소 횟수를 갱신
			tracks[idx] += addLength;
			minCount++;
			
			/* 현재 트랙의 길이를 늘려도 이전 트랙보다 짧거나 같은 경우 다오가 트랙의 길이를 점점 증가하도록
			만들기 위해 필요한 시행의 최소 횟수를 갱신 후 반복문 탈출 */
			if (tracks[idx] <= tracks[idx - 1]) {
				minCount = -1;
				break;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 다오가 트랙의 길이를 점점 증가하도록 만들기 위해 필요한 최소 시행의 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}