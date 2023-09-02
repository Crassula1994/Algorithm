package silver4.num10825;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Student 클래스 정의
	public static class Student {
		
		// 학생의 이름, 국어, 영어, 수학 점수를 저장할 각 변수 초기화
		String name;
		int korean;
		int english;
		int math;
		
		// 인수를 입력 받는 생성자 정의
		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
	    
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 학생의 정보를 저장할 PriorityQueue 객체 studentSorter 초기화
		PriorityQueue<Student> studentSorter = new PriorityQueue<>(new Comparator<Student>() {
			
			// compare() 메서드 정의
			@Override
			public int compare(Student s1, Student s2) {
				
				// 국어 점수가 다른 경우 국어 점수를 기준으로 내림차순 정렬
				if (s1.korean != s2.korean)
					return s2.korean - s1.korean;
				
				// 영어 점수가 다른 경우 영어 점수를 기준으로 오름차순 정렬
				if (s1.english != s2.english)
					return s1.english - s2.english;
				
				// 수학 점수가 다른 경우 수학 점수를 기준으로 내림차순 정렬
				if (s1.math != s2.math)
					return s2.math - s1.math;

				// 이름을 기준으로 사전 순으로 정렬
				return s1.name.compareTo(s2.name);
			}
		});
		
		// for 반복문을 사용해 입력 받은 각 학생의 정보를 순회
		for (int s = 0; s < studentNum; s++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 학생의 정보를 각 변수에 할당
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 해당 학생의 정보를 studentSorter에 추가
			studentSorter.offer(new Student(name, korean, english, math));
		}
		
		// while 반복문을 사용해 정렬된 학생의 이름을 차례로 출력
		while (!studentSorter.isEmpty())
			out.write(studentSorter.poll().name + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}