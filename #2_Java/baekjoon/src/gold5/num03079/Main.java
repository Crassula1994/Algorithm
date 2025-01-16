package gold5.num03079;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 심사를 받아야 할 사람의 수를 저장할 변수 peopleNum 초기화
	static int peopleNum;
	
	// 각 입국심사대에서 심사를 하는 데 걸리는 시간을 저장할 배열 checkpoints 초기화
	static int[] checkpoints;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 입국심사대의 개수 및 심사를 받아야 할 사람의 수를 각 변수에 할당
		int checkpointNum = Integer.parseInt(st.nextToken());
		peopleNum = Integer.parseInt(st.nextToken());
		
		// 상근이와 친구들이 심사를 마치는 데 걸리는 시간의 범위를 나타낼 각 변수 초기화
		long start = Long.MAX_VALUE;
		long end = 0;
		
		// 각 입국심사대에서 심사를 하는 데 걸리는 시간을 저장할 배열 checkpoints 초기화
		checkpoints = new int[checkpointNum];
		
		// for 반복문을 사용해 각 입국심사대를 순회
		for (int idx = 0; idx < checkpoints.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 입국심사대에서 심사를 하는 데 걸리는 시간을 배열 checkpoints에 저장
			checkpoints[idx] = Integer.parseInt(in.readLine());
			
			// min() 메서드를 사용해 상근이와 친구들이 심사를 마치는 데 걸리는 시간의 범위를 갱신
			start = Math.min(checkpoints[idx], start);
		}
		
		// 상근이와 친구들이 심사를 마치는 데 걸리는 시간의 최댓값을 갱신
		end = start * peopleNum;
		
		// 상근이와 친구들이 심사를 마치는 데 걸리는 최소 시간을 저장할 변수 minTime 초기화
		long minTime = end;
		
		// while 반복문을 사용해 상근이와 친구들이 심사를 마치는 데 걸리는 최소 시간을 찾을 때까지 순회
		while (start <= end) {
			
			// 현재 범위의 중간값을 계산해 변수 mid에 할당
			long mid = (start + end) / 2;
			
			// 상근이와 친구들이 해당 시간 내에 심사를 마칠 수 있는 경우 범위의 끝 부분과 최소 시간을 갱신
			if ((timeChecker(mid))) {
				end = mid - 1;
				minTime = mid;
				
			// 상근이와 친구들이 해당 시간 내에 심사를 마칠 수 없는 경우 범위의 시작 부분을 갱신
			} else {
				start = mid + 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 상근이와 친구들이 심사를 마치는 데 걸리는 최소 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeChecker() 메서드 정의
	public static boolean timeChecker(long targetTime) {
		
		// 심사를 마친 사람의 수를 저장할 변수 count 초기화
		long count = 0;
		
		// for 반복문을 사용해 각 입국심사대를 순회
		for (int time : checkpoints) {
			
			// 해당 입국심사대에서 주어진 시간 동안 심사를 마칠 수 있는 사람의 수를 갱신
			count += targetTime / time;
			
			// 주어진 시간 내에 상근이와 친구들이 심사를 마칠 수 있는 경우 true 반환
			if (count >= peopleNum)
				return true;
		}
		
		// 주어진 시간 내에 상근이와 친구들이 심사를 마칠 수 없는 경우 false 반환
		return false;
	}
}