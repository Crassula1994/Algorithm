package gold3.num02473;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 용액의 수를 변수 solutionNum에 할당
		int solutionNum = Integer.parseInt(in.readLine());
		
		// 각 용액의 특성 값을 저장할 배열 pHIndex 초기화
		long[] pHIndex = new long[solutionNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 용액의 특성 값을 배열 pHIndex에 저장
		for (int idx = 0; idx < solutionNum; idx++)
			pHIndex[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 pHIndex를 오름차순으로 정렬
		Arrays.sort(pHIndex);
		
		// 0에 가장 가까운 용액의 특성값의 합, 해당 합을 구성하는 각 용액의 인덱스를 저장할 각 변수 초기화
		int minSol1 = 0;
		int minSol2 = 1;
		int minSol3 = solutionNum - 1;
		long minDifference = Math.abs(pHIndex[minSol1] + pHIndex[minSol2] + pHIndex[minSol3]);
		
		// for 반복문을 사용해 첫 번째 용액의 인덱스를 차례로 순회
		outer: for (int s1 = 0; s1 < solutionNum - 2; s1++) {
			
			// 각 용액의 쌍을 탐색하기 위해 필요한 나머지 두 용액의 인덱스를 초기화
			int s2 = s1 + 1;
			int s3 = solutionNum - 1;
			
			// while 반복문을 사용해 두 용액의 인덱스가 교차할 때까지 순회
			while (s2 < s3) {
			
				// 각 용액 쌍의 특성값 합을 변수 sum에 할당
				long sum = pHIndex[s1] + pHIndex[s2] + pHIndex[s3];
				
				// 특성값의 합이 현재 저장된 0에 가장 가까운 용액의 특성값의 합보다 작은 경우
				if (Math.abs(sum) < minDifference) {
					
					// 0에 가장 가까운 용액의 특성값의 합을 갱신
					minDifference = Math.abs(sum);
					minSol1 = s1;
					minSol2 = s2;
					minSol3 = s3;
					
					// 특성값의 합이 0인 경우 반복문 탈출
					if (sum == 0)
						break outer;
				}
				
				// 각 쌍의 특성값 합이 0보다 작은 경우 두 번째 용액을 조정
				if (sum < 0) {
					s2++;

				// 각 쌍의 특성값 합이 0보다 큰 경우 세 번째 용액을 조정
				} else {
					s3--;
				}
			}
		}
		
		// write() 메서드를 사용해 0에 가장 가까운 용액의 특성값을 구성하는 세 용액을 출력
		out.write(pHIndex[minSol1] + " " + pHIndex[minSol2] + " " + pHIndex[minSol3]);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}