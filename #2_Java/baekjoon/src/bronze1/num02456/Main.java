package bronze1.num02456;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생들의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 후보의 총점 및 점수를 받은 횟수를 저장할 2차원 배열 results 초기화
		int[][] results = new int[4][4];
		
		// for 반복문을 사용해 입력 받은 각 학생들의 선호도 투표 결과를 순회
		for (int student = 0; student < studentNum; student++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 점수를 순회
			for (int idx = 1; idx <= 3; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 후보의 점수를 변수 score에 할당
				int score = Integer.parseInt(st.nextToken());
				
				// 해당 후보의 총점 및 점수의 개수를 갱신
				results[idx][0] += score;
				results[idx][score]++;
			}
		}
		
		// 회장이 유일하게 결정되는지, 최고 점수와 당선 후보 번호를 나타낼 각 변수 초기화
		boolean isUnique = true;
		int maxScore = Integer.MIN_VALUE;
		int winner = 0;
		
		// for 반복문을 사용해 각 후보자의 점수를 순회
		for (int idx = 1; idx <= 3; idx++) {
			
			// 해당 점수가 저장된 최고 점수보다 큰 경우
			if (results[idx][0] > maxScore) {
				
				// 회장이 유일하게 결정되는지를 나타내는 변수, 최고 점수와 당선 후보 번호를 모두 갱신
				isUnique = true;
				maxScore = results[idx][0];
				winner = idx;
				
			// 해당 점수가 저장된 최고 점수와 같은 경우
			} else if (results[idx][0] == maxScore) {
				
				// 유일하게 회장을 결정하지 못하는 경우 회장이 유일하게 결정되는지를 나타내는 변수를 갱신
				if (results[idx][3] == results[winner][3] && results[idx][2] == results[winner][2]) {
					isUnique = false;
				
				// 해당 후보가 새로운 당선 후보인 경우
				} else if (results[idx][3] > results[winner][3] ||
						(results[idx][3] == results[winner][3] && results[idx][2] > results[winner][2])) {
					
					// 회장이 유일하게 결정되는지를 나타내는 변수, 당선 후보 번호를 갱신
					isUnique = true;
					winner = idx;
				}
			}
		}
		
		// 회장이 유일하게 결정되는 경우 후보 번호와 최고 점수를 출력
		if (isUnique) {
			out.write(winner + " " + maxScore);
		
		// 회장이 유일하게 결정되지 않는 경우 0과 최고 점수를 출력
		} else {
			out.write(0 + " " + maxScore);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}