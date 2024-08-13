package silver3.num09479;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 핑의 청취음을 배열 pings에 할당
			char[] pings = in.readLine().toCharArray();
			
			// 0이 입력된 경우 반복문 탈출
			if (pings.length == 1)
				break;
			
			// for 반복문을 사용해 각 시간을 순회
			for (int time = 1; time < pings.length; time++) {
				
				// 핑이 청취되지 않은 경우 다음 시간을 순회
				if (pings[time] == '0')
					continue;
				
				// write() 메서드를 사용해 위성의 핑이 청취된 시간을 출력
				out.write(time + " ");
				
				// for 반복문을 사용해 해당 위성의 시간 간격의 핑을 갱신
				for (int interval = time; interval < pings.length; interval += time)
					pings[interval] = (pings[interval] == '1') ? '0' : '1';
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}