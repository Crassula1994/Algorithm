package silver2.num02644;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 전체 사람의 수, 촌수를 계산해야 하는 두 사람을 저장할 각 변수 초기화
	static int personNum;
	static int startPerson;
	static int endPerson;
	
	// 각 영역의 넓이를 저장할 PriorityQueue 객체 areas 초기화
	static PriorityQueue<Integer> areas = new PriorityQueue<>();
	
	// 각 사람의 연결 정보를 저장할 2차원 배열 connection 초기화
	static boolean[][] connection;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전체 사람의 수를 변수 personNum에 할당
		personNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 촌수를 계산해야 하는 두 사람을 각 변수에 할당
		startPerson = Integer.parseInt(st.nextToken());
		endPerson = Integer.parseInt(st.nextToken());
		
		// 각 사람의 연결 정보를 저장할 2차원 배열 connection 초기화
		connection = new boolean[personNum + 1][personNum + 1];
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부모 자식들 간의 관계의 개수를 변수 connNum에 할당
		int connNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 관계를 순회
		for (int conn = 0; conn < connNum; conn++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 사람을 각 변수에 할당
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			// 각 사람의 연결 정보를 갱신
			connection[parent][child] = true;
			connection[child][parent] = true;
		}
		
		// kinshipScaler() 메서드를 호출해 두 사람의 촌수를 변수 degree에 할당
		int degree = kinshipScaler();
		
		// valueOf() 및 write() 메서드를 사용해 두 사람의 촌수를 출력
		out.write(String.valueOf(degree));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// kinshipScaler() 메서드 정의
	public static int kinshipScaler() {
		
		// 해당 사람의 확인 여부를 저장할 배열 checked 초기화
		Integer[] checked = new Integer[personNum + 1];
		
		// 다음에 확인할 사람을 저장할 Queue 객체 checkList 초기화
		Queue<Integer> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 가장 처음 확인할 사람을 checkList에 추가 및 확인 처리
		checkList.offer(startPerson);
		checked[startPerson] = 0;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 사람을 변수 currentPerson에 할당
			int currentPerson = checkList.poll();
			
			// 해당 사람이 찾고자 하는 사람인 경우 해당 사람의 촌수를 반환
			if (currentPerson == endPerson)
				return checked[currentPerson];
			
			// for 반복문을 사용해 관계로 연결된 각 사람을 순회
			for (int person = 1; person <= personNum; person++) {
				
				// 해당 사람이 관계로 연결되어 있고, 확인하지 않은 경우
				if (connection[currentPerson][person] && checked[person] == null) {
					
					// offer() 메서드를 사용해 해당 사람을 checkList에 추가 및 확인 처리
					checkList.offer(person);
					checked[person] = checked[currentPerson] + 1;
				}
			}
		}
		
		// 친척 관계가 없는 경우 -1을 반환
		return -1;
	}
}