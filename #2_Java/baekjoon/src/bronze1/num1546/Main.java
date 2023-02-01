package bronze1.num1546;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 시험 본 과목 수를 변수 testNum에 할당
		int testNum = Integer.parseInt(in.readLine());
		
		// 실제 점수를 저장할 배열 trueScores 초기화
		int[] trueScores = new int[testNum];
		
		// 가장 높은 시험 점수를 저장할 변수 maxScore 초기화
		double maxScore = 0;
		
		// 조작한 점수의 합을 저장할 변수 sumScore 초기화
		double sumScore = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 trueScores의 각 원소를 순회
		for (int i = 0; i < trueScores.length; i++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 실제 시험 점수를 저장
			trueScores[i] = Integer.parseInt(st.nextToken());
			
			// 해당 점수가 maxScore 변수보다 높은 경우 최대 점수 갱신
			if (trueScores[i] > maxScore)
				maxScore = trueScores[i];
		}
		
		// for 반복문을 사용해 조작한 점수를 계산해 점수의 총합을 갱신
		for (int i = 0; i < trueScores.length; i++)
			sumScore += trueScores[i] / maxScore * 100;
		
		// 새로운 평균을 계산해 newAverage 변수에 할당
		double newAverage = sumScore / testNum;
		
		// valueOf() 및 write() 메서드를 사용해 새로운 평균을 출력
		out.write(String.valueOf(newAverage));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}