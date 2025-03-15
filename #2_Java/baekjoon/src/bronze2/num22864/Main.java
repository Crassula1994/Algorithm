package bronze2.num22864;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 1시간 일할 때 쌓이는 피로도의 양과 처리하는 일의 양,
		한 시간을 쉴 때 줄어드는 피로도의 양, 번아웃이 오는 피로도의 양을 각 변수에 할당 */
		int fatigueInc = Integer.parseInt(st.nextToken());
		int workInc = Integer.parseInt(st.nextToken());
		int fatigueDec = Integer.parseInt(st.nextToken());
		int fatigueLimit = Integer.parseInt(st.nextToken());
		
		// 현재 피로도와 하루에 최대 일할 수 있는 양을 저장할 각 변수 초기화
		int curFatigue = 0;
		int maxWork = 0;
		
		// for 반복문을 사용해 하루의 각 시간을 순회
		for (int hour = 1; hour <= 24; hour++) {
		
			// 일을 해도 번아웃이 오지 않는 경우 일을 한 것으로 처리
			if (curFatigue + fatigueInc <= fatigueLimit) {
				 curFatigue += fatigueInc;
				 maxWork += workInc;
				 
			// 일을 하면 번아웃이 오는 경우 쉰 것으로 처리
			} else {
				curFatigue = Math.max(0, curFatigue - fatigueDec);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 하루에 최대 일할 수 있는 양을 출력
		out.write(String.valueOf(maxWork));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}