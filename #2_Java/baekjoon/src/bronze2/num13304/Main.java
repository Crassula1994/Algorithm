package bronze2.num13304;

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
		
		// 같은 방을 쓸 수 있는 각 그룹에 속한 학생 인원 수를 저장할 배열 students 초기화
		int[] students = new int[5];
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수학여행에 참가하는 학생 수
		및 한 방에 배정할 수 있는 최대 인원 수를 각 변수에 할당 */
		int studentNum = Integer.parseInt(st.nextToken());
		int occupancy = Integer.parseInt(st.nextToken());
		
		// 학생들을 모두 배정하기 위해 필요한 최소한의 방의 수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// while 반복문을 사용해 각 학생의 정보를 순회
		while (studentNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 성별과 학년을 각 변수에 할당
			int sex = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			// 1학년 또는 2학년인 경우 해당 그룹의 학생 수를 갱신
			if (year < 3) {
				students[0]++;
				
			// 3학년 또는 4학년인 경우 해당 그룹의 학생 수를 갱신
			} else if (year < 5) {
				students[1 + sex]++;
				
			// 5학년 또는 학년인 경우 해당 그룹의 학생 수를 갱신
			} else {
				students[3 + sex]++;
			}
		}
		
		// for 반복문을 사용해 학생들을 모두 배정하기 위해 필요한 최소한의 방의 수를 갱신
		for (int count : students)
			minCount += (count + occupancy - 1) / occupancy;
		
		// valueOf() 및 write() 메서드를 사용해 학생들을 모두 배정하기 위해 필요한 최소한의 방의 수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}