package bronze1.num01296;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// Team 클래스 정의
	public static class Team implements Comparable<Team> {
		
		// 팀의 이름과 우승 확률을 저장할 각 변수 초기화
		String name;
		int odds;
		
		// 인자를 입력 받는 생성자 정의
		public Team(String name, int odds) {
			this.name = name;
			this.odds = odds;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Team anotherTeam) {
			
			// 우승할 확률이 같은 경우 팀 이름 중 사전 순으로 가장 앞서는 순서대로 정렬
			if (odds == anotherTeam.odds)
				return name.compareTo(anotherTeam.name);
			
			// 우승할 확률이 가장 높은 순서대로 정렬
			return anotherTeam.odds - odds;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 이용해 입력 받은 연두의 이름을 변수 name에 할당
		String name = in.readLine();
		
		// 연두의 이름에서 등장하는 각 알파벳의 개수를 저장할 Map 객체 nameCounter 초기화
		Map<Character, Integer> nameCounter = new HashMap<>();
		
		// for 반복문을 사용해 연두의 영어 이름의 각 알파벳을 순회
		for (int idx = 0; idx < name.length(); idx++) {
			
			// charAt() 메서드를 사용해 알파벳을 변수 alphabet에 할당
			char alphabet = name.charAt(idx);
			
			// 해당 알파벳이 'L', 'O', 'V', 'E'인 경우 해당 알파벳의 개수를 nameCounter에 저장
			if (alphabet == 'L' || alphabet == 'O' || alphabet == 'V' || alphabet == 'E')
				nameCounter.put(alphabet, nameCounter.getOrDefault(alphabet, 0) + 1);
		}
		
		// 우승할 확률이 높은 순서대로 팀을 저장할 PriorityQueue 객체 teamSorter 초기화
		PriorityQueue<Team> teamSorter = new PriorityQueue<>();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 팀의 개수를 변수 teamNum에 할당
		int teamNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 팀의 이름을 차례로 순회
		for (int t = 0; t < teamNum; t++) {
			
			// readLine() 메서드를 사용해 입력 받은 팀 이름을 변수 teamName에 할당
			String teamName = in.readLine();
			
			// 팀 이름에서 등장하는 각 알파벳의 개수를 저장할 Map 객체 teamNameCounter 초기화
			Map<Character, Integer> teamNameCounter = new HashMap<>();
			
			// for 반복문을 사용해 팀 이름의 각 알파벳을 순회
			for (int idx = 0; idx < teamName.length(); idx++) {
				
				// charAt() 메서드를 사용해 알파벳을 변수 alphabet에 할당
				char alphabet = teamName.charAt(idx);
				
				// 해당 알파벳이 'L', 'O', 'V', 'E'인 경우 해당 알파벳의 개수를 teamNameCounter에 저장
				if (alphabet == 'L' || alphabet == 'O' || alphabet == 'V' || alphabet == 'E')
					teamNameCounter.put(alphabet, teamNameCounter.getOrDefault(alphabet, 0) + 1);
			}
			
			// getOrDefault() 메서드를 사용해 우승할 확률 계산에 필요한 각 변수를 초기화
			int pointL = nameCounter.getOrDefault('L', 0) + teamNameCounter.getOrDefault('L', 0);
			int pointO = nameCounter.getOrDefault('O', 0) + teamNameCounter.getOrDefault('O', 0);
			int pointV = nameCounter.getOrDefault('V', 0) + teamNameCounter.getOrDefault('V', 0);
			int pointE = nameCounter.getOrDefault('E', 0) + teamNameCounter.getOrDefault('E', 0);
			
			// 우승 확률을 계산해 변수 odds에 할당
			int odds = ((pointL + pointO) * (pointL + pointV) * (pointL + pointE) * (pointO + pointV)
					* (pointO + pointE) * (pointV + pointE)) % 100;
			
			// add() 메서드를 사용해 해당 팀을 teamSorter에 추가
			teamSorter.add(new Team(teamName, odds));
		}
		
		// poll() 및 write() 메서드를 사용해 우승할 확률이 가장 높은 팀 이름을 출력
		out.write(teamSorter.poll().name);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}