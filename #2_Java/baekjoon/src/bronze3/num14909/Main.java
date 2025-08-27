package bronze3.num14909;

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
		
		// 양의 정수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 숫자를 순회
		while (st.hasMoreTokens()) {
			
			// 해당 숫자가 양의 정수인 경우 양의 정수의 개수를 갱신
			if (Integer.parseInt(st.nextToken()) > 0)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 양의 정수의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}