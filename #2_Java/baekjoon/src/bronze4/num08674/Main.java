package bronze4.num08674;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 초콜릿의 가로와 세로에 있는 조각의 수를 각 변수에 할당
		long widthCount = Long.parseLong(st.nextToken());
		long heightCount = Long.parseLong(st.nextToken());
		
		// 가로에 있는 조각의 수와 세로에 있는 조각의 수 중 짝수인 것이 존재하는 경우 0을 출력
		if ((widthCount & 1) == 0 || (heightCount & 1) == 0) {
			out.write("0");
			
		// 가로와 세로에 있는 조각의 수가 모두 홀수인 경우 두 소년이 받게 될 초콜릿 조각 수의 차이의 최솟값을 출력
		} else {
			out.write(String.valueOf(Math.min(widthCount, heightCount)));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}