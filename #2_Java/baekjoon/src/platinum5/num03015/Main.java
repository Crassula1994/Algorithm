package platinum5.num03015;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {
	
	// Person 클래스 정의
	public static class Person {
		
		// 해당 사람의 키 및 동일한 키를 가진 사람의 연속 횟수를 저장할 각 변수 초기화
		int height;
		int count;
		
		// 매개변수를 입력 받는 생성자 정의
		public Person(int height, int count) {
			this.height = height;
			this.count = count;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 줄에서 기다리고 있는 사람의 수를 변수 personNum에 할당
		int personNum = Integer.parseInt(in.readLine());
		
		// 서로 볼 수 있는 쌍의 수를 저장할 변수 pairNum 초기화
		long pairNum = 0;
		
		// 각 사람이 서로 볼 수 있는지를 확인할 Stack 객체 pairFinder 초기화
		Stack<Person> pairFinder = new Stack<>();
		
		// for 반복문을 사용해 각 사람을 순회
		for (int idx = 0; idx < personNum; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 키를 변수 height에 할당
			int height = Integer.parseInt(in.readLine());
			
			// 해당 키를 가진 사람의 수를 저장할 변수 count 초기화
			int count = 1;
			
			// while 반복문을 사용해 pairFinder가 빌 때까지 순회
			while (!pairFinder.isEmpty()) {
				
				// 입력 받은 사람의 키가 가장 마지막에 저장된 사람의 키보다 작은 경우 반복문 탈출
				if (height < pairFinder.peek().height)
					break;
				
				// 입력 받은 사람의 키가 가장 마지막에 저장된 사람의 키와 같은 경우 해당 키를 가진 사람의 수를 갱신
				if (height == pairFinder.peek().height)
					count += pairFinder.peek().count;
				
				// pop() 메서드를 사용해 서로 볼 수 있는 쌍의 수를 갱신
				pairNum += pairFinder.pop().count;
			}
			
			// pairFinder가 비어 있지 않은 경우 서로 볼 수 있는 쌍의 수를 갱신
			if (!pairFinder.isEmpty())
				pairNum++;
			
			// push() 메서드를 사용해 해당 사람의 키와 그 수를 pairFinder에 추가
			pairFinder.push(new Person(height, count));
		}
		
		// valueOf() 및 write() 메서드를 사용해 서로 볼 수 있는 쌍의 수를 출력
		out.write(String.valueOf(pairNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}