package bronze2.num06246;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 슬롯 수 및 풍선들을 꽂는 횟수를 각 변수에 할당
		int slotNum = Integer.parseInt(st.nextToken());
		int stickCnt = Integer.parseInt(st.nextToken());
		
		// 비어 있는 슬롯의 개수를 저장할 변수 emptySlots 초기화
		int emptySlots = slotNum;
		
		// 각 슬롯에 풍선이 꽂혀 있는지 여부를 저장할 배열 hasBalloon 초기화
		boolean[] hasBalloon = new boolean[slotNum + 1];
		
		// for 반복문을 사용해 각 풍선들을 꽂는 횟수를 순회
		for (int count = 0; count < stickCnt; count++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 풍선을 꽂기 시작하는 슬롯과 간격을 각 변수에 할당
			int startSlot = Integer.parseInt(st.nextToken());
			int interval = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 풍선을 꽂을 각 슬롯을 순회
			for (int idx = startSlot; idx < hasBalloon.length; idx += interval) {
				
				// 이미 풍선이 꽂혀 있는 경우 다음 슬롯을 순회
				if (hasBalloon[idx])
					continue;
				
				// 풍선을 꽂은 것으로 처리 및 비어 있는 슬롯의 개수를 갱신
				hasBalloon[idx] = true;
				emptySlots--;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 비어 있는 슬롯의 개수를 출력
		out.write(String.valueOf(emptySlots));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}