package bronze4.num19944;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학년 기준 및 구분할 학년을 각 변수에 할당
		int standard = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		
		// 해당 학년이 뉴비인 경우 'NEWBIE!'를 출력
		if (year < 3) {
			out.write("NEWBIE!");
		
		// 해당 학년이 올드비인 경우 'OLDBIE!'를 출력
		} else if (year <= standard) {
			out.write("OLDBIE!");
		
		// 해당 학년이 TLE인 경우 'TLE!'를 출력
		} else {
			out.write("TLE!");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}