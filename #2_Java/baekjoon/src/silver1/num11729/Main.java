package silver1.num11729;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {

	// 하노이의 탑 이동 경로를 저장할 List 객체 pathway 초기화
	static List<int[]> pathway;

	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 원판의 개수를 변수 diskNum에 할당
		int diskNum = Integer.parseInt(in.readLine());
		
		// 하노이의 탑 이동 횟수를 저장할 변수 moveCnt 초기화
		int moveCnt = 1;
		
		// for 반복문을 사용해 원판의 개수에 따른 이동 횟수를 갱신
		for (int n = 0; n < diskNum; n++) {
			moveCnt *= 2;
			if (n == diskNum - 1)
				moveCnt--;
		}
		
		// 하노이의 탑 이동 경로를 저장할 List 객체 pathway 초기화
		pathway = new ArrayList<>();
		
		// towerHanoi() 메서드를 호출해 이동 경로를 차례로 배열에 저장
		towerHanoi(diskNum, 1, 3, 2);
		
		// write() 메서드를 사용해 이동 횟수를 출력
		out.write(moveCnt + "\n");
		
		// for 반복문을 사용해 각 이동 경로를 차례로 출력
		for (int idx = 0; idx < moveCnt; idx++)
			out.write(pathway.get(idx)[0] + " " + pathway.get(idx)[1] + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// towerHanoi() 메서드 정의
	public static void towerHanoi(int diskNum, int start, int end, int mid) {
		
		// 원판이 1개인 경우
		if (diskNum == 1) {
			
			// 이동 경로를 담은 배열 path 초기화
			int[] path = {start, end};
	
			// add() 메서드를 사용해 pathway에 이동 경로 추가
			pathway.add(path);
			
		// 원판이 1개가 아닌 경우
		} else {
			
			// 가장 밑 원반을 제외한 다른 원반을 중간 막대로 옮기는 towerHanoi() 메서드 재귀 호출
			towerHanoi(diskNum - 1, start, mid, end);
			
			// 가장 밑 원반을 목표 막대로 옮기는 이동 경로를 담은 배열 path 초기화
			int[] path = {start, end};
			
			// add() 메서드를 사용해 pathway에 이동 경로 추가
			pathway.add(path);
			
			// 중간 막대에 있는 나머지 원반을 목표 막대로 옮기는 towerHanoi() 메서드 재귀 호출
			towerHanoi(diskNum - 1, mid, end, start);
		}
	}
}