package d2.num01966;

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
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 numCnt에 할당
			int numCnt = Integer.parseInt(in.readLine());
			
			// 주어진 행렬을 저장할 2차원 배열 matrix 초기화
			int[] minHeap = new int[numCnt];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열의 각 원소를 순회하며 배열 minHeap에 입력 받은 숫자를 저장
			for (int idx = 0; idx < minHeap.length; idx++)
				minHeap[idx] = Integer.parseInt(st.nextToken());

			// for 반복문을 사용해 자식이 있는 노드부터 루트 노드까지 순회하며 heapify() 메서드 호출해 최대 힙을 생성
			for (int idx = numCnt / 2 - 1; idx >= 0; idx--)
				heapify(minHeap, numCnt, idx);
			
			// for 반복문을 사용해 마지막 값부터 차례로 순회
			for (int idx = numCnt - 1; idx > 0; idx--) {
				
				// 마지막 값과 가장 처음에 위치한 값을 교환
				int temp = minHeap[0];
				minHeap[0] = minHeap[idx];
				minHeap[idx] = temp;
				
				// 남은 값 중 가장 큰 값이 앞에 위치하도록 haepify() 메서드 호출
				heapify(minHeap, idx, 0);
			}
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("#" + (tc + 1));
			
			// for 반복문을 사용해 정렬된 배열을 순회하며 원소를 출력
			for (int idx = 0; idx < minHeap.length; idx++)
				out.write(" " + minHeap[idx]);
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// heapify() 메서드 정의
	public static void heapify(int[] minHeap, int range, int idx) {
		
		// 현재 인덱스를 최댓값이라 가정하고 변수 maxVal에 할당
		int maxVal = idx;
		
		// 왼쪽 자식 노드 및 오른쪽 자식 노드의 인덱스를 각 변수에 할당
		int leftChild = 2 * idx + 1;
		int rightChild = 2 * idx + 2;
		
		// 왼쪽 자식 노드가 힙의 범위 내에 있고 부모 노드보다 큰 경우 왼쪽 자식 노드를 최댓값으로 갱신
		if (leftChild < range && minHeap[leftChild] > minHeap[maxVal])
			maxVal = leftChild;
		
		// 오른쪽 자식 노드가 힙의 범위 내에 있고 부모 노드보다 큰 경우 오른쪽 자식 노드를 최댓값으로 갱신
		if (rightChild < range && minHeap[rightChild] > minHeap[maxVal])
			maxVal = rightChild;
		
		// 부모 노드가 최댓값이 아닌 경우
		if (maxVal != idx) {
			
			// 부모 노드와 자식 노드의 자리를 교환
			int temp = minHeap[idx];
			minHeap[idx]= minHeap[maxVal];
			minHeap[maxVal]= temp;
			
			// 가장 큰 값이 가장 처음에 위치하도록 heapify() 메서드 재귀 호출
			heapify(minHeap, range, maxVal);
		}
	}
}