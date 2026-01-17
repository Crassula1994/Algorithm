package bronze1.num02929;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 예전 프로세서용 머신 코드 프로그램을 변수 program에 할당
		String program = in.readLine();
		
		// 삽입해야 하는 NOP 개수의 최솟값을 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 각 명령의 파라미터 개수를 저장할 배열 commands 초기화
		int[] commands = new int[26];
		
		// fills() 메서드를 사용해 각 명령의 파라미터 개수를 초기화
		Arrays.fill(commands, -1);
		
		// 현재 명령어와 해당 명령어의 파라미터 개수를 저장할 각 변수 초기화
		int curCommand = -1;
		int paramCount = 0;
		
		// for 반복문을 사용해 프로그램의 메모리를 순회
		for (int idx = 0; idx < program.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 메모리의 값을 변수 value에 할당
			char value = program.charAt(idx);
			
			// 해당 메모리의 값이 파라미터인 경우 파라미터 개수를 저장 후 다음 메모리를 순회
			if (value >= 'a') {
				paramCount++;
				continue;
			}
			
			/* 이전에 파라미터 개수가 저장되지 않은 명령어가 있는 경우 해당 명령어의 파라미터 개수
			및 삽입해야 하는 NOP 개수의 최솟값를 갱신하고 파라미터 개수를 초기화 */
			if (curCommand >= 0 && commands[curCommand] == -1) {
				commands[curCommand] = paramCount;
				minCount = ((paramCount + 1) % 4 == 0) ? minCount : minCount + 4 - (paramCount + 1) % 4;
				paramCount = 0;
			}
			
			// 현재 명령어를 갱신
			curCommand = value - 'A';
			
			/* 해당 명령어가 이미 이전에 나왔고 마지막 명령어가 아닌 경우
			현재 메모리의 위치 및 삽입해야 하는 NOP 개수의 최솟값을 갱신 */
			if (commands[curCommand] != -1 && idx + commands[curCommand] < program.length() - 1) {
				minCount = ((commands[curCommand] + 1) % 4 == 0)
						? minCount : minCount + 4 - (commands[curCommand] + 1) % 4;
				idx += commands[curCommand];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 삽입해야 하는 NOP 개수의 최솟값을 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}