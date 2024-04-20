package gold3.num07579;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 활성화된 앱의 개수 및 필요한 메모리의 크기를 각 변수에 할당
		int appNum = Integer.parseInt(st.nextToken());
		int memoryNeeded = Integer.parseInt(st.nextToken());
		
		// 필요한 메모리의 크기를 확보하기 위한 앱 비활성화의 최소 비용을 저장할 변수 minCost 초기화
		int minCost = Integer.MAX_VALUE;
		
		// 각 앱이 사용 중인 메모리와 비활성화 했을 때의 비용을 저장할 각 배열 초기화
		int[] usages = new int[appNum + 1];
		int[] costs = new int[appNum + 1];
		
		// 각 앱을 비활성화 시, 그 비용으로 확보할 수 있는 최대 메모리를 저장할 2차원 배열 memories 초기화
		int[][] memories = new int[appNum + 1][10001];
		
		// StringTokenizer 객체를 불러와 각 변수에 할당
		StringTokenizer usageStr = new StringTokenizer(in.readLine());
		StringTokenizer costStr = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 앱의 사용 중인 메모리와 비활성화 했을 때의 비용을 각 배열에 저장
		for (int idx = 1; idx <= appNum; idx++) {
			usages[idx] = Integer.parseInt(usageStr.nextToken());
			costs[idx] = Integer.parseInt(costStr.nextToken());
		}
		
		// for 반복문을 사용해 각 앱을 차례로 순회
		for (int idx = 1; idx <= appNum; idx++) {
			
			// 해당 앱이 사용 중인 메모리와 비활성화 시 비용을 각 변수에 할당
			int usage = usages[idx];
			int cost = costs[idx];
			
			// for 반복문을 사용해 각 비활성화 시 비용을 순회
			for (int c = 0; c <= 10000; c++) {
				
				// 비활성화 시 비용이 해당 앱의 비용 이상인 경우 그 비용으로 확보할 수 있는 최대 메모리를 갱신
				if (c >= cost) {
					memories[idx][c] = Math.max(memories[idx - 1][c - cost] + usage, memories[idx - 1][c]);
				
				// 비활성화 시 비용이 해당 앱의 비용 미만인 경우 그 비용으로 확보할 수 있는 최대 메모리를 갱신
				} else {
					memories[idx][c] = memories[idx - 1][c];
				}
				
				// 확보할 수 있는 최대 메모리가 필요한 메모리의 크기 이상인 경우 앱 비활성화의 최소 비용 갱신
				if (memories[idx][c] >= memoryNeeded)
					minCost = Math.min(c, minCost);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 필요한 메모리의 크기를 확보하기 위한 앱 비활성화의 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}