package bronze5.num28927;

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
		
		// 맥스와 멜이 비디오 시청에 할애한 시간을 저장할 각 변수 초기화
		int timeMax = 0;
		int timeMel = 0;
		
		// 트레일러, TV 쇼, 영화의 진행 시간을 저장할 배열 screenTimes 초기화
		int[] screenTimes = {3, 20, 120};
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 맥스가 비디오 시청에 할애한 시간을 갱신
		for (int idx = 0; idx < 3; idx++)
			timeMax += screenTimes[idx] * Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 멜이 비디오 시청에 할애한 시간을 갱신
		for (int idx = 0; idx < 3; idx++)
			timeMel += screenTimes[idx] * Integer.parseInt(st.nextToken());
		
		// 맥스가 멜보다 더 많은 시간을 비디오 시청에 할애한 경우 'Max'를 출력
		if (timeMax > timeMel) {
			out.write("Max");
			
		// 멜이 맥스보다 더 많은 시간을 비디오 시청에 할애한 경우 'Mel'을 출력
		} else if (timeMax < timeMel) {
			out.write("Mel");
			
		// 둘 다 비디오를 보는 데 동일한 시간을 보낸 경우 'Draw'를 출력
		} else {
			out.write("Draw");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}