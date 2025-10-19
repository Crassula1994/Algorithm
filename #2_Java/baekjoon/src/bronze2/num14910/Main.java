package bronze2.num14910;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 이전 정수
		및 비내림차순으로 나열되어 있는지 여부를 저장할 각 변수 초기화 */
		int prevNumber = Integer.parseInt(st.nextToken());
		boolean isSorted = true;
		
		// while 반복문을 사용해 각 정수를 순회
		while (st.hasMoreTokens()) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 정수를 변수 curNumber에 할당
			int curNumber = Integer.parseInt(st.nextToken());
			
			// 비내림차순으로 나열되지 않은 경우 비내림차순으로 나열되어 있는지 여부를 갱신 후 반복문 탈출
			if (curNumber < prevNumber) {
				isSorted = false;
				break;
			}
			
			// 이전 정수를 갱신
			prevNumber = curNumber;
		}
		
		// write() 메서드를 사용해 비내림차순으로 나열되어 있는지 여부를 출력
		out.write((isSorted) ? "Good" : "Bad");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}