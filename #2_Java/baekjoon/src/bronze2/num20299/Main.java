package bronze2.num20299;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 팀의 수 및 클럽 가입 조건을 각 변수에 할당
		int teamNum = Integer.parseInt(st.nextToken());
		int sumLimit = Integer.parseInt(st.nextToken());
		int minLimit = Integer.parseInt(st.nextToken());
		
		// VIP 클럽에 가입이 가능한 팀의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// VIP 회원들의 레이팅을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 팀의 정보를 순회
		while (teamNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 해당 팀의 정보를 변수 teamRating에 할당
			String teamRating = in.readLine();
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(teamRating);
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 팀원의 점수를 각 변수에 할당
			int ratingA = Integer.parseInt(st.nextToken());
			int ratingB = Integer.parseInt(st.nextToken());
			int ratingC = Integer.parseInt(st.nextToken());
			
			// 각 팀원이 개인 레이팅에 대한 클럽 가입 조건을 만족하지 못한 경우 다음 팀을 순회
			if (ratingA < minLimit || ratingB < minLimit || ratingC < minLimit)
				continue;
			
			// 팀원 레이팅 합에 대한 클럽 가입 조건을 만족하지 못한 경우 다음 팀을 순회
			if (ratingA + ratingB + ratingC < sumLimit)
				continue;
			
			// VIP 클럽에 가입이 가능한 팀의 수를 갱신
			count++;
			
			// append() 메서드를 사용해 해당 팀의 레이팅 정보를 sb에 저장
			sb.append(teamRating).append(" ");
		}
		
		// toString() 및 write() 메서드를 사용해 VIP 클럽에 가입이 가능한 팀의 수 및 회원들의 레이팅을 출력
		out.write(count + "\n" + sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}