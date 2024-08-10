package gold5.num10427;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 돈을 빌린 횟수를 변수 loanNum에 할당
			int loanNum = Integer.parseInt(st.nextToken());
			
			// 민균이가 추가적으로 갚아야 하는 돈의 최솟값 총합을 저장할 변수 totalSum 초기화
			long totalSum = 0;
			
			// 각 돈을 빌린 횟수별 빌린 액수 및 그 누적 합을 저장할 각 배열 초기화
			int[] loans = new int[loanNum + 1];
			long[] sums = new long[loanNum + 1];
			
			// for 반복문을 사용해 입력 받은 돈을 빌린 횟수별 빌린 액수를 배열 loans에 저장
			for (int idx = 1; idx < loans.length; idx++)
				loans[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 돈을 빌린 액수를 오름차순으로 정렬
			Arrays.sort(loans);
			
			// for 반복문을 사용해 입력 받은 돈을 빌린 횟수별 빌린 액수의 누적 합을 갱신
			for (int idx = 1; idx < sums.length; idx++)
				sums[idx] = loans[idx] + sums[idx - 1];
			
			// for 반복문을 사용해 각 갚아야 하는 횟수를 순회
			for (int count = 2; count <= loanNum; count++) {
				
				// 갚아야 하는 돈의 최솟값을 저장할 변수 minAmount 초기화
				long minAmount = Long.MAX_VALUE;
				
				// for 반복문을 사용해 갚아야 하는 돈의 최솟값을 갱신
				for (int idx = count; idx <= loanNum; idx++)
					minAmount = Math.min(loans[idx] * count - sums[idx] + sums[idx - count], minAmount);
				
				// 민균이가 추가적으로 갚아야 하는 돈의 최솟값 총합을 갱신
				totalSum += minAmount;
			}
			
			// write() 메서드를 사용해 민균이가 추가적으로 갚아야 하는 돈의 최솟값 총합을 출력
			out.write(totalSum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}