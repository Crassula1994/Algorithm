package silver1.num16198;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 에너지 구슬의 개수, 모을 수 있는 에너지 양의 최댓값을 저장할 각 변수 초기화
	static int marbleNum;
	static int maxEnergy = 0;
	
	// 에너지 구슬의 무게와 제거되었는지 여부를 저장할 각 배열 초기화
	static int[] weights;
	static boolean[] removed;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 에너지 구슬의 개수를 변수 marbleNum에 할당
		marbleNum = Integer.parseInt(in.readLine());
		
		// 에너지 구슬의 무게와 제거되었는지 여부를 저장할 각 배열 초기화
		weights = new int[marbleNum];
		removed = new boolean[marbleNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 에너지 구슬의 무게를 배열 weights에 저장
		for (int idx = 0; idx < weights.length; idx++)
			weights[idx] = Integer.parseInt(st.nextToken());
		
		// marbleRemover() 메서드를 호출해 모을 수 있는 에너지 양의 최댓값을 갱신
		marbleRemover(0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 모을 수 있는 에너지 양의 최댓값을 출력
		out.write(String.valueOf(maxEnergy));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// marbleRemover() 메서드 정의
	public static void marbleRemover(int removedNum, int energy) {
		
		// 제거할 수 있는 구슬을 모두 제거한 경우
		if (removedNum == marbleNum - 2) {
			
			// max() 메서드를 사용해 모을 수 있는 에너지 양의 최댓값을 갱신 후 메서드 종료
			maxEnergy = Math.max(energy, maxEnergy);
			return;
		}
		
		// for 반복문을 사용해 제거할 수 있는 구슬을 순회
		for (int idx = 1; idx < marbleNum - 1; idx++) {
			
			// 해당 구슬을 이미 제거한 경우 다음 구슬을 순회
			if (removed[idx])
				continue;
			
			// 해당 구슬의 양쪽에 존재하는 구슬의 인덱스를 저장할 각 변수 초기화
			int prevMarble = -1;
			int nextMarble = -1;
			
			// for 반복문을 사용해 구슬의 왼쪽에 놓인 구슬을 순회
			for (int left = idx - 1; left >= 0; left--) {
				
				// 해당 구슬이 아직 제거되지 않은 경우 해당 구슬의 왼쪽에 존재하는 구슬의 인덱스를 갱신 후 반복문 탈출
				if (!removed[left]) {
					prevMarble = left;
					break;
				}
			}
			
			// for 반복문을 사용해 구슬의 오른쪽에 놓인 구슬을 순회
			for (int right = idx + 1; right < marbleNum; right++) {
				
				// 해당 구슬이 아직 제거되지 않은 경우 해당 구슬의 오른쪽에 존재하는 구슬의 인덱스를 갱신 후 반복문 탈출
				if (!removed[right]) {
					nextMarble = right;
					break;
				}
			}
			
			// 해당 구슬을 제거한 것으로 처리
			removed[idx] = true;
			
			// 해당 구슬을 제거한 것을 상정해 marbleRemover() 메서드 재귀 호출
			marbleRemover(removedNum + 1, energy + weights[prevMarble] * weights[nextMarble]);
			
			// 해당 구슬을 제거하지 않은 것으로 원상 복구
			removed[idx] = false;
		}
	}
}