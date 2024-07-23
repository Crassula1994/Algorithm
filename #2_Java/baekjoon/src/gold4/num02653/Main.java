package gold4.num02653;

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
	
	// 집단에 속한 사람들의 수를 저장할 변수 personNum 초기화
	static int personNum;
	
	// 각 사람을 확인했는지 여부를 저장할 배열 checked 초기화
	static boolean[] checked;
	
	// 집단에 속한 사람들의 호오 관계를 저장할 2차원 배열 relationships 초기화
	static boolean[][] relationships;
	
	// 각 집단에 속한 소집단을 저장할 List 객체 groups 초기화
	static List<List<Integer>> groups = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집단에 속한 사람들의 수를 변수 personNum에 할당
		personNum = Integer.parseInt(in.readLine());
		
		// 해당 집단이 안정된 집단인지 여부를 나타낼 변수 isStable 초기화
		boolean isStable = true;
		
		// 각 사람을 확인했는지 여부를 저장할 배열 checked 초기화
		checked = new boolean[personNum + 1];
		
		// 집단에 속한 사람들의 호오 관계를 저장할 2차원 배열 relationships 초기화
		relationships = new boolean[personNum + 1][personNum + 1];
		
		// for 반복문을 사용해 각 사람을 순회
		for (int r = 1; r <= personNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 다른 사람과의 관계를 배열 relationships에 저장
			for (int c = 1; c <= personNum; c++)
				relationships[r][c] = Integer.parseInt(st.nextToken()) == 0;
		}
		
		// for 반복문을 사용해 각 사람을 순회
		for (int person = 1; person <= personNum; person++) {
			
			// 해당 사람을 이미 확인한 경우 다음 사람을 순회
			if (checked[person])
				continue;
			
			// groupChecker() 메서드를 사용해 해당 사람이 속한 소집단이 안정되었는지 여부를 isStable에 할당
			isStable = groupChecker(person);
			
			// 소집단이 불안정한 경우 반복문 탈출
			if (!isStable)
				break;
		}
		
		// 해당 집단이 안정된 집단인 경우
		if (isStable) {
			
			// size() 및 write() 메서드를 사용해 소집단의 수를 출력
			out.write(groups.size() + "\n");
			
			// for 반복문을 사용해 각 소그룹을 순회
			for (List<Integer> group : groups) {
				
				// for 반복문을 사용해 해당 소그룹에 속한 사람을 출력
				for (int person : group)
					out.write(person + " ");
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		
		// 해당 집단이 불안정한 집단인 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// groupChecker() 메서드 정의
	public static boolean groupChecker(int startPerson) {
		
		// 해당 소집단에 속한 사람을 저장할 List 객체 members 초기화
		List<Integer> members = new ArrayList<>();
		
		// for 반복문을 사용해 다른 사람을 순회
		for (int person = 1; person <= personNum; person++) {
			
			// 해당 사람을 싫어하는 경우 다음 사람을 순회
			if (!relationships[startPerson][person])
				continue;
			
			// 해당 사람이 이미 다른 소집단에 속해 있는 경우 false 반환
			if (checked[person])
				return false;
			
			// 해당 사람을 확인 처리
			checked[person] = true;
			
			// add() 메서드를 사용해 좋아하는 사람을 members에 추가
			members.add(person);
		}
		
		// 해당 소집단에 속한 사람이 1명인 경우 false 반환
		if (members.size() == 1)
			return false;
		
		// for 반복문을 사용해 해당 소집단에 속해 있는 두 사람을 순회
		for (int personA : members) {
			for (int personB : members) {
				
				// 두 사람이 모두 서로를 좋아하지 않는 경우 false 반환
				if (!relationships[personA][personB])
					return false;
			}
		}
		
		// add() 메서드를 사용해 해당 소집단을 groups에 추가
		groups.add(members);
		
		// 해당 소집단이 안정된 경우 true 반환
		return true;
	}
}