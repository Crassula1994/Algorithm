package bronze4.num05554;

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
		
		// 총 이동 시간을 저장할 변수 time 초기화
		int time = 0;
		
		// for 반복문을 사용해 입력 받은 각 이동 시간을 총 이동 시간에 더해 갱신
		for (int t = 0; t < 4; t++)
			time += Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 총 이동 시간의 분과 초를 차례로 출력
		out.write((time / 60) + "\n" + (time % 60));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}