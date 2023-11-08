package bronze4.num14652;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 관중석의 크기 및 잃어버린 관중석 번호를 각 변수에 할당
		@SuppressWarnings("unused")
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int seatNum = Integer.parseInt(st.nextToken());
		
		// write() 메서드를 사용해 욱제의 잃어버린 자리의 좌표를 출력
		out.write((seatNum / width) + " " + (seatNum % width));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}