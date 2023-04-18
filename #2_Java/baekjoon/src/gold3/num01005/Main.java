package gold3.num01005;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 건물의 개수와 건설 순서 규칙의 총 개수를 각 변수에 할당
			int buildingNum = Integer.parseInt(st.nextToken());
			int orderNum = Integer.parseInt(st.nextToken());
			
			// 각 건물을 짓기 위해 필요한 시간, 선행 건물의 수, 완성을 위해 필요한 최소 시간을 저장할 각 배열 초기화
			int[] buildingTime = new int[buildingNum + 1];
			int[] buildCounter = new int[buildingNum + 1];
			int[] minTime = new int[buildingNum + 1];
			
			// 각 건물 간의 건설 순서를 저장할 배열 orders 초기화
			@SuppressWarnings("unchecked")
			List<Integer>[] orders = new ArrayList[buildingNum + 1];
			
			// for 반복문을 사용해 건설 순서를 저장할 List 객체 초기화
			for (int idx = 0; idx <= buildingNum; idx++)
				orders[idx] = new ArrayList<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 건물을 짓기 위해 필요한 시간을 배열 buildingTime에 저장
			for (int idx = 1; idx <= buildingNum; idx++)
				buildingTime[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 건설 순서를 순회
			for (int order = 0; order < orderNum; order++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 선행 건물 및 이후 지을 수 있는 건물을 각 변수에 할당
				int prevBuilding = Integer.parseInt(st.nextToken());
				int nextBuilding = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 건설 순서를 추가
				orders[prevBuilding].add(nextBuilding);
				
				// 건물별로 선행 건물의 수를 갱신
				buildCounter[nextBuilding]++;
			}
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 승리하기 위해 건설해야 할 건물 번호를 변수 targetBuilding에 할당
			int targetBuilding = Integer.parseInt(in.readLine());
			
			// 다음에 지을 건물을 저장할 Queue 객체 buildList 초기화
			Queue<Integer> buildList = new LinkedList<>();
			
			// for 반복문을 사용해 배열 buildCounter의 각 원소를 순회
			for (int idx = 1; idx <= buildingNum; idx++) {
				
				// 해당 건물의 선행 건물이 존재하지 않는 경우 buildList에 추가
				if (buildCounter[idx] == 0)
					buildList.offer(idx);
			}
			
			// while 반복문을 사용해 buildList가 빌 때까지 순회
			while (!buildList.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 건설 중인 건물을 변수 currentBuilding에 할당
				int currentBuilding = buildList.poll();
				
				// 해당 건물의 건설 시간을 최소 건설 시간에 반영
				minTime[currentBuilding] += buildingTime[currentBuilding];
				
				// 해당 건물이 승리하기 위해 건설해야 할 건물인 경우
				if (currentBuilding == targetBuilding) {
				
					// write() 메서드를 사용해 해당 건물의 완성을 위해 필요한 최소 시간을 출력 후 반복문 탈출
					out.write(minTime[currentBuilding] + "\n");
					break;
				}
				
				// for 반복문을 사용해 현재 건설 중인 건물이 선행 건물인 건물을 순회
				for (int idx = 0; idx < orders[currentBuilding].size(); idx++) {
					
					// get() 메서드를 사용해 현재 건설 중인 건물이 선행 건물인 건물을 변수 nextBuilding에 할당
					int nextBuilding = orders[currentBuilding].get(idx);
					
					// 해당 건물의 선행 건물 수를 갱신
					buildCounter[nextBuilding]--;
					
					// max() 메서드를 사용해 해당 건물의 건설 시간에 선행 건물의 건설 시간을 갱신
					minTime[nextBuilding] = Math.max(minTime[currentBuilding], minTime[nextBuilding]);
					
					// 해당 건물의 선행 건물 수가 0인 경우 buildList에 추가
					if (buildCounter[nextBuilding] == 0)
						buildList.offer(nextBuilding);
				}
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}