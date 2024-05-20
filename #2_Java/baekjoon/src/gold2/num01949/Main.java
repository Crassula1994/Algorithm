package gold2.num01949;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 마을의 주민 수, 우수 마을 선정 확인 여부, 마을 사이 길의 정보를 저장할 각 배열 초기화
	static int[] residents;
	static boolean[] checked;
	static List<Integer>[] roads;
	
	// 해당 마을의 선정 여부에 따른 최대 주민 수를 저장할 2차원 배열 maxResidents 초기화
	static int[][] maxResidents;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 마을의 수를 변수 townNum에 할당
		int townNum = Integer.parseInt(in.readLine());
		
		// 각 마을의 주민 수, 우수 마을 선정 확인 여부, 마을 사이 길의 정보를 저장할 각 배열 초기화
		residents = new int[townNum + 1];
		checked = new boolean[townNum + 1];
		roads = new ArrayList[townNum + 1];
		
		// for 반복문을 사용해 마을 사이 길의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < roads.length; idx++)
			roads[idx] = new ArrayList<>();
		
		// 해당 마을의 선정 여부에 따른 최대 주민 수를 저장할 2차원 배열 maxResidents 초기화
		maxResidents = new int[townNum + 1][2];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 마을의 주민 수를 배열 residents에 저장
		for (int idx = 1; idx < residents.length; idx++)
			residents[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 입력 받은 각 마을 사이 길의 정보를 순회
		for (int road = 0; road < townNum - 1; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 길이 연결하는 각 마을을 각 변수에 할당
			int startTown = Integer.parseInt(st.nextToken());
			int endTown = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 길의 정보를 배열 roads에 추가
			roads[startTown].add(endTown);
			roads[endTown].add(startTown);
		}
		
		// townSelector() 메서드를 호출해 우수 마을의 주민 수의 총합을 갱신
		townSelector(1);
		
		// max(), valueOf(), write() 메서드를 사용해 우수 마을의 주민 수의 총합을 출력
		out.write(String.valueOf(Math.max(maxResidents[1][0], maxResidents[1][1])));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// townSelector() 메서드 정의
	public static void townSelector(int curTown) {

		// 해당 마을을 이미 확인한 경우 메서드 종료
		if (checked[curTown])
			return;
		
		// 해당 마을의 선정 여부에 따른 우수 마을의 주민 수를 초기화
		maxResidents[curTown][1] = residents[curTown];
		
		// 해당 마을의 선정 여부를 확인한 것으로 처리
		checked[curTown] = true;
		
		// for 반복문을 사용해 인접한 마을을 순회
		for (int nextTown : roads[curTown]) {
			
			// 해당 마을을 이미 확인한 경우 다음 마을을 순회
			if (checked[nextTown])
				continue;
			
			// townSelector() 메서드 재귀 호출
			townSelector(nextTown);
			
			// max() 메서드를 사용해 해당 마을의 선정 여부에 따른 우수 마을의 주민 수를 갱신
			maxResidents[curTown][0] += Math.max(maxResidents[nextTown][0], maxResidents[nextTown][1]);
			maxResidents[curTown][1] += maxResidents[nextTown][0];
		}
	}
}