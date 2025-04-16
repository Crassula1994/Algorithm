package bronze2.num13280;

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
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(in.readLine());
			
			// 모든 데이터 세트를 순회한 경우 반복문 탈출
			if (studentNum == 0)
				break;
			
			// 두 학생 사이의 최소 성적 차이를 저장할 변수 minDifference 초기화
			int minDifference = Integer.MAX_VALUE;
			
			// 각 학생의 성적을 저장할 배열 scores 초기화
			int[] scores = new int[studentNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 학생의 성적을 배열 scores에 저장
			for (int idx = 0; idx < scores.length; idx++)
				scores[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 입력 받은 각 학생의 성적을 오름차순으로 정렬
			Arrays.sort(scores);
			
			// for 반복문을 사용해 각 학생의 쌍을 순회
			for (int idx = 0; idx < scores.length - 1; idx++) {
				
				// min() 메서드를 사용해 두 학생 사이의 최소 성적 차이를 갱신
				minDifference = Math.min(scores[idx + 1] - scores[idx], minDifference);
				
				// 두 학생 사이의 최소 성적 차이가 0인 경우 반복문 탈출
				if (minDifference == 0)
					break;
			}
			
			// write() 메서드를 사용해 두 학생 사이의 최소 성적 차이를 출력
			out.write(minDifference + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}