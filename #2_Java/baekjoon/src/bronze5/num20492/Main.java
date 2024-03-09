package bronze5.num20492;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 상금의 금액을 변수 cashPrize에 할당
		int cashPrize = Integer.parseInt(in.readLine());
		
		/* 전체 상금의 22%를 제세공과금으로 납부하는 경우와 상금의 80%를 필요 경비로 인정 받고
		나머지 금액 중 22%를 납부하는 경우를 계산해 각 변수에 할당 */
		int case1 = cashPrize / 100 * 78;
		int case2 = cashPrize / 10 * 8 + cashPrize / 10 * 2 / 100 * 78;
		
		// write() 메서드를 사용해 각 경우를 출력
		out.write(case1 + " " + case2);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}