package bronze2.num01408;

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
		StringTokenizer st = new StringTokenizer(in.readLine(), ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 현재 시간을 계산하고 변수 curTime에 할당
		int curTime = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60
				+ Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine(), ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 임무 시작 시간을 계산하고 변수 startTime에 할당
		int startTime = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60
				+ Integer.parseInt(st.nextToken());
		
		// 임무를 수행하는 데 남은 시간을 계산해 변수 remainTime에 할당
		int remainTime = (curTime < startTime) ? startTime - curTime : startTime - curTime + 86400;
		
		// format() 및 write() 메서드를 사용해 도현이가 임무를 수행하는 데 남은 시간을 출력
		out.write(String.format("%02d:%02d:%02d", remainTime / 3600, (remainTime / 60) % 60, remainTime % 60));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}