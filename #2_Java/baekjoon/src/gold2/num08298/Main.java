package gold2.num08298;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전을 던진 횟수 및
		앞면이 나오는 횟수와 뒷면이 나오는 횟수의 비율을 각 변수에 할당 */
		int tossNum = Integer.parseInt(st.nextToken());
		int targetMultiple = Integer.parseInt(st.nextToken());
		
		/* 현재 횟수까지 필요한 앞면의 개수, 앞면과 뒷면이 나오는 횟수의 비율이 일치하는
		가장 긴 동전 던지기 결과의 길이를 저장할 각 변수 초기화 */
		long sum = 0;
		int maxLength = 0;
		
		// readLine() 메서드를 사용해 입력 받은 동전 던지기의 결과를 변수 result에 할당
		String result = in.readLine();
		
		// 처음부터 현재 횟수까지 필요한 앞면의 개수와 해당 개수가 처음 등장한 횟수를 저장할 Map 객체 countSum 초기화
		Map<Long, Integer> countSum = new HashMap<>();
		
		// put() 메서드를 사용해 동전 던지기를 시작하기 전 필요한 앞면의 개수를 countSum에 추가
		countSum.put(0L, 0);
		
		// for 반복문을 사용해 각 동전 던지기 결과를 순회
		for (int idx = 0; idx < tossNum; idx++) {
			
			// 해당 동전 던지기 결과에 따라 현재 횟수까지 필요한 앞면의 개수를 갱신
			sum = (result.charAt(idx) == 'O') ? sum - 1 : sum + targetMultiple;
			
			// 현재 횟수까지 필요한 앞면의 개수가 이전에도 등장했던 경우
			if (countSum.containsKey(sum)) {
				
				// get() 메서드를 사용해 앞면과 뒷면이 나오는 횟수의 비율이 일치하는 동전 던지기 결과의 길이를 변수 length에 할당
				int length = idx + 1 - countSum.get(sum);
				
				// max() 메서드를 사용해 앞면과 뒷면이 나오는 횟수의 비율이 일치하는 가장 긴 동전 던지기 결과의 길이를 갱신
				maxLength = Math.max(length, maxLength);
				
			// 현재 횟수까지 필요한 앞면의 개수가 처음 등장했던 경우 countSum에 추가
			} else {
				countSum.put(sum, idx + 1);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 앞면과 뒷면이 나오는 횟수의 비율이 일치하는 가장 긴 동전 던지기 결과의 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}