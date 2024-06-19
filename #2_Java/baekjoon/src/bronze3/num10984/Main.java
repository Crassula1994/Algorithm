package bronze3.num10984;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학기의 수를 변수 semesterNum에 할당
		int semesterNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 학기를 순회
		for (int semester = 0; semester < semesterNum; semester++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 과목의 수를 변수 courseNum에 할당
			int courseNum = Integer.parseInt(in.readLine());
			
			// 총 학점과 평점을 저장할 각 변수 초기화
			int creditSum = 0;
			double gradeSum = 0;
			
			// for 반복문을 사용해 각 과목을 순회
			for (int course = 0; course < courseNum; course++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken(), parseInt(), parseDouble() 메서드를 사용해 입력 받은 과목의 학점 및 성적을 각 변수에 할당
				int credit = Integer.parseInt(st.nextToken());
				double grade = Double.parseDouble(st.nextToken());
				
				// 총 학점과 평점을 갱신
				creditSum += credit;
				gradeSum += grade * credit;
			}
			
			// format() 및 write() 메서드를 사용해 해당 학기 근우의 총 학점과 평점을 출력
			out.write(creditSum + " " + String.format("%.1f", gradeSum / creditSum) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}