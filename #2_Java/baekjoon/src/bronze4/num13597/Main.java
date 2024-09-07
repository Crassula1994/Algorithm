package bronze4.num13597;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 처음에 받은 두 카드의 숫자를 각 변수에 할당
		int cardA = Integer.parseInt(st.nextToken());
		int cardB = Integer.parseInt(st.nextToken());
		
		// max(), valueOf(), write() 메서드를 사용해 플레이어가 승리할 가능성이 가장 높은 나머지 카드의 숫자를 출력
		out.write(String.valueOf(Math.max(cardA, cardB)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}