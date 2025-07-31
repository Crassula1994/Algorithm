package bronze3.num02991;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 개의 공격 시간과 쉬는 시간을 각 변수에 할당
		int attackTimeA = Integer.parseInt(st.nextToken());
		int breakTimeA = Integer.parseInt(st.nextToken());
		int attackTimeB = Integer.parseInt(st.nextToken());
		int breakTimeB = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 우체부, 우유배달원, 신문배달원의 도착 시간을 순회
		while (st.hasMoreTokens()) {
			
			// 해당 인원의 도착 시간을 변수 arrivalTime에 할당
			int arrivalTime = Integer.parseInt(st.nextToken());
			
			// 해당 인원이 공격 받게 되는 개의 마리 수와 각 개의 시간 중 위치하게 되는 시간을 계산해 저장할 각 변수를 초기화
			int count = 0;
			int timeCycleA = arrivalTime % (attackTimeA + breakTimeA);
			int timeCycleB = arrivalTime % (attackTimeB + breakTimeB);
			
			// 첫 번째 개에게 공격 받는 경우 해당 인원이 공격 받게 되는 개의 마리 수를 갱신
			if (timeCycleA >= 1 && timeCycleA <= attackTimeA)
				count++;
			
			// 두 번째 개에게 공격 받는 경우 해당 인원이 공격 받게 되는 개의 마리 수를 갱신
			if (timeCycleB >= 1 && timeCycleB <= attackTimeB)
				count++;
			
			// write() 메서드를 사용해 해당 인원이 공격 받게 되는 개의 마리 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}