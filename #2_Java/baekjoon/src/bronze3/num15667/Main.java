package bronze3.num15667;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 폭죽이 만든 중형, 소형 불꽃의 개수를 변수 flameNum에 할당
		int flameNum = Integer.parseInt(in.readLine()) - 1;
		
		// sqrt() 메서드를 사용해 구한 K값을 변수 valueK에 할당
		int valueK = (int) (Math.sqrt(1 + 4 * flameNum) / 2);
		
		// valueOf() 및 write() 메서드를 사용해 K값을 출력
		out.write(String.valueOf(valueK));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}