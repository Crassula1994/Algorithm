package bronze5.num33515;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 팀원이 백준 1001번 문제를 푸는 데 걸린 시간을 각 변수에 할당
		int timeA = Integer.parseInt(st.nextToken());
		int timeB = Integer.parseInt(st.nextToken());
		
		// min(), valueOf(), write() 메서드를 사용해 형진이가 백준 1001번 문제를 푸는 데까지 필요한 최대 시간을 출력
		out.write(String.valueOf(Math.min(timeA, timeB)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}