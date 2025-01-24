package bronze4.num17874;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 케이크의 한 변의 길이, 케이크를 가로로 자른 선이 위쪽으로부터 떨어진 거리,
		케이크를 세로로 자른 선이 케이크의 왼쪽으로부터 떨어진 거리를 각 변수에 할당 */
		int length = Integer.parseInt(st.nextToken());
		int depth = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// max() 메서드를 사용해 케이크의 가장 큰 조각의 부피를 계산하고 변수 maxVolume에 할당
		int maxVolume = Math.max(depth, length - depth) * Math.max(width, length - width) * 4;
		
		// valueOf() 및 write() 메서드를 사용해 케이크의 가장 큰 조각의 부피를 출력
		out.write(String.valueOf(maxVolume));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}