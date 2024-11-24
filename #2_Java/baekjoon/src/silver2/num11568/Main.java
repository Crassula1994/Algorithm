package silver2.num11568;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 준민이가 제시할 수 있는 수열의 원소 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 카드 및 해당 카드까지 증가하는 카드의 최대 개수를 저장할 각 배열 초기화
		int[] cards = new int[cardNum];
		int[] maxCounts = new int[cardNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 숫자를 순회
		for (int idx = 0; idx < cards.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 숫자를 배열 cards에 저장
			cards[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 카드까지 증가하는 카드의 최대 개수를 초기화
			maxCounts[idx] = 1;
			
			// for 반복문을 사용해 이전의 카드를 순회
			for (int prev = 0; prev < idx; prev++) {
				
				// 해당 숫자보다 이전 카드의 숫자가 크거나 같은 경우 다음 카드를 순회
				if (cards[prev] >= cards[idx])
					continue;
				
				// max() 메서드를 사용해 해당 카드까지 증가하는 카드의 최대 개수를 갱신
				maxCounts[idx] = Math.max(maxCounts[prev] + 1, maxCounts[idx]);
			}
			
			// max() 메서드를 사용해 준민이가 제시할 수 있는 수열의 원소 최대 개수를 갱신
			maxCount = Math.max(maxCounts[idx], maxCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 준민이가 제시할 수 있는 수열의 원소 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}