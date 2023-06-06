package silver1.num01946;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지원자의 수를 변수 applicantNum에 할당
			int applicantNum = Integer.parseInt(in.readLine());
			
			// 각 지원자의 서류심사 성적 및 면접 성적을 저장할 2차원 배열 grades 초기화
			int[][] grades = new int[applicantNum][2];
			
			// for 반복문을 사용해 배열 grades의 각 인덱스를 순회
			for (int idx = 0; idx < grades.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지원자의 각 성적을 배열 grade에 저장
				grades[idx][0] = Integer.parseInt(st.nextToken());
				grades[idx][1] = Integer.parseInt(st.nextToken());
			}
			
			// sort() 메서드를 사용해 서류심사 성적을 기준으로 오름차순으로 정렬
			Arrays.sort(grades, (a1, a2) -> {
				return a1[0] - a2[0];
			});
			
			// 선발할 수 있는 신입사원의 최대 인원 수, 합격 기준이 되는 면접 성적을 저장할 각 변수 초기화
			int maxApplicant = 1;
			int criterion = grades[0][1];
			
			// for 반복문을 사용해 각 지원자를 순회
			for (int idx = 1; idx < grades.length; idx++) {
				
				// 해당 지원자의 면접 성적이 합격 기준보다 높은 경우
				if (grades[idx][1] < criterion) {
					
					// 선발할 수 있는 최대 인원 수 및 합격 기준 갱신
					maxApplicant++;
					criterion = grades[idx][1];
				}
			}
			
			// write() 메서드를 사용해 선발할 수 있는 신입사원의 최대 인원 수를 출력
			out.write(maxApplicant + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}