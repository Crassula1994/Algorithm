package bronze2.num02605;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 학생이 선 줄을 저장할 List 객체 line 초기화
		List<Integer> line = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 학생이 뽑은 번호를 순회
		for (int student = 1; student < length + 1; student++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력받은 숫자를 변수 num에 할당
			int num = Integer.parseInt(st.nextToken());
			
			// 0이 입력된 경우 그대로 List 객체에 추가
			if (num == 0) {
				line.add(student);
			
			// 0 이상이 입력된 경우 인덱스 조정 후 List 객체에 추가
			} else {
				line.add(line.size() - num, student);
			}
		}
		
		// for 반복문을 사용해 줄을 선 학생의 번호를 출력
		for (int student : line)
			out.write(student + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}