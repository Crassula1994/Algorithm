package bronze3.num02754;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 성적을 변수 grade에 할당
		String grade = in.readLine();
		
		// 각 성적의 평점을 담은 Map 객체 gradeTable 초기화
		Map<String, String> gradeTable = new HashMap<>();
		
		// 성적과 평점을 담은 각 배열 초기화
		String[] gradeName = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};
		String[] score = {"4.3", "4.0", "3.7", "3.3", "3.0", "2.7", "2.3", "2.0", "1.7", "1.3", "1.0", "0.7", "0.0"};
		
		// for 반복문을 사용해 gradeTable에 각 평점 추가
		for (int i = 0; i < gradeName.length; i++)
			gradeTable.put(gradeName[i], score[i]);

		// get() 메서드와 write() 메서드를 사용해 입력 받은 성적의 평점을 출력
		out.write(gradeTable.get(grade));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}