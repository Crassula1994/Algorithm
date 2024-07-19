package bronze4.num06763;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 제한 속도 및 기록된 차의 속도를 각 변수에 할당
		int speedLimit = Integer.parseInt(in.readLine());
		int carSpeed = Integer.parseInt(in.readLine());
		
		// 차가 속도 위반을 하지 않은 경우 정해진 문구를 출력
		if (carSpeed <= speedLimit) {
			out.write("Congratulations, you are within the speed limit!");
		
		// 차가 속도 위반을 한 경우
		} else {
			
			// 차가 제한 속도보다 빠른 속도를 계산해 변수 overSpeed에 할당
			int overSpeed = carSpeed - speedLimit;
			
			// 해당 차의 벌금을 계산해 변수 fine에 할당
			int fine = (overSpeed > 20) ? (overSpeed > 30) ? 500 : 270 : 100;
			
			// write() 메서드를 사용해 정해진 문구를 출력
			out.write("You are speeding and your fine is $" + fine + ".");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}