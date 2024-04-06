package gold4.num01043;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 사람이 진실을 아는 사람과 연결되었는지를 저장할 배열 connected 초기화
	static int[] connected;
	
	// 진실을 아는 사람의 번호를 저장할 Set 객체 knownPeople 초기화
	static Set<Integer> knownPeople;
		
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수, 파티의 수를 각 변수에 할당
		int peopleNum = Integer.parseInt(st.nextToken());
		int partyNum = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 이야기의 진실을 아는 사람의 수를 변수 knownCnt에 할당
		int knownCnt = Integer.parseInt(st.nextToken());
		
		// 진실을 아는 사람이 아무도 없는 경우 모든 파티의 수를 출력
		if (knownCnt == 0) {
			out.write(String.valueOf(partyNum));
			
		// 진실을 아는 사람이 존재하는 경우
		} else {
			
			// 거짓말을 할 수 있는 파티의 수를 저장할 변수 totalCnt 초기화
			int totalCnt = 0;
			
			// 각 사람이 진실을 아는 사람과 연결되었는지, 파티에 참석한 사람을 저장할 각 배열 초기화
			connected = new int[peopleNum + 1];
			List<Integer>[] parties = new ArrayList[partyNum];
			
			// for 반복문을 사용해 각 사람이 진실을 아는 사람과 연결되었는지를 초기화
			for (int idx = 1; idx < connected.length; idx++)
				connected[idx] = idx;
			
			// for 반복문을 사용해 각 파티에 참석한 사람을 저장할 List 객체 초기화
			for (int idx = 0; idx < parties.length; idx++)
				parties[idx] = new ArrayList<>();
			
			// 진실을 아는 사람의 번호를 저장할 Set 객체 knownPeople 초기화
			knownPeople = new HashSet<>();
			
			// for 반복문을 사용해 입력 받은 진실을 아는 사람의 번호를 knownPeople에 저장
			for (int k = 0; k < knownCnt; k++)
				knownPeople.add(Integer.parseInt(st.nextToken()));
			
			// for 반복문을 사용해 각 파티의 정보를 순회
			for (int party = 0; party < partyNum; party++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 파티의 참석자 수, 참석한 이전 사람의 번호를 각 변수에 할당
				int count = Integer.parseInt(st.nextToken());
				int prevPeople = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 참석한 이전 사람의 정보를 배열 parties에 추가
				parties[party].add(prevPeople);
				
				// for 반복문을 사용해 파티에 참석한 각 사람을 순회
				for (int c = 0; c < count - 1; c++) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 다음 사람의 번호를 변수 nextPeople에 할당
					int nextPeople = Integer.parseInt(st.nextToken());
					
					// add() 메서드를 사용해 참석한 다음 사람의 정보를 배열 parties에 추가
					parties[party].add(nextPeople);
					
					// peopleConnector() 메서드를 호출해 두 사람을 연결
					peopleConnector(prevPeople, nextPeople);
					
					// 다음 사람을 이전 사람으로 갱신
					prevPeople = nextPeople;
				}
			}
			
			// for 반복문을 사용해 각 파티를 순회
			for (int party = 0; party < partyNum; party++) {
				
				// 해당 파티에서 거짓말을 할 수 있는지 여부를 나타낼 변수 canLie 초기화
				boolean canLie = true;
				
				// for 반복문을 사용해 해당 파티의 각 참석자를 순회
				for (int idx = 0; idx < parties[party].size(); idx++) {
				
					// get() 메서드를 사용해 해당 파티의 참석자를 변수 people에 할당
					int people = parties[party].get(idx);
					
					// 해당 참석자가 진실을 알고 있는 사람과 연결된 경우
					if (knownPeople.contains(peopleFinder(people))) {
						
						// 해당 파티에서 거짓말을 할 수 있는지 여부를 갱신 후 반복문 탈출
						canLie = false;
						break;
					}
				}
				
				// 해당 파티에서 거짓말을 할 수 있는 경우 거짓말을 할 수 있는 파티의 수를 갱신
				if (canLie)
					totalCnt++;
			}
			
			// valueOf() 및 write() 메서드를 사용해 거짓말을 할 수 있는 파티의 수를 출력
			out.write(String.valueOf(totalCnt));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// peopleConnector() 메서드 정의
	public static void peopleConnector(int peopleA, int peopleB) {
		
		// peopleFinder() 메서드를 호출해 각 사람의 연결 여부를 각 변수에 할당
		int knownA = peopleFinder(peopleA);
		int knownB = peopleFinder(peopleB);
		
		// 두 사람의 아는 사람이 다른 경우
		if (knownA != knownB) {
			
			// contains() 메서드를 사용해 두 사람의 아는 사람이 진실을 아는 사람인지를 각 변수에 저장
			boolean isKnownA = knownPeople.contains(knownA);
			boolean isKnownB = knownPeople.contains(knownB);
			
			// 첫 번째 사람만 진실을 아는 사람인 경우 진실을 아는 사람을 갱신
			if (isKnownA && !isKnownB) {
				connected[knownB] = knownA;
				
			// 두 번째 사람만 진실을 아는 사람인 경우 진실을 아는 사람을 갱신
			} else if (!isKnownA && isKnownB) {
				connected[knownA] = knownB;
				
			// 두 사람 모두 진실을 아는 사람을 모르거나 모두 진실을 아는 사람인 경우 진실을 아는 사람을 갱신
			} else {
				connected[Math.max(knownA, knownB)] = Math.min(knownA, knownB);
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// peopleFinder() 메서드 정의
	public static int peopleFinder(int people) {
		
		// 진실을 아는 사람이 자기 자신인 경우 자기 자신을 반환
		if (connected[people] == people)
			return people;
		
		// peopleFinder() 메서드를 재귀 호출해 진실을 아는 사람을 찾아 반환
		return connected[people] = peopleFinder(connected[people]);
	}
}