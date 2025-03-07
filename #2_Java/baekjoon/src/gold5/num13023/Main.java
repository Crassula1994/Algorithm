package gold5.num13023;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 주어진 친구 관계가 존재하는지 여부를 나타낼 변수 hasABCDE 초기화
	static boolean hasABCDE = false;
	
	// 각 사람의 확인 여부 및 입력 받은 친구 관계를 저장할 각 배열 초기화
	static boolean[] checked;
	static List<Integer>[] relations;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수 및 친구 관계의 수를 각 변수에 할당
		int personNum = Integer.parseInt(st.nextToken());
		int relationNum = Integer.parseInt(st.nextToken());
		
		// 각 사람의 확인 여부 및 입력 받은 친구 관계를 저장할 각 배열 초기화
		checked = new boolean[personNum];
		relations = new ArrayList[personNum];
		
		// for 반복문을 사용해 입력 받은 친구 관계를 저장할 List 객체 초기화
		for (int idx = 0; idx < relations.length; idx++)
			relations[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 친구 관계를 순회
		while (relationNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 관계를 이루는 사람을 각 변수에 할당
			int personA = Integer.parseInt(st.nextToken());
			int personB = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 입력 받은 친구 관계를 배열 relations에 저장
			relations[personA].add(personB);
			relations[personB].add(personA);
		}
		
		// for 반복문을 사용해 각 사람을 순회
		for (int idx = 0; idx < personNum; idx++) {
			
			// 주어진 친구 관계가 존재하는 경우 반복문 탈출
			if (hasABCDE)
				break;
			
			// relationFinder() 메서드를 호출해 주어진 친구 관계가 존재하는지 여부를 갱신
			relationFinder(idx, 1);
		}
		
		// write() 메서드를 사용해 문제에서 주어진 친구 관계가 존재하는지 여부를 출력
		out.write((hasABCDE) ? "1" : "0");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// relationFinder() 메서드 정의
	public static void relationFinder(int curPerson, int depth) {
		
		// 주어진 친구 관계가 존재하는 경우 메서드 종료
		if (hasABCDE)
			return;
		
		// 주어진 친구 관계를 찾은 경우 주어진 친구 관계가 존재하는지 여부를 갱신 후 메서드 종료
		if (depth == 5) {
			hasABCDE = true;
			return;
		}
		
		// 현재 사람을 확인 처리
		checked[curPerson] = true;
		
		// for 반복문을 사용해 해당 사람의 친구 관계를 순회
		for (int nextPerson : relations[curPerson]) {
			
			// 친구 관계인 사람을 이미 확인한 경우 다음 사람을 순회
			if (checked[nextPerson])
				continue;
			
			// relationFinder() 메서드 재귀 호출
			relationFinder(nextPerson, depth + 1);
		}
		
		// 현재 사람을 확인하지 않은 것으로 처리
		checked[curPerson] = false;
	}
}