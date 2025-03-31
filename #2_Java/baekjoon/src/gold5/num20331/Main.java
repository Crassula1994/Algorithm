package gold5.num20331;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 참가 팀의 수 및 대회 문제의 수를 각 변수에 할당
		int teamNum = Integer.parseInt(st.nextToken());
		int problemNum = Integer.parseInt(st.nextToken());
		
		// 각 팀이 푼 문제의 수가 불명확한지 여부를 저장할 변수 isAmbiguous 초기화
		boolean isAmbiguous = false;
		
		// 각 순위의 팀의 점수와 푼 문제의 수를 저장할 각 배열 초기화
		int[] scores = new int[teamNum];
		int[] counts = new int[teamNum];
		
		// for 반복문을 사용해 각 팀을 순회
		for (int idx = 0; idx < teamNum; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 현재 순위의 팀의 시간 점수를 배열 scores에 저장
			scores[idx] = Integer.parseInt(in.readLine());
			
			// 현재 순위의 팀의 시간 점수가 0인 경우
			if (scores[idx] == 0) {
				
				// 해당 팀이 푼 문제의 수를 배열 counts에 저장
				counts[idx] = 0;
				
				// 현재 팀이 푼 문제의 수가 불명확한 경우 각 팀이 푼 문제의 수가 불명확한지 여부를 갱신 후 반복문 탈출
				if (idx > 0 && counts[idx - 1] > 1) {
					isAmbiguous = true;
					break;
				}
				
			// 첫 번째 순위의 팀인 경우 해당 팀이 푼 문제의 수를 배열 counts에 저장
			} else if (idx == 0) {
				counts[idx] = problemNum;
	
			// 첫 번째 순위 이후 팀인 경우 해당 팀이 푼 문제의 수를 배열 counts에 저장
			} else {
				counts[idx] = (scores[idx] >= scores[idx - 1]) ? counts[idx - 1] : counts[idx - 1] - 1;
			}
		}
		
		// 각 팀이 푼 문제의 수가 불명확한 경우 'ambiguous' 출력
		if (counts[teamNum - 1] > 1 || isAmbiguous) {
			out.write("ambiguous");
			
		// 각 팀이 푼 문제의 수가 명확한 경우
		} else {
			
			// for 반복문을 사용해 각 팀이 푼 문제의 수를 출력
			for (int count : counts)
				out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}