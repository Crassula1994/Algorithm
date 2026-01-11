package bronze1.num23739;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 챕터의 개수를 변수 chapterNum에 할당
		int chapterNum = Integer.parseInt(in.readLine());
		
		// 지환이가 절반 이상 공부한 챕터의 개수를 저장할 각 변수 초기화
		int count = 0;
		int remains = 30;
		
		// while 반복문을 사용해 각 챕터를 순회
		while (chapterNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 해당 챕터를 공부하는 데 필요한 시간을 변수 time에 할당
			int time = Integer.parseInt(in.readLine());
			
			// 해당 챕터를 절반 이상 공부할 수 있는 경우 지환이가 절반 이상 공부한 챕터의 개수를 갱신
			if (remains * 2 >= time)
				count++;
			
			// 공부시간을 갱신
			remains -= time;
			
			// 공부시간이 끝난 경우, 다음 공부 시간을 갱신
			if (remains <= 0)
				remains = 30;
		}
		
		// valueOf() 및 write() 메서드를 사용해 지환이가 절반 이상 공부한 챕터의 개수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}