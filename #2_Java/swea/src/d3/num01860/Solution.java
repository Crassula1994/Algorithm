package d3.num01860;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
    
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 손님의 수, 소요 시간, 한번에 만드는 붕어빵의 개수를 각 변수에 할당
			int customerNum = Integer.parseInt(st.nextToken());
			int unitTime = Integer.parseInt(st.nextToken());
			int unitQuantity = Integer.parseInt(st.nextToken());
			
			// 각 시간별로 오는 손님의 수를 저장할 배열 customers 초기화
			int[] customers = new int[11112];
			
			// 기다리는 시간 없이 붕어빵을 제공할 수 있는지 여부를 저장할 변수 answer 초기화
			String answer = "Possible";
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 손님의 도착 시간을 순회하며 시간별로 도착하는 손님의 수를 배열 customers에 갱신
			for (int c = 0; c < customerNum; c++)
				customers[Integer.parseInt(st.nextToken())]++;
			
			// 붕어빵의 개수를 저장할 변수 totalQuantity 초기화
			int totalQuantity = 0;
			
			// for 반복문을 사용해 각 시간을 순회
			for (int time = 0; time <= 11111; time++) {
				
				// 붕어빵을 만드는 시간이 된 경우 붕어빵의 개수 갱신
				if (time != 0 && time % unitTime == 0)
					totalQuantity += unitQuantity;
				
				// 붕어빵을 손님에게 분배 후 붕어빵의 개수 갱신
				totalQuantity -= customers[time];
				
				// 붕어빵의 개수가 음수가 된 경우 기다리는 시간 없이 붕어빵을 제공할 수 있는지 여부 갱신 및 반복문 탈출
				if (totalQuantity < 0) {
					answer = "Impossible";
					break;
				}
			}
			
			// write() 메서드를 사용해 기다리는 시간 없이 붕어빵을 제공할 수 있는지 여부를 출력
        	out.write("#" + tc + " " + answer + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}