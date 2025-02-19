package bronze1.num09329;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Prize 클래스 정의
	static class Prize {
		
		// 상금의 액수를 저장할 변수 초기화
		int money;
		
		// 해당 상금에 필요한 스티커의 종류를 저장할 List 객체 stickers 초기화
		List<Integer> stickers;
		
		// 매개변수를 입력 받는 생성자 정의
		public Prize(List<Integer> stickers, int money) {
			this.money = money;
			this.stickers = stickers;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상금의 종류 및 코치가 가지고 있는 스티커의 종류를 각 변수에 할당
			int prizeNum = Integer.parseInt(st.nextToken());
			int stickerNum = Integer.parseInt(st.nextToken());
			
			// 최대 상금의 액수를 저장할 변수 maxMoney 초기화
			int maxMoney = 0;
			
			// 상금의 정보 및 코치가 가지고 있는 스티커의 개수를 저장할 각 배열 초기화
			Prize[] prizes = new Prize[prizeNum];
			int[] counts = new int[stickerNum + 1];
			
			// for 반복문을 사용해 각 상금을 순회
			for (int idx = 0; idx < prizes.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상금에 필요한 스티커의 개수를 변수 stickerCnt에 할당
				int stickerCnt = Integer.parseInt(st.nextToken());
				
				// 해당 상금에 필요한 스티커의 종류를 저장할 List 객체 stickers 초기화
				List<Integer> stickers = new ArrayList<>();
				
				// while 반복문을 사용해 해당 상금에 필요한 스티커의 종류를 stickers에 저장
				while (stickerCnt-- > 0)
					stickers.add(Integer.parseInt(st.nextToken()));
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상금의 액수를 변수 money에 할당
				int money = Integer.parseInt(st.nextToken());
				
				// 해당 상금의 정보를 배열 prizes에 저장
				prizes[idx] = new Prize(stickers, money);
			}
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 코치가 가지고 있는 스티커의 개수를 배열 counts에 저장
			for (int idx = 1; idx < counts.length; idx++)
				counts[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 상금의 정보를 순회
			for (Prize prize : prizes) {
				
				// 해당 상금을 최대로 탈 수 있는 횟수를 저장할 변수 maxCount 초기화
				int maxCount = Integer.MAX_VALUE;
				
				// for 반복문을 사용해 해당 상금을 최대로 탈 수 있는 횟수를 갱신
				for (int sticker : prize.stickers)
					maxCount = Math.min(counts[sticker], maxCount);
				
				// 최대 상금의 액수를 갱신
				maxMoney += maxCount * prize.money;
			}
			
			// write() 메서드를 사용해 최대 상금의 액수를 출력
			out.write(maxMoney + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}