package silver1.num32358;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 쿼리의 개수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// 근성이의 현재 위치 및 이동 거리를 저장할 각 변수 초기화
		int currentLoc = 0;
		long totalDist = 0;
		
		// 민규가 쓰레기를 버린 나무의 위치를 저장할 TreeSet 객체 trashes 초기화
		TreeSet<Integer> trashes = new TreeSet<>();
		
		// while 반복문을 사용해 각 쿼리를 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 쿼리의 종류를 변수 category에 할당
			int category = Integer.parseInt(st.nextToken());
			
			// 민규가 쓰레기를 버리는 경우 쓰레기를 버린 좌표를 trashes에 추가
			if (category == 1) {
				trashes.add(Integer.parseInt(st.nextToken()));
				
			// 근성이가 쓰레기를 수거하는 경우
			} else {
				
				// while 반복문을 사용해 더 이상 쓰레기가 없을 때까지 순회
				while (!trashes.isEmpty()) {
				
					// ceiling() 및 floor() 메서드를 사용해 현재 근성이의 위치에서 가장 가까운 쓰레기가 투기된 나무를 각 변수에 할당
					Integer leftTree = trashes.floor(currentLoc);
					Integer rightTree = trashes.ceiling(currentLoc);
					
					// 근성이가 다음으로 이동할 위치를 저장할 변수 nextLoc 초기화
					int nextLoc;
					
					// 근성이의 오른쪽에 쓰레기가 투기된 나무가 없는 경우 왼쪽 나무로 이동
					if (rightTree == null) {
						nextLoc = leftTree;
					
					// 근성이의 왼쪽에 쓰레기가 투기된 나무가 없는 경우 오른쪽 나무로 이동
					} else if (leftTree == null) {
						nextLoc = rightTree;
						
					// 근성이의 양쪽에 쓰레기가 투기된 나무가 있는 경우
					} else {
						
						// 왼쪽 나무가 근성이와 더 가깝거나, 두 나무가 근성이로부터 같은 거리만큼 떨어져 있는 경우 왼쪽 나무로 이동
						if (Math.abs(leftTree - currentLoc) <= Math.abs(rightTree - currentLoc)) {
							nextLoc = leftTree;
							 
						// 오른쪽 나무가 근성이와 더 가까운 경우 오른쪽 나무로 이동
						} else {
							nextLoc = rightTree; 
						}
					}
					
					// abs() 메서드를 사용해 근성이의 이동 거리를 갱신
					totalDist += Math.abs(nextLoc - currentLoc);
					
					// 근성이의 현재 위치를 갱신
					currentLoc = nextLoc;
					
					// remove() 메서드를 사용해 쓰레기를 치운 나무의 위치를 trashes에서 제거
					trashes.remove(nextLoc);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 근성이의 이동 거리를 출력
		out.write(String.valueOf(totalDist));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}