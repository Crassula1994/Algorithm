package silver3.num14501;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 남은 일수를 변수 dayCnt에 할당
		int dayCnt = Integer.parseInt(in.readLine());
		
		// 각 날짜의 상담 정보 및 최대 이익을 저장할 각 배열 초기화
		int[][] schedule = new int[dayCnt + 1][2];
		int[] maxProfits = new int[dayCnt + 2];
		
		// for 반복문을 사용해 입력 받은 각 날짜의 상담 정보를 순회
		for (int idx = 1; idx <= dayCnt; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 정보를 2차원 배열 schedule에 저장
			schedule[idx][0] = Integer.parseInt(st.nextToken());
			schedule[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 날짜를 순회
		for (int day = dayCnt; day > 0; day--) {
			
			// 해당 날짜의 상담을 진행했을 때 끝나는 날을 계산해 변수 endDate에 할당
			int endDate = day + schedule[day][0] - 1;
			
			// 해당 날짜를 선택할 수 없는 경우 최대 이익을 갱신
			if (endDate > dayCnt) {
				maxProfits[day] = maxProfits[day + 1];
			
			// 해당 날짜를 선택할 수 있는 경우 최대 이익을 갱신
			} else {
				maxProfits[day] = Math.max(maxProfits[day + 1], maxProfits[endDate + 1] + schedule[day][1]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 백준이가 얻을 수 있는 최대 이익을 출력
		out.write(String.valueOf(maxProfits[1]));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}