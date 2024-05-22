package bronze1.num17224;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문제의 개수, 현정이의 역량, 풀 수 있는 문제의 최대 개수를 각 변수에 할당
		int problemNum = Integer.parseInt(st.nextToken());
		int levelLimit = Integer.parseInt(st.nextToken());
		int countLimit = Integer.parseInt(st.nextToken());
		
		// 현정이가 얻을 수 있는 최대 점수를 저장할 변수 maxScore 초기화
		int maxScore = 0;
		
		// 풀 수 있는 문제의 점수를 저장할 List 객체 scores 초기화
		List<Integer> scores = new ArrayList<>();
		
		// for 반복문을 사용해 각 문제의 난이도를 순회
		for (int idx = 0; idx < problemNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문제의 각 난이도를 각 변수에 할당
			int easyLevel = Integer.parseInt(st.nextToken());
			int hardLevel = Integer.parseInt(st.nextToken());
			
			// 어려운 문제를 풀 수 있는 경우 140점을 scores에 저장
			if (hardLevel <= levelLimit) {
				scores.add(140);
			
			// 어려운 문제를 풀지는 못하지만 쉬운 문제를 풀 수 있는 경우 100점을 scores에 저장
			} else if (easyLevel <= levelLimit) {
				scores.add(100);
			}
		}
		
		// reverseOrder() 및 sort() 메서드를 사용해 풀 수 있는 문제의 점수를 내림차순으로 정렬
		Collections.sort(scores, Collections.reverseOrder());
		
		// for 반복문을 사용해서 풀 수 있는 각 문제를 순회
		for (int idx = 0, count = 0; idx < scores.size(); idx++) {
			
			// 풀 수 있는 문제의 최대 개수에 도달한 경우 반복문 탈출
			if (count == countLimit)
				break;
			
			// get() 메서드를 사용해 현정이가 얻을 수 있는 최대 점수 및 푼 문제의 수를 갱신
			maxScore += scores.get(idx);
			count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 현정이가 얻을 수 있는 최대 점수를 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}