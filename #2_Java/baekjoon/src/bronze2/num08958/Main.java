package bronze2.num08958;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
			
			// OX 퀴즈의 결과를 저장할 배열 result 초기화
			String[] result = in.readLine().split("");
			
			// OX 퀴즈의 각 문제 점수를 저장할 배열 scores 초기화
			int[] scores = new int[result.length];
			
			// OX 퀴즈의 총 점수를 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 배열 result의 각 원소를 순회
			for (int j = 0; j < result.length; j++) {
				
				// 퀴즈 결과가 'O'인 경우 점수를 갱신
				if (result[j].equals("O")) {
					scores[j]++;

					// 두 번째 이상의 문제이고, 그 전의 퀴즈 결과가 'O'인 경우 점수를 갱신
					if (j > 0 && result[j - 1].equals("O"))
						scores[j] = scores[j - 1] + 1;
					
					// 각 퀴즈의 점수를 총 점수에 합산
					sum += scores[j];
				}
			}
			
			// write() 메서드를 사용해 총 점수를 출력
			out.write(sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}