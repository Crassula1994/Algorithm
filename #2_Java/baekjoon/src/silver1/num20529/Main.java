package silver1.num20529;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(in.readLine());
			
			// 각 학생의 MBTI를 저장할 배열 students 초기화
			String[] students = new String[studentNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 학생의 MBTI를 배열 students에 저장
			for (int idx = 0; idx < students.length; idx++)
				students[idx] = st.nextToken();
			
			// 학생의 수가 33명 이상인 경우 같은 MBTI가 3개 이상 존재하므로 0을 출력
			if (studentNum > 32) {
				out.write(0 + "\n");
				
			// 학생의 수가 32명 이하인 경우
			} else {
				
				// 최소 심리적 거리를 저장할 변수 minDistance 초기화
				int minDistance = Integer.MAX_VALUE;
				
				// for 반복문을 사용해 각 학생을 차례로 순회
				outer: for (int student1 = 0; student1 < students.length - 2; student1++) {
					for (int student2 = student1 + 1; student2 < students.length - 1; student2++) {
						for (int student3 = student2 + 1; student3 < students.length; student3++) {
							
							// 세 학생 간의 심리적 거리를 저장할 변수 distance 초기화
							int distance = 0;
							
							// for 반복문을 사용해 각 MBTI의 성격 유형을 순회
							for (int idx = 0; idx < 4; idx++) {
								
								// 각 학생 간 MBTI가 다른 경우 심리적 거리를 갱신
								if (students[student1].charAt(idx) != students[student2].charAt(idx))
									distance++;
								if (students[student2].charAt(idx) != students[student3].charAt(idx))
									distance++;
								if (students[student1].charAt(idx) != students[student3].charAt(idx))
									distance++;
							}
							
							// 세 학생 간의 심리적 거리가 0인 경우 최소 심리적 거리 갱신 후 반복문 탈출
							if (distance == 0) {
								minDistance = 0;
								break outer;
							}
							
							// min() 메서드를 사용해 최소 심리적 거리를 갱신
							minDistance = Math.min(distance, minDistance);
						}
					}
				}
				
				// write() 메서드를 사용해 최소 심리적 거리를 출력
				out.write(minDistance + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}