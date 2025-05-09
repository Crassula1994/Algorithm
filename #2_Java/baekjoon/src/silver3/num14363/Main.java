package silver3.num14363;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Party 클래스 정의
	static class Party implements Comparable<Party> {
		
		// 정당의 이름과 소속 상원 의원의 수를 저장할 각 변수 초기화
		char name;
		int count;
		
		// 매개변수를 입력 받는 생성자 정의
		public Party(char name, int count) {
			this.name = name;
			this.count = count;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Party anotherParty) {
			
			// 소속 상원 의원의 수가 많은 순서대로 정렬
			return anotherParty.count - this.count;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// format() 및 write() 메서드를 사용해 테스트 케이스의 번호를 정해진 양식으로 출력
			out.write(String.format("Case #%d: ", tc));
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정당의 개수를 변수 partyNum에 할당
			int partyNum = Integer.parseInt(in.readLine());
			
			// 각 정당별 남은 인원 수를 저장할 PriorityQueue 객체 parties 초기화
			PriorityQueue<Party> parties = new PriorityQueue<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 정당을 순회
			for (int idx = 0; idx < partyNum; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 정당에 속한 상원 의원의 수를 변수 count에 할당
				int count = Integer.parseInt(st.nextToken());
				
				// offer() 메서드를 사용해 해당 정당을 parties에 추가
				parties.offer(new Party((char) ('A' + idx), count));
			}
			
			// 탈출하는 상원 의원의 소속 정당을 저장할 StringBuilder 객체 sb 초기화
			StringBuilder sb = new StringBuilder();
			
			// while 반복문을 사용해 모든 상원 의원이 탈출할 때까지 순회
			while (!parties.isEmpty()) {
				
				// 정당이 두 개만 존재하는 경우
				if (parties.size() == 2) {
					
					// poll() 메서드를 사용해 남은 두 정당과 남은 상원 의원의 수를 각 변수에 할당
					Party party1 = parties.poll();
					Party party2 = parties.poll();
					int count = party1.count;
					
					// while 반복문을 사용해 남은 두 정당의 상원 의원이 차례로 탈출하도록 sb에 정당 이름을 추가
					while (count-- > 0)
						sb.append(party1.name).append(party2.name).append(" ");
					
				// 정당이 세 개 이상 존재하는 경우
				} else {
					
					// poll() 메서드를 사용해 가장 많은 상원 의원이 남은 정당을 변수 party에 할당
					Party party = parties.poll();
					
					// append() 메서드를 사용해 해당 정당의 이름을 sb에 추가
					sb.append(party.name).append(" ");
					
					// 정당에 소속된 모든 상원 의원이 탈출하지 못한 경우 해당 정당을 parties에 추가
					if (party.count-- > 1)
						parties.offer(party);
				}
			}
			
			// toString() 및 write() 메서드를 사용해 탈출하는 상원 의원의 소속 정당을 차례로 출력
			out.write(sb.toString());
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}