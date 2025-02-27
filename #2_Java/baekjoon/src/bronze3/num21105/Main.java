package bronze3.num21105;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도넛 맛의 수를 변수 flavourNum에 할당
		int flavourNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 도넛 맛을 순회
		while (flavourNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 도넛의 새로운 가격 및 가격 변동 비율을 각 변수에 할당
			double newPrice = Double.parseDouble(st.nextToken());
			double changeRate = Double.parseDouble(st.nextToken());
			
			// 가격 변동 비율 공식에서 계산한 도넛의 원래 가격을 변수 originalPrice에 할당
			double originalPrice = newPrice * 100.0 / (100.0 + changeRate);
			
			// format() 및 write() 메서드를 사용해 도넛의 원래 가격을 출력
			out.write(String.format("%.9f\n", originalPrice));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}