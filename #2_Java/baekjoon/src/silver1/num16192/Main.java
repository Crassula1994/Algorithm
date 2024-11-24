package silver1.num16192;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보로노이 다이어그램에 포함된 점의 수와
		질의의 수를 각 변수에 할당 */
		int pointNum = Integer.parseInt(st.nextToken());
		int queryNum = Integer.parseInt(st.nextToken());
		
		// 보로노이 다이어그램에 포함된 점을 저장할 2차원 배열 diagram 초기화
		int[][] diagram = new int[pointNum + 1][2];
		
		// for 반복문을 사용해 각 보로노이 다이어그램에 포함된 점을 순회
		for (int idx = 1; idx <= pointNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보로노이 다이어그램에 포함된 
			점의 좌표를 2차원 배열 diagram에 저장 */
			diagram[idx][0] = Integer.parseInt(st.nextToken());
			diagram[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// while 반복문을 사용해 각 질의를 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 질의한 점의 좌표를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// 해당 점과 가장 가까운 보로노이 다이어그램의 점의 거리를 저장할 변수 minDistance 초기화
			int minDistance = Integer.MAX_VALUE;
			
			// 해당 점과 가장 가까운 보로노이 다이어그램의 점을 저장할 List 객체 nearestPoints 초기화
			List<Integer> nearestPoints = new ArrayList<>();
			
			// for 반복문을 사용해 각 보로노이 다이어그램에 포함된 점을 순회
			for (int idx = 1; idx <= pointNum; idx++) {
				
				// 해당 점과 질의한 점의 거리를 계산해 변수 distance에 할당
				int distance = (diagram[idx][0] - coordinateX) * (diagram[idx][0] - coordinateX)
						+ (diagram[idx][1] - coordinateY) * (diagram[idx][1] - coordinateY);
				
				// 해당 점이 저장된 가장 가까운 보로노이 다이어그램의 점의 거리보다 짧은 거리에 있는 경우
				if (distance < minDistance) {
					
					// clear() 및 add() 메서드를 사용해 기존 점을 모두 제거 후 해당 점을 nearestPoints에 추가
					nearestPoints.clear();
					nearestPoints.add(idx);
					
					// 해당 점과 가장 가까운 보로노이 다이어그램의 점의 거리를 갱신
					minDistance = distance;
					
				// 해당 점이 저장된 가장 가까운 보로노이 다이어그램의 점의 거리와 같은 거리에 있는 경우
				} else if (distance == minDistance) {
					
					// add() 메서드를 사용해 해당 점을 nearestPoints에 추가
					nearestPoints.add(idx);
				}
			}
			
			// 해당 점이 어떠한 영역에도 속하지 않는 경우 'NONE' 출력
			if (nearestPoints.isEmpty()) {
				out.write("NONE");
				
			// 해당 점이 하나의 영역에만 속한 경우 해당 영역의 번호를 출력
			} else if (nearestPoints.size() == 1) {
				out.write("REGION " + nearestPoints.get(0));
				
			// 해당 점이 두 개의 영역에 속한 경우 두 영역의 번호를 출력
			} else if (nearestPoints.size() == 2) {
				out.write("LINE " + nearestPoints.get(0) + " " + nearestPoints.get(1));
				
			// 해당 점이 세 개 이상의 영역에 속한 경우 'POINT'를 출력
			} else {
				out.write("POINT");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}