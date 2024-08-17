package silver2.num27914;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수, 은호의 학년, 질문의 수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int gradeLimit = Integer.parseInt(st.nextToken());
		int questionNum = Integer.parseInt(st.nextToken());
		
		// 각 학생들의 학년 및 해당 학생까지 인터뷰 대상 학생을 고르는 방법의 수를 저장할 각 배열 초기화
		int[] students = new int[studentNum + 1];
		long[] counts = new long[studentNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 학생의 학년을 순회
		for (int idx = 1, count = 0; idx < students.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 학년을 배열 students에 저장
			students[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 학생이 은호와 같은 학년인 경우 연속된 인터뷰 가능한 학생의 수 및 방법의 수를 갱신
			if (students[idx] == gradeLimit) {
				count = 0;
				counts[idx] = counts[idx - 1];
				
			// 해당 학생이 은호와 같은 학년이 아닌 경우 연속된 인터뷰 가능한 학생의 수 및 방법의 수를 갱신
			} else {
				count++;
				counts[idx] = counts[idx - 1] + count;
			}
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 질문에 대한 인터뷰 대상의 가짓수를 출력
		for (int question = 0; question < questionNum; question++)
			out.write(counts[Integer.parseInt(st.nextToken())] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}