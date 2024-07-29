package bronze3.num02921;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도미노 세트의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 도미노 세트에 존재하는 점의 개수를 계산해 변수 dotNum에 할당
		int dotNum = size * (size + 1) * (size + 2) / 2;
		
		// valueOf() 및 write() 메서드를 사용해 도미노 세트에 존재하는 점의 개수를 출력
		out.write(String.valueOf(dotNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}