package silver2.num05567;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 상근이의 동기 수, 친구 관계 리스트의 길이를 각 변수에 할당
		int alumnusNum = Integer.parseInt(in.readLine());
		int listLen = Integer.parseInt(in.readLine());
		
		// 초대하는 동기의 수를 저장할 변수 count 초기화
		int count = -1;
		
		// 각 친구의 초대 확인 여부를 저장할 배열 checked 초기화
		boolean[] checked = new boolean[alumnusNum + 1];
		
		// 친구 관계를 저장할 배열 freindship 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] friendship = new ArrayList[alumnusNum + 1];
		
		// for 반복문을 사용해 친구 관계를 저장할 List 객체 초기화
		for (int idx = 0; idx < friendship.length; idx++)
			friendship[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 친구 관계 리스트를 순회
		for (int l = 0; l < listLen; l++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 친구 관계의 구성원을 각 변수에 할당
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 입력 받은 친구 관계를 friendship에 추가
			friendship[friend1].add(friend2);
			friendship[friend2].add(friend1);
		}
		
		// 다음에 확인할 동기를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 상근이를 checkList에 추가 후 상근이의 학번을 확인 처리
		checkList.offer(new int[] {1, 0});
		checked[1] = true;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 동기를 배열 alumnusInfo에 할당
			int[] alumnusInfo = checkList.poll();
			
			// 동기의 학번과 관계의 깊이를 각 변수에 할당
			int curAlumnus = alumnusInfo[0];
			int relationship = alumnusInfo[1];
			
			// 현재 확인 중인 동기가 친구의 친구보다 먼 경우 반복문 탈출
			if (relationship > 2)
				break;
			
			// 초대하는 동기의 수를 갱신
			count++;
			
			// for 반복문을 사용해 해당 동기의 각 친구 관계를 순회
			for (int nextAlumnus : friendship[curAlumnus]) {
				
				// 현재 확인 중인 친구를 이미 확인한 경우 다음 친구를 순회
				if (checked[nextAlumnus])
					continue;
				
				// offer() 메서드를 사용해 친구를 checkList에 추가 후 친구의 학번을 확인 처리
				checkList.offer(new int[] {nextAlumnus, relationship + 1});
				checked[nextAlumnus] = true;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 초대하는 동기의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}