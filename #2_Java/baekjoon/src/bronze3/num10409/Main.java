package bronze3.num10409;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 일의 개수 및 일을 처리할 수 있는 시간을 각 변수에 할당
		int workNum = Integer.parseInt(st.nextToken());
		int timeLimit = Integer.parseInt(st.nextToken());
		
		// 현재 일을 끝낸 후 시간, 시간 내에 완료될 수 있는 일의 개수를 저장할 각 변수 초기화
		int curTime = 0;
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 일을 순회
		while (workNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 일의 수행 시간을 변수 time에 할당
			int time = Integer.parseInt(st.nextToken());
			
			// 해당 일을 수행할 수 없는 경우 반복문 탈출
			if (curTime + time > timeLimit)
				break;
			
			// 현재 일을 끝낸 후 시간, 시간 내에 완료될 수 있는 일의 개수를 갱신
			curTime += time;
			count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 시간 내에 완료될 수 있는 일의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}