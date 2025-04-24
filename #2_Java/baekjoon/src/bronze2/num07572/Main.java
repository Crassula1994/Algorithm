package bronze2.num07572;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 십간과 십이지의 서양식 간지 표현법을 저장할 각 배열 초기화
	static String[] heavenlyStems = {"6", "7", "8", "9", "0", "1", "2", "3", "4", "5"};
	static String[] earthlyBranches = {"I", "J", "K", "L", "A", "B", "C", "D", "E", "F", "G", "H"};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 주어진 연도를 변수 targetYear에 할당
		int targetYear = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 서양식 간지 표현법으로 표현한 문자열을 출력
		out.write(earthlyBranches[targetYear % 12]);
		out.write(heavenlyStems[targetYear % 10]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}