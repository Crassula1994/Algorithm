package silver5.num14729;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 하위 7명의 성적을 저장할 배열 lowGrades 초기화
		double[] lowGrades = new double[7];
		
		// for 반복문을 사용해 입력 받은 첫 7명의 학생 성적을 배열 grades에 저장
		for (int idx = 0; idx < lowGrades.length; idx++)
			lowGrades[idx] = Double.parseDouble(in.readLine());
		
		// sort() 메서드를 사용해 학생들의 성적을 오름차순으로 정렬
		Arrays.sort(lowGrades);
		
		// for 반복문을 사용해 나머지 학생의 성적을 순회
		for (int student = 0; student < studentNum - 7; student++) {
			
			// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 성적을 변수 grade에 할당
			double grade = Double.parseDouble(in.readLine());
			
			// 해당 성적이 현재 저장된 하위 7명의 성적 중 가장 높은 성적보다 높거나 같은 경우 다음 성적을 순회
			if (grade >= lowGrades[6])
				continue;
			
			// 가장 높은 성적을 새로운 하위 성적으로 대체
			lowGrades[6] = grade;
			
			// sort() 메서드를 사용해 학생들의 성적을 오름차순으로 정렬
			Arrays.sort(lowGrades);
		}
		
		// for 반복문을 사용해 하위 7명의 성적을 출력
		for (int idx = 0; idx < lowGrades.length; idx++)
			out.write(String.format("%.3f", lowGrades[idx]) + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}