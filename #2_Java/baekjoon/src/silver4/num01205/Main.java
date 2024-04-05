package silver4.num01205;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점수의 개수 및 태수의 새로운 점수를 각 변수에 할당
		int scoreNum = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		// 점수 리스트를 저장할 배열 scoreList 초기화
		int[] scoreList = new int[limit];
		
		// fill() 메서드를 사용해 점수 리스트의 점수를 초기화
		Arrays.fill(scoreList, -1);
		
		// 리스트에 저장된 점수가 존재하는 경우
		if (scoreNum > 0) {
		
			// StringTokenizer 객체를 불러와 변수 st에 할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 점수를 scoreList에 저장
			for (int idx = 0; idx < scoreNum; idx++)
				scoreList[idx] = Integer.parseInt(st.nextToken());
		}
		
		// 점수 리스트에 저장할 수 없는 경우 -1을 출력
		if (newScore <= scoreList[limit - 1]) {
			out.write(String.valueOf(-1));
			
		// 점수 리스트에 저장할 수 있는 경우
		} else {
			
			// for 반복문을 사용해 점수 리스트의 각 점수를 순회
			for (int idx = 0; idx < scoreList.length; idx++) {
				
				// 점수 리스트에 저장된 점수보다 높거나 같은 점수를 얻은 경우 해당 등수를 출력 후 반복문 탈출
				if (newScore >= scoreList[idx]) {
					out.write(String.valueOf(idx + 1));
					break;
				}
			}
		}
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}