package silver1.num01389;

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
	
	// 유저의 수를 저장할 변수 userNum 초기화
	static int userNum;
	
	// 친구 관계의 연결 정보를 저장할 2차원 배열 friendships 초기화
	static boolean[][] friendships;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 유저의 수 및 친구 관계의 수를 각 변수에 할당
		userNum = Integer.parseInt(st.nextToken());
		int relationNum = Integer.parseInt(st.nextToken());
		
		// 친구 관계의 연결 정보를 저장할 2차원 배열 friendships 초기화
		friendships = new boolean[userNum + 1][userNum + 1];
		
		// 각 유저의 케빈 베이컨 수를 저장할 배열 kevinBacons 초기화
		int[] kevinBacons = new int[userNum + 1];
		
		// for 반복문을 사용해 입력 받은 각 친구 관계를 순회
		for (int relation = 0; relation < relationNum; relation++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 친구 관계를 배열 frinedships에 저장
			int fromUser = Integer.parseInt(st.nextToken());
			int toUser = Integer.parseInt(st.nextToken());
			friendships[fromUser][toUser] = true;
			friendships[toUser][fromUser] = true;			
		}
		
		// for 반복문을 사용해 각 유저를 순회
		for (int start = 1; start <= userNum; start++) {
			
			// for 반복문을 사용해 다른 유저를 순회
			for (int target = start + 1; target <= userNum; target++) {
			
				// kevinBaconCalculator() 메서드를 호출해 각 사람의 케빈 베이컨 수를 계산 후 변수 result에 할당
				int result = kevinBaconCalculator(start, target);
				
				// 각 사람의 케빈 베이컨 수를 갱신
				kevinBacons[start] += result;
				kevinBacons[target] += result;
			}
		}
		
		// 최소의 케빈 베이컨 수와 해당 유저를 저장할 각 변수 초기화
		int minKevinBacons = Integer.MAX_VALUE;
		int minUser = 0;
		
		// for 반복문을 사용해 배열 kevinBacons의 각 원소를 순회
		for (int idx = 1; idx < kevinBacons.length; idx++) {
			
			// 해당 값이 최소의 케빈 베이컨 수인 경우 최소의 케빈 베이컨 수 및 해당 유저 갱신
			if (kevinBacons[idx] < minKevinBacons) {
				minKevinBacons = kevinBacons[idx];
				minUser = idx;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 케빈 베이컨 수가 가장 작은 사람을 출력
		out.write(String.valueOf(minUser));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// kevinBaconCalculator() 메서드 정의
	public static int kevinBaconCalculator(int startUser, int targetUser) {
		
		// 해당 친구의 통과 여부를 저장할 배열 passed 초기화
		Integer[] passed = new Integer[userNum + 1];
		
		// 다음에 방문할 친구를 저장할 Queue 객체 passList 초기화
		Queue<Integer> passList = new LinkedList<>(); 
		
		// offer() 메서드를 사용해 passList에 추가 및 시작 유저 통과 처리
		passList.offer(startUser);
		passed[startUser] = 0;
		
		// while 반복문을 사용해 passList가 빌 때까지 순회
		while (!passList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 통과 중인 유저를 변수 currentUser에 할당
			int currentUser = passList.poll();
			
			// 해당 유저가 목표로 하는 유저인 경우 반복문 탈출
			if (currentUser == targetUser)
				break;
			
			// for 반복문을 사용해 해당 유저와 연결되어 있는 다른 유저를 순회
			for (int user = 1; user <= userNum; user++) {
				
				// 해당 유저와 연결되어 있고 통과하지 않은 경우
				if (friendships[currentUser][user] && passed[user] == null) {
					
					// offer() 메서드를 사용해 passList에 추가 및 해당 유저 통과 처리
					passList.offer(user);
					passed[user] = passed[currentUser] + 1;
				}
			}
		}
		
		// 해당 유저까지의 최단 거리를 반환
		return passed[targetUser];
	}
}