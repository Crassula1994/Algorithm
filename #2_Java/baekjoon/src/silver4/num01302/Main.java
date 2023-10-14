package silver4.num01302;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// Book 클래스 정의
	public static class Book implements Comparable<Book> {
		
		// 책의 제목, 개수를 저장할 각 변수 초기화
		String name;
		int count;
		
		// 인수를 입력 받는 생성자 정의
		public Book(String name, int count) {
			this.name = name;
			this.count = count;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Book book) {
			return (count == book.count) ? name.compareTo(book.name) : book.count - count;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 책의 판매 현황을 저장할 Map 객체 counter 초기화
		Map<String, Integer> counter = new HashMap<>();
		
		// 책을 가장 많이 팔린 순서대로 정렬할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Book> sorter = new PriorityQueue<>();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 하루 동안 팔린 책의 개수를 변수 bookCnt에 할당
		int bookCnt = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 입력 받은 책의 제목을 순회
		for (int b = 0; b < bookCnt; b++) {
			
			// readLine() 메서드를 사용해 입력 받은 책의 이름을 변수 bookName에 할당
			String bookName = in.readLine();
			
			// getOrDefault() 및 put() 메서드를 사용해 책의 개수를 갱신
			counter.put(bookName, counter.getOrDefault(bookName, 0) + 1);
		}
		
		// for 반복문을 사용해 각 책의 개수를 sorter에 추가
		for (String name : counter.keySet())
			sorter.offer(new Book(name, counter.get(name)));
		
		// poll() 및 write() 메서드를 사용해 가장 많이 팔린 책의 제목을 출력
		out.write(sorter.poll().name);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}