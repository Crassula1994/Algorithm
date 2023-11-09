package silver1.num01325;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Computer 클래스 정의
	public static class Computer {
		
		// 컴퓨터의 번호를 저장할 변수 number 초기화
		int number;
		
		// 신뢰 관계인 컴퓨터를 저장할 List 객체 trustList 초기화
		List<Computer> trustList;
		
		// 인수를 입력 받는 생성자 정의
		public Computer(int index) {
			this.number = index;
			trustList = new ArrayList<>(); 
		}
	}
	
	// 컴퓨터의 수, 신뢰 관계의 수를 저장할 각 변수 초기화
	static int computerNum;
	static int connNum;
	
	// 각 컴퓨터의 정보, 해킹할 수 있는 컴퓨터의 수, 각 컴퓨터의 해킹 확인 여부를 저장할 각 배열 초기화
	static Computer[] computers;
	static int[] hackCounter;
	static boolean[] hacked;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 가장 많이 해킹할 수 있는 컴퓨터의 번호를 저장할 List 객체 computerList 초기화
		List<Integer> computerList = new ArrayList<>();
		
		// 가장 많이 해킹할 수 있는 컴퓨터의 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 컴퓨터의 수 및 신뢰 관계의 수를 각 변수에 할당
		computerNum = Integer.parseInt(st.nextToken());
		connNum = Integer.parseInt(st.nextToken());
		
		// 각 컴퓨터의 정보, 해킹할 수 있는 컴퓨터의 수를 저장할 각 배열 초기화
		computers = new Computer[computerNum + 1];
		hackCounter = new int[computerNum + 1];
		
		// for 반복문을 사용해 각 컴퓨터의 정보를 저장할 각 Computer 객체 초기화
		for (int idx = 0; idx < computers.length; idx++)
			computers[idx] = new Computer(idx);

		// for 반복문을 사용해 각 신뢰 관계를 순회
		for (int conn = 0; conn < connNum; conn++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신뢰하는 컴퓨터와 신뢰 받는 컴퓨터를 각 변수에 할당
			int fromComputer = Integer.parseInt(st.nextToken());
			int toComputer = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 신뢰 관계를 추가
			computers[toComputer].trustList.add(computers[fromComputer]);
		}
				
		// for 반복문을 사용해 각 컴퓨터를 순회
		for (int computer = 1; computer <= computerNum; computer++) {
			
			// 각 컴퓨터의 해킹 확인 여부를 저장할 배열 hacked 초기화
			hacked = new boolean[computerNum + 1];
			
			// 해당 컴퓨터를 해킹 처리
			hacked[computer] = true;
			
			// connCounter() 메서드를 호출해 해킹할 수 있는 컴퓨터의 수를 갱신
			connCounter(computer, computer);
			
			// 해당 컴퓨터의 해킹할 수 있는 컴퓨터 수가 현재 저장된 가장 많이 해킹할 수 있는 컴퓨터의 수보다 더 많은 경우
			if (hackCounter[computer] > maxCount) {
				
				// 가장 많이 해킹할 수 있는 컴퓨터의 수 갱신
				maxCount = hackCounter[computer];
				
				// clear() 메서드를 사용해 computerList의 컴퓨터를 모두 제거
				computerList.clear();
				
				// add() 메서드를 사용해 computerList에 해당 컴퓨터를 추가
				computerList.add(computer);
				
			// 해당 컴퓨터의 해킹할 수 있는 컴퓨터의 수가 현재 저장된 가장 많이 해킹할 수 있는 컴퓨터의 수와 같은 경우
			} else if (hackCounter[computer] == maxCount) {
				
				// add() 메서드를 사용해 computerList에 해당 컴퓨터를 추가
				computerList.add(computer);
			}
		}
		
		// for 반복문을 사용해 가장 많이 해킹할 수 있는 컴퓨터를 오름차순으로 출력
		for (int computer : computerList)
			out.write(computer + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// connCounter() 메서드 정의
	public static void connCounter(int startComputer, int curComputer) {
			
		// for 반복문을 사용해 신뢰 관계인 컴퓨터를 순회
		for (Computer nextComputer : computers[curComputer].trustList) {
			
			// 해당 컴퓨터를 이미 해킹 처리한 경우 다음 컴퓨터를 순회
			if (hacked[nextComputer.number])
				continue;
			
			// 해당 컴퓨터 해킹 처리
			hacked[nextComputer.number] = true;
			
			// connCounter() 메서드 재귀 호출
			connCounter(startComputer, nextComputer.number);
			
			// 시작 컴퓨터의 해킹 가능한 컴퓨터의 수를 갱신
			hackCounter[startComputer]++;
		}
	}
}