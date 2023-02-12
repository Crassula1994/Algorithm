package bronze1.num2851;

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
		
		// 버섯을 먹었을 때의 점수를 저장할 배열 scores 초기화
		int[] scores = new int[10];
		
		// 100과의 차이 및 최대 점수를 저장할 각 변수 초기화
		int diff = Integer.MAX_VALUE;
		int maxScore = 0;
		
		// for 반복문을 사용해 배열의 각 점수를 순회
		for (int idx = 0; idx < 10; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 버섯의 점수를 변수 score에 할당
			int score = Integer.parseInt(in.readLine());
			
			// 첫 번째 값인 경우 점수를 그대로 배열에 추가하고 그 이후인 경우 이전 점수에 해당 점수를 더한 값을 추가
			scores[idx] = (idx == 0) ? score : scores[idx - 1] + score;
		}
		
		// for 반복문을 사용해 배열의 각 점수를 순회
		for (int idx = 0; idx < 10; idx++) {
			
			// 해당 값의 차이가 기존의 차이보다 적거나 같은 경우 차이 및 최대 점수 갱신
			if (Math.abs(scores[idx] - 100) <= diff) {
				diff = Math.abs(scores[idx] - 100);
				maxScore = scores[idx];
			}
		}
	
		// valueOf() 및 write() 메서드를 사용해 최대 점수를 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}