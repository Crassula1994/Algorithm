package bronze1.num27961;

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
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 키우기를 원하는 고양이의 수를 변수 targetCount에 할당
		long targetCount = Long.parseLong(in.readLine());
		
		// 고양이를 키우고 싶지 않을 경우 0을 출력
		if (targetCount == 0) {
			out.write(String.valueOf(0));
			
		// 고양이를 키우고 싶은 경우
		} else {
			
			// 현재 고양이의 수 및 고양이를 마도카의 집에 들일 수 있는 최소의 행동 횟수를 저장할 각 변수 초기화
			long count = 1;
			int minCount = 1;
			
			// while 반복문을 사용해 현재 고양이의 수 및 고양이를 마도카의 집에 들일 수 있는 최소의 행동 횟수를 갱신
			while (count < targetCount) {
				count *= 2;
				minCount++;
			}
			
			// valueOf() 및 write() 메서드를 사용해 고양이를 마도카의 집에 들일 수 있는 최소의 행동 횟수를 출력
			out.write(String.valueOf(minCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}