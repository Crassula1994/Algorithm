package gold5.num02107;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 구간의 개수를 변수 rangeNum 초기화
		int rangeNum = Integer.parseInt(in.readLine());
		
		// 어떤 한 구간이 다른 구간들을 최대한 많이 포함하고 있는 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 구간의 정보를 저장할 2차원 배열 ranges 초기화
		int[][] ranges = new int[rangeNum][2];
		
		// for 반복문을 사용해 각 구간의 정보를 순회
		for (int idx = 0; idx < ranges.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 구간의 정보를 2차원 배열 ranges에 저장
			ranges[idx][0] = Integer.parseInt(st.nextToken());
			ranges[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// sort() 메서드를 사용해 구간의 시작 위치, 끝 위치를 기준으로 오름차순 정렬
		Arrays.sort(ranges, (r1, r2) -> {
			return (r1[0] == r2[0]) ? r1[1] - r2[1] : r1[0] - r2[0];
		});
		
		// for 반복문을 사용해 각 구간을 순회
		for (int curIdx = 0; curIdx < ranges.length - 1; curIdx++) {
			
			// 해당 구간의 끝 위치와 해당 구간에 포함된 구간의 개수를 저장할 각 변수 초기화
			int endPoint = ranges[curIdx][1];
			int count = 0;
			
			// for 반복문을 사용해 시작 위치가 포함되는 각 구간을 순회
			for (int nextIdx = curIdx + 1; nextIdx < ranges.length; nextIdx++) {
				
				// 해당 구간이 현재 구간에 포함되지 않는 경우 반복문 탈출
				if (ranges[nextIdx][0] > endPoint)
					break;
				
				// 해당 구간이 현재 구간에 포함되는 경우 어떤 한 구간이 다른 구간들을 최대한 많이 포함하고 있는 개수를 갱신
				if (ranges[nextIdx][1] < endPoint)
					count++;
			}
			
			// max() 메서드를 사용해 어떤 한 구간이 다른 구간들을 최대한 많이 포함하고 있는 개수를 갱신
			maxCount = Math.max(count, maxCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 어떤 한 구간이 다른 구간들을 최대한 많이 포함하고 있는 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}