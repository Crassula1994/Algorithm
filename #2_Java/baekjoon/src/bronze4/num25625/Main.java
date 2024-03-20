package bronze4.num25625;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소요 시간을 각 변수에 할당
		int totalTime = Integer.parseInt(st.nextToken());
		int remainTime = Integer.parseInt(st.nextToken());
		
		// 버스가 서울대입구역에서 제2공학관으로 향하는 경우 버스에 탑승하기 위해서 기다려야 하는 시간을 출력
		if (totalTime > remainTime) {
			out.write(String.valueOf(totalTime + remainTime));
		
		// 버스가 제2공학관에서 서울대입구역으로 향하는 경우 버스에 탑승하기 위해서 기다려야 하는 시간을 출력
		} else {
			out.write(String.valueOf(remainTime - totalTime));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}