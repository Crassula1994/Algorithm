package gold2.num04195;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 사람의 친구 관계와 그 수를 저장할 각 배열 초기화
	static int[] rootUser;
	static int[] friendCnt;
	
	// 각 사람의 아이디와 번호를 저장할 Map 객체 users 초기화
	static Map<String, Integer> users;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 친구 관계의 수를 변수 relationNum에 할당
			int relationNum = Integer.parseInt(in.readLine());
			
			// 각 사람의 친구 관계와 그 수를 저장할 각 List 객체 초기화
			rootUser = new int[relationNum * 2];
			friendCnt = new int[relationNum * 2];
			
			// for 반복문을 사용해 각 사람의 친구 관계와 그 수를 초기화
			for (int idx = 0; idx < rootUser.length; idx++) {
				rootUser[idx] = idx;
				friendCnt[idx] = 1;
			}
			
			// 각 사람의 아이디와 번호를 저장할 Map 객체 users 초기화
			users = new HashMap<>();
			
			// for 반복문을 사용해 입력 받은 각 친구 관계를 순회
			for (int relation = 0, index = 0; relation < relationNum; relation++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 메서드를 사용해 입력 받은 각 사람의 아이디를 각 변수에 할당
				String userNameA = st.nextToken();
				String userNameB = st.nextToken();
				
				// userNameChecker() 메서드를 사용해 각 아이디에 대한 정보를 초기화
				index = userNameChecker(userNameA, index);
				index = userNameChecker(userNameB, index);
				
				// get() 메서드를 사용해 각 사람의 번호를 각 변수에 할당
				int indexA = users.get(userNameA);
				int indexB = users.get(userNameB);
				
				// userConnector() 메서드를 호출해 두 사람의 친구 관계를 갱신하고 그 수를 변수 count에 할당
				int count = userConnector(indexA, indexB);
				
				// write() 메서드를 사용해 해당 친구 네트워크에 있는 사람의 수를 출력
				out.write(count + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// userNameChecker() 메서드 정의
	public static int userNameChecker(String userName, int index) {
		
		// 해당 아이디가 이미 존재하는 경우 저장할 인덱스를 그대로 반환
		if (users.containsKey(userName))
			return index;
		
		// put() 메서드를 사용해 첫 번째 아이디를 users에 추가
		users.put(userName, index);
		
		// 다음에 저장할 인덱스를 반환
		return ++index;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// userConnector() 메서드 정의
	public static int userConnector(int userA, int userB) {
		
		// userFinder() 메서드를 호출해 두 사람의 기본 친구를 각 변수에 할당
		int rootA = userFinder(userA);
		int rootB = userFinder(userB);
		
		// 두 사람의 기본 친구가 같은 경우 기본 친구 수를 반환
		if (rootA == rootB)
			return friendCnt[rootA];
			
		// max() 및 min() 메서드를 사용해 새로운 기본 친구와 그에 종속될 친구를 각 변수에 할당
		int root = Math.min(rootA, rootB);
		int leaf = Math.max(rootA, rootB);
		
		// get() 및 set() 메서드를 사용해 각 기본 친구의 친구 관계 및 그 친구 수를 갱신
		rootUser[leaf] = root;
		friendCnt[root] += friendCnt[leaf];
		
		// 새로운 기본 친구의 친구 수를 반환
		return friendCnt[root];
	}
	
	// ----------------------------------------------------------------------------------------------------

	// userFinder() 메서드 정의
	public static int userFinder(int user) {
		
		// 기본 친구가 자기 자신인 경우 자기 자신을 반환
		if (rootUser[user] == user)
			return user;
		
		// userFinder() 메서드를 재귀 호출해 기본 친구를 찾아 반환
		return rootUser[user] = userFinder(rootUser[user]);
	}
}