package silver2.num10895;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 거듭제곱의 밑과 테트레이션 횟수를 각 변수에 할당
		int base = Integer.parseInt(st.nextToken());
		int tetrationCnt = Integer.parseInt(st.nextToken());
		
		// 테트레이션 횟수가 0이거나 밑이 홀수인 경우 밑에 1을 더한 값으로 나눈 나머지는 밑과 같으므로 밑을 출력
		if (tetrationCnt == 0 || base % 2 == 1) {
			out.write(String.valueOf(base));
		
		// 테트레이션 횟수가 1 이상이고, 밑이 짝수인 경우 밑에 1을 더한 값으로 나눈 나머지는 1이므로 1을 출력
		} else {
			out.write(String.valueOf(1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}