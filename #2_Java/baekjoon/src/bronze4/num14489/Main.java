package bronze4.num14489;

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

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 통장의 잔고를 각 변수에 할당
		int bankBalanceA = Integer.parseInt(st.nextToken());
		int bankBalanceB = Integer.parseInt(st.nextToken());
		
		// 두 통장 잔고의 합을 계산해 변수 sum에 할당
		int sum = bankBalanceA + bankBalanceB;

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 치킨 한 마리의 가격을 변수 chickenPrice에 할당
		int chickenPrice = Integer.parseInt(in.readLine());
		
		// 치킨 두 마리를 살 수 있는 경우와 그렇지 않은 경우의 각각의 통장 잔고의 합을 계산해 변수 result에 할당
		int result = (sum < 2 * chickenPrice) ? sum : sum - 2 * chickenPrice;
		
		// valueOf() 및 write() 메서드를 사용해 정답을 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}