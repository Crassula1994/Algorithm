package silver4.num26069;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람들이 만난 기록 수를 변수 meetingNum에 할당
		int meetingNum = Integer.parseInt(in.readLine());
		
		// 무지개 댄스를 추고 있는 사람을 저장할 Set 객체 dancingPerson 초기화
		Set<String> dancingPerson = new HashSet<>();
		
		// add() 메서드를 사용해 춤을 추고 있는 총총이를 dancingPerson에 추가
		dancingPerson.add("ChongChong");
		
		// for 반복문을 사용해 각 만남을 순회
		for (int meeting = 0; meeting < meetingNum; meeting++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 만난 사람들의 이름을 각 변수에 할당
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			
			// 해당 이름이 dancingPerson에 있는 경우 나머지 이름을 추가
			if (dancingPerson.contains(name1))
				dancingPerson.add(name2);
			if (dancingPerson.contains(name2))
				dancingPerson.add(name1);
		}
		
		// size() 메서드를 사용해 춤을 추고 있는 사람의 수를 변수 count에 할당
		int count = dancingPerson.size();

		// valueOf() 및 write() 메서드를 사용해 춤을 추고 있는 사람의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}