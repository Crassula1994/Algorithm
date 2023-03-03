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
			
			// 필요한 날짜의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// 각 나무의 높이를 저장할 배열 trees 초기화
			int[] trees = new int[treeNum];
			
			// for 반복문을 사용해 배열 trees의 각 원소를 순회
			for (int idx = 0; idx < trees.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 각 나무의 높이를 배열 trees에 할당
				trees[idx] = Integer.parseInt(st.nextToken());
				
				// 저장된 최대 높이보다 키가 높은 경우 해당 나무의 키를 최대 높이로 저장
				maxHeight = (trees[idx] > maxHeight) ? trees[idx] : maxHeight;
			}
			
			// for 반복문을 사용해 배열 trees의 각 원소를 순회하며 부족한 나무의 높이를 저장
			for (int idx = 0; idx < trees.length; idx++)
				trees[idx] = maxHeight - trees[idx];
			
			// 남은 높이가 1 또는 2인 나무의 개수를 저장할 배열 remains 초기화
			int[] remains = new int[2];
			
			// for 반복문을 사용해 배열 trees의 각 원소를 순회
			for (int idx = 0; idx < trees.length; idx++) {
				
				// 물을 연속으로 2일 줄 수 있는 경우를 계산해 날짜의 수를 갱신
				count += (trees[idx] / 3) * 2;
				
				// 남은 나무의 높이를 배열에 저장
				trees[idx] = trees[idx] % 3;
				
				// 남은 길이가 1인 나무의 수를 갱신
				if (trees[idx] == 1) {
					remains[0]++;
				
				// 남은 길이가 2인 나무의 수를 갱신
				} else if  (trees[idx] == 2){
					remains[1]++;
				}
			}
			
			// 길이가 1과 2인 나무 중 묶어서 물을 줄 수 있는 경우를 변수 couples에 할당 후 날짜의 수에 갱신
			int couples = Math.min(remains[0], remains[1]);
			count += couples * 2;
			remains[0] -= couples;
			remains[1] -= couples;
			
			// 모든 나무에 물을 준 경우 최소 날짜를 출력
			if (remains[0] == remains[1]) {
				out.write("#" + tc + " " + count + "\n");
				
			// 길이가 1인 나무가 남은 경우
			} else if (remains[0] > remains[1]) {
				
				count += remains[0] * 2 - 1;
				out.write("#" + tc + " " + count + "\n");
				
			// 길이가 2인 나무가 남은 경우
			} else {
				
				count += (remains[1] - 1) / 3 * 4 + (remains[1] - 1) % 3 + 2;
				out.write("#" + tc + " " + count + "\n");
				
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}