package silver1.num2564;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 블록의 크기를 각 변수에 할당
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 상점의 개수를 변수 shopNum에 할당
		int shopNum = Integer.parseInt(in.readLine());
		
		// 각 랜선의 길이를 저장할 배열 cables 초기화
		long[] cables = new long[originalCable];
		
		// 주어진 랜선 중 최소 랜선의 길이를 저장할 변수 maxCable 초기화
		long maxCable = 0;
		
		// for 반복문을 사용해 배열 cables의 각 원소 순회
		for (int idx = 0; idx < cables.length; idx++) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 각 케이블의 길이를 배열 cables에 저장
			cables[idx] = Long.parseLong(in.readLine());
			
			// 가장 긴 케이블인 경우 변수 maxCable 갱신
			maxCable = (cables[idx] > maxCable) ? cables[idx] : maxCable;
		}
		
		// 이진 탐색 시 사용할 상한, 하한, 중간값을 나타내는 각 변수 초기화
		long start = 1;
		long mid = 0;
		long end = maxCable;
		
		// while 반복문을 사용해 최대 길이를 찾을 때까지 순회
		while (start <= end) {
			
			// 이진 탐색 시 사용할 중간값 갱신
			mid = (start + end) / 2;
			
			// 만들 수 있는 랜선의 개수를 저장할 변수 count 초기화
			long count = 0;
			
			// for 반복문을 사용해 배열 cables의 각 원소를 순회하며 랜선의 개수 갱신
			for (int idx = 0; idx < cables.length; idx++)
				count += cables[idx] / mid;
			
			// 랜선의 개수가 부족한 경우 상한을 조정
			if (count < newCable) {
				end = mid - 1;
			
			// 랜선의 개수가 같거나 많은 경우 하한을 조정
			} else {
				start = mid + 1;
			}
		}
		
		// 랜선의 최대 길이를 변수 maxLength에 할당
		Long maxLength = end;
		
		// valueOf() 및 write() 메서드를 사용해 랜선의 최대 길이 출력
		out.write(String.valueOf(maxLength));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}