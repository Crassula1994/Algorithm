package silver4.num31301;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Team 클래스 정의
	static class Team implements Comparable<Team> {
		
		// 팀의 ID, 순위를 저장할 각 변수 초기화
		int id;
		int rank;
		
		// 매개변수를 입력 받는 생성자 정의
		public Team(int id, int rank) {
			this.id = id;
			this.rank = rank;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Team anotherTeam) {
			
			// 순위를 기준으로 순위가 높은 순으로 정렬
			return this.rank - anotherTeam.rank;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 대회에 참가한 팀의 수,
		다음 단계에 진출할 팀의 수, 학교 당 진출할 수 있는 팀 수 제한을 각 변수에 할당 */
		int curTeamCnt = Integer.parseInt(st.nextToken());
		int nextTeamCnt = Integer.parseInt(st.nextToken());
		int schoolLimit = Integer.parseInt(st.nextToken());
		
		// 학교별 다음 단계에 진출한 팀의 수를 저장할 Map 객체 schoolCounts 초기화
		Map<Integer, Integer> schoolCounts = new HashMap<>();
		
		// 다음 단계에 진출한 팀과 그렇지 못한 팀을 저장할 각 List 객체 초기화
		List<Team> qualifier = new ArrayList<>();
		List<Team> nonQualifier = new ArrayList<>();
		
		// for 반복문을 사용해 각 팀을 순위 순서대로 순회
		for (int rank = 1; rank <= curTeamCnt; rank++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 팀의 ID와 소속 학교를 각 변수에 할당
			int id = Integer.parseInt(st.nextToken());
			int school = Integer.parseInt(st.nextToken());
			
			// 다음 단계에 진출할 수 있는 경우 
			if (qualifier.size() < nextTeamCnt && schoolCounts.getOrDefault(school, 0) < schoolLimit) {
				
				// add() 메서드를 사용해 해당 팀의 정보를 qualifier에 저장
				qualifier.add(new Team(id, rank));
				
				// getOrDefault() 및 put() 메서드를 사용해 학교별 다음 단계에 진출한 팀의 수를 갱신
				schoolCounts.put(school, schoolCounts.getOrDefault(school, 0) + 1);
				
			// 다음 단계에 진출할 수 없는 경우 해당 팀의 정보를 nonQualifier에 저장
			} else {
				nonQualifier.add(new Team(id, rank));
			}
		}
		
		// size() 메서드를 사용해 부족한 팀의 수를 변수 remains에 할당
		int remains = nextTeamCnt - qualifier.size();
		
		// for 반복문을 사용해 다음 단계에 진출할 팀이 부족한 경우 나머지 팀을 추가로 qualifier에 저장
		for (int idx = 0; idx < remains; idx++)
			qualifier.add(nonQualifier.get(idx));
		
		// sort() 메서드를 사용해 다음 단계에 진출할 팀을 순위대로 정렬
		Collections.sort(qualifier);
		
		// for 반복문을 사용해 다음 단계에 진출한 팀의 ID를 순위대로 출력
		for (Team team : qualifier)
			out.write(team.id + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}