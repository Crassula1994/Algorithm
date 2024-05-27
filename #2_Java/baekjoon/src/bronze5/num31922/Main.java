package bronze5.num31922;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 대회의 상금을 각 변수에 할당
		int prizeA = Integer.parseInt(st.nextToken());
		int prizeP = Integer.parseInt(st.nextToken());
		int prizeC = Integer.parseInt(st.nextToken());
		
		// max() 메서드를 사용해 얻을 수 있는 최대 상금의 액수를 변수 maxPrize에 할당
		int maxPrize = Math.max(prizeA + prizeC, prizeP);
		
		// valueOf() 및 write() 메서드를 사용해 얻을 수 있는 최대 상금의 액수를 출력
		out.write(String.valueOf(maxPrize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}