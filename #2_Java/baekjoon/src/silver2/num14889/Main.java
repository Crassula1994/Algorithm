package silver2.num14889;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 능력치를 저장할 2차원 배열 abilities 초기화
	static int[][] abilities;
	
	// 해당 사람의 선택 여부를 저장할 배열 selected 초기화
	static boolean[] selected;
	
	// 두 팀 사이 점수의 최솟값을 저장할 변수 minDifference 초기화
	static int minDifference = Integer.MAX_VALUE;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 모인 사람의 수를 변수 personNum에 할당
		int personNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 능력치를 저장할 2차원 배열 abilities 초기화
		abilities = new int[personNum][personNum];
		
		// 해당 사람의 선택 여부를 저장할 배열 selected 초기화
		selected = new boolean[personNum];
		
		// for 반복문을 사용해 배열 abilities의 각 행을 순회
		for (int r = 0; r < personNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 능력치를 배열 abilities에 저장
			for (int c = 0; c < personNum; c++)
				abilities[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// teamMaker() 메서드를 호출해 두 팀간 능력치 차이의 최솟값을 갱신
		teamMaker(0, 0, out);
		
		// valueOf() 및 write() 메서드를 사용해 두 팀간 능력치 차이의 최솟값을 출력
		out.write(String.valueOf(minDifference));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// teamMaker() 메서드 정의
	public static void teamMaker(int startIdx, int selectedNum, BufferedWriter out) throws IOException {
		
		// 모든 선택이 끝난 경우
		if (selectedNum == abilities.length / 2) {
			
			// 팀 스타트와 팀 링크의 각 능력치를 저장할 각 변수 초기화
			int startAbility = 0;
			int linkAbility = 0;
			
			// 각 팀의 구성원을 저장할 배열 초기화
			int[] startTeam = new int[abilities.length / 2];
			int[] linkTeam = new int[abilities.length / 2];
			
			// for 반복문을 사용해 배열 selected를 순회
			for (int idx = 0, sIdx = 0, lIdx = 0; idx < selected.length; idx++) {
				
				// 팀 스타트인 경우 배열 startTeam에 저장
				if (selected[idx]) {
					startTeam[sIdx++] = idx;

				// 팀 링크인 경우 배열 linkTeam에 저장
				} else {
					linkTeam[lIdx++] = idx;
				}
			}
			
			// for 반복문을 사용해 팀 스타트의 각 사람을 순회
			for (int i = 0; i < startTeam.length - 1; i++) {
				
				// for 반복문을 사용해 팀 스타트의 다음 사람을 순회
				for (int j = i + 1; j < startTeam.length; j++) {
					
					// 팀 스타트의 능력치 갱신
					startAbility += abilities[startTeam[i]][startTeam[j]];
					startAbility += abilities[startTeam[j]][startTeam[i]];
				}
			}
			
			// for 반복문을 사용해 팀 링크의 각 사람을 순회
			for (int i = 0; i < linkTeam.length - 1; i++) {
				
				// for 반복문을 사용해 팀 링크의 다음 사람을 순회
				for (int j = i + 1; j < linkTeam.length; j++) {
					
					// 팀 링크의 능력치 갱신
					linkAbility += abilities[linkTeam[i]][linkTeam[j]];
					linkAbility += abilities[linkTeam[j]][linkTeam[i]];
				}
			}
			
			// 두 팀 사이의 능력치 차이를 계산해 변수 difference에 할당
			int difference = Math.abs(startAbility - linkAbility);
			
			// 차이가 0인 경우
			if (difference == 0) {
				
				// valueOf() 및 write() 메서드를 사용해 차이를 출력
				out.write(String.valueOf(difference));
				
				// flush() 메서드를 사용해 지금까지의 내용을 출력
				out.flush();
				
				// exit() 메서드를 사용해 JVM 정상 종료
				System.exit(0);
			}
			
			// 두 팀 사이의 능력치 차이가 저장된 최소 능력치 차이보다 작은 경우 최소 능력치 차이 갱신
			minDifference = (difference < minDifference) ? difference : minDifference;

		// 모든 선택이 끝나지 않은 경우
		} else {
			
			// for 반복문을 사용해 각 사람을 순회
			for (int i = startIdx; i < abilities.length; i++) {
				
				// 해당 사람을 선택하지 않은 경우
				if (!selected[i]) {
					
					// 해당 사람 선택 처리
					selected[i] = true;
					
					// teamMaker() 메서드 재귀 호출
					teamMaker(i + 1, selectedNum + 1, out);
					
					// 선택 처리한 사람 원래 상태로 복구
					selected[i] = false;
				}
			}
		}
	}
}