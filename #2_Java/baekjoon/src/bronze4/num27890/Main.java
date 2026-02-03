package bronze4.num27890;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 0초에서의 분수의 높이
		및 분수 높이를 출력하고자 하는 시간 초를 저장할 각 변수 초기화 */
		int height = Integer.parseInt(st.nextToken());
		int targetTime = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 초에서 분수의 높이를 갱신
		while (targetTime-- > 0)
			height = ((height & 1) == 0) ? height >> 1 ^ 6 : height << 1 ^ 6;
		
		// valueOf() 및 write() 메서드를 사용해 분수 높이를 출력하고자 하는 시간에서의 분수 높이를 출력
		out.write(String.valueOf(height));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}