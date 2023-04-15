package gold4.num15961;

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
		
		// StrintTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 회전 초밥 벨트에 놓인 접시의 수, 초밥의 가짓수,
		연속해서 먹는 접시의 수, 쿠폰 번호를 각 변수에 할당 */
		int dishNum = Integer.parseInt(st.nextToken());
		int sushiNum = Integer.parseInt(st.nextToken());
		int interval = Integer.parseInt(st.nextToken());
		int couponNum = Integer.parseInt(st.nextToken());
		
		// 회전 초밥 벨트에 놓인 초밥의 종류를 저장할 배열 sushiBelt 초기화
		int[] sushiBelt = new int[dishNum];
		
		// for 반복문을 사용해 입력 받은 초밥의 종류를 배열 sushiBelt에 저장
		for (int idx = 0; idx < dishNum; idx++)
			sushiBelt[idx] = Integer.parseInt(in.readLine());
		
		// 지금까지 먹은 초밥의 종류별 개수를 저장할 배열 sushiCounter 초기화
		int[] sushiCounter = new int[sushiNum + 1];
		
		// 손님이 먹을 수 있는 초밥 가짓수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 첫 번째 연속된 초밥 접시를 순회
		for (int idx = 0; idx < interval; idx++) {
			
			// 현재 접시의 초밥을 변수 sushi에 할당
			int sushi = sushiBelt[idx];
			
			// 해당 초밥을 먹은 적이 없는 경우 먹을 수 있는 초밥 가짓수 갱신
			if (sushiCounter[sushi] == 0)
				count++;
			
			// 지금까지 먹은 초밥의 종류별 개수를 갱신
			sushiCounter[sushi]++;
		}
		
		// 손님이 먹을 수 있는 초밥 가짓수의 최댓값를 저장할 변수 maxCnt 초기화
		int maxCnt = count;
		
		// 쿠폰 번호의 초밥을 먹은 적이 없는 경우 먹을 수 있는 초밥 가짓수의 최댓값 갱신
		if (sushiCounter[couponNum] == 0)
			maxCnt++;
		
		// for 반복문을 사용해 각 연속된 초밥 접시를 순회
		for (int idx = 1; idx < dishNum; idx++) {
			
			// 이전 접시의 초밥 및 다음 접시의 초밥을 각 변수에 할당
			int prevSushi = sushiBelt[idx - 1];
			int nextSushi = sushiBelt[(idx + interval - 1) % dishNum];
			
			// 다음 초밥을 먹은 적이 없는 경우 먹을 수 있는 초밥 가짓수 갱신
			if (sushiCounter[nextSushi] == 0)
				count++;
			
			// 이전 접시의 초밥의 개수를 제거 및 다음 접시의 초밥을 추가
			sushiCounter[prevSushi]--;
			sushiCounter[nextSushi]++;
			
			// 이전 초밥을 먹은 적이 없는 경우 먹을 수 있는 초밥 가짓수 갱신
			if (sushiCounter[prevSushi] == 0)
				count--;
			
			// 해당 초밥 접시들에 대해 손님이 먹을 수 있는 초밥 가짓수가 저장된 최댓값보다 크거나 같을 경우
			if (count >= maxCnt) {
				
				// 먹을 수 있는 초밥 가짓수의 최댓값 갱신
				maxCnt = (sushiCounter[couponNum] == 0) ? count + 1 : count;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 출력
		out.write(String.valueOf(maxCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}