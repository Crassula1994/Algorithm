package gold1.num02357;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 극값의 범위를 초과한 값을 저장할 각 상수 초기화
	static final int MIN_VALUE = 0;
	static final int MAX_VALUE = 1_000_000_001;
	
	// 입력 받은 숫자를 배열 형태로 저장할 배열 numbers 초기화
	static int[] numbers;
	
	// 입력 받은 숫자를 세그먼트 트리 형태로 최솟값과 최댓값을 저장할 2차원 배열 segmentTree 초기화
	static int[][] segmentTree;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수, 구간의 최솟값과 최댓값을 구하는 횟수를 각 변수에 할당
		int numberCnt = Integer.parseInt(st.nextToken());
		int calcCnt = Integer.parseInt(st.nextToken());
		
		// 입력 받은 숫자를 배열 형태로 저장할 배열 numbers 초기화
		numbers = new int[numberCnt];
		
		// 입력 받은 숫자를 세그먼트 트리 형태로 최솟값과 최댓값을 저장할 2차원 배열 segmentTree 초기화
		segmentTree = new int[numberCnt * 4][2];
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(in.readLine());
		
		// segmentTreeMaker() 메서드를 호출해 입력 받은 숫자에 대하여 최솟값과 최댓값을 세그먼트 트리 형태로 저장
		segmentTreeMaker(1, 0, numberCnt - 1);
		
		// while 반복문을 사용해 각 수의 변경 및 구간의 합을 구하는 횟수를 순회
		while (calcCnt-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 최솟값과 최댓값을 구할 범위를 각 변수에 할당
			int startIdx = Integer.parseInt(st.nextToken()) - 1;
			int endIdx = Integer.parseInt(st.nextToken()) - 1;
			
			// segmentTreeFinder() 메서드를 호출해 주어진 범위의 최솟값과 최댓값을 배열 extremum에 저장
			int[] extremum = segmentTreeFinder(1, 0, numberCnt - 1, startIdx, endIdx);
			
			// write() 메서드를 사용해 해당 구간의 최솟값과 최댓값을 출력
			out.write(extremum[0] + " " + extremum[1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// segmentTreeMaker() 메서드 정의
	public static void segmentTreeMaker(int node, int start, int end) {
		
		// 현재 노드가 말단 노드인 경우 말단 노드의 극값을 갱신 후 메서드 종료
		if (start == end) {
			segmentTree[node][0] = numbers[start];
			segmentTree[node][1] = numbers[start];
			return;
		}
		
		// 범위의 중간 값 및 자식 노드를 계산해 각 변수에 할당
		int mid = (start + end) / 2;
		int leftChild = node * 2;
		int rightChild = node * 2 + 1;
		
		// segmentTreeMaker() 메서드를 재귀 호출해 자식 노드 값의 극값을 갱신
		segmentTreeMaker(leftChild, start, mid);
		segmentTreeMaker(rightChild, mid + 1, end);
		
		// min() 및 max() 메서드를 사용해 해당 노드의 극값을 2차원 배열 segmentTree에 저장
		segmentTree[node][0] = Math.min(segmentTree[leftChild][0], segmentTree[rightChild][0]);
		segmentTree[node][1] = Math.max(segmentTree[leftChild][1], segmentTree[rightChild][1]);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// segmentTreeFinder() 메서드 정의
	public static int[] segmentTreeFinder(int node, int start, int end, int startIdx, int endIdx) {
		
		// 해당 범위에 값을 구해야 할 범위가 존재하지 않는 경우 최댓값과 최솟값의 범위를 벗어나는 값을 배열에 담아 반환
		if (startIdx > end || endIdx < start)
			return new int[] {MAX_VALUE, MIN_VALUE};
		
		// 해당 범위가 극값을 구해야 할 범위 내에 존재하는 경우 현재 노드의 극값을 반환
		if (startIdx <= start && endIdx >= end)
			return segmentTree[node];
		
		// 범위의 중간 값을 계산해 변수 mid에 할당
		int mid = (start + end) / 2;
		
		// segmentTreeFinder() 메서드를 재귀 호출해 두 자식 노드에 대한 극값을 각 배열에 할당
		int[] leftChildExtremum = segmentTreeFinder(node * 2, start, mid, startIdx, endIdx);
		int[] rightChildExtremum = segmentTreeFinder(node * 2 + 1, mid + 1, end, startIdx, endIdx);
		
		// min() 및 max() 메서드를 사용해 해당 노드에서 극값을 각 변수에 할당
		int minNumber = Math.min(leftChildExtremum[0], rightChildExtremum[0]);
		int maxNumber = Math.max(leftChildExtremum[1], rightChildExtremum[1]);
		
		// 두 자식 노드에 대해 극값을 구한 결과를 반환
		return new int[] {minNumber, maxNumber};
	}
}