package bronze3.num04766;

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
		
		// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 혼합물의 온도를 변수 prevTemp에 할당
		double prevTemp = Double.parseDouble(in.readLine());
		
		// while 반복문을 사용해 각 혼합물의 온도를 순회
		while (true) {
			
			// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 변화한 혼합물의 온도를 변수 curTemp에 할당
			double curTemp = Double.parseDouble(in.readLine());
			
			// 마지막 측정이 끝난 경우 반복문 탈출
			if (curTemp == 999)
				break;
			
			// format() 및 write() 메서드를 사용해 혼합물의 이전 온도와의 차이를 출력
			out.write(String.format("%.2f\n", curTemp - prevTemp));
			
			// 이전 혼합물의 온도를 갱신
			prevTemp = curTemp;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}