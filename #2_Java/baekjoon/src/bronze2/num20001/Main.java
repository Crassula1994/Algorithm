package bronze2.num20001;

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
		
		// 수진이가 해결하지 못한 문제의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 각 줄을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 줄을 변수 line에 할당
			String line = in.readLine();
			
			// 문제풀이를 종료한 경우 반복문 탈출
			if (line.equals("고무오리 디버깅 끝"))
				break;
			
			// 문제가 주어진 경우 문제의 개수를 갱신
			if (line.equals("문제")) {
				count++;
				
			// 고무오리가 주어진 경우 문제의 개수를 갱신
			} else if (line.equals("고무오리")) {
				count = (count == 0) ? 2 : count - 1;
			}
		}
		
		// write() 메서드를 사용해 주어진 문제를 수진이가 모두 해결했는지 여부를 출력
		out.write((count > 0) ? "힝구" : "고무오리야 사랑해");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}