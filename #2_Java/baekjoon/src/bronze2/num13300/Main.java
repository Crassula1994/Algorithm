package bronze2.num13300;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생 수 및 방별 최대 인원 수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		// 각 성별, 학년별 학생 수를 저장할 2차원 배열 students 초기화
		int[][] students= new int[2][6];
		
		// for 반복문을 사용해 각 학생을 순회
		for (int student = 0; student < studentNum; student++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 성별 및 학년을 각 변수에 할당
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			// 해당하는 학생 수 조정
			students[sex][grade - 1]++;
		}
		
		// 필요한 최소 방의 수를 저장할 변수 minRoom 초기화
		int minRoom = 0;
		
		// for 반복문을 사용해 배열 students의 각 행과 열을 순회
		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 6; c++) {
				
				// 필요한 각 방의 개수를 계산
				minRoom += (students[r][c] % limit == 0) ? students[r][c] / limit : students[r][c] / limit + 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 필요한 최소 방의 개수를 출력
		out.write(String.valueOf(minRoom));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}