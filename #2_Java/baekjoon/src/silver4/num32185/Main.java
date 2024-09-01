package silver4.num32185;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Student 클래스 정의
	static class Student implements Comparable<Student> {

		// 학생의 번호 및 꿈, 열정, 나눔 스탯의 합을 저장할 각 변수 초기화
		int number;
		int sum;
		
		// 매개변수를 입력 받는 생성자 정의
		public Student(int number, int sum) {
			this.number = number;
			this.sum = sum;
		}
		
		// compareTo() 메서드 정의
		@Override
		public int compareTo(Student anotherStudent) {
			return anotherStudent.sum - this.sum;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 참가자 학생 수 및 재원이를 제외한 최대 팀원 수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int maxLimit = Integer.parseInt(st.nextToken()) - 1;
		
		// 재원이의 꿈, 열정, 나눔 스탯의 합을 저장할 변수 sumLimit 초기화
		int sumLimit = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 재원이의 꿈, 열정, 나눔 스탯의 합을 갱신
		while (st.hasMoreTokens())
			sumLimit += Integer.parseInt(st.nextToken());
		
		// 각 학생의 꿈, 열정, 나눔 스탯의 합을 저장할 List 객체 members 초기화
		List<Student> members = new ArrayList<>();
		
		// for 반복문을 사용해 각 학생을 순회
		for (int number = 1; number <= studentNum; number++) {
			
			// 해당 학생의 꿈, 열정, 나눔 스탯의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 해당 학생의 꿈, 열정, 나눔 스탯의 합을 갱신
			while (st.hasMoreTokens())
				sum += Integer.parseInt(st.nextToken());
			
			// 해당 학생의 스탯 합이 재원이의 스탯 합보다 큰 경우 다음 학생을 순회
			if (sum > sumLimit)
				continue;
			
			// add() 메서드를 사용해 해당 학생의 정보를 members에 추가
			members.add(new Student(number, sum));
		}
		
		// sort() 메서드를 사용해 스탯의 합이 큰 학생 순으로 정렬
		Collections.sort(members);
		
		// write() 메서드를 사용해 재원이의 번호를 출력
		out.write(0 + " ");
		
		// for 반복문을 사용해 스탯의 합을 최대화할 수 있는 팀원의 번호를 출력
		for (int idx = 0; idx < Math.min(maxLimit, members.size()); idx++)
			out.write(members.get(idx).number + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}