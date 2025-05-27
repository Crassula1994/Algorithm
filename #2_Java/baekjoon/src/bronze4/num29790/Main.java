package bronze4.num29790;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지원자의 문제 해결 개수, 유니온 레벨, 최고 레벨을 각 변수에 할당
		int solvedNum = Integer.parseInt(st.nextToken());
		int unionLevel = Integer.parseInt(st.nextToken());
		int maxLevel = Integer.parseInt(st.nextToken());
		
		// 조건을 모두 만족하는 경우 'Very Good'을 출력
		if (solvedNum >= 1000 && (unionLevel >= 8000 || maxLevel >= 260)) {
			out.write("Very Good");
			
		// 백준의 대회 출제 조건만 만족하는 경우 'Good'을 출력
		} else if (solvedNum >= 1000) {
			out.write("Good");
			
		// 백준의 대회 출제 조건을 만족하지 못하는 경우 'Bad'를 출력
		} else {
			out.write("Bad");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}