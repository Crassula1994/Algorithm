package bronze2.num01773;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 폭죽을 터뜨리는 학생 수 및 폭죽쇼가 끝나는 시간을 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int endTime = Integer.parseInt(st.nextToken());
		
		// 밤하늘에 폭죽을 볼 수 있는 총 시간을 저장할 변수 totalTime 초기화
		int totalTime = 0;
		
		// 밤하늘에 폭죽을 볼 수 있는 시간을 저장할 배열 times 초기화
		boolean[] times = new boolean[endTime + 1];
		
		// while 반복문을 사용해 각 학생을 순회
		while (studentNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 해당 학생의 폭죽을 터뜨리는 주기를 변수 duration에 할당
			int duration = Integer.parseInt(in.readLine());
			
			// 이미 같은 주기를 가진 학생이 있는 경우 다음 학생을 순회
			if (times[duration])
				continue;
			
			// for 반복문을 사용해 각 주기를 순회
			for (int time = duration; time < times.length; time += duration) {
				
				// 이미 해당 시간에 폭죽이 터진 경우 다음 시간을 순회
				if (times[time])
					continue;
				
				// 해당 시간에 폭죽이 터졌는지 여부 및 밤하늘에 폭죽을 볼 수 있는 총 시간을 갱신
				times[time] = true;
				totalTime++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 밤하늘에 폭죽을 볼 수 있는 총 시간을 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}