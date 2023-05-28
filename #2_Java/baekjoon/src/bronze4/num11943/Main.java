package bronze4.num11943;

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
		
		// StringTokenzier 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 첫 번째 바구니의 사과와 오렌지의 수를 각 변수에 할당
		int apple1 = Integer.parseInt(st.nextToken());
		int orange1 = Integer.parseInt(st.nextToken());
		
		// StringTokenzier 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 번째 바구니의 사과와 오렌지의 수를 각 변수에 할당
		int apple2 = Integer.parseInt(st.nextToken());
		int orange2 = Integer.parseInt(st.nextToken());
		
		// min(), valueOf(), write() 메서드를 사용해 사과와 오렌지를 옮기는 최소 횟수를 출력
		out.write(String.valueOf(Math.min(apple1 + orange2, apple2 + orange1)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}