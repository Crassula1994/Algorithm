package bronze2.num01568;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 새의 수를 변수 birdNum에 할당
		int birdNum = Integer.parseInt(in.readLine());
		
		// 모든 새가 날아가기까지 걸리는 시간을 저장할 변수 totalTime 초기화
		int totalTime = 0;
		
		// while 반복문을 사용해 남은 새의 수가 0이 될 때까지 순회
		while (birdNum > 0) {
			
			// 노래하는 숫자를 저장할 변수 songNum 초기화
			int songNum = 1;
			
			// while 반복문을 사용해 노래하는 숫자가 남은 수의 새보다 같거나 적을 때까지 순회
			while (songNum <= birdNum) {
				
				// 노래를 부르며 날아간 새의 수를 갱신
				birdNum -= songNum;
				
				// 모든 새가 날아가기까지 걸리는 시간 및 노래하는 숫자를 갱신
				totalTime++;
				songNum++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 새가 날아가기까지 걸리는 시간을 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}