package bronze4.num16199;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 생년월일을 각 변수에 할당
		int birthYear = Integer.parseInt(st.nextToken());
		int birthMonth = Integer.parseInt(st.nextToken());
		int birthDay = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 기준 날짜를 각 변수에 할당
		int curYear = Integer.parseInt(st.nextToken());
		int curMonth = Integer.parseInt(st.nextToken());
		int curDay = Integer.parseInt(st.nextToken());
		
		// 만 나이, 세는 나이, 연 나이를 계산해 각 변수에 할당
		int worldAge = (curMonth > birthMonth || (curMonth == birthMonth && curDay >= birthDay))
				? curYear - birthYear : curYear - birthYear - 1;
		int koreanAge = curYear - birthYear + 1;
		int lawAge = curYear - birthYear;
		
		// write() 메서드를 사용해 만 나이, 세는 나이, 연 나이를 출력
		out.write(worldAge + "\n" + koreanAge + "\n" + lawAge);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}