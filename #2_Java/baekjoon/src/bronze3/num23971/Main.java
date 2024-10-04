package bronze3.num23971;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 강의실의 크기 및 거리두기 수칙을 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int rowDist = Integer.parseInt(st.nextToken());
		int colDist = Integer.parseInt(st.nextToken());
		
		// valueOf() 및 write() 메서드를 사용해 강의실이 수용할 수 있는 최대 인원 수를 출력
		out.write(String.valueOf(((height - 1) / (rowDist + 1) + 1) * ((width - 1) / (colDist + 1) + 1)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}