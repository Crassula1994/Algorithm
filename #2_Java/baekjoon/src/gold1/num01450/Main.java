package gold1.num01450;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 가방에 넣을 수 있는 최대 무게를 저장할 변수 maxWeight 초기화
	static int maxWeight;
	
	// 각 물건의 무게를 저장할 배열 weights 초기화
	static int[] weights;
	
	// 물건을 두 개의 그룹으로 나누어 각 그룹에서 모든 물건의 무게 조합을 저장할 각 List 객체 초기화
	static List<Integer> groupA;
	static List<Integer> groupB;	
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 물건의 개수와 가방에 넣을 수 있는 최대 무게를 각 변수에 할당
		int stuffNum = Integer.parseInt(st.nextToken());
		maxWeight = Integer.parseInt(st.nextToken());
		
		// 각 물건의 무게를 저장할 배열 weights 초기화
		weights = new int[stuffNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 물건의 무게를 배열 weights에 저장
		for (int idx = 0; idx < weights.length; idx++)
			weights[idx] = Integer.parseInt(st.nextToken());
		
		// 물건을 두 개의 그룹으로 나누어 각 그룹에서 모든 물건의 무게 조합을 저장할 각 List 객체 초기화
		groupA = new ArrayList<>();
		groupB = new ArrayList<>();
		
		// weightCalculator() 메서드를 호출해 각 그룹별 무게 조합을 갱신
		weightCalculator(0, stuffNum / 2, 0, groupA);
		weightCalculator(stuffNum / 2, stuffNum, 0, groupB);
		
		// 물건을 가방에 넣는 방법의 수를 저장할 변수 totalCnt 초기화
		int totalCnt = 0;
		
		// sort() 메서드를 사용해 두 번째 그룹의 각 무게를 오름차순으로 정렬
		Collections.sort(groupB);
		
		// for 반복문을 사용해 첫 번째 그룹의 각 무게를 순회
		for (int weightA : groupA) {
			
			// weightFinder() 메서드를 호출해 가방에 넣을 수 있는 최대 무게를 만들 수 있는 무게 조합의 수를 변수 count에 할당
			int count = weightFinder(weightA);
			
			// 물건을 가방에 넣는 방법의 수를 갱신
			totalCnt += count;
		}
		
		// valueOf() 및 write() 메서드를 사용해 물건을 가방에 넣는 방법의 수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// weightCalculator() 메서드 정의
	public static void weightCalculator(int start, int end, int sum, List<Integer> group) {

		// 해당 그룹의 무게 합이 가방에 넣을 수 있는 최대 무게를 초과한 경우 메서드 종료
		if (sum > maxWeight)
			return;
		
		// 모든 물건을 확인한 경우
		if (start == end) {
			
			// add() 메서드를 사용해 해당 그룹의 무게 합을 주어진 List 객체에 추가 후 메서드 종료
			group.add(sum);
			return;
		}
		
		// 해당 물건을 넣은 경우와 넣지 않은 경우를 상정해 weightCalculator() 메서드 재귀 호출
		weightCalculator(start + 1, end, sum, group);
		weightCalculator(start + 1, end, sum + weights[start], group);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// weightFinder() 메서드 정의
	public static int weightFinder(int weight) {
		
		// 이분탐색을 위해 필요한 구간의 양끝 값을 저장할 각 변수 초기화
		int start = 0;
		int end = groupB.size();
		
		// while 반복문을 사용해 가방에 넣을 수 있는 최대 무게를 초과하는 값을 찾을 때까지 순회
		while (start < end) {
			
			// 이분탐색을 위해 필요한 중간값을 나타낼 변수 mid 초기화
			int mid = (start + end) / 2;
			
			// 주어진 첫 번째 그룹의 무게와 두 번째 그룹의 무게의 합이 가방의 최대 무게 이하인 경우 구간의 왼쪽 끝을 갱신
			if (groupB.get(mid) + weight <= maxWeight) {
				start = mid + 1;
			
			// 주어진 첫 번째 그룹의 무게와 두 번째 그룹의 무게의 합이 가방의 최대 무게 초과인 경우 구간의 오른쪽 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// 가방에 넣을 수 있는 최대 무게를 초과하는 값의 인덱스를 반환
		return end;
	}
}