package gold4.num25330;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 몬스터의 수, 시루가 해방시킬 수 있는 주민들의 최대 수를 저장할 각 변수 초기화
	static int monsterNum;
	static int maxNumber = 0;
	
	// 각 마을을 시루가 방문했는지 여부를 저장할 배열 visited 초기화
	static boolean[] visited;
	
	// 각 마을에 있는 몬스터의 공격력 및 주민의 수를 저장할 2차원 배열 towns 초기화
	static int[][] towns;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 몬스터의 수 및 시루의 초기 체력을 각 변수에 할당
		monsterNum = Integer.parseInt(st.nextToken());
		int startEnergy = Integer.parseInt(st.nextToken());
		
		// 각 마을을 시루가 방문했는지 여부를 저장할 배열 visited 초기화
		visited = new boolean[monsterNum + 1];
		
		// 각 마을에 있는 몬스터의 공격력 및 주민의 수를 저장할 2차원 배열 towns 초기화
		towns = new int[monsterNum + 1][2];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 마을에 있는 몬스터의 공격력을 2차원 배열 towns에 저장
		for (int idx = 1; idx <= monsterNum; idx++)
			towns[idx][0] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 마을에 있는 주민의 수를 2차원 배열 towns에 저장
		for (int idx = 1; idx <= monsterNum; idx++)
			towns[idx][1] = Integer.parseInt(st.nextToken());
		
		// gameSimulator() 메서드를 호출해 시루가 해방시킬 수 있는 주민들의 최대 수를 갱신
		gameSimulator(startEnergy, 0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 시루가 해방시킬 수 있는 주민들의 최대 수를 출력
		out.write(String.valueOf(maxNumber));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gameSimulator() 메서드 정의
	public static void gameSimulator(int curEnergy, int residentSum, int damageSum) {
		
		// max() 메서드를 사용해 시루가 해방시킬 수 있는 주민들의 최대 수를 갱신
		maxNumber = Math.max(residentSum, maxNumber);
		
		// 앞으로 더 해방시킬 수 있는 주민들의 수를 저장할 변수 remains 초기화
		int remains = 0;
		
		// for 반복문을 사용해 각 마을을 순회
		for (int idx = 1; idx <= monsterNum; idx++) {
			
			// 해당 마을을 이미 방문했거나 현재 체력으로 해당 마을을 방문할 수 없는 경우 다음 마을을 순회
			if (visited[idx] || curEnergy < damageSum + towns[idx][0])
				continue;
			
			// 앞으로 더 해방시킬 수 있는 주민들의 수를 갱신
			remains += towns[idx][1];
		}
		
		// 앞으로 더 해방시킬 수 있는 주민들의 수를 더해도 저장된 해방시킬 수 있는 주민들의 최대 수보다 적은 경우 메서드 종료
		if (residentSum + remains <= maxNumber)
			return;
		
		// for 반복문을 사용해 각 마을을 순회
		for (int idx = 1; idx <= monsterNum; idx++) {
			
			// 해당 마을을 이미 방문했거나 현재 체력으로 해당 마을을 방문할 수 없는 경우 다음 마을을 순회
			if (visited[idx] || curEnergy < damageSum + towns[idx][0])
				continue;
			
			// 해당 마을을 방문 처리
			visited[idx] = true;
			
			// 해당 마을을 방문한 것으로 상정해 gameSimulator() 메서드 재귀 호출
			gameSimulator(curEnergy - damageSum - towns[idx][0], residentSum + towns[idx][1], damageSum + towns[idx][0]);
			
			// 해당 마을을 방문하지 않은 것으로 원상 복구
			visited[idx] = false;
		}
	}
}