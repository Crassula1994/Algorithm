package silver5.num25757;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken(), parseInt(), charAt() 메서드를 사용해 입력 받은 플레이 신청 횟수 및 게임의 종류를 각 변수에 할당
		int requestNum = Integer.parseInt(st.nextToken());
		char category = st.nextToken().charAt(0);
		
		// 같이 플레이할 사람의 이름을 중복 없이 저장할 Set 객체 names 초기화
		Set<String> names = new HashSet<>();
		
		// for 반복문을 사용해 입력 받은 사람의 이름을 names에 저장
		for (int request = 0; request < requestNum; request++)
			names.add(in.readLine());
		
		// size() 메서드를 사용해 사람들의 수를 변수 personNum에 할당
		int personNum = names.size();
		
		// 임스가 최대로 플레이할 수 있는 게임의 수를 계산해 변수 maxCount에 할당
		int maxCount = (category != 'Y') ? (category != 'F') ? personNum / 3 : personNum / 2 : personNum;
		
		// valueOf() 및 write() 메서드를 사용해 임스가 최대로 플레이할 수 있는 게임의 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}