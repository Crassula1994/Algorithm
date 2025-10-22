package bronze4.num16727;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 페르세폴리스와 에스테그랄의 득점을 각 변수에 할당
		int homeScoreP = Integer.parseInt(st.nextToken());
		int awayScoreE = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 에스테그랄과 페르세폴리스의 득점을 각 변수에 할당
		int homeScoreE = Integer.parseInt(st.nextToken());
		int awayScoreP = Integer.parseInt(st.nextToken());
		
		// 페르세폴리스가 더 많은 득점을 한 경우 'Persepolis' 출력
		if (homeScoreP + awayScoreP > homeScoreE + awayScoreE) {
			out.write("Persepolis");
			
		// 에스테그랄이 더 많은 득점을 한 경우 'Esteghlal' 출력
		} else if (homeScoreP + awayScoreP < homeScoreE + awayScoreE) {
			out.write("Esteghlal");
			
		// 페르세폴리스와 에스테그랄이 같은 득점을 한 경우
		} else {
			
			// 페르세폴리스가 원정 다득점인 경우 'Persepolis' 출력
			if (awayScoreP > awayScoreE) {
				out.write("Persepolis");
			
			// 에스테그랄이 원정 다득점인 경우 'Esteghlal' 출력
			} else if (awayScoreP < awayScoreE) {
				out.write("Esteghlal");
			
			// 승부차기를 해야 하는 경우 'Penalty' 출력
			} else {
				out.write("Penalty");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}