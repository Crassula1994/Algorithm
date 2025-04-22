package gold2.num22863;

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
		
		// nextToken(), parseInt(), parseLong() 메서드를 사용해 입력 받은 카드의 개수와 카드를 섞은 횟수를 각 변수에 할당
		int cardNum = Integer.parseInt(st.nextToken());
		long shuffleCount = Long.parseLong(st.nextToken());
		
		// 카드를 섞기 전 및 섞은 후 카드의 배치, 수열 D, 각 카드의 순환 확인 여부를 저장할 각 배열 초기화
		int[] prevCards = new int[cardNum + 1];
		int[] curCards = new int[cardNum + 1];
		int[] sequenceD = new int[cardNum + 1];
		boolean[] circulated = new boolean[cardNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 카드를 섞은 후 카드의 배치를 배열 curCards에 저장
		for (int idx = 1; idx < curCards.length; idx++)
			curCards[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열 D를 배열 sequenceD에 저장
		for (int idx = 1; idx < sequenceD.length; idx++)
			sequenceD[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 카드를 순회
		for (int idx = 1; idx <= cardNum; idx++) {
			
			// 해당 카드의 순환을 이미 확인한 경우 다음 카드를 순회
			if (circulated[idx])
				continue;
			
			// 현재 카드와 순환한 횟수를 저장할 각 변수 초기화
			int count = 0;
			int curCard = idx;
			
			// 순환하는 카드 순서를 저장할 변수 order 초기화
			int[] order = new int[cardNum + 1];
			
			// while 반복문을 사용해 각 카드의 순환이 끝날 때까지 순회
			while (!circulated[curCard]) {
				
				// 해당 카드의 순환 확인 여부 및 순환하는 카드 순서를 각 배열에 저장
				circulated[curCard] = true;
				order[count++] = curCard;
				
				// 현재 카드를 갱신
				curCard = sequenceD[curCard];
			}
			
			// for 반복문을 사용해 각 순환 횟수를 순회
			for (int c = 0; c < count; c++) {
				
				// 카드를 섞은 후 해당 위치의 카드를 변수 card에 할당
				int card = curCards[order[c]];
				
				// 카드가 원래 있어야 할 위치를 계산해 변수 prevIdx에 할당
				int prevIdx = order[(int) ((c + shuffleCount) % count)];
				
				// 해당 카드가 원래 있어야 할 위치에 해당 카드를 저장
				prevCards[prevIdx] = card;
			}
		}
		
		// for 반복문을 사용해 카드를 섞기 전 카드의 배치를 출력
		for (int idx = 1; idx < prevCards.length; idx++)
			out.write(prevCards[idx] + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}