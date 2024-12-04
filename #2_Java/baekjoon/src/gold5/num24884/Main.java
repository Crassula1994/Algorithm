package gold5.num24884;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	/* 모닥불의 개수, 모닥불 놀이 시간, 유지해야 하는 최소 모닥불의 개수,
	최소 모닥불이 유지되도록 장작을 넣는 경우의 수를 저장할 각 변수 초기화 */
	static int bonfireNum;
	static int totalTime;
	static int minLimit;
	static int totalCount = 0;
	
	// SKH가 이동할 수 있는 경우의 수를 저장할 배열 direction 초기화
	static int[] direction = {-1, 0, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 모닥불의 개수, 시작 모닥불 번호, 모닥불 놀이 시간,
		유지해야 하는 최소 모닥불의 개수를 각 변수에 할당 */
		bonfireNum = Integer.parseInt(st.nextToken());
		int startBonfire = Integer.parseInt(st.nextToken());
		totalTime = Integer.parseInt(st.nextToken());
		minLimit = Integer.parseInt(st.nextToken());
		
		// 각 모닥불의 화력을 저장할 배열 bonfires 초기화
		int[] bonfires = new int[bonfireNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 모닥불의 화력을 배열 bonfires에 저장
		for (int idx = 0; idx < bonfires.length; idx++)
			bonfires[idx] = Integer.parseInt(st.nextToken());
		
		// playSimulator() 메서드를 호출해 최소 모닥불이 유지되도록 장작을 넣는 경우의 수를 갱신
		playSimulator(bonfires, 1, startBonfire);
		
		// valueOf() 및 write() 메서드를 사용해 최소 모닥불이 유지되도록 장작을 넣는 경우의 수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// playSimulator() 메서드 정의
	public static void playSimulator(int[] bonfires, int curTime, int curBonfire) {
		
		// 장작을 새로 집어 넣은 모닥불의 위치를 addedBonfire에 할당
		int addedBonfire = (curTime == 1) ? -1 : curBonfire;
		
		// 켜져 있는 모닥불의 개수가 유지해야 하는 최소 모닥불의 개수 미만인 경우 메서드 종료
		if (bonfireCounter(bonfires, addedBonfire) < minLimit)
			return;
		
		// 모닥불 놀이 시간이 끝날 때까지 도달한 경우 모닥불에 장작을 넣는 경우의 수를 갱신 후 메서드 종료
		if (curTime == totalTime) {
			totalCount++;
			return;
		}
		
		// for 반복문을 사용해 숭고한이 이동할 수 있는 각 위치를 순회
		for (int d = 0; d < 3; d++) {
			
			// SKH가 이동할 다음 모닥불의 위치를 변수 nextBonfire에 할당
			int nextBonfire = curBonfire + direction[d];
			
			// 다음 모닥불의 위치가 모닥불의 범위를 벗어나는 경우 다음 위치를 순회
			if (nextBonfire < 0 || nextBonfire >= bonfireNum)
				continue;
			
			// clone() 메서드를 사용해 다음 모닥불의 위치를 상정하고 playSimulator() 메서드 재귀 호출
			playSimulator(bonfires.clone(), curTime + 1, nextBonfire);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// bonfireCounter() 메서드 정의
	public static int bonfireCounter(int[] bonfires, int addedBonfire) {
		
		// 켜져 있는 모닥불의 개수를 저장할 변수 onCount 초기화
		int onCount = 0;
		
		// clone() 메서드를 사용해 모닥불의 화력이 변한 결과를 저장할 배열 newBonfires 초기화
		int[] newBonfires = bonfires.clone();
		
		// for 반복문을 사용해 각 모닥불을 순회
		for (int idx = 0; idx < bonfireNum; idx++) {
			
			// 현재 위치의 모닥불이 꺼져 있는 경우 다음 모닥불을 순회
			if (bonfires[idx] == 0)
				continue;
			
			// 현재 위치가 장작을 새로 집어 넣은 위치인 경우 켜져 있는 모닥불의 개수를 갱신 후 다음 모닥불을 순회
			if (idx == addedBonfire) {
				onCount++;
				continue;
			}
			
			// 해당 모닥불의 감소하는 화력을 저장할 변수 variance 초기화
			int variance = 3;
			
			// 이전 모닥불이 켜져 있는 경우 해당 모닥불의 감소하는 화력을 갱신
			if (idx > 0 && bonfires[idx - 1] > 0)
				variance--;
			
			// 다음 모닥불이 켜져 있는 경우 해당 모닥불의 감소하는 화력을 갱신
			if (idx < bonfireNum - 1 && bonfires[idx + 1] > 0)
				variance--;
			
			// max() 메서드를 사용해 해당 모닥불의 새로운 화력을 배열 newBonfires에 저장
			newBonfires[idx] = Math.max(0, bonfires[idx] - variance);
			
			// 해당 모닥불이 켜져 있는 경우 켜져 있는 모닥불의 개수를 갱신
			if (newBonfires[idx] > 0)
				onCount++;
		}
		
		// arraycopy() 메서드를 사용해 모닥불의 화력이 변한 결과를 반영
		System.arraycopy(newBonfires, 0, bonfires, 0, bonfireNum);
		
		// 켜져 있는 모닥불의 개수를 반환
		return onCount;
	}
}