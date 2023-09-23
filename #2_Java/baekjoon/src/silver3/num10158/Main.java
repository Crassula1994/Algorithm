package silver3.num10158;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 격자 공간의 크기를 각 변수에 할당
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 현재 개미의 행과 열의 번호를 각 변수에 할당
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 개미가 움직일 시간을 변수 time에 할당
		int time = Integer.parseInt(in.readLine());
		
		// abs() 메서드를 사용해 주어진 시간 이후의 개미 위치 좌표를 계산해 각 변수에 할당
		int x = width - Math.abs(width - (p + time) % (2 * width));
		int y = height - Math.abs(height - (q + time) % (2 * height));
		
		// write() 메서드를 사용해 주어진 시간 이후의 개미 위치를 출력
		out.write(x + " " + y);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}