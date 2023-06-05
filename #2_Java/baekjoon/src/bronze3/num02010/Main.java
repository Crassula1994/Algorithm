package bronze3.num02010;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 멀티탭의 개수를 변수 stripNum에 할당
		int stripNum = Integer.parseInt(in.readLine());
		
		// 최대로 전원에 연결될 수 있는 컴퓨터의 수를 저장할 변수 maxComCnt 초기화
		int maxComCnt = 0;
		
		// for 반복문을 사용해 각 멀티탭을 순회
		for (int strip = 0; strip < stripNum; strip++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 해당 멀티탭의 플러그 개수를 변수 plugCnt에 할당
			int plugCnt = Integer.parseInt(in.readLine());
			
			// 해당 멀티탭이 마지막 멀티탭인 경우 
			if (strip == stripNum - 1) {
				
				// 모든 플러그의 개수를 최대로 전원에 연결될 수 있는 컴퓨터의 수에 합산
				maxComCnt += plugCnt;
			
			// 해당 멀티탭이 마지막 멀티탭이 아닌 경우
			} else {
				
				// 다음 플러그를 꽂을 위치를 제외한 나머지를 최대로 전원에 연결될 수 있는 컴퓨터의 수에 합산
				maxComCnt += plugCnt - 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해  최대로 전원에 연결될 수 있는 컴퓨터의 수를 출력
		out.write(String.valueOf(maxComCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}