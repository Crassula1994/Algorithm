package bronze4.num10156;

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
			
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 과자 한 개의 가격, 사려고 하는 과자의 개수, 현재 동수가 가진 돈을 각 변수에 할당
		int price = Integer.parseInt(st.nextToken());
		int quantity = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
			
		// 동수가 부모님께 받아야 하는 돈을 계산해 변수 deficit에 할당
		int deficit = price * quantity - money;
		
		// 부모님께 받아야 하는 돈이 음수인 경우 0을 출력
		if (deficit < 0) {
			out.write(String.valueOf(0));
			
		// 부모님께 받아야 하는 돈이 음수가 아닌 경우 그대로 출력
		} else {
			out.write(String.valueOf(deficit));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}