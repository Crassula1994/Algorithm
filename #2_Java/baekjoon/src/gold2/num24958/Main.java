package gold2.num24958;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 복권의 수를 변수 ticketNum에 할당
		int ticketNum = Integer.parseInt(in.readLine());
		
		// 복권으로 받을 수 있는 최대 상금의 총합을 저장할 변수 maxSum 초기화
		int maxSum = 0;
		
		/* 각 복권의 번호, 마지막 네 자리 및 두 자리 번호의 빈도,
		마지막 두 자리 번호별 가장 많은 네 자리 번호의 개수를 저장할 각 배열 초기화 */
		int[] tickets = new int[ticketNum];
		int[] secondCounts = new int[10000];
		int[] thirdCounts = new int[100];
		int[] maxSecondCounts = new int[100];
		
		// 마지막 두 자리 번호별 개수를 저장할 2차원 배열 maxThirdCounts 초기화
		int[][] maxThirdCounts = new int[100][2];
		
		// for 반복문을 사용해 각 복권을 순회
		for (int idx = 0; idx < tickets.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 해당 복권의 번호를 배열 tickets에 저장
			tickets[idx] = Integer.parseInt(in.readLine());
			
			// 마지막 네 자리 및 두 자리 번호의 빈도를 갱신
			secondCounts[tickets[idx] % 10000]++;
			thirdCounts[tickets[idx] % 100]++;
		}
		
		// for 반복문을 사용해 각 두 자리 번호를 순회
		for (int twoDigit = 0; twoDigit < 100; twoDigit++) {
			
			/* for 반복문을 사용해 해당 두 자리 번호로 끝나는 각 네 자리 번호 중
			가장 많은 네 자리 번호의 개수를 배열 maxSecondCounts에 저장 */
			for (int fourDigit = twoDigit; fourDigit < 10000; fourDigit += 100)
				maxSecondCounts[twoDigit] = Math.max(secondCounts[fourDigit], maxSecondCounts[twoDigit]);
		}
		
		// for 반복문을 사용해 마지막 두 자리 번호별 개수를 2차원 배열 maxThirdCounts에 저장
		for (int twoDigit = 0; twoDigit < 100; twoDigit++) {
			maxThirdCounts[twoDigit][0] = twoDigit;
			maxThirdCounts[twoDigit][1] = thirdCounts[twoDigit];
		}
		
		// sort() 메서드를 사용해 마지막 두 자리 번호가 많은 순서대로 정렬
		Arrays.sort(maxThirdCounts, (t1, t2) -> {
			return t2[1] - t1[1];
		});
		
		// for 반복문을 사용해 1등과 2등 당첨 번호의 각 마지막 두 자리 번호 조합을 순회
		for (int first = 0; first < 100; first++) {
			for (int second = 0; second < 100; second++) {
			
				// 1등과 2등 당첨 번호의 마지막 두 자리 번호가 같은 경우 다음 조합을 순회
				if (first == second)
					continue;
				
				// 해당 조합의 상금 총합을 저장할 변수 sum 초기화
				int sum = 0;
				
				// 1등 당첨 번호가 존재하는 경우 해당 조합의 상금 총합을 갱신
				if (thirdCounts[first] > 0)
					sum += 300000;
				
				// 2등 당첨 상금을 해당 조합의 상금 총합에 갱신
				sum += maxSecondCounts[second] * 4000;
				
				// for 반복문을 사용해 각 당첨 번호를 순회
				for (int idx = 0, count = 0; idx < 100; idx++) {
					
					// 세 개의 3등 당첨 번호를 모두 고른 경우 반복문 탈출
					if (count == 3)
						break;
					
					// 해당 당첨 번호와 그 개수를 각 변수에 할당
					int twoDigit = maxThirdCounts[idx][0];
					int thirdCount = maxThirdCounts[idx][1];
					
					// 해당 당첨 번호가 1등 및 2등 당첨 번호와 중복되는 경우 다음 당첨 번호를 순회
					if (twoDigit == first || twoDigit == second)
						continue;
					
					// 3등 당첨 상금을 해당 조합의 상금 총합에 갱신
					sum += thirdCount * 500;
					
					// 고른 3등 당첨 번호의 개수를 갱신
					count++;
				}
			
				// max() 메서드를 사용해 복권으로 받을 수 있는 최대 상금의 총합을 갱신
				maxSum = Math.max(sum, maxSum);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 복권으로 받을 수 있는 최대 상금의 총합을 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}