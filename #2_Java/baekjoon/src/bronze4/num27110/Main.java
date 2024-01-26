package bronze4.num27110;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 치킨의 수를 변수 totalCnt에 할당
		int totalCnt = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 후라이드 치킨, 간장 치킨, 양념 치킨을 각각 가장 선호하는 병사의 수를 각 변수에 할당
		int friedCnt = Integer.parseInt(st.nextToken());
		int spicyCnt = Integer.parseInt(st.nextToken());
		int soySauceCnt = Integer.parseInt(st.nextToken());
		
		// min() 메서드를 사용해 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원 수를 계산해 변수 maxCount에 할당
		int maxCount = Math.min(friedCnt, totalCnt) + Math.min(spicyCnt, totalCnt) + Math.min(soySauceCnt, totalCnt);
		
		// valueOf() 및 write() 메서드를 사용해 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}