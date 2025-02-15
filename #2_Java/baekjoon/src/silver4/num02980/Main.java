package silver4.num02980;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신호등의 개수 및 도로의 길이를 각 변수에 할당
		int lightNum = Integer.parseInt(st.nextToken());
		int roadLength = Integer.parseInt(st.nextToken());
		
		// 현재 상근이의 위치 및 상근이가 이동하는 데 걸린 시간을 저장할 각 변수 초기화
		int curLocation = 0;
		int totalTime = 0;
		
		// while 반복문을 사용해 각 신호등을 순회
		while (lightNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신호등의 위치 및 빨간불, 파란불이 지속되는 시간을 각 변수에 할당
			int location = Integer.parseInt(st.nextToken());
			int redTime = Integer.parseInt(st.nextToken());
			int greenTime = Integer.parseInt(st.nextToken());
			
			// 현재 신호등까지 이동하는 데 필요한 시간 및 현재 상근이의 위치를 갱신
			totalTime += location - curLocation;
			curLocation = location;
			
			// 신호등에 도달했을 때의 시간을 변수 curTime에 할당
			int curTime = totalTime % (redTime + greenTime);
			
			// 신호등 대기 여부에 따라 상근이가 이동하는 데 걸린 시간을 갱신
			totalTime = (curTime < redTime) ? totalTime + redTime - curTime : totalTime;
		}
		
		// 상근이가 마지막 신호등으로부터 나머지 도로를 이동하는 시간을 갱신
		totalTime += roadLength - curLocation;
		
		// valueOf() 및 write() 메서드를 사용해 상근이가 이동하는 데 걸린 시간을 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}