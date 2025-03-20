package bronze1.num09494;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 글의 줄 수를 변수 lineNum에 할당
			int lineNum = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (lineNum == 0)
				break;
			
			// 공이 떨어지는 세로단의 위치를 저장할 변수 dropPoint 초기화
			int dropPoint = 0;
			
			// for 반복문을 사용해 각 줄을 순회
			for (int line = 1; line <= lineNum; line++) {
				
				// readLine() 메서드를 사용해 글의 해당 줄을 변수 textLine에 할당
				String textLine = in.readLine();
				
				// 첫 번째 줄인 경우
				if (line == 1) {
					
					// while 반복문을 사용해 공이 떨어지는 세로단의 위치를 갱신
					while (textLine.charAt(dropPoint) == ' ')
						dropPoint++;
				}
				
				// while 반복문을 사용해 공이 떨어지는 세로단의 위치를 갱신
				while (dropPoint < textLine.length() && textLine.charAt(dropPoint) != ' ')
					dropPoint++;
			}
			
			// write() 메서드를 사용해 공이 떨어지는 세로단의 위치를 출력
			out.write(++dropPoint + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}