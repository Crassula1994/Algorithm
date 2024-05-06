package gold2.num12738;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 수열을 저장할 배열 sequence 초기화
	static int[] sequence;
	
	// 가장 긴 증가하는 부분 수열을 저장할 List 객체 subSequence 초기화
	static List<Integer> subSequence;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 입력 받은 수열을 저장할 각 배열 sequence 초기화
		sequence = new int[size];
		
		// 가장 긴 증가하는 부분 수열을 저장할 List 객체 subSequence 초기화
		subSequence = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 수열의 각 항을 순회
		for (int idx = 0; idx < sequence.length; idx++) {
			
			// 해당 항을 변수 term에 할당
			int term = sequence[idx];
			
			// 부분 수열이 비었거나 해당 항이 부분 수열의 마지막 항보다 큰 경우 해당 항을 subSequence에 추가
			if (subSequence.isEmpty() || term > subSequence.get(subSequence.size() - 1)) {
				subSequence.add(term);
			
			// 해당 항이 부분 수열의 마지막 항보다 작거나 같은 경우
			} else {
				
				// indexFinder() 메서드를 호출해 해당 항을 넣을 인덱스의 위치를 변수 index에 할당
				int index = indexFinder(term);
				
				// set() 메서드를 사용해 해당 인덱스의 항을 해당 항으로 변경
				subSequence.set(index, term);
			}
		}
		
		// size(), valueOf(), write() 메서드를 사용해 가장 긴 증가하는 부분 수열의 길이를 출력
		out.write(String.valueOf(subSequence.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// indexFinder() 메서드 정의
	public static int indexFinder(int term) {
		
		// size() 메서드를 사용해 이분 탐색에 필요한 시작과 끝 인덱스를 각 변수에 할당
		int start = 0;
		int end = subSequence.size();
		
		// while 반복문을 사용해 주어진 항을 넣을 인덱스를 찾을 때까지 순회
		while (start < end) {
			
			// 이분 탐색에 필요한 중간값을 저장할 mid 변수 초기화
			int mid = (start + end) / 2;
			
			// 해당 항의 값이 주어진 항보다 작은 경우 시작 인덱스를 갱신
			if (subSequence.get(mid) < term) {
				start = mid + 1;
				
			// 해당 항의 값이 주어진 항보다 크거나 같은 경우 끝 인덱스를 갱신
			} else {
				end = mid;
			}
		}
		
		// 주어진 항을 넣을 인덱스를 반환
		return start;
	}
}