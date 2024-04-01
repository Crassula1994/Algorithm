package silver3.num07795;

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
	
	// A가 B를 먹을 수 있는 쌍의 개수를 저장할 변수 pairNum 초기화
	static int pairNum;
	
	// 각 생명체의 크기를 저장할 각 배열 초기화
	static int[] sizeA;
	static int[] sizeB;
	
	// ----------------------------------------------------------------------------------------------------
	
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
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 생명체 A와 B의 수를 각 변수에 저장
			int countA = Integer.parseInt(st.nextToken());
			int countB = Integer.parseInt(st.nextToken());
			
			// A가 B를 먹을 수 있는 쌍의 개수를 저장할 변수 pairNum 초기화
			pairNum = 0;
			
			// 각 생명체의 크기를 저장할 각 배열 초기화
			sizeA = new int[countA];
			sizeB = new int[countB];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());

			// for 반복문을 사용해 입력 받은 생명체 A의 크기를 배열 sizeA에 저장
			for (int idx = 0; idx < sizeA.length; idx++)
				sizeA[idx] = Integer.parseInt(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 생명체 B의 크기를 배열 sizeB에 저장
			for (int idx = 0; idx < sizeB.length; idx++)
				sizeB[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 생명체 B의 크기를 오름차순으로 정렬
			Arrays.sort(sizeB);
			
			// for 반복문을 사용해 생명체 A의 크기에 따라 A가 B를 먹을 수 있는 쌍의 개수를 갱신
			for (int idx = 0; idx < sizeA.length; idx++)
				preyFinder(sizeA[idx]);
			
			// write() 메서드를 사용해 A가 B를 먹을 수 있는 쌍의 개수를 출력
			out.write(pairNum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// preyFinder() 메서드 정의
	public static void preyFinder(int targetSize) {
		
		// 이분탐색을 위해 필요한 구간의 양끝 값을 저장할 각 변수 초기화
		int start = 0;
		int end = sizeB.length;

		// while 반복문을 사용해 값을 찾을 때까지 순회
		while (start < end) {
			
			// 이분탐색을 위해 필요한 중간값인 mid 변수 초기화
			int mid = (start + end) / 2;
			
			// 중간값에 위치한 B의 크기가 A의 크기보다 작은 경우 구간의 왼쪽 끝을 갱신
			if (sizeB[mid] < targetSize) {
				start = mid + 1;
				
			// 중간값에 위치한 B의 크기가 A의 크기보다 크거나 같은 경우 구간의 오른쪽 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// A가 B를 먹을 수 있는 쌍의 개수를 갱신
		pairNum += end;
	}
}