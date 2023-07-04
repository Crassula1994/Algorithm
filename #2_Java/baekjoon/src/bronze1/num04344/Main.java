package bronze1.num04344;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(st.nextToken());
			
			// 각 학생의 점수를 저장할 배열 scores 초기화
			int[] scores = new int[studentNum];
			
			// 점수의 총합을 저장할 변수 sum 초기화
			double sum = 0;
			
			// for 반복문을 사용해 배열 scores의 각 원소를 순회
			for (int j = 0; j < scores.length; j++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 점수를 저장
				scores[j] = Integer.parseInt(st.nextToken());
				
				// 점수를 총합에 합산
				sum += scores[j];
			}
			
			// 점수의 평균을 계산해 변수 average에 할당
			double average = sum / studentNum;
			
			// 평균을 넘는 학생의 수를 저장할 변수 count 초기화
			double count = 0;
			
			// for 반복문을 사용해 배열 scores의 각 원소를 순회
			for (int score : scores) {
				
				// 평균을 넘는 학생인 경우 평균을 넘는 학생의 수 갱신
				if (score > average)
					count++;
			}
			
			// 평균을 넘는 학생의 비율을 계산해 변수 ratio에 할당
			double ratio = count / studentNum * 100;
			
			// format() 및 write() 메서드를 사용해 평균을 넘는 학생의 비율을 출력
			out.write(String.format("%.3f", ratio) + "%\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}