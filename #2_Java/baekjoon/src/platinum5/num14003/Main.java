package platinum5.num14003;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 가장 긴 증가하는 부분 수열을 저장할 List 객체 subSequence 초기화
	static List<Integer> subSequence = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 수열과 각 원소를 가장 긴 증가하는 부분 수열에 삽입한 위치를 저장할 각 배열 초기화
		int[] sequence = new int[size];
		int[] locations = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 수열의 각 원소를 순회
		for (int idx = 0; idx < sequence.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 원소를 배열 sequence에 저장
			sequence[idx] = Integer.parseInt(st.nextToken());
			
			// 저장된 부분 수열이 없거나 해당 원소가 마지막으로 저장된 원소보다 큰 경우
			if (subSequence.isEmpty() || sequence[idx] > subSequence.get(subSequence.size() - 1)) {
				
				// add() 메서드를 사용해 해당 원소를 subSequence에 추가
				subSequence.add(sequence[idx]);
				
				// size() 메서드를 사용해 해당 원소를 부분 수열에 삽입한 위치를 갱신
				locations[idx] = subSequence.size() - 1;
				
			// 해당 원소가 마지막으로 저장된 원소보다 작거나 같은 경우
			} else {
				
				// indexFinder() 메서드를 호출해 해당 원소를 부분 수열에 삽입할 위치를 변수 index에 할당
				int index = indexFinder(sequence[idx]);
				
				// set() 메서드를 사용해 해당 원소를 subSequence에 추가
				subSequence.set(index, sequence[idx]);
				
				// 해당 원소를 부분 수열에 삽입한 위치를 갱신
				locations[idx] = index;
			}
		}
		
		// 가장 긴 증가하는 부분 수열을 저장할 Stack 객체 subSeqFinder 초기화
		Stack<Integer> subSeqFinder = new Stack<>();
		
		// for 반복문을 사용해 수열의 각 원소를 거꾸로 순회
		for (int idx = size - 1, targetIdx = subSequence.size() - 1; idx >= 0; idx--) {
			
			// 가장 긴 증가하는 부분 수열의 원소를 모두 찾은 경우 반복문 탈출
			if (targetIdx < 0)
				break;
			
			// 찾고자 하는 인덱스에 위치한 부분 수열의 원소를 찾은 경우
			if (locations[idx] == targetIdx) {
				
				// push() 메서드를 사용해 찾은 부분 수열의 원소를 subSeqFinder에 추가
				subSeqFinder.push(sequence[idx]);
				
				// 찾고자 하는 인덱스를 갱신
				targetIdx--;
			}
		}
		
		// size() 및 write() 메서드를 사용해 가장 긴 증가하는 부분 수열의 길이를 출력
		out.write(subSequence.size() + "\n");
		
		// while 반복문을 사용해 가장 긴 증가하는 부분 수열을 출력
		while (!subSeqFinder.isEmpty())
			out.write(subSeqFinder.pop() + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// indexFinder() 메서드 정의
	public static int indexFinder(int element) {
		
		// 이분 탐색을 위해 필요한 양 구간의 끝을 나타낼 각 변수 초기화
		int start = 0;
		int end = subSequence.size();
		
		// while 반복문을 사용해 해당 원소를 삽입할 인덱스를 찾을 때까지 순회
		while (start < end) {
			
			// 이분 탐색을 위해 필요한 중간값을 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// 삽입하려는 원소가 중간값에 위치한 원소보다 큰 경우 구간의 시작을 갱신
			if (element > subSequence.get(mid)) {
				start = mid + 1;
				
			// 삽입하려는 원소가 중간값에 위치한 원소보다 작거나 같은 경우 구간의 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// 해당 원소를 삽입할 인덱스를 반환
		return end;
	}
}