package bronze4.num21612;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 물이 끓기 시작하는 온도를 변수 temperature에 할당
		int temperature = Integer.parseInt(in.readLine());
		
		// 물이 끓기 시작하는 온도를 기준으로 계산한 대기압을 변수 atmoPressure에 할당
		int atmoPressure = 5 * temperature - 400;
		
		// altitudeFinder() 및 write() 메서드를 사용해 대기압, 그리고 해수면을 기준으로 현재 어디에 위치해 있는지를 출력
		out.write(atmoPressure + "\n" + altitudeFinder(atmoPressure));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// altitudeFinder() 메서드 정의
	private static String altitudeFinder(int atmoPressure) {
		
		// 대기압이 100인 경우 해수면 상에 위치해 있으므로 0을 반환
		if (atmoPressure == 100)
			return "0";
		
		// 해수면 위 또는 아래에 있는지 여부를 반환
		return (atmoPressure > 100) ? "-1" : "1";
	}
}