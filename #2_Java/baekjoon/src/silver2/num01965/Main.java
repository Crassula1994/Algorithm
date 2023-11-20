package silver2.num01965;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 상자의 개수를 변수 boxNum에 할당
		int boxNum = Integer.parseInt(in.readLine());
		
		// 한 줄에 넣을 수 있는 최대의 상자 개수를 저장할 변수 maxCnt 초기화
		int maxCnt = 0;
		
		// 각 상자의 크기, 각 상자까지 한번에 넣을 수 있는 최대의 상자 개수를 저장할 각 배열 초기화
		int[] boxSizes = new int[boxNum];
		int[] maxCounts = new int[boxNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 상자의 크기를 배열 boxSizes에 저장
		for (int idx = 0; idx < boxSizes.length; idx++)
			boxSizes[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 상자를 차례로 순회
		for (int b = 0; b < boxNum; b++) {
			
			// 해당 상자까지 한번에 넣을 수 있는 최대의 상자 개수를 초기화
			maxCounts[b] = 1;
			
			// for 반복문을 사용해 해당 상자까지의 모든 상자를 순회
			for (int idx = 0; idx < b; idx++) {
				
				// 현재 상자가 해당 상자에 넣을 수 있는 경우 한번에 넣을 수 있는 최대의 상자 개수 갱신
				if (boxSizes[idx] < boxSizes[b])
					maxCounts[b] = Math.max(maxCounts[b], maxCounts[idx] + 1);
			}
			
			// max() 메서드를 사용해 한 줄에 넣을 수 있는 최대의 상자 개수를 갱신
			maxCnt = Math.max(maxCounts[b], maxCnt);
		}
		
		// valueOf() 및 write() 메서드를 사용해 한 줄에 넣을 수 있는 최대의 상자 개수를 출력
		out.write(String.valueOf(maxCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}