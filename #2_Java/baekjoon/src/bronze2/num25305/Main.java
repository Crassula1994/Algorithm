package bronze2.num25305;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 응시자 및 수상자의 수를 각 변수에 할당
		int examinee = Integer.parseInt(st.nextToken());
		int winner = Integer.parseInt(st.nextToken());
		
		// 응시자 시험 점수의 분포를 저장할 배열 scores 초기화
		int[] scores = new int[10001];
		
		// 시험 점수를 내림차순으로 저장할 List 객체 orderedList 초기화
		List<Integer> orderedList = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 응시자의 점수를 순회
		for (int i = 0; i < examinee; i++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 점수를 변수 score에 할당
			int score = Integer.parseInt(st.nextToken());
			
			// 배열 scores에 입력 받은 점수의 개수를 갱신
			scores[score]++;
		}
		
		// for 반복문을 사용하여 배열 scores의 각 원소를 순회
		for (int idx = scores.length - 1; idx >= 0; idx--) {
			
			// 해당 원소가 0이 아닌 경우 
			if (scores[idx] != 0) {
				
				// for 반복문 및 add() 메서드를 사용해 List 객체 orderedList에 개수만큼 추가
				for (int j = 0; j < scores[idx]; j++)
					orderedList.add(idx);
			}
		}
		
		// get(), valueOf(), write() 메서드를 사용해 커트라인을 출력
		out.write(String.valueOf(orderedList.get(winner - 1)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}