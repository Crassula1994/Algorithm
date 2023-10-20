package bronze3.num10162;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 요리 시간을 변수 targetTime에 할당
		int targetTime = Integer.parseInt(in.readLine());
		
		// 정확한 시간을 맞출 수 없는 경우 -1을 출력
		if (targetTime % 10 != 0) {
			out.write(String.valueOf(-1));
		
		// 정확한 시간을 맞출 수 있는 경우
		} else {
			
			// 각 버튼의 조작 횟수를 계산해 각 변수에 할당
			int aCount = targetTime / 300;
			int bCount = (targetTime % 300) / 60;
			int cCount = ((targetTime % 300) % 60) / 10;
			
			// write() 메서드를 사용해 각 버튼의 조작 횟수를 출력
			out.write(aCount + " " + bCount + " " + cCount);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}