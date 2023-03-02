package d3.num02930;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// 완전 이진 트리를 나타낼 배열 maxHeap 초기화
	static int[] maxHeap;
	
	// 배열 maxHeap의 마지막 원소의 인덱스를 나타낼 변수 lastIdx 초기화
	static int lastIdx;
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 연산의 수를 변수 calcNum에 할당
			int calcNum = Integer.parseInt(in.readLine());
			
			// 완전 이진 트리를 나타낼 배열 maxHeap 초기화
			maxHeap = new int[calcNum + 1];
			
			// 배열 maxHeap의 마지막 원소의 인덱스를 나타낼 변수 lastIdx 초기화
			lastIdx = 0;
			
			// write() 메서드를 사용해 테스트 케이스 번호를 출력
			out.write("#" + (tc + 1));
			
			// for 반복문을 사용해 각 연산의 수를 순회
			for (int c = 0; c < calcNum; c++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 명령어를 변수 command에 할당
				int command = Integer.parseInt(st.nextToken());
				
				// 삽입 명령어인 경우
				if (command == 1) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
					int number = Integer.parseInt(st.nextToken());
					
					// 배열 maxHeap의 마지막 인덱스에 해당 숫자를 추가
					maxHeap[++lastIdx] = number;
					
					// 현재 노드의 인덱스를 변수 currentNode에 할당
					int currentNode = lastIdx;
					
					// while 반복문을 사용해 루트 노드에 도달하거나 부모 노드가 더 큰 값일 때까지 순회
					while (currentNode > 1 && maxHeap[currentNode] > maxHeap[currentNode / 2]) {
						
						// 현재 노드와 부모 노드의 값을 교환
						int temp = maxHeap[currentNode];
						maxHeap[currentNode] = maxHeap[currentNode / 2];
						maxHeap[currentNode / 2] = temp;
						
						// 현재 위치 갱신
						currentNode = currentNode / 2;
					}
					
				// 삭제 명령어인 경우
				} else {
					
					// maxHeap이 빈 경우 -1을 출력
					if (lastIdx == 0) {
						out.write(" " + -1);
					
					// maxHeap이 비지 않았을 경우
					} else {
						// write() 메서드를 사용해 루트 노드의 값을 출력
						out.write(" " + maxHeap[1]);
						
						// 루트 노드에 마지막 노드의 값을 삽입
						maxHeap[1] = maxHeap[lastIdx];
						
						// 마지막 노드 삭제 및 마지막 인덱스 조정
						maxHeap[lastIdx--] = 0;
						
						// 현재 노드의 인덱스를 변수 currentNode에 할당
						int currentNode = 1;
						
						// while 반복문을 사용해 자식 노드보다 더 클 때까지 순회
						while (true) {
							
							// 왼쪽 자식 노드를 변수 child에 할당
							int child = currentNode * 2;
							
							// 오른쪽 자식 노드가 존재하고, 오른쪽 자식 노드가 왼쪽 자식 노드보다 큰 경우 오른쪽 자식 노드를 child에 할당
							if (child + 1 <= lastIdx && maxHeap[child] < maxHeap[child + 1])
								child++;
							
							// 자식 노드가 더 이상 존재하지 않거나 자식 노드보다 더 큰 값일 경우 반복문 탈출
							if (child > lastIdx || maxHeap[child] <= maxHeap[currentNode])
								break;
							
							// 현재 노드와 자식 노드의 값을 교환
							int temp = maxHeap[currentNode];
							maxHeap[currentNode] = maxHeap[child];
							maxHeap[child] = temp;
							
							// 현재 위치 갱신
							currentNode = child;
						}
					}
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}