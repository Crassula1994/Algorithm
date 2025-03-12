package silver3.num26070;

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
		
		// 배불리 먹일 수 있는 곰곰이의 최대 마릿수를 저장할 변수 maxCount 초기화
		long maxCount = 0;
		
		// 치킨, 피자, 햄버거를 먹고 싶은 곰곰이의 마릿수 및 치킨, 피자, 햄버거 식권 장수를 저장할 각 배열 초기화
		int[] counts = new int[3];
		int[] tickets = new int[3];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 치킨, 피자, 햄버거를 먹고 싶은 곰곰이의 마릿수를 배열 counts에 저장
		for (int idx = 0; idx < counts.length; idx++)
			counts[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 치킨, 피자, 햄버거 식권 장수를 배열 tickets에 저장
		for (int idx = 0; idx < tickets.length; idx++)
			tickets[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 식권 교환 횟수를 순회
		for (int exchangeCnt = 0; exchangeCnt < 3; exchangeCnt++) {
			
			// for 반복문을 사용해 각 음식을 순회
			for (int idx = 0; idx < 3; idx++) {
				
				// min() 메서드를 사용해 해당 음식을 먹을 수 있는 곰곰이의 마릿수를 변수 count에 할당
				int count = Math.min(counts[idx], tickets[idx]);
				
				// 해당 음식을 먹고 싶은 곰곰이의 마릿수와 식권 장수, 배불리 먹일 수 있는 곰곰이의 최대 마릿수를 갱신
				counts[idx] -= count;
				tickets[idx] -= count;
				maxCount += count;
			}
			
			// 새로운 식권의 장수를 저장할 배열 newTickets 초기화
			int[] newTickets = new int[3];
			
			// for 반복문을 사용해 교환한 새로운 식권의 장수를 배열 newTickets에 저장
			for (int idx = 0; idx < 3; idx++)
				newTickets[idx] = tickets[(idx + 2) % 3] / 3 + tickets[idx] % 3;
			
			// 치킨, 피자, 햄버거 식권 장수를 갱신
			tickets = newTickets;
		}
		
		// valueOf() 및 write() 메서드를 사용해 배불리 먹일 수 있는 곰곰이의 최대 마릿수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}