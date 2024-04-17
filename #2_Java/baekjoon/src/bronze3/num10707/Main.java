package bronze3.num10707;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 요금 및 상한, 수도의 양을 각 변수에 할당
		int rateX = Integer.parseInt(in.readLine());
		int basicY = Integer.parseInt(in.readLine());
		int boundY = Integer.parseInt(in.readLine());
		int rateY = Integer.parseInt(in.readLine());
		int usage = Integer.parseInt(in.readLine());
		
		// 두 회사의 수도 요금을 계산해 각 변수에 할당
		int totalX = rateX * usage;
		int totalY = (usage > boundY) ? basicY + (usage - boundY) * rateY : basicY;
		
		// min(), valueOf(), write() 메서드를 사용해 JOI 군의 집에서 지불하는 수도 요금을 출력
		out.write(String.valueOf(Math.min(totalX, totalY)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}