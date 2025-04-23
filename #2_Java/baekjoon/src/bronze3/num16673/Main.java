package bronze3.num16673;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수빈이가 와인을 모은 년수, 고려대 애착 정도,
		구매 중독 정도를 각 변수에 할당 */
		int totalYear = Integer.parseInt(st.nextToken());
		int attachment = Integer.parseInt(st.nextToken());
		int addiction = Integer.parseInt(st.nextToken());
		
		// 수빈이가 수집한 와인의 수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// for 반복문을 사용해 수빈이가 수집한 와인의 수를 갱신
		for (int year = 1; year <= totalYear; year++)
			totalCount += attachment * year + addiction * year * year;
		
		// valueOf() 및 write() 메서드를 사용해 수빈이가 수집한 와인의 수를 출력
		out.write(String.valueOf(totalCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}