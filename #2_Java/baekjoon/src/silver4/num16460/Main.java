package silver4.num16460;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 프리미엄 사용자의 이름과 성적 지향, 지리적 거리의 한계를 각 변수에 할당
		String premiumUserName = st.nextToken();
		String genderLimit = st.nextToken();
		int distanceLimit = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 사용자의 수를 변수 userNum에 할당
		int userNum = Integer.parseInt(in.readLine());
		
		// 프리미엄 사용자의 성적 지향과 지리적 거리의 한계를 만족하는 사용자를 저장할 List 객체 candidates 초기화
		List<String> candidates = new ArrayList<>();
		
		// for 반복문을 사용해 각 사용자를 순회
		for (int user = 0; user < userNum; user++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 사용자의 이름과 성별, 프리미엄 사용자로부터의 거리를 각 변수에 할당
			String userName = st.nextToken();
			String gender = st.nextToken();
			int distance = Integer.parseInt(st.nextToken());
			
			// 성적 지향을 만족하지 않는 경우 다음 사용자를 순회
			if (genderLimit.length() == 1 && !genderLimit.equals(gender))
				continue;
			
			// 지리적 거리의 한계를 만족하지 않는 경우 다음 사용자를 순회
			if (distance > distanceLimit)
				continue;
			
			// add() 메서드를 사용해 사용자의 이름을 candidates에 추가
			candidates.add(userName);
		}
		
		// 조건을 만족하는 사용자가 없는 경우 'No one yet' 출력
		if (candidates.isEmpty()) {
			out.write("No one yet");
			
		// 조건을 만족하는 사용자가 있는 경우
		} else {
		
			// sort() 메서드를 사용해 조건을 만족하는 사용자의 이름을 사전 순으로 정렬
			Collections.sort(candidates);
			
			// for 반복문을 사용해 조건을 만족하는 사용자의 이름을 출력
			for (String userName : candidates)
				out.write(userName + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}