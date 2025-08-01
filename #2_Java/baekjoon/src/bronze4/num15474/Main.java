package bronze4.num15474;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 필요한 연필의 개수,
		각 세트에 속한 연필의 개수와 그 가격을 각 변수에 할당 */
		int targetCount = Integer.parseInt(st.nextToken());
		int countX = Integer.parseInt(st.nextToken());
		int priceX = Integer.parseInt(st.nextToken());
		int countY = Integer.parseInt(st.nextToken());
		int priceY = Integer.parseInt(st.nextToken());
		
		// 세트 X와 Y를 구입했을 때 필요한 금액을 계산해 각 변수에 할당
		int costX = ((targetCount + countX - 1) / countX) * priceX;
		int costY = ((targetCount + countY - 1) / countY) * priceY;
		
		// min(), valueOf(), write() 메서드를 사용해 연필을 사기 위해 필요한 금액의 최솟값을 출력
		out.write(String.valueOf(Math.min(costX, costY)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}