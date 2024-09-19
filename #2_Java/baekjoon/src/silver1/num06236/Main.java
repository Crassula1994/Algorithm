package silver1.num06236;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 날짜에 필요한 금액을 저장할 배열 expenses 초기화
	static int[] expenses;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 기간과 돈을 인출할 횟수를 각 변수에 할당
		int period = Integer.parseInt(st.nextToken());
		int countLimit = Integer.parseInt(st.nextToken());
		
		// 이분 탐색에 필요한 양 구간을 저장할 각 변수 초기화
		int start = 0;
		int end = 1;
		
		// 각 날짜에 필요한 금액을 저장할 배열 expenses 초기화
		expenses = new int[period];
		
		// for 반복문을 사용해 각 날짜에 필요한 금액을 순회
		for (int idx = 0; idx < expenses.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 금액을 배열 expenses에 저장
			expenses[idx] = Integer.parseInt(in.readLine());
			
			// max() 메서드를 사용해 이분 탐색에 필요한 양 구간을 갱신
			start = Math.max(expenses[idx], start);
			end += expenses[idx];
		}
		
		// moneyWithdrawer() 메서드를 호출해 현우가 통장에서 인출해야 할 최소 금액을 변수 minAmount에 할당
		int minAmount = moneyWithdrawer(start, end, countLimit);
		
		// valueOf() 및 write() 메서드를 사용해 현우가 통장에서 인출해야 할 최소 금액을 출력
		out.write(String.valueOf(minAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// moneyWithdrawer() 메서드 정의
	public static int moneyWithdrawer(int start, int end, int countLimit) {
		
		// while 반복문을 사용해 인출해야 할 최소 금액을 찾을 때까지 순회
		while (start < end) {
			
			// 이분 탐색을 위해 필요한 중간 값을 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// dayCounter() 메서드를 호출해 중간 값에 해당하는 금액을 인출했을 때 필요한 인출 횟수를 변수 count에 할당
			int count = dayCounter(mid);
			
			// 필요한 인출 횟수가 정해진 인출 횟수보다 많은 경우 구간의 시작을 갱신
			if (count > countLimit) {
				start = mid + 1;
				
			// 필요한 인출 횟수가 정해진 인출 횟수보다 작거나 같은 경우 구간의 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// 인출해야 할 최소 금액을 반환
		return end;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// dayCounter() 메서드 정의
	public static int dayCounter(int amount) {
		
		// 현재 보유한 금액과 필요한 인출 횟수를 저장할 각 변수 초기화
		int curAmount = amount;
		int count = 1;
		
		// for 반복문을 사용해 각 날짜에 필요한 금액을 순회
		for (int expense : expenses) {
			
			// 현재 보유한 금액이 필요한 금액보다 적은 경우 현재 보유한 금액과 필요한 인출 횟수를 갱신
			if (curAmount < expense) {
				curAmount = amount;
				count++;
			}
			
			// 현재 보유한 금액을 갱신
			curAmount -= expense;
		}
		
		// 필요한 인출 횟수를 반환
		return count;
	}
}