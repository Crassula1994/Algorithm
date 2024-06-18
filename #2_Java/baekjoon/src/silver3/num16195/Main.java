package silver3.num16195;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 걸그룹의 수와 맞혀야 할 문제의 수를 각 변수에 할당
		int groupNum = Integer.parseInt(st.nextToken());
		int questionNum = Integer.parseInt(st.nextToken());
		
		// 각 걸그룹의 정보와 각 멤버의 소속 걸그룹을 저장할 각 Map 객체 초기화
		Map<String, List<String>> groups = new HashMap<>();
		Map<String, String> members = new HashMap<>();
		
		// for 반복문을 사용해 각 걸그룹의 정보를 순회
		for (int group = 0; group < groupNum; group++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 해당 걸그룹 팀의 이름 및 소속 인원 수를 각 변수에 할당
			String teamName = in.readLine();
			int memberCnt = Integer.parseInt(in.readLine());
			
			// put() 메서드를 사용해 해당 걸그룹을 groups에 저장
			groups.put(teamName, new ArrayList<>());
			
			// for 반복문을 사용해 각 멤버를 순회
			for (int member = 0; member < memberCnt; member++) {
				
				// readLine() 메서드를 사용해 입력 받은 멤버의 이름을 변수 memberName에 할당
				String memberName = in.readLine();
				
				// put() 메서드를 사용해 해당 멤버의 소속 팀 정보를 members에 저장
				members.put(memberName, teamName);
				
				// get() 및 add() 메서드를 사용해 해당 멤버의 소속 팀을 groups에 저장
				groups.get(teamName).add(memberName);
			}
			
			// get() 및 sort() 메서드를 사용해 해당 걸그룹의 소속 멤버를 사전 순으로 정렬
			Collections.sort(groups.get(teamName));
		}
		
		// for 반복문을 사용해 각 질문을 순회
		for (int question = 0; question < questionNum; question++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 질문 내용 및 그 종류를 각 변수에 할당
			String name = in.readLine();
			int category = Integer.parseInt(in.readLine());
			
			// 질문 내용이 팀 이름인 경우
			if (category == 0) {
				
				// for 반복문을 사용해 각 멤버의 이름을 사전 순으로 출력
				for (String memberName : groups.get(name))
					out.write(memberName + "\n");
				
			// 질문 내용이 멤버 이름인 경우
			} else {
				
				// get() 및 write() 메서드를 사용해 해당 멤버가 소속된 팀 이름을 출력
				out.write(members.get(name) + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}