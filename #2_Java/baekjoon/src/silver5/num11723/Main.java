package silver5.num11723;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 명령어의 수를 변수 commands에 할당
		int commands = Integer.parseInt(in.readLine());
		
		// 정수를 저장할 Set 객체 set 초기화
		Set<Integer> set = new HashSet<>();
		
		// for 반복문을 사용해 각 명령어를 순회
		for (int c = 0; c < commands; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 명령어를 command에 할당
			String command = st.nextToken();
			
			// 입력 받은 숫자를 저장할 변수 number 초기화
			int number = 0;
			
			// switch 조건문을 사용해 명령어에 따라 명령 수행
			switch (command) {
			
			// 'add'를 입력받은 경우
			case "add":
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 Set 객체에 숫자 추가
				set.add(number);
				
				// 조건문 탈출
				break;
				
			// 'remove'를 입력받은 경우
			case "remove":
					
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(st.nextToken());
				
				// remove() 메서드를 사용해 Set 객체에서 숫자 제거
				set.remove(number);
				
				// 조건문 탈출
				break;
			
			// 'check'를 입력받은 경우
			case "check":
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(st.nextToken());
				
				// contains() 메서드를 사용해 Set 객체에 숫자가 있는 경우 1, 그렇지 않은 경우 0을 변수 isContain에 저장
				int isContain = (set.contains(number)) ? 1 : 0;
				
				// write() 메서드를 사용해 Set 객체에 해당 숫자가 존재하는지 여부를 출력 후 조건문 탈출
				out.write(isContain  + "\n");
				break;
				
			// 'toggle'을 입력받은 경우
			case "toggle":
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(st.nextToken());
				
				// 해당 숫자가 존재하는 경우 해당 숫자를 제거
				if (set.contains(number)) {
					set.remove(number);
				
				// 해당 숫자가 존재하지 않는 경우 해당 숫자를 추가
				} else {
					set.add(number);
				}
				
				// 조건문 탈출
				break;
			
			// 'all'을 입력받은 경우
			case "all":
				
				// for 반복문을 사용해 20까지의 모든 값을 추가
				for (int num = 1; num <= 20; num++)
					set.add(num);
				
				// 조건문 탈출
				break;
				
			// 'empty'를 입력받은 경우
			case "empty":
				
				// clear() 메서드를 사용해 Set 객체의 모든 원소 제거
				set.clear();
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}