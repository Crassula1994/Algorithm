package silver3.num13778;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Member 클래스 정의
	static class Member implements Comparable<Member> {
		
		// 의원의 번호와 점수, 이름을 저장할 각 변수 초기화
		int number;
		int point;
		String name;
		
		// 매개변수를 입력 받는 생성자 정의
		public Member(int number, int point, String name) {
			this.number = number;
			this.point = point;
			this.name = name;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Member anotherMember) {
			
			// 두 의원의 점수가 같은 경우 번호 순으로 오름차순 정렬
			if (this.point == anotherMember.point)
				return this.number - anotherMember.number;
			
			// 두 의원의 점수가 다른 경우 점수 순으로 내림차순 정렬
			return anotherMember.point - this.point;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 하원의원의 수를 변수 memberNum에 할당
		int memberNum = Integer.parseInt(in.readLine());
		
		// 의원의 정보를 저장할 Map 객체 members 초기화
		Map<Integer, Member> members = new HashMap<>();
		
		// for 반복문을 사용해 각 의원의 정보를 순회
		for (int member = 0; member < memberNum; member++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 의원의 번호를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// nextToken() 메서드를 사용해 해당 의원의 이름을 저장할 StringBuilder 객체 sb 초기화
			StringBuilder sb = new StringBuilder(st.nextToken());
			
			// while 반복문을 사용해 해당 의원의 이름을 sb에 추가
			while (st.hasMoreTokens())
				sb.append(" ").append(st.nextToken());
			
			// toString() 및 put() 메서드를 사용해 해당 의원의 정보를 members에 저장
			members.put(number, new Member(number, 0, sb.toString()));
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 의원의 행동의 수를 변수 actionNum에 할당
		int actionNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 행동을 순회
		while (actionNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseInt(), charAt() 메서드를 사용해 해당 행동을 한 의원의 번호와 그 코드를 각 변수에 할당
			int number = Integer.parseInt(st.nextToken());
			char code = st.nextToken().charAt(0);
			
			// switch 조건문을 사용해 해당 의원의 행동에 따른 점수를 갱신
			switch (code) {
				case 'S':
					members.get(number).point += 10;
					break;
				case 'Q':
					members.get(number).point += 5;
					break;
				case 'A':
					members.get(number).point += 7;
					break;
				case 'L':
					members.get(number).point -= 8;
					break;
				case 'F':
					members.get(number).point += 4;
					break;
				case 'D':
					members.get(number).point -= 5;
					break;
				default:
					members.get(number).point -= 10;
			}
		}
		
		// values() 메서드를 사용해 각 의원의 정보를 List 객체 memberList에 저장
		List<Member> memberList = new ArrayList<>(members.values());
		
		// sort() 메서드를 사용해 의원을 점수 순으로 정렬
		Collections.sort(memberList);
		
		// get() 메서드를 사용해 가장 높은 점수 및 낮은 점수를 각 변수에 할당
		int maxPoint = memberList.get(0).point;
		int minPoint = memberList.get(memberNum - 1).point;
		
		// write() 메서드를 사용해 가장 높은 점수를 출력
		out.write(maxPoint + " ");
		
		// for 반복문을 사용해 각 의원을 순회
		for (Member member : memberList) {
			
			// 해당 의원의 점수가 가장 높은 점수가 아닌 경우 반복문 탈출
			if (member.point != maxPoint)
				break;
			
			// write() 메서드를 사용해 가장 높은 점수를 기록한 의원의 이름을 출력
			out.write(member.name + " ");
		}
		
		// write() 메서드를 사용해 가장 낮은 점수를 출력
		out.write("\n" + minPoint + " ");
		
		// for 반복문을 사용해 각 의원을 순회
		for (Member member : memberList) {
			
			// 가장 낮은 점수인 경우 해당 의원의 이름을 출력
			if (member.point == minPoint)
				out.write(member.name + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}