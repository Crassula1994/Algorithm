package silver1.num02156;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 포도주 잔의 개수를 변수 glassNum에 할당
		int glassNum = Integer.parseInt(in.readLine());
		
		// 포도주 잔에 담긴 포도주의 양 및 각 잔을 선택했을 때 최대로 마실 수 있는 포도주의 양을 저장할 각 배열 초기화
		int[] glasses = new int[glassNum];
		int[] maxWine = new int[glassNum];
		
		// for 반복문을 사용해 입력 받은 포도주의 양을 배열 glasses에 저장
		for (int idx = 0; idx < glassNum; idx++)
			glasses[idx] = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 포도주 잔을 차례로 순회
		for (int idx = 0; idx < glassNum; idx++) {
			
			// 첫 번째 포도주 잔까지 최대로 마실 수 있는 포도주의 양을 갱신
			if (idx == 0) {
				maxWine[idx] = glasses[idx];
			
			// 두 번째 포도주 잔까지 최대로 마실 수 있는 포도주의 양을 갱신
			} else if (idx == 1) {
				maxWine[idx] = glasses[idx - 1] + glasses[idx];
			
			// 세 번째 포도주 잔까지 최대로 마실 수 있는 포도주의 양을 갱신
			} else if (idx == 2) {
				maxWine[idx] = Math.max(maxWine[idx - 1], Math.max(glasses[idx - 2] + glasses[idx], glasses[idx - 1] + glasses[idx]));

			// 네 번째 포도주 잔 이상에서 최대로 마실 수 있는 포도주의 양을 갱신
			} else {
				maxWine[idx] = Math.max(maxWine[idx - 1], Math.max(maxWine[idx - 2]+ glasses[idx], maxWine[idx - 3] + glasses[idx - 1] + glasses[idx]));
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 최대로 마실 수 있는 포도주의 양를 출력
		out.write(String.valueOf(maxWine[glassNum - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}