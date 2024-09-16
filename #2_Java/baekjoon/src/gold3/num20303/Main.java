package gold3.num20303;

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
	
	// Group 클래스 정의
	static class Group {
		
		// 그룹에 속한 아이들의 수 및 총 사탕의 개수를 저장할 각 변수 초기화
		int childNum;
		int candyNum;
		
		// 매개변수를 입력 받는 생성자 정의
		public Group(int childNum, int candyNum) {
			this.childNum = childNum;
			this.candyNum = candyNum;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// 각 아이들이 가진 사탕의 수, 친구 관계, 그룹의 확인 여부를 저장할 각 배열 초기화
	static int[] candies;
	static List<Integer>[] friendships;
	static boolean[] grouped;
	
	// 각 아이들의 그룹을 저장할 List 객체 groups 초기화
	static List<Group> groups = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 아이들의 수, 아이들의 친구 관계 수,
		울음소리가 공명하기 위한 최소 아이의 수를 각 변수에 할당 */
		int childNum = Integer.parseInt(st.nextToken());
		int friendshipNum = Integer.parseInt(st.nextToken());
		int minLimit = Integer.parseInt(st.nextToken());
		
		// 각 아이들이 가진 사탕의 수, 친구 관계, 그룹의 확인 여부를 저장할 각 배열 초기화
		candies = new int[childNum + 1];
		friendships = new ArrayList[childNum + 1];
		grouped = new boolean[childNum + 1];
		
		// for 반복문을 사용해 친구 관계를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < friendships.length; idx++)
			friendships[idx] = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 아이들이 가진 사탕의 수를 배열 candies에 저장
		for (int idx = 1; idx < candies.length; idx++)
			candies[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 친구 관계를 순회
		for (int friendship = 0; friendship < friendshipNum; friendship++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 친구 관계인 두 아이의 번호를 각 변수에 할당
			int childA = Integer.parseInt(st.nextToken());
			int childB = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 친구 관계를 갱신
			friendships[childA].add(childB);
			friendships[childB].add(childA);
		}
		
		// for 반복문을 사용해 각 아이를 순회
		for (int idx = 1; idx < grouped.length; idx++) {
			
			// 해당 아이의 그룹을 이미 확인한 경우 다음 아이를 순회
			if (grouped[idx])
				continue;
			
			// groupMaker() 메서드를 호출해 해당 아이가 속한 그룹을 groups에 추가
			groupMaker(idx);
		}
		
		// candyCalculator() 메서드를 호출해 아이들로부터 뺏을 수 있는 최대 사탕의 수를 변수 maxCount에 할당
		int maxCount = candyCalculator(minLimit);
		
		// valueOf() 및 write() 메서드를 사용해 아이들로부터 뺏을 수 있는 최대 사탕의 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// groupMaker() 메서드 정의
	public static void groupMaker(int startChild) {
		
		// 해당 그룹에 속한 아이의 수 및 사탕의 수를 저장할 각 변수 초기화
		int childNum = 1;
		int candyNum = candies[startChild];
		
		// 다음에 그룹을 확인할 아이를 저장할 Queue 객체 groupList 초기화
		Queue<Integer> groupList = new LinkedList<>();
		
		// offer() 메서드를 사용해 그룹의 시작이 될 아이를 groupList에 추가 및 그룹 확인 여부 갱신
		groupList.offer(startChild);
		grouped[startChild] = true;
		
		// while 반복문을 사용해 groupList가 빌 때까지 순회
		while (!groupList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 아이를 변수 curChild에 할당
			int curChild = groupList.poll();
			
			// for 반복문을 사용해 해당 아이의 친구를 순회
			for (int nextChild : friendships[curChild]) {
				
				// 해당 친구를 이미 확인한 경우 다음 친구를 순회
				if (grouped[nextChild])
					continue;
				
				// offer() 메서드를 사용해 해당 아이를 groupList에 추가 및 그룹 확인 여부 갱신
				groupList.offer(nextChild);
				grouped[nextChild] = true;
				
				// 해당 그룹에 속한 아이의 수 및 사탕의 수를 갱신
				childNum++;
				candyNum += candies[nextChild];
			}
		}
		
		// add() 메서드를 사용해 groups에 그룹을 추가
		groups.add(new Group(childNum, candyNum));
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// candyCalculator() 메서드 정의
	public static int candyCalculator(int minLimit) {
		
		// 사탕을 뺏은 아이들의 수에 따른 최대 사탕의 수를 저장할 배열 maxCounts 초기화
		int[] maxCounts = new int[minLimit];
		
		// for 반복문을 사용해 각 그룹을 순회
		for (Group group : groups) {
			
			// 해당 그룹에 속한 아이들의 수와 캔디의 수를 각 변수에 할당
			int childNum = group.childNum;
			int candyNum = group.candyNum;
			
			// for 반복문을 사용해 사탕을 뺏은 아이들의 수에 따른 최대 사탕의 수를 갱신
			for (int idx = minLimit - 1; idx >= childNum; idx--)
				maxCounts[idx] = Math.max(maxCounts[idx - childNum] + candyNum, maxCounts[idx]);
		}
		
		// 아이들로부터 뺏을 수 있는 최대 사탕의 수를 반환
		return maxCounts[minLimit - 1];
	}
}