package bronze2.num04592;

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

		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방문자들의 제출 횟수를 변수 count에 할당
			int count = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (count == 0)
				break;
			
			// 이전 숫자를 저장할 변수 prevNumber 초기화
			int prevNumber = 0;
			
			// while 반복문을 사용해 각 입력을 순회
			while (st.hasMoreTokens()) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 제출한 숫자를 변수 curNumber에 할당
				int curNumber = Integer.parseInt(st.nextToken());
				
				// 중복된 숫자인 경우 다음 숫자를 순회
				if (prevNumber == curNumber)
					continue;
				
				// write() 메서드를 사용해 중복되지 않은 숫자를 출력
				out.write(curNumber + " ");
				
				// 이전 숫자를 갱신
				prevNumber = curNumber;
			}
			
			// write() 메서드를 사용해 테스트 케이스를 구분하기 위한 '$' 출력
			out.write("$");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}