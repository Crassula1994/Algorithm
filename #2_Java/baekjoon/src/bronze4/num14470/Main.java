package bronze4.num14470;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 원래 고기의 온도, 목표 온도, 얼어 있는 고기를 1℃ 데우는 데 걸리는 시간,
		얼어 있는 고기를 해동하는 시간, 얼어 있지 않은 고기를 1℃ 데우는 데 걸리는 시간을 각 변수에 할당 */
		int startTemp = Integer.parseInt(in.readLine());
		int targetTemp = Integer.parseInt(in.readLine());
		int frozenTime = Integer.parseInt(in.readLine());
		int zeroTime = Integer.parseInt(in.readLine());
		int unfrozenTime = Integer.parseInt(in.readLine());
		
		// 고기를 해동하는 시간, 현재 고기의 온도를 저장할 변수 thrawingTime 초기화
		int thrawingTime = 0;
		int currentTemp = startTemp;
		
		// 현재 고기의 온도가 0℃ 미만일 경우
		if (currentTemp < 0) {
			
			// abs() 메서드를 사용해 0℃까지의 해동 시간을 계산하고 고기를 해동하는 시간 갱신
			thrawingTime += Math.abs(startTemp) * frozenTime;
			
			// 현재 고기의 온도를 갱신
			currentTemp = 0;
		}
		
		// 현재 고기의 온도가 0℃인 경우 0℃에서의 해동 시간을 계산하고 고기를 해동하는 시간 갱신
		if (currentTemp == 0)
			thrawingTime += zeroTime;
		
		// 목표 온도까지의 시간을 계산하고 고기를 해동하는 시간 갱신
		thrawingTime += (targetTemp - currentTemp) * unfrozenTime;
		
		// valueOf() 및 write() 메서드를 사용해 고기를 해동하는 시간을 출력
		out.write(String.valueOf(thrawingTime));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}