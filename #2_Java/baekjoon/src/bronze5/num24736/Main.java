package bronze5.num24736;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 미식 축구 점수를 저장할 배열 scores 초기화
	static int[] scores = {6, 3, 2, 1, 2};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 원정 팀과 홈 팀의 점수를 저장할 각 변수 초기화
		int visitingScore = 0;
		int homeScore = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 원정 팀의 점수를 갱신
		for (int idx = 0; idx < scores.length; idx++)
			visitingScore += scores[idx] * Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 홈 팀의 점수를 갱신
		for (int idx = 0; idx < scores.length; idx++)
			homeScore += scores[idx] * Integer.parseInt(st.nextToken());
		
		// write() 메서드를 사용해 원정 팀과 홈 팀의 점수를 출력
		out.write(visitingScore + " " + homeScore);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}