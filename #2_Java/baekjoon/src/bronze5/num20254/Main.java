package bronze5.num20254;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 지역 점수를 각 변수에 할당
		int universityR = Integer.parseInt(st.nextToken());
		int teamR = Integer.parseInt(st.nextToken());
		int universityO = Integer.parseInt(st.nextToken());
		int teamO = Integer.parseInt(st.nextToken());
		
		// 최종 지역 점수를 계산해 변수 result에 할당
		int result = 56 * universityR + 24 * teamR + 14 * universityO + 6 * teamO;
		
		// valueOf() 및 write() 메서드를 사용해 최종 지역 점수를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}