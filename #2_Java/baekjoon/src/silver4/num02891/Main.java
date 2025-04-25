package silver4.num02891;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 팀의 수, 카약이 손상된 팀의 수,
		카약을 하나 더 가져온 팀의 수를 각 변수에 할당 */
		int teamNum = Integer.parseInt(st.nextToken());
		int damagedCnt = Integer.parseInt(st.nextToken());
		int spareCnt = Integer.parseInt(st.nextToken());
		
		// 출발을 할 수 없는 팀의 최솟값을 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 각 팀이 지닌 카약의 수를 저장할 배열 counts 초기화
		int[] counts = new int[teamNum];
		
		// fill() 메서드를 사용해 각 팀이 지닌 카약의 수를 초기화
		Arrays.fill(counts, 1);
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 카약이 손상된 팀이 지닌 카약의 수를 갱신
		while (damagedCnt-- > 0)
			counts[Integer.parseInt(st.nextToken()) - 1]--;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 카약을 하나 더 가져온 팀이 지닌 카약의 수를 갱신
		while (spareCnt-- > 0)
			counts[Integer.parseInt(st.nextToken()) - 1]++;
		
		// for 반복문을 사용해 각 팀을 순회
		for (int idx = 0; idx < counts.length; idx++) {
			
			// 해당 팀이 카약을 빌려줄 수 없는 경우 다음 팀을 순회
			if (counts[idx] < 2)
				continue;
			
			// 해당 팀 바로 앞 순서의 팀이 카약이 손상된 경우 카약을 빌려준 것으로 처리
			if (idx > 0 && counts[idx - 1] == 0) {
				counts[idx - 1]++;
				counts[idx]--;
				
			// 해당 팀 바로 뒤 순서의 팀이 카약이 손상된 경우 카약을 빌려준 것으로 처리
			} else if (idx < teamNum - 1 && counts[idx + 1] == 0) {
				counts[idx + 1]++;
				counts[idx]--;
			}
		}
		
		// for 반복문을 사용해 각 팀을 순회
		for (int count : counts) {
			
			// 해당 팀이 출발을 할 수 없는 경우 출발을 할 수 없는 팀의 최솟값을 갱신
			if (count == 0)
				minCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 출발을 할 수 없는 팀의 최솟값을 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}