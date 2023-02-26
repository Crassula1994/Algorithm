package silver1.num01931;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 회의의 수를 변수 meetingNum에 할당
		int meetingNum = Integer.parseInt(in.readLine());

		// 각 회의의 시작 시간 및 종료 시간을 저장할 2차원 배열 meetings 초기화
		int[][] meetings = new int[meetingNum][2];
		
		// for 반복문을 사용해 배열 meetings의 각 원소 순회
		for (int idx = 0; idx < meetingNum; idx++ ) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 시간 및 종료 시간을 배열 meetings에 저장
			meetings[idx][0] = Integer.parseInt(st.nextToken());
			meetings[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// sort() 메서드를 사용해 각 회의를 종료 시간이 빠른 순, 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬
		Arrays.sort(meetings, (m1, m2) -> {
			return (m1[1] == m2[1]) ? m1[0] - m2[0] : m1[1] - m2[1];
		});
		
		// 회의의 최대 개수 및 이전 회의의 종료 시간을 저장할 각 변수 초기화
		int maxCnt = 0;
		int endTime = 0;
		
		// for 반복문을 사용해 정렬된 각 회의를 순회
		for (int idx = 0; idx < meetings.length; idx++) {
			
			// 회의의 시작 시간이 이전 회의의 종료 시간과 같거나 그 이후인 경우
			if (meetings[idx][0] >= endTime) {
				
				// 이전 회의의 종료 시간을 현재 회의의 종료 시간으로 갱신
				endTime = meetings[idx][1];
				
				// 회의의 최대 개수 갱신
				maxCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 회의의 최대 개수 출력
		out.write(String.valueOf(maxCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}