package silver4.num10158;

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
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 개미가 움직일 시간을 변수 time에 할당
		int time = Integer.parseInt(in.readLine());

		/*
		P = W-Math.abs(W-(T+P)%(2*W));
    	Q = H-Math.abs(H-(T+Q)%(2*H));
		*/
		
		// write() 메서드를 사용해 해당 관객의 좌석번호를 출력
		out.write((c + 1) + " " + (r + 1));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}