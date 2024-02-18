package bronze1.num02755;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 과목의 개수를 변수 courseNum에 할당
		int courseNum = Integer.parseInt(in.readLine());
		
		// 각 과목의 학점과 성적을 곱한 값을 모두 더한 값과 총 학점을 저장할 각 변수 초기화
		double dividend = 0;
		double divisor = 0;
		
		// 각 성적 정보를 저장할 Map 객체 grades 초기화
		Map<String, Double> grades = new HashMap<>();
		
		// put() 메서드를 사용해 성적 정보를 grades에 저장
		grades.put("A+", 4.3);
		grades.put("A0", 4.0);
		grades.put("A-", 3.7);
		grades.put("B+", 3.3);
		grades.put("B0", 3.0);
		grades.put("B-", 2.7);
		grades.put("C+", 2.3);
		grades.put("C0", 2.0);
		grades.put("C-", 1.7);
		grades.put("D+", 1.3);
		grades.put("D0", 1.0);
		grades.put("D-", 0.7);
		grades.put("F", 0.0);
		
		// for 반복문을 사용해 각 과목의 정보를 순회
		for (int course = 0; course < courseNum; course++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());			
			
			// nextToken(), parseInt(), get() 메서드를 사용해 과목의 정보를 각 변수에 할당
			@SuppressWarnings("unused")
			String name = st.nextToken();
			int credit = Integer.parseInt(st.nextToken());
			double grade = grades.get(st.nextToken());
			
			// 각 과목의 학점과 성적을 곱한 값을 모두 더한 값과 총 학점을 갱신
			dividend += credit * grade;
			divisor += credit;
		}
		
		// 평균 평점을 계산해 변수 gradePntAvg에 할당
		double gradePntAvg = dividend / divisor;
		
		// format() 및 write() 메서드를 사용해 평균 평점을 소수점 둘째 자리까지 출력
		out.write(String.format("%.2f", gradePntAvg));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}