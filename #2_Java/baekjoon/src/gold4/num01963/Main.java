package gold4.num01963;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 네 자리 숫자가 소수인지 여부를 저장할 배열 isNotPrime 초기화
	static boolean[] isNotPrime = new boolean[10000];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 0과 1은 소수가 아니므로 소수가 아닌 것으로 갱신
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 2; number * number < 10000; number++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[number])
				continue;
			
			// for 반복문을 사용해 해당 숫자의 배수를 소수가 아닌 것으로 갱신
			for (int multiple = number * 2; multiple < 10000; multiple += number)
				isNotPrime[multiple] = true;
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 비밀번호와 목표 비밀번호를 각 변수에 할당
			int startPassword = Integer.parseInt(st.nextToken());
			int targetPassword = Integer.parseInt(st.nextToken());
			
			// changeCounter() 메서드를 사용해 두 소수 사이의 변환에 필요한 최소 횟수를 변수 minCount에 할당
			int minCount = changeCounter(startPassword, targetPassword);
			
			// valueOf() 및 write() 메서드를 사용해 두 소수 사이의 변환에 필요한 최소 횟수를 출력
			out.write((minCount == -1) ? "Impossible" : String.valueOf(minCount));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// changeCounter() 메서드 정의
	public static int changeCounter(int startPassword, int targetPassword) {
		
		// 해당 비밀번호의 변경 여부를 저장할 배열 changed 초기화
		Integer[] changed = new Integer[10000];
		
		// 다음에 변경할 비밀번호를 저장할 Queue 객체 changeList 초기화
		Queue<Integer> changeList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 비밀번호를 changeList에 추가 및 변경 처리
		changeList.offer(startPassword);
		changed[startPassword] = 0;
		
		// while 반복문을 사용해 changeList가 빌 때까지 순회
		while (!changeList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 비밀번호를 변수 curPassword에 할당
			int curPassword = changeList.poll();
			
			// 현재 비밀번호가 목표 비밀번호인 경우 변환에 필요한 최소 횟수를 반환
			if (curPassword == targetPassword)
				return changed[curPassword];
			
			// valueOf() 메서드를 사용해 해당 비밀번호를 문자열로 변환해 변수 numStr에 할당
			String numStr = String.valueOf(curPassword);
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int digit = 0; digit < 4; digit++) {
				
				// for 반복문을 사용해 해당 자릿수의 가능한 숫자를 순회
				for (int number = 0; number < 10; number++) {
					
					// 가장 앞자리가 0이거나 해당 숫자가 원래 자리 숫자와 동일한 경우 다음 숫자를 순회
					if ((digit == 0 && number == 0) || number == numStr.charAt(digit) - '0')
						continue;
					
					// substring() 및 parseInt() 메서드를 사용해 가능한 다음 비밀번호를 변수 nextPassword에 할당
					int nextPassword = Integer.parseInt(numStr.substring(0, digit) + number + numStr.substring(digit + 1));
					
					// 해당 비밀번호를 이미 확인했거나 소수가 아닌 경우 다음 비밀번호를 순회
					if (changed[nextPassword] != null || isNotPrime[nextPassword])
						continue;
					
					// offer() 메서드를 사용해 해당 비밀번호를 changeList에 추가 및 변경 처리
					changeList.offer(nextPassword);
					changed[nextPassword] = changed[curPassword] + 1;
				}
			}
		}
		
		// 목표 비밀번호를 만들지 못하는 경우 -1 반환
		return -1;
	}
}