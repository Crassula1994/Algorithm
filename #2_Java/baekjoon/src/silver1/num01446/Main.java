package silver1.num01446;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Shortcut 클래스 정의
	static class Shortcut {
		
		// 지름길의 시작 위치, 지름길의 거리를 나타내는 각 변수 초기화
		int startLoc;
		int distance;
		
		// 매개변수를 입력 받는 생성자 정의
		public Shortcut(int startLoc, int distance) {
			this.startLoc = startLoc;
			this.distance = distance;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지름길의 개수 및 고속도로의 길이를 각 변수에 할당
		int shortcutNum = Integer.parseInt(st.nextToken());
		int highwayLen = Integer.parseInt(st.nextToken());
		
		// 지름길의 정보를 저장할 배열 info 초기화
		@SuppressWarnings("unchecked")
		List<Shortcut>[] info = new ArrayList[highwayLen + 1];
		
		// for 반복문을 사용해 각 지름길의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < info.length; idx++)
			info[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 지름길의 정보를 순회
		for (int s = 0; s < shortcutNum; s++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지름길의 정보를 각 변수에 할당
			int startLoc = Integer.parseInt(st.nextToken());
			int endLoc = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// 지름길의 끝 위치가 고속도로의 길이를 벗어나는 경우 다음 지름길의 정보를 순회
			if (endLoc > highwayLen)
				continue;
			
			// 지름길을 택하는 경우가 택하지 않는 경우에 비해 거리가 같거나 더 먼 경우 다음 지름길의 정보를 순회
			if (endLoc - startLoc <= distance)
				continue;
			
			// add() 메서드를 사용해 해당 지름길의 정보를 List 객체 info에 저장
			info[endLoc].add(new Shortcut(startLoc, distance));
		}
		
		// 출발점으로부터 고속도로 각 길이까지의 최단 거리를 저장할 배열 minDistance 초기화
		int[] minDistance = new int[highwayLen + 1];
		
		// fill() 메서드를 사용해 배열 minDistance의 각 원소를 초기화
		Arrays.fill(minDistance, Integer.MAX_VALUE);

		// 출발 위치의 최단 거리를 초기화
		minDistance[0] = 0;
		
		// for 반복문을 사용해 고속도로의 각 길이를 순회
		for (int loc = 1; loc <= highwayLen; loc++) {
			
			// 해당 위치가 도착점인 지름길이 존재하는 경우
			if (info[loc].size() > 0) {
				
				// for 반복문을 사용해 각 지름길을 순회
				for (int idx = 0; idx < info[loc].size(); idx++) {
					
					// get() 메서드를 사용해 해당 지름길을 변수 shortcut에 할당
					Shortcut shortcut = info[loc].get(idx);
					
					// min() 메서드를 사용해 해당 위치의 최단 거리를 갱신
					minDistance[loc] = Math.min(minDistance[shortcut.startLoc] + shortcut.distance, minDistance[loc]);
				}
				
				// min() 메서드를 사용해 해당 위치의 최단 거리를 갱신
				minDistance[loc] = Math.min(minDistance[loc - 1] + 1, minDistance[loc]);
			
			// 해당 위치가 도착점인 지름길이 존재하지 않는 경우 이전 거리보다 1 증가한 값을 최단 거리로 갱신
			} else {
				minDistance[loc] = minDistance[loc - 1] + 1;
			}
		}
		
		// valueOf() 및 wirte() 메서드를 사용해 세준이가 운전해야 하는 최소 거리를 출력
		out.write(String.valueOf(minDistance[highwayLen]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}