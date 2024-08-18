package bronze3.num17496;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 여름의 일 수, 스타후르츠가 자라는데 걸리는 일 수,
		스타후르츠를 심을 수 있는 칸의 수, 스타후르츠 개당 가격을 각 변수에 할당 */
		int dayLimit = Integer.parseInt(st.nextToken());
		int duration = Integer.parseInt(st.nextToken());
		int quantity = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		
		// 진수가 여름 동안 스타후르츠를 팔아 벌 수 있는 수익을 계산해 변수 revenue에 할당
		int revenue = (dayLimit - 1) / duration * quantity * price;
		
		// valueOf() 및 write() 메서드를 사용해 진수가 여름 동안 스타후르츠를 팔아 벌 수 있는 수익을 출력
		out.write(String.valueOf(revenue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}