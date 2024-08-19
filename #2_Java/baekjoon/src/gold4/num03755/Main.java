package gold4.num03755;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 고객 대기 목록을 저장할 Map 객체 waitingList 초기화
		TreeMap<Integer, Integer> waitingList = new TreeMap<>();
		
		// while 반복문을 사용해 각 요청을 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 요청의 종류를 변수 request에 할당
			int request = Integer.parseInt(st.nextToken());
			
			// 응대 시스템을 종료해야 하는 경우 반복문 탈출
			if (request == 0)
				break;
			
			// 고객을 고객 대기 목록에 추가해야 하는 경우
			if (request == 1) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 고객의 번호와 우선도를 각 변수에 할당
				int client = Integer.parseInt(st.nextToken());
				int priority = Integer.parseInt(st.nextToken());
				
				// put() 메서드를 사용해 고객을 waitingList에 추가
				waitingList.put(priority, client);
				
			// 고객을 고객 대기 목록에서 제거해야 하는데 고객 대기 목록이 빈 경우 0을 출력
			} else if (waitingList.isEmpty()) {
				out.write(0 + "\n");
				
			// 고객을 고객 대기 목록에서 제거해야 하고 고객 대기 목록이 비지 않은 경우
			} else {
				
				// pollLastEntry(), pollFirstEntry(), getValue() 메서드를 사용해 제거해야 할 고객 번호를 변수 client에 할당
				int client = (request == 2) ?
						waitingList.pollLastEntry().getValue() : waitingList.pollFirstEntry().getValue();
				
				// write() 메서드를 사용해 제거해야 할 고객 번호를 출력
				out.write(client + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}