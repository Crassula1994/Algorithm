package bronze1.num01268;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 학생이 같은 반이었던 학생 수를 저장할 배열 classmate 초기화
		int[] classmate = new int[studentNum];
		
		// 각 학생들이 과거에 몇 반이었는지를 저장할 2차원 배열 classInfo 초기화
		int[][] classInfo = new int[studentNum][5];
		
		// for 반복문을 사용해 배열 classInfo의 각 행을 순회
		for (int r = 0; r < studentNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 학생의 과거 반의 정보를 배열 classInfo에 저장
			for (int c = 0; c < 5; c++)
				classInfo[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 같은 반이었던 학생 수가 가장 많은 학생과 해당 학생 수를 저장할 각 변수 초기화
		int president = 1;
		int maxClassmate = 0;
		
		// for 반복문을 사용해 각 학생을 순회
		for (int i = 0; i < studentNum; i++) {
			
			// for 반복문을 사용해 해당 학생 이후 번호의 다른 학생을 순회
			for (int j = i + 1; j < studentNum; j++) {
				
				// for 반복문을 사용해 각 반의 정보를 순회
				for (int c = 0; c < 5; c++) {
					
					// 두 학생이 같은 반이었던 경우 각 학생의 같은 반이었던 학생 수 갱신 및 반복문 탈출
					if (classInfo[i][c] == classInfo[j][c]) {
						classmate[i]++;
						classmate[j]++;
						break;
					}
				}
			}
			
			// 해당 학생이 가장 많은 학생과 같은 반이었던 경우 각 변수 갱신
			if (classmate[i] > maxClassmate) {
				president = i + 1;
				maxClassmate = classmate[i];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 임시 반장으로 선출된 학생의 번호를 출력
		out.write(String.valueOf(president));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}