package gold5.num01013;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 직녀성의 전파 패턴을 변수 vegaPattern에 할당
		String vegaPattern = "(100+1+|01)+";  
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 전파 패턴을 변수 pattern에 할당
			String pattern = in.readLine();
			
			// matches() 메서드를 사용해 해당 전파 패턴이 직녀성의 그것과 일치하는지 여부를 변수 isMatched에 저장
			boolean isMatched = Pattern.matches(vegaPattern, pattern);
			
			// 해당 전파 패턴이 직녀성의 그것과 일치하는지 나타내는 문자열을 변수 result에 할당
			String result = (isMatched) ? "YES" : "NO";
			
			// write() 메서드를 사용해 해당 전파 패턴이 직녀성의 그것과 일치하는지 여부를 출력
			out.write(result + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}