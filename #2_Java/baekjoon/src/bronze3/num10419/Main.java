package bronze3.num10419;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 창영이가 궁금한 경우의 수를 변수 caseNum에 할당
		int caseNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 경우의 수를 순회
		while (caseNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수업 시간을 변수 lectureTime에 할당
			int lectureTime = Integer.parseInt(in.readLine());
			
			// 교수님이 지각할 수 있는 최대 시간을 계산해 변수 maxTime에 할당
			int maxTime = (int) ((-1 + Math.sqrt(1 + 4 * lectureTime)) / 2);
			
			// write() 메서드를 사용해 교수님이 지각할 수 있는 최대 시간을 출력
			out.write(maxTime + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}