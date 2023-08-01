package silver5.num01380;

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

		// 각 시나리오의 번호를 저장할 변수 scenarioNum 초기화
		int scenarioNum = 0;
		
		// while 반복문을 사용해 마지막 줄까지 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 귀걸이를 압수당한 여학생의 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(in.readLine());
			
			// 0이 입력된 경우 반복문 탈출
			if (studentNum == 0)
				break;
			
			// 해당 여학생의 이름, 귀걸이의 압수 여부를 저장할 각 배열 초기화
			String[] students = new String[studentNum + 1];
			boolean[] isSeizured = new boolean[studentNum + 1];
			
			// for 반복문을 사용해 각 여학생의 이름을 배열 students에 저장
			for (int idx = 1; idx <= studentNum; idx++)
				students[idx] = in.readLine();
			
			// for 반복문을 사용해 각 리스트를 순회
			for (int li = 0; li < studentNum * 2 - 1; li++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 여학생의 번호를 변수 studentSeq에 할당
				int studentSeq = Integer.parseInt(st.nextToken());
				
				// 해당 여학생의 귀걸이 압수 여부를 갱신
				isSeizured[studentSeq] = !isSeizured[studentSeq];
			}
			
			// for 반복문을 사용해 각 학생을 출력
			for (int idx = 1; idx <= studentNum; idx++) {
				
				// 귀걸이를 돌려 받지 못한 경우 시나리오 번호 및 학생의 이름을 출력
				if (isSeizured[idx])
					out.write(++scenarioNum + " " + students[idx] + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}