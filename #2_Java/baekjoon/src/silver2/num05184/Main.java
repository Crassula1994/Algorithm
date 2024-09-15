package silver2.num05184;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자료 집합의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 자료 집합을 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정답이 '예'인 문제의 최소/최대 개수,
			전체 문제의 개수를 각 변수에 할당 */
			int minLimit = Integer.parseInt(st.nextToken());
			int maxLimit = Integer.parseInt(st.nextToken());
			int questionNum = Integer.parseInt(st.nextToken());
			
			// 현재 문제 및 최대로 맞힐 수 있는 문제의 수를 저장할 각 변수 초기화
			int curIdx = 0;
			double maxCount = 0;
			
			// 각 문제의 정답이 '예'일 확률을 저장할 배열 probability 초기화
			Double[] probability = new Double[questionNum];
			
			// for 반복문을 사용해 각 문제의 정답이 '예'일 확률을 배열 probability에 저장
			for (int idx = 0; idx < questionNum; idx++)
				probability[idx] = Double.parseDouble(in.readLine());
			
			// reverseOrder() 및 sort() 메서드를 사용해 '예'일 확률이 높은 순서대로 정렬
			Arrays.sort(probability, Collections.reverseOrder());
			
			// while 반복문을 사용해 입력 받은 정답이 '예'인 문제의 최소 개수를 '예'로 선택 처리
			while (curIdx < minLimit)
				maxCount += probability[curIdx++];
			
			/* while 반복문을 사용해 입력 받은 정답이 '예'인 문제의 최소 개수 이상 최대 개수 이하인 문제 중
			확률이 0.5 이상인 경우를 '예'로 선택 처리 */
			while (curIdx < maxLimit && probability[curIdx] >= 0.5)
				maxCount += probability[curIdx++];
			
			// while 반복문을 사용해 나머지 문제를 '아니오'로 선택 처리
			while (curIdx < questionNum)
				maxCount += 1 - probability[curIdx++];
			
			// format() 및 write() 메서드를 사용해 최대로 맞힐 수 있는 문제의 수를 출력
			out.write("Data Set " + tc + ":\n" + String.format("%.2f", maxCount) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}