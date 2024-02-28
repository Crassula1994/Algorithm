package bronze1.num10823;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 더 이상 문자열이 없을 때까지 문자열을 추가
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// 더 이상 문자열이 존재하지 않는 경우 반복문 탈출
			if (string == null || string.isEmpty())
				break;
			
			// append() 메서드를 사용해 입력 받은 문자열을 sb에 추가
			sb.append(string);
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		
		// 자연수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// while 반복문을 사용해 모든 자연수를 자연수의 합에 더해 갱신
		while (st.hasMoreTokens())
			sum += Integer.parseInt(st.nextToken());
		
		// valueOf() 및 write() 메서드를 사용해 자연수의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}