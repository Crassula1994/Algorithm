package d3.num3307;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
			int length = Integer.parseInt(in.readLine());
			
			// 입력 받은 수열을 저장할 배열 sequence 초기화
			int[] sequence = new int[length];
			
			// 최장 증가 부분 수열을 저장할 리스트 lisSequence 초기화
			List<Integer> lisSequence = new LinkedList<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 sequence의 각 원소 순회
			for (int i = 0; i < length; i++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 원소를 배열에 저장
				sequence[i] = Integer.parseInt(st.nextToken());
				
				// 최장 증가 부분 수열에 저장된 값이 없는 경우
				if (lisSequence.isEmpty())
					lisSequence.add(sequence[i]);
				
				if (!lisSequence.isEmpty() && sequence[i] > lisSequence.get(lisSequence.size() - 1)) {
					lisSequence.add(sequence[i]);
				
				} else if (!lisSequence.isEmpty() && sequence[i] < lisSequence.get(lisSequence.size() - 1)) {
					
					int left = 0;
					int right = size - 1;
					int mid = size / 2;
					
					// 
					while (left < right) {
						mid = (left + right) / 2;
						
						if (lisSequence[mid] < sequence[j]) {
							left = mid + 1;
						} else {
							right = mid;
						}
					}
					
					lisSequence[right] = sequence[];
					
					for (int k = right + 1; k < size; k++)
						lisSequence[k] = 0;
					
					size = right;
				}
			}
			
			// write() 메서드를 사용해 최장 증가 부분 수열의 길이를 출력
			out.write("#" + (tc + 1) + " " + size + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}