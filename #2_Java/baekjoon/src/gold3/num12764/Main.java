package gold3.num12764;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Person 클래스 정의
	static class Person {
		
		// 해당 사람의 컴퓨터 이용 시작 시각 및 종료 시각, 이용한 컴퓨터 번호를 저장할 각 변수 초기화
		int startTime;
		int endTime;
		int computerNum;
		
		// 매개변수를 입력 받는 생성자 정의
		public Person(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.computerNum = -1;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 personNum에 할당
		int personNum = Integer.parseInt(in.readLine());
		
		// 각 사람의 컴퓨터 이용 정보 및 각 자리를 사용한 사람의 수를 저장할 각 List 객체 초기화
		List<Person> persons = new ArrayList<>();
		List<Integer> seatCount = new ArrayList<>();
		
		// 가장 컴퓨터 이용 종료 시간이 빠른 사람과 가장 번호가 작은 컴퓨터 빈 좌석을 찾을 각 PriorityQueue 객체 초기화
		PriorityQueue<Person> seatFinder = new PriorityQueue<>((p1, p2) -> {
			return p1.endTime - p2.endTime;
		});
		PriorityQueue<Person> vacancyFinder = new PriorityQueue<>((p1, p2) -> {
			return p1.computerNum - p2.computerNum;
		});
		
		// while 반복문을 사용해 각 사람의 이용 시간을 순회
		while (personNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 사람의 이용 시간을 각 변수에 할당
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 사람의 컴퓨터 이용 정보를 persons에 저장
			persons.add(new Person(startTime, endTime));
		}
		
		// sort() 메서드를 사용해 컴퓨터 이용 시작 시간이 빠른 사람 순으로 정렬
		Collections.sort(persons, (p1, p2) -> {
			return p1.startTime - p2.startTime;
		});
		
		// for 반복문을 사용해 각 사람의 컴퓨터 이용 시간을 순회
		for (Person person : persons) {
			
			// while 반복문을 사용해 현재 사람의 시작 시간에 사용을 종료한 사람들을 vancyFinder에 추가
			while (!seatFinder.isEmpty() && seatFinder.peek().endTime < person.startTime)
				vacancyFinder.offer(seatFinder.poll());
			
			// 빈 좌석이 없는 경우
			if (vacancyFinder.isEmpty()) {
				
				// size() 메서드를 사용해 해당 사람이 사용할 컴퓨터의 번호를 갱신
				person.computerNum = seatFinder.size();
				
				// add() 메서드를 사용해 새로운 컴퓨터 좌석을 배정
				seatCount.add(1);
			
			// 빈 좌석이 있는 경우
			} else {
				
				// poll() 메서드를 사용해 해당 사람이 사용할 컴퓨터의 번호를 갱신
				person.computerNum = vacancyFinder.poll().computerNum;
				
				// get() 및 set() 메서드를 사용해 해당 컴퓨터 좌석을 이용한 사람의 수를 갱신
				seatCount.set(person.computerNum, seatCount.get(person.computerNum) + 1);
			}
			
			// offer() 메서드를 사용해 현재 컴퓨터를 이용 중인 사람을 seatFinder에 추가
			seatFinder.offer(person);
		}
		
		// size() 및 write() 메서드를 사용해 모든 사람이 기다리지 않아도 되는 컴퓨터의 최소 개수를 출력
		out.write(seatCount.size() + "\n");
		
		// for 반복문을 사용해 각 자리 순서대로 사용한 사람의 수를 출력
		for (int count : seatCount)
			out.write(count + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}