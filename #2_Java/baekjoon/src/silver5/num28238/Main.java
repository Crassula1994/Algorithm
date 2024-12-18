package silver5.num28238;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 특강을 들을 수 있는 학생의 수의 최댓값 및 특강을 진행할 요일을 저장할 각 변수 초기화
		int maxCount = Integer.MIN_VALUE;
		int maxDay1 = -1;
		int maxDay2 = -1;
		
		// 각 학생의 요일별 참가 여부, 각 선정 요일별 참가 학생의 수를 저장할 각 2차원 배열 초기화
		boolean[][] students = new boolean[studentNum][5];
		int[][] counts = new int[5][5];
		
		// for 반복문을 사용해 각 학생을 순회
		for (int idx = 0; idx < students.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 학생의 각 요일을 순회
			for (int day = 0; day < 5; day++) {
				
				// 해당 요일에 학생이 참석할 수 있는 경우 해당 요일의 참가 여부를 갱신
				if (Integer.parseInt(st.nextToken()) == 1)
					students[idx][day] = true;
			}
			
			// for 반복문을 사용해 가능한 각 요일의 조합을 순회
			for (int day1 = 0; day1 < 4; day1++) {
				for (int day2 = day1 + 1; day2 < 5; day2++) {
					
					// 해당 요일의 조합에 해당 학생이 참석 가능한 경우 해당 조합의 참가 학생의 수를 갱신
					if (students[idx][day1] && students[idx][day2])
						counts[day1][day2]++;
				}
			}
		}
		
		// for 반복문을 사용해 가능한 각 요일의 조합을 순회
		for (int day1 = 0; day1 < 4; day1++) {
			for (int day2 = day1 + 1; day2 < 5; day2++) {
				
				// 해당 요일의 조합에 참가하는 학생의 수가 최대인 경우
				if (counts[day1][day2] > maxCount) {
					
					// 특강을 들을 수 있는 학생의 수의 최댓값 및 특강을 진행할 요일을 갱신
					maxCount = counts[day1][day2];
					maxDay1 = day1;
					maxDay2 = day2;
				}
			}
		}
		
		// write() 메서드를 사용해 특강을 들을 수 있는 학생의 수의 최댓값을 출력
		out.write(maxCount + "\n");
		
		// for 반복문을 사용해 특강을 진행할 요일을 출력
		for (int idx = 0; idx < 5; idx++)
			out.write((idx == maxDay1 || idx == maxDay2) ? "1 " : "0 ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}