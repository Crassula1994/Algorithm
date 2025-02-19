package silver1.num12761;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스카이 콩콩의 힘 및 동규와 주미의 현재 위치를 각 변수에 할당
		int powerA = Integer.parseInt(st.nextToken());
		int powerB = Integer.parseInt(st.nextToken());
		int startLoc = Integer.parseInt(st.nextToken());
		int targetLoc = Integer.parseInt(st.nextToken());
		
		// 돌다리의 각 위치까지의 이동 횟수, 이동 방법을 저장할 각 배열 초기화
		Integer[] bridges = new Integer[100001];
		int[] methods = new int[] {-1, 1, -powerA, -powerB, powerA, powerB, powerA, powerB};
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<Integer> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 동규의 위치를 moveList에 추가 후 이동 횟수를 초기화
		moveList.offer(startLoc);
		bridges[startLoc] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 변수 currentLoc에 할당
			int currentLoc = moveList.poll();
			
			// 현재 위치가 주미의 현재 위치인 경우 반복문 탈출
			if (currentLoc == targetLoc)
				break;
			
			// for 반복문을 사용해 다음에 이동할 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 다음에 이동할 위치를 변수 nextLoc에 할당
				int nextLoc = (d < 6) ? currentLoc + methods[d] : currentLoc * methods[d];
				
				// 다음에 이동할 위치가 돌다리의 범위를 벗어나거나 이미 이동했던 곳인 경우 다음 위치를 순회
				if (nextLoc < 0 || nextLoc > 100000 || bridges[nextLoc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 moveList에 추가 후 이동 횟수를 갱신
				moveList.offer(nextLoc);
				bridges[nextLoc] = bridges[currentLoc] + 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 동규가 주미에게 도달하기 위한 최소 이동 횟수를 출력
		out.write(String.valueOf(bridges[targetLoc]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}