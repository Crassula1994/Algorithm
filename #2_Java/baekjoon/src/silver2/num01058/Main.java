package silver2.num01058;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 사람의 수를 저장할 변수 personNum 초기화
	static int personNum;
	
	// 각 사람의 인간관계를 저장할 2차원 배열 friendship 초기화
	static boolean[][] friendship;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 사람의 수를 변수 personNum에 할당
		personNum = Integer.parseInt(in.readLine());
		
		// 각 사람의 인간관계를 저장할 2차원 배열 friendship 초기화
		friendship = new boolean[personNum][personNum];
		
		// for 반복문을 사용해 입력 받은 친구 관계의 행을 순회
		for (int r = 0; r < personNum; r++) {
			
			// readLine() 메서드를 사용해 친구 관계의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 입력 받은 친구 관계의 상태를 순회
			for (int c = 0; c < personNum; c++) {
				
				// 해당 관계가 친구 관계인 경우 해당 인간관계를 갱신
				if (line.charAt(c) == 'Y')
					friendship[r][c] = true;
			}
		}
		
		// 가장 유명한 사람의 2-친구 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// for 반복문을 사용해 각 사람을 순회
		for (int person = 0; person < personNum; person++) {
			
			// friendCounter() 메서드를 호출해 해당 사람의 2-친구 수를 반환해 변수 count에 할당
			int count = friendCounter(person);
			
			// max() 메서드를 사용해 가장 유명한 사람의 2-친구 수를 갱신
			maxCount = Math.max(count, maxCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 유명한 사람의 2-친구 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// friendConter() 메서드 정의
	public static int friendCounter(int startPerson) {
		
		// 해당 사람의 2-친구 수를 저장할 변수 count 초기화
		int count = 0;

		// 해당 사람을 확인했는지 여부를 나타낼 배열 counted 초기화
		Integer[] counted = new Integer[personNum];
		
		// 다음에 확인할 사람을 저장할 	Queue 객체 countList 초기화
		Queue<Integer> countList = new LinkedList<>();
		
		// offer() 메서드를 사용해 주어진 사람을 countList에 추가 및 주어진 사람의 확인 여부 갱신
		countList.offer(startPerson);
		counted[startPerson] = 0;
		
		// while 반복문을 사용해 countList가 빌 때까지 순회
		while (!countList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 사람을 변수 curPerson에 할당
			int curPerson = countList.poll();
			
			// 2-친구의 범위를 벗어난 경우 다음 사람을 순회
			if (counted[curPerson] == 2)
				continue;
			
			// for 반복문을 사용해 현재 확인 중인 사람의 인간 관계를 순회
			for (int nextPerson = 0; nextPerson < personNum; nextPerson++) {
				
				// 해당 사람을 이미 확인했거나 해당 사람과 친구 관계가 아닌 경우 다음 사람을 순회
				if (counted[nextPerson] != null || !friendship[curPerson][nextPerson])
					continue;
				
				// offer() 메서드를 사용해 친구인 사람을 countList에 추가
				countList.offer(nextPerson);
				
				// 주어진 사람의 확인 여부 및 2-친구 수 갱신
				counted[nextPerson] = counted[curPerson] + 1;
				count++;
			}
		}
		
		// 해당 사람의 2-친구 수를 반환
		return count;
	}
}