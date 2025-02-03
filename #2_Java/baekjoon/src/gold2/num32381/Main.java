package gold2.num32381;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Action 클래스 정의
	static class Action {
		
		// 병윤이가 뒤집은 줄의 종류와 번호를 저장할 각 변수 초기화
		char category;
		long number;
		
		// 매개변수를 입력 받는 생성자 정의
		public Action(char category, long number) {
			this.category = category;
			this.number = number;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자판의 크기와 병윤이의 행동 수를 각 변수에 할당
		long size = Integer.parseInt(st.nextToken());
		int actionNum = Integer.parseInt(st.nextToken());
		
		// 병윤이의 행동으로 주어진 수열을 구성할 수 있는지 여부, 이전의 검은색 칸의 개수, 뒤집은 행과 열의 수를 나타낼 각 변수 초기화
		boolean isPossible = true;
		long prevCount = 0;
		long rowCount = 0;
		long columnCount = 0;
		
		// 병윤이가 수행한 행동을 저장할 배열 actions 초기화
		Action[] actions = new Action[actionNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 병윤이가 외친 검은색 칸의 개수를 순회
		for (int idx = 0; idx < actions.length; idx++) {
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 검은색 칸의 개수를 변수 curCount에 할당
			long curCount = Long.parseLong(st.nextToken());
			
			// 새로운 행을 뒤집어 해당 검은색 칸의 개수를 만들 수 있는 경우 병윤이의 행동을 배열 actions에 저장
			if (rowCount < size && prevCount + size - 2 * columnCount == curCount) {
				actions[idx] = new Action('R', ++rowCount);
				
			// 기존에 뒤집힌 행을 거꾸로 뒤집어 해당 검은색 칸의 개수를 만들 수 있는 경우 병윤이의 행동을 배열 actions에 저장
			} else if (rowCount > 0 && prevCount - size + 2 * columnCount == curCount) {
				actions[idx] = new Action('R', rowCount--);
				
			// 새로운 열을 뒤집어 해당 검은색 칸의 개수를 만들 수 있는 경우 병윤이의 행동을 배열 actions에 저장
			} else if (columnCount < size && prevCount + size - 2 * rowCount == curCount) {
				actions[idx] = new Action('C', ++columnCount);
				
			// 기존에 뒤집힌 열을 거꾸로 뒤집어 해당 검은색 칸의 개수를 만들 수 있는 경우 병윤이의 행동을 배열 actions에 저장
			} else if (columnCount > 0 && prevCount - size + 2 * rowCount == curCount) {
				actions[idx] = new Action('C', columnCount--);
				
			// 해당 검은색 칸의 개수를 만들 수 없는 경우 병윤이의 행동으로 주어진 수열을 구성할 수 있는지 여부를 갱신 후 반복문 탈출
			} else {
				isPossible = false;
				break;
			}
			
			// 이전의 검은색 칸의 개수를 갱신
			prevCount = curCount;
		}
		
		// 병윤이의 행동으로 주어진 수열을 구성할 수 없는 경우 -1을 출력
		if (!isPossible) {
			out.write(String.valueOf(-1));
			
		// 병윤이의 행동으로 주어진 수열을 구성할 수 있는 경우
		} else {
			
			// for 반복문을 사용해 병윤이가 수행한 행동을 출력
			for (Action action : actions)
				out.write(action.category + " " + action.number + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}