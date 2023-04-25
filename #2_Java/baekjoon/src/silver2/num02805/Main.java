package silver2.num02805;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 나무의 수 및 필요한 나무의 길이를 각 변수에 할당
		int treeNum = Integer.parseInt(st.nextToken());
		int demand = Integer.parseInt(st.nextToken());
		
		// 각 나무의 길이를 저장할 배열 trees 초기화
		int[] trees = new int[treeNum];
		
		// 나무의 최대 높이를 저장할 maxHeight 초기화
		int maxHeight = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 나무의 높이를 순회
		for (int idx = 0; idx < trees.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 나무의 높이를 배열에 저장
			trees[idx] = Integer.parseInt(st.nextToken());
			
			// 나무의 최대 높이를 갱신
			maxHeight = (trees[idx] > maxHeight) ? trees[idx] : maxHeight;
		}
		
		// 이진 탐색 시 사용할 상한, 하한, 중간값을 나타내는 각 변수 초기화
		int start = 1;
		int mid = 0;
		int end = maxHeight;
		
		// while 반복문을 사용해 나무의 최대 높이를 도출할 때까지 순회
		while (start <= end) {
			
			// 이진 탐색 시 사용할 중간값 갱신
			mid = (start + end) / 2;
			
			// 절단한 나무의 길이 총합을 저장할 변수 length 초기화
			long length = 0;
;			
			// for 반복문을 사용해 배열 trees의 각 원소를 순회하며 절단한 나무의 길이 갱신
			for (int idx = 0; idx < trees.length; idx++)
				length = (trees[idx] < mid) ? length : length + trees[idx] - mid;
			
			// 필요한 양보다 더 적은 양의 나무를 자르는 경우 상한 조정
			if (length < demand) {
				end = mid - 1;
			
			// 필요한 양과 같거나 많은 양의 나무를 자르는 경우 하한 조정
			} else {
				start = mid + 1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 절단기의 최대 높이를 출력
		out.write(String.valueOf(end));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}