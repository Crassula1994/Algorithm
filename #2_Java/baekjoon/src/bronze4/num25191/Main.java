package bronze4.num25191;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 치킨의 총 개수를 변수 chickenNum에 할당
		int chickenNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 콜라의 개수와 맥주의 개수를 각 변수에 할당
		int cokeNum = Integer.parseInt(st.nextToken());
		int beerNum = Integer.parseInt(st.nextToken());
		
		// min() 메서드를 사용해 임스가 시켜먹을 수 있는 치킨의 총 개수를 계산해 변수 count에 할당
		int count = Math.min(cokeNum / 2 + beerNum, chickenNum);
		
		// valueOf() 및 write() 메서드를 사용해 임스가 시켜먹을 수 있는 치킨의 총 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}