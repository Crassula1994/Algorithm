package bronze3.num02857;

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
		
		// FBI 요원이 존재하는지 여부를 나타낼 변수 isFound 초기화
		boolean isFound = false;
		
		// for 반복문을 사용해 각 첩보원명을 순회
		for (int number = 1; number <= 5; number++) {
			
			// readLine() 메서드를 사용해 입력 받은 첩보원명을 변수 name에 할당
			String name = in.readLine();
			
			// 해당 첩보원명에 'FBI'가 들어있는 경우
			if (name.contains("FBI")) {
				
				// write() 메서드를 사용해 FBI 요원의 번호를 출력
				out.write(number + " ");
				
				// FBI 요원이 존재하는지 여부를 갱신
				isFound = true;
			}
		}
		
		// FBI 요원이 존재하지 않는 경우 'HE GOT AWAY!' 출력
		if (!isFound)
			out.write("HE GOT AWAY!");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}