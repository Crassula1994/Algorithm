package bronze1.num02869;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 저장
		int climb = Integer.parseInt(st.nextToken());
		int drop = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// 나무 막대를 모두 올라가는 데 필요한 날짜를 저장할 변수 day 계산
		int day = (height - drop) / (climb - drop);
		
		// 완전히 나누어 떨어지지 않는 경우 날짜 조정
		if ((height - drop) % (climb - drop) != 0)
			day++;
		
		// valueOf() 및 write() 메서드를 사용해 주어진 높이까지 오르는 데 걸리는 날짜를 출력
		out.write(String.valueOf(day));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}