package silver5.num14606;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 피자판의 개수를 변수 panNum에 할당
		int panNum = Integer.parseInt(in.readLine());
		
		// 피자판의 개수에서 얻을 수 있는 즐거움의 최댓값을 계산해 변수 pleasure에 할당
		int pleasure = panNum * (panNum - 1) / 2;
		
		// valueOf() 및 write() 메서드를 사용해 피자판의 개수에서 얻을 수 있는 즐거움의 최댓값을 출력
		out.write(String.valueOf(pleasure));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}