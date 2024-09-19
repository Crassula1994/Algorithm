package silver1.num17875;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구단주의 수 및 각 팀의 크기를 각 변수에 할당
		int ownerNum = Integer.parseInt(st.nextToken());
		int teamSize = Integer.parseInt(st.nextToken());
		
		// 각 팀에서 뽑은 선수들의 목록을 차례로 저장할 2차원 배열 teams 초기화
		String[][] teams = new String[ownerNum][teamSize];
		
		// 각 구단주의 선수 우선순위 목록을 저장할 배열 prefList 초기화
		Queue<String>[] prefList = new LinkedList[ownerNum];
		
		// 지난 해 선수 순위를 저장할 Queue 객체 rankings 초기화
		Queue<String> rankings = new LinkedList<>();
		
		// 이미 다른 팀에 뽑힌 선수를 저장할 Set 객체 selected 초기화
		Set<String> selected = new HashSet<>();
		
		// for 반복문을 사용해 각 구단주를 순회
		for (int idx = 0; idx < prefList.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 선수 우선순위 목록의 크기를 변수 listSize에 할당
			int listSize = Integer.parseInt(st.nextToken());
			
			// 해당 구단주의 선호 리스트를 저장할 Queue 객체 초기화
			prefList[idx] = new LinkedList<>();
			
			// while 반복문을 사용해 입력 받은 선수 우선순위 목록을 배열 prefList에 저장
			while (listSize-- > 0)
				prefList[idx].add(st.nextToken());
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선수들의 수를 변수 playerNum에 할당
		int playerNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 입력 받은 지난 해 선수 순위를 rankings에 저장
		while (playerNum-- > 0)
			rankings.add(in.readLine());
		
		// for 반복문을 사용해 각 드래프트 차례를 순회
		for (int player = 0; player < teamSize; player++) {
			
			// for 반복문을 사용해 각 팀을 순회
			for (int owner = 0; owner < ownerNum; owner++) {
				
				// while 반복문을 사용해 해당 팀의 우선순위 목록에서 이미 뽑힌 선수들을 제거
				while (!prefList[owner].isEmpty() && selected.contains(prefList[owner].peek()))
					prefList[owner].poll();
			
				// 해당 팀의 우선순위 목록에서 뽑을 선수가 존재하는 경우 해당 선수를 2차원 배열 teams에 저장
				if (!prefList[owner].isEmpty()) {
					teams[owner][player] = prefList[owner].poll();
					
				// 해당 팀의 우선순위 목록에서 뽑을 선수가 존재하지 않는 경우
				} else {
					
					// while 반복문을 사용해 지난 해의 랭킹 목록에서 이미 뽑힌 선수들을 제거
					while (selected.contains(rankings.peek()))
						rankings.poll();
					
					// poll() 메서드를 사용해 해당 선수를 2차원 배열 teams에 저장
					teams[owner][player] = rankings.poll();
				}
				
				// add() 메서드를 사용해 선택된 선수를 selected에 추가
				selected.add(teams[owner][player]);
			}
		}
		
		// for 반복문을 사용해 각 팀에 뽑힌 선수를 차례로 출력
		for (int owner = 0; owner < ownerNum; owner++) {
			for (String player : teams[owner])
				out.write(player + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}