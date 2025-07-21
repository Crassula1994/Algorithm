package bronze4.num32025;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 운동장의 변의 길이를 센티미터 단위로 변환하고 각 변수에 할당
		int height = Integer.parseInt(in.readLine()) * 100;
		int width = Integer.parseInt(in.readLine()) * 100;
		
		// min(), valueOf(), write() 메서드를 사용해 운동장에 그릴 수 있는 가장 큰 원의 반지름의 길이를 센티미터 단위로 출력
		out.write(String.valueOf(Math.min(height, width) / 2));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}