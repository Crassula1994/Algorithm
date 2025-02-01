package bronze5.num30007;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 예찬이가 라면을 끓이는 횟수를 변수 totalCount에 할당
		int totalCount = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 라면을 끓이는 횟수를 순회
		while (totalCount-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 라면 계수, 기본 물의 양, 끓일 라면 수를 각 변수에 할당
			int coefficient = Integer.parseInt(st.nextToken());
			int baseAmount = Integer.parseInt(st.nextToken());
			int ramenNum = Integer.parseInt(st.nextToken());
			
			// 라면 공식에 따라 필요한 물의 양을 계산해 변수 waterAmount에 할당
			int waterAmount = coefficient * (ramenNum - 1) + baseAmount;
			
			// write() 메서드를 사용해 라면 공식에 따라 필요한 물의 양을 출력
			out.write(waterAmount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}