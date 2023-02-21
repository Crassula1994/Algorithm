package silver5.num25206;

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
		
		// 학점을 저장할 Map 객체 grades 초기화
		Map<String, Double> grades = new HashMap<>();
		
		// put() 메서드를 사용해 각 학점을 Map 객체에 저장
		grades.put("A+", 4.5);
		grades.put("A0", 4.0);
		grades.put("B+", 3.5);
		grades.put("B0", 3.0);
		grades.put("C+", 2.5);
		grades.put("C0", 2.0);
		grades.put("D+", 1.5);
		grades.put("D0", 1.0);
		grades.put("F", 0.0);
		
		// 학점의 총합 및 평점의 가중합을 저장할 각 변수 초기화
		Double creditSum = 0.0;
		Double gradeSum = 0.0;
		
		// for 반복문을 사용해 각 과목을 순회
		for (int subject = 0; subject < 20; subject++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble 메서드를 사용해 학점, 등급을 각 변수에 할당
			st.nextToken();
			Double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			// 등급이 'P'인 경우 다음 과목으로 넘기기
			if (grade.equals("P")) {
				continue;

			// 등급이 'P'가 아닌 경우 학점의 총합 및 평점의 가중합 갱신
			} else {
				creditSum += credit;
				gradeSum += credit * grades.get(grade);
			}
		}
		
		// format() 및 write() 메서드를 사용해 전공평점 출력
		out.write(String.format("%.6f", gradeSum / creditSum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}