package silver4.num15088;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수 및 대너리스가 외친 명령의 수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int commandNum = Integer.parseInt(st.nextToken());
		
		// 게임이 끝날 때 알을 가진 학생의 번호를 저장할 변수 result 초기화
		int result = 0;
		
		// 대너리스가 외친 명령을 저장할 Stack 객체 commands 초기화
		Stack<Integer> commands = new Stack<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 명령을 순회
		for (int c = 0; c < commandNum; c++) {
			
			// nextToken() 메서드를 사용해 해당 명령어를 변수 command에 할당
			String command = st.nextToken();
			
			// 명령을 되돌려야 하는 경우
			if (command.equals("undo")) {
				
				// parseInt() 및 nextToken() 메서드를 사용해 명령을 되돌릴 횟수를 변수 count에 할당
				int count = Integer.parseInt(st.nextToken());
				
				// while 반복문을 사용해 명령을 되돌릴 횟수만큼 명령을 되돌리기
				while (count-- > 0)
					commands.pop();
				
			// 알을 전달할 거리를 명령한 경우 commands에 추가
			} else {
				commands.push(Integer.parseInt(command));
			}
		}
		
		// while 반복문을 사용해 게임이 끝날 때 알을 가진 학생의 번호를 갱신
		while (!commands.isEmpty())
			result += commands.pop();
		
		// 정해진 학생의 번호 범위를 벗어나지 않도록 게임이 끝날 때 알을 가진 학생의 번호를 조정
		result %= studentNum;
		result = (result < 0) ? result + studentNum : result;
		
		// valueOf() 및 write() 메서드를 사용해 게임이 끝날 때 알을 가진 학생의 번호를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}