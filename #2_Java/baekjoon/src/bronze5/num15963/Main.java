package bronze5.num15963;

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
		
		/* nextToken() 및 parseLong() 메서드를 사용해 입력 받은 송찬이가 필요한 배터리, 선생님이 가져온 배터리를
		각 변수에 할당 */
		long demand = Long.parseLong(st.nextToken());
		long supply = Long.parseLong(st.nextToken());
		
		// 송찬이가 원한 배터리인 경우 1을 출력
		if (demand == supply) {
			out.write(String.valueOf(1));
		
		// 송찬이가 원한 배터리가 아닌 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}