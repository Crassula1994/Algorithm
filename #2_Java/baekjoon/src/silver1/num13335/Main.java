package silver1.num13335;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 트럭의 수, 다리의 길이, 다리의 최대 하중을 각 변수에 할당
		int truckNum = Integer.parseInt(st.nextToken());
		int bridgeLen = Integer.parseInt(st.nextToken());
		int bridgeLoad = Integer.parseInt(st.nextToken());

		// 각 트럭의 무게 및 다리의 상태를 저장할 각 Queue 객체 초기화
		Queue<Integer> trucks = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 Queue 객체 trucks에 트럭을 추가
		for (int t = 0; t < truckNum; t++)
			trucks.offer(Integer.parseInt(st.nextToken()));
		
		// for 반복문을 사용해 Queue 객체 bridge에 현재 다리의 상태 초기화
		for (int l = 0; l < bridgeLen; l++)
			bridge.offer(0);
		
		// 트럭이 다리를 건너는 데 걸리는 최단 시간 및 현재 건너는 트럭의 총 하중을 저장할 각 변수 초기화
		int time = 0;
		int weight = 0;
		
		// while 반복문을 사용해 모든 트럭이 다리를 건너갈 때까지 순회
		while (!bridge.isEmpty()) {
			
			// 트럭이 다리를 건너는 시간을 갱신
			time++;
			
			// 트럭이 다리를 다 건넌 경우 현재 다리의 하중을 갱신
			if (bridge.peek() != 0)
				weight -= bridge.peek();
			
			// 트럭이 더 이상 없는 경우 더 이상 값을 추가하지 않고 이동
			if (trucks.isEmpty()) {
				bridge.poll();
			
			// 다음 트럭을 추가하더라도 최대 하중을 초과하지 않는 경우 해당 트럭을 추가하고 무게 갱신
			}	else if (weight + trucks.peek() <= bridgeLoad) {
				bridge.poll();
				weight += trucks.peek();
				bridge.offer(trucks.poll());
				
			// 다음 트럭을 추가했을 때 최대 하중을 초과하는 경우 트럭이 아니라 빈 값을 추가
			} else {
				bridge.poll();
				bridge.offer(0);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 트럭이 이동하는 데 소요되는 시간을 출력
		out.write(String.valueOf(time));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}