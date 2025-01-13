package silver2.num03758;

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
	
	// Team 클래스 정의
	static class Team implements Comparable<Team> {
		
		// 팀 ID, 획득한 점수, 제출 횟수, 마지막 제출 시간을 저장할 각 변수 초기화
		int id;
		int totalScore;
		int submitCount;
		int lastSubmit;
		
		// 각 문제별 획득한 점수를 저장할 배열 scores 초기화
		int[] scores;
		
		// 매개변수를 입력 받는 생성자 정의
		public Team(int id, int questionNum) {
			this.id = id;
			this.totalScore = 0;
			this.submitCount = 0;
			this.lastSubmit = 0;
			this.scores = new int[questionNum + 1];
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Team anotherTeam) {
			
			// 팀의 점수가 다른 경우 팀의 점수가 더 높은 순서대로 정렬
			if (this.totalScore != anotherTeam.totalScore)
				return anotherTeam.totalScore - this.totalScore;
			
			// 제출 횟수가 다른 경우 제출 횟수가 더 적은 순서대로 정렬
			if (this.submitCount != anotherTeam.submitCount)
				return this.submitCount - anotherTeam.submitCount;
			
			// 마지막 제출 시간이 빠른 순서대로 정렬
			return this.lastSubmit - anotherTeam.lastSubmit;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 데이터의 개수를 변수 testData에 할당
		int testData = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 데이터를 순회
		while (testData-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 팀의 개수, 문제의 개수, 목표 팀의 ID,
			로그 엔트리의 개수를 각 변수에 할당 */
			int teamNum = Integer.parseInt(st.nextToken());
			int questionNum = Integer.parseInt(st.nextToken());
			int targetId = Integer.parseInt(st.nextToken());
			int logNum = Integer.parseInt(st.nextToken());
			
			// 각 팀의 정보를 저장할 배열 teams 초기화
			Team[] teams = new Team[teamNum];
			
			// for 반복문을 사용해 각 팀의 정보를 초기화
			for (int idx = 0; idx < teams.length; idx++)
				teams[idx] = new Team(idx + 1, questionNum);
			
			// for 반복문을 사용해 각 로그를 순회
			for (int time = 1; time <= logNum; time++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 팀 ID, 문제 번호, 획득 점수를 각 변수에 할당
				int id = Integer.parseInt(st.nextToken());
				int question = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				
				// max() 메서드를 사용해 해당 팀의 해당 문제에 대한 획득 점수를 갱신
				teams[id - 1].scores[question] = Math.max(score, teams[id - 1].scores[question]);
				
				// 해당 팀의 제출 횟수 및 마지막 제출 시간을 갱신
				teams[id - 1].submitCount++;
				teams[id - 1].lastSubmit = time;
			}
			
			// for 반복문을 사용해 각 팀을 순회
			for (Team team : teams) {
				
				// for 반복문을 사용해 해당 팀이 획득한 점수를 갱신
				for (int idx = 1; idx <= questionNum; idx++)
					team.totalScore += team.scores[idx];
			}
			
			// sort() 메서드를 사용해 각 팀을 순위 순서대로 정렬
			Arrays.sort(teams);
			
			// for 반복문을 사용해 각 팀을 순회
			for (int idx = 0; idx < teams.length; idx++) {
				
				// 해당 팀이 목표 팀인 경우 목표 팀의 순위를 출력
				if (teams[idx].id == targetId)
					out.write((idx + 1) + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}