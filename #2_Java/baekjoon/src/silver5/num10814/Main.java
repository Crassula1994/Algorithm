package silver5.num10814;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 회원의 수를 변수 memberNum에 저장
		int memberNum = Integer.parseInt(in.readLine());
		
		// 각 회원을 저장할 2차원 배열 members 초기화
		String[][] members = new String[memberNum][2];
		
		// for 반복문을 사용해 각 회원을 순회
		for (int r = 0; r < memberNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 나이와 이름을 배열 members에 저장
			members[r][0] = st.nextToken();
			members[r][1] = st.nextToken();			
		}
		
		// sort() 메서드를 사용해 배열을 정렬
		Arrays.sort(members, (mb1, mb2) -> {
			int age1 = Integer.parseInt(mb1[0]);
			int age2 = Integer.parseInt(mb2[0]);
			return age1 != age2 ? age1 - age2 : 0;
		});
		
		// for 반복문을 사용해 배열 members의 각 회원을 출력
		for (int r = 0; r < memberNum; r++)
			out.write(members[r][0] + " " + members[r][1] + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}