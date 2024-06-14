package silver2.num17300;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 패턴의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 해당 패턴이 가능한 패턴인지 여부를 나타낼 변수 isPossible 초기화
		boolean isPossible = true;
		
		// 입력 받은 패턴, 각 숫자의 등장 여부를 저장할 각 배열 초기화
		int[] pattern = new int[length];
		boolean[] pressed = new boolean[10];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 패턴의 번호를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 패턴을 배열 pattern에 저장
			pattern[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 숫자가 이미 등장한 경우 가능한 패턴인지 여부를 갱신 후 반복문 탈출
			if (pressed[pattern[idx]]) {
				isPossible = false;
				break;
			}
			
			// 해당 숫자의 등장 여부를 갱신
			pressed[pattern[idx]] = true;
			
			// 해당 숫자가 첫 번째 등장한 숫자이거나 5인 경우 다음 숫자를 순회
			if (idx == 0 || pattern[idx] == 5)
				continue;
			
			// 해당 숫자가 짝수이고 도달할 수 없는 숫자가 아닌 경우 다음 숫자를 순회
			if (pattern[idx] % 2 == 0 && pattern[idx] + pattern[idx - 1] != 10)
				continue;
				
			// 해당 숫자가 홀수이고 도달할 수 없는 숫자가 아닌 경우 다음 숫자를 순회
			if (pattern[idx] % 2 == 1 && (pattern[idx - 1] % 2 == 0 || pattern[idx - 1] == 5))
				continue;
			
			// 두 숫자의 중간 숫자가 등장한 적 없는 경우 가능한 패턴인지 여부를 갱신 후 반복문 탈출
			if (!pressed[(pattern[idx] + pattern[idx - 1]) / 2]) {				
				isPossible = false;
				break;
			}
		}
		
		// write() 메서드를 사용해 해당 패턴이 가능한 패턴인지 여부를 출력
		out.write((isPossible) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}