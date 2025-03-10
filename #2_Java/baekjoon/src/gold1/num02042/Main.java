package gold1.num02042;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 숫자를 배열 및 세그먼트 트리 형태로 저장할 각 배열 초기화
	static long[] numbers;
	static long[] segmentTree;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와  변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수, 수의 변경 및 구간의 합을 구하는 횟수를 각 변수에 할당
		int numberCnt = Integer.parseInt(st.nextToken());
		int commandCnt = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		// 입력 받은 숫자를 배열 및 세그먼트 트리 형태로 저장할 각 배열 초기화
		numbers = new long[numberCnt];
		segmentTree = new long[numberCnt * 4];
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Long.parseLong(in.readLine());
		
		// segmentTreeMaker() 메서드를 호출해 입력 받은 숫자를 세그먼트 트리 형태로 저장
		segmentTreeMaker(1, 0, numberCnt - 1);
		
		// while 반복문을 사용해 각 수의 변경 및 구간의 합을 구하는 횟수를 순회
		while (commandCnt-- > 0) {
			
			// StringTokenizer 객체를 불러와  변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 명령의 종류를 변수 category에 할당
			int category = Integer.parseInt(st.nextToken());
			
			// 수의 변경이 일어나는 경우
			if (category == 1) {
				
				// nextToken(), parseInt(), parseLong() 메서드를 사용해 입력 받은 바꿀 수의 위치 및 바꿀 숫자를 각 변수에 할당
				int targetIdx = Integer.parseInt(st.nextToken()) - 1;
				long targetVal = Long.parseLong(st.nextToken());
				
				// segmentTreeUpdater() 메서드를 호출해 세그먼트 트리에 저장된 값을 변경
				segmentTreeUpdater(1, 0, numberCnt - 1, targetIdx, targetVal);
				
			// 구간의 합을 구하는 경우
			} else {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구간의 합을 구할 범위를 각 변수에 할당
				int startIdx = Integer.parseInt(st.nextToken()) - 1;
				int endIdx = Integer.parseInt(st.nextToken()) - 1;
				
				// segmentTreeAggregator() 및 write() 메서드를 사용해 해당 구간의 합을 출력
				out.write(segmentTreeAggregator(1, 0, numberCnt - 1, startIdx, endIdx) + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// segmentTreeMaker() 메서드 정의
	public static long segmentTreeMaker(int node, int start, int end) {
		
		// 현재 노드가 말단 노드인 경우 말단 노드의 값을 반환
		if (start == end)
			return segmentTree[node] = numbers[start];
		
		// 범위의 중간 값을 계산해 변수 mid에 할당
		int mid = (start + end) / 2;
		
		// segmentTreeMaker() 메서드를 재귀 호출해 자식 노드 값의 합을 반환
		return segmentTree[node] = segmentTreeMaker(node * 2, start, mid)
				+ segmentTreeMaker(node * 2 + 1, mid + 1, end);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// segmentTreeUpdater() 메서드 정의
	public static void segmentTreeUpdater(int node, int start, int end, int targetIdx, long targetVal) {
		
		// 해당 범위에 바꿔야 할 값이 존재하지 않는 경우 메서드 종료
		if (targetIdx < start || targetIdx > end)
			return;
		
		// 현재 노드가 말단 노드인 경우 해당 값을 변경 처리 후 메서드 종료
		if (start == end) {
			segmentTree[node] = targetVal;
			return;
		}
		
		// 범위의 중간 값 및 자식 노드를 계산해 각 변수에 할당
		int mid = (start + end) / 2;
		int leftChild = node * 2;
		int rightChild = node * 2 + 1;
		
		// segmentTreeUpdater() 메서드를 재귀 호출해 자식 노드에 대하여 값을 변경 처리
		segmentTreeUpdater(leftChild, start, mid, targetIdx, targetVal);
		segmentTreeUpdater(rightChild, mid + 1, end, targetIdx, targetVal);
		
		// 현재 노드의 값을 변경 처리
		segmentTree[node] = segmentTree[leftChild] + segmentTree[rightChild];
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// segmentTreeAggregator() 메서드 정의
	public static long segmentTreeAggregator(int node, int start, int end, int startIdx, int endIdx) {
		
		
		
		return 1;
	}
}