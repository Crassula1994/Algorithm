package d2.num14510;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
    
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 나무의 수를 변수 treeNum에 할당
			int treeNum = Integer.parseInt(in.readLine());
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 가장 키 큰 나무의 키를 저장할 변수 maxHeight 초기화
			int maxHeight = 0;
			
			// 필요한 날짜의 수를 저장할 변수 minDate 초기화
			int minDate = 0;
			
			// 각 나무의 높이를 저장할 배열 trees 초기화
			int[] trees = new int[treeNum];
			
			// for 반복문을 사용해 배열 trees의 각 원소를 순회
			for (int idx = 0; idx < trees.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 각 나무의 높이를 배열 trees에 할당
				trees[idx] = Integer.parseInt(st.nextToken());
				
				// max() 메서드를 사용해 저장된 최대 높이보다 키가 높은 경우 해당 나무의 키를 최대 높이로 저장
				maxHeight = Math.max(trees[idx], maxHeight);
			}
			
			// 최대 높이와 비교해 더 자라야 하는 높이 중 2와 1의 개수를 저장할 각 변수 초기화
			int evenHeight = 0;
			int oddHeight = 0;
			
			// for 반복문을 사용해 배열 trees의 각 원소를 순회
			for (int idx = 0; idx < trees.length; idx++) {
				
				// 최대 높이와 비교해 더 자라야 하는 높이 중 2와 1의 개수를 갱신
				evenHeight += (maxHeight - trees[idx]) / 2;
				oddHeight += (maxHeight - trees[idx]) % 2;
			}
			
			// min() 메서드를 사용해 필요한 날짜 수 갱신
			minDate += Math.min(evenHeight, oddHeight) * 2;
			
			// 2의 높이가 1의 높이에 비해 많은 경우
			if (evenHeight > oddHeight) {
				
				// 2의 높이가 3의 배수로 있는 경우 4일간 나누어 작업할 수 있으므로 필요한 날짜 수 갱신
				minDate += (evenHeight - oddHeight) / 3 * 4;
				
				// 차이를 3으로 나눈 나머지를 변수 difference에 할당
				int difference = (evenHeight - oddHeight) % 3;
				
				// 차이가 2인 경우 3일간 나누어 작업할 수 있으므로 필요한 날짜 수 갱신
				if (difference == 2) {
					minDate += 3;
				
				// 차이가 1인 경우 하루를 쉬고 다음 날 작업할 수 있으므로 필요한 날짜 수 갱신
				} else if (difference == 1) {
					minDate += 2;
				}
			
			// 1의 높이가 2의 높이에 비해 많은 경우 필요한 날짜 수 갱신
			} else if (evenHeight < oddHeight) {
				minDate += 2 * (oddHeight - evenHeight) - 1;
			}

			// write() 메서드를 사용해 필요한 날짜 수 출력
			out.write("#" + tc + " " + minDate + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}