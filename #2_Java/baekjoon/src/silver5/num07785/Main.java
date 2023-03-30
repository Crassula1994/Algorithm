package silver5.num07785;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 출입 기록의 수를 변수 logNum에 할당
		int logNum = Integer.parseInt(in.readLine());
		
		// 현재 회사에 있는 사람을 저장할 Set 객체 attendance 초기화
		Set<String> attendance = new TreeSet<>();
		
		// for 반복문을 사용해 각 출입 기록을 순회
		for (int log = 0; log < logNum; log++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 사람의 이름 및 출퇴근 여부를 각 변수에 할당
			String name = st.nextToken();
			String status = st.nextToken();
			
			// 출근한 경우 add() 메서드를 사용해 attendance에 이름을 추가
			if (status.equals("enter")) {
				attendance.add(name);
			
			// 퇴근한 경우 remove() 메서드를 사용해 attendance에서 이름을 제거
			} else {
				attendance.remove(name);
			}
		}
		
		// 현재 회사에 있는 사람을 저장할 List 객체 attendanceSorted 초기화
		List<String> attendanceSorted = new ArrayList<>(attendance);
		
		// for 반복문을 사용해 현재 회사에 있는 사람을 사전 순의 역순으로 출력
		for (int idx = attendanceSorted.size() - 1; idx >= 0; idx--)
			out.write(attendanceSorted.get(idx) + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}