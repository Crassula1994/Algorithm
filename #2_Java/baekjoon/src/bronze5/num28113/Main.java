package bronze5.num28113;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스와 지하철에 탑승하게 되는 시간을 각 변수에 할당
		st.nextToken();
		int timeBus = Integer.parseInt(st.nextToken());
		int timeSubway = Integer.parseInt(st.nextToken());
		
		// 버스에 더 먼저 탑승할 수 있는 경우 'Bus' 출력
		if (timeBus < timeSubway) {
			out.write("Bus");
		
		// 지하철에 더 먼저 탑승할 수 있는 경우 'Subway' 출력
		} else if (timeBus > timeSubway) {
			out.write("Subway");
			
		// 버스와 지하철에 탑승하게 되는 시간이 동일한 경우 'Anything' 출력
		} else {
			out.write("Anything");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}