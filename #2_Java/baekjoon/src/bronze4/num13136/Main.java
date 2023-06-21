package bronze4.num13136;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌석의 세로 크기, 가로 크기, CCTV의 수용 범위를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int scope = Integer.parseInt(st.nextToken());
		
		// 필요한 CCTV의 최소 개수를 계산해 각 변수에 할당
		long minHeight = (height % scope == 0) ? height / scope : height / scope + 1;
		long minWidth = (width % scope == 0) ? width / scope : width / scope + 1;
		long minCount = minHeight * minWidth;
		
		// valueOf() 및 write() 메서드를 사용해 필요한 CCTV의 최소 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}