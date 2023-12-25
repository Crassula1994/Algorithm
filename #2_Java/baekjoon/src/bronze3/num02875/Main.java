package bronze3.num02875;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 여학생, 남학생, 인턴십에 참가해야 하는 인원 수를 각 변수에 할당
		int girlCnt = Integer.parseInt(st.nextToken());
		int boyCnt = Integer.parseInt(st.nextToken());
		int internship = Integer.parseInt(st.nextToken());
		
		// min() 메서드를 사용해 만들 수 있는 팀의 최대 개수를 저장할 변수 maxTeam 초기화
		int maxTeam = Math.min(girlCnt / 2, boyCnt);
		
		// 팀을 이루지 못한 학생을 인턴십에 보낸 것으로 처리
		internship -= boyCnt - maxTeam;
		internship -= girlCnt - maxTeam * 2;
		
		// while 반복문을 사용해 인턴십에 보낼 학생을 채울 때까지 팀을 해체
		while (internship > 0 && maxTeam > 0) {
			maxTeam--;
			internship -= 3;
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 팀의 최대 개수를 출력
		out.write(String.valueOf(maxTeam));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}