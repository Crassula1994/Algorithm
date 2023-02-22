package silver5.num24313;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 함수 f(n)을 나타내는 정수를 각 변수에 할당
		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 양의 정수를 각 변수에 할당
		int c = Integer.parseInt(in.readLine());
		int n0 = Integer.parseInt(in.readLine());
		
		// 함수 f(n)의 결과를 계산해 변수 leftTerm에 할당
		int leftTerm = a1 * n0 + a0;
		
		// c × g(n)의 결과를 계산해 변수 rightTerm에 할당
		int rightTerm = c * n0;
		
		// O(n)의 정의를 만족하는지 여부를 나타내는 변수 isSatisfied 계산
		int isSatisfied = (leftTerm <= rightTerm && a1 <= c) ? 1 : 0;
		
		// valueOf() 및 write() 메서드를 사용해 O(n)의 정의를 만족하는지 여부를 출력
		out.write(String.valueOf(isSatisfied));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}