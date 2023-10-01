package silver2.num02512;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지방의 수를 변수 regionNum에 할당
		int regionNum = Integer.parseInt(in.readLine());
		
		// 모든 예산 요청의 총합 및 가장 많은 예산 요청을 저장할 각 변수 초기화
		int sumRequest = 0;
		int maxRequest = 0;
		
		// 각 예산 요청을 저장할 배열 requests 초기화
		int[] requests = new int[regionNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 지방의 예산 요청을 순회
		for (int idx = 0; idx < regionNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지방 예산 요청을 배열 requests에 저장
			requests[idx] = Integer.parseInt(st.nextToken());
			
			// 예산 요청의 총합 및 가장 많은 예산 요청을 갱신
			sumRequest += requests[idx];
			maxRequest = Math.max(requests[idx], maxRequest);
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 총 예산을 변수 totalBudget에 할당
		int totalBudget = Integer.parseInt(in.readLine());
		
		// 모든 요청을 배정할 수 있는 경우 가장 많은 예산 요청을 출력
		if (totalBudget >= sumRequest) {
			out.write(String.valueOf(maxRequest));
		
		// 모든 요청을 배정할 수 없는 경우
		} else {
			
			// 상한액을 결정하기 위해 필요한 각 변수 초기화
			int low = 1;
			int high = maxRequest;
			
			// while 반복문을 사용해 상한액을 찾을 때까지 순회
			while (low <= high) {
				
				// 예산 총합을 저장할 변수 sum 초기화
				int sum = 0;
				
				// 중간값을 계산해 변수 mid에 할당
				int mid = (low + high) / 2;
				
				// for 반복문을 사용해 예산 총합을 계산
				for (int idx = 0; idx < requests.length; idx++)
					sum += Math.min(requests[idx], mid);
					
				// 예산 총합의 상한액을 정확히 찾은 경우 상한액을 갱신 후 반복문 탈출
				if (sum == totalBudget) {
					high = mid;
					break;
					
				// 예산 총합의 상한액을 넘은 경우 상한을 나타내는 변수를 갱신
				} else if (sum > totalBudget) {
					high = mid - 1;
					
				// 예산 총합의 상한액에 미달한 경우 하한을 나타내는 변수를 갱신
				} else {
					low = mid + 1;
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 상한액을 출력
			out.write(String.valueOf(high));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}