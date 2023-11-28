package silver5.num05635;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Student 클래스 정의
	public static class Student implements Comparable<Student> {
		
		// 학생의 이름, 생일을 저장할 각 변수 초기화
		String name;
		int year;
		int month;
		int day;
		
		// 인자를 입력 받는 생성자 정의
		public Student(String name, int year, int month, int day) {
			this.name = name;
			this.year = year;
			this.month = month;
			this.day = day;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Student otherStudent) {
			
			// 같은 해에 태어난 경우
			if (year == otherStudent.year) {
				
				// 같은 달에 태어난 경우 날짜를 비교
				if (month == otherStudent.month)
					return day - otherStudent.day;
				
				// 다른 달에 태어난 경우 달을 비교
				return month - otherStudent.month;
			}
			
			// 다른 해에 태어난 경우 연도를 비교
			return year - otherStudent.year;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 반에 있는 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 학생을 나이 순으로 정렬한 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Student> sorter = new PriorityQueue<>();
		
		// for 반복문을 사용해 입력 받은 각 학생의 정보를 순회
		for (int student = 0; student < studentNum; student++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 정보를 각 변수에 할당
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 해당 학생을 sorter에 추가
			sorter.offer(new Student(name, year, month, day));
		}
		
		// poll() 메서드를 사용해 가장 나이가 많은 사람의 이름을 변수 oldName에 할당
		String oldName = sorter.poll().name;
		
		// 가장 나이가 적은 사람의 이름을 저장할 변수 youngName 초기화
		String youngName = "";
		
		// while 반복문을 사용해 가장 나이가 적은 사람의 이름을 갱신
		while (!sorter.isEmpty())
			youngName = sorter.poll().name;
		
		// write() 메서드를 사용해 가장 나이가 적은 사람의 이름, 가장 나이가 많은 사람의 이름을 출력
		out.write(youngName + "\n" + oldName);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}