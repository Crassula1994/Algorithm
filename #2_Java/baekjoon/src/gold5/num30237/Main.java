package gold5.num30237;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집합의 개수를 변수 setNum에 할당
			int setNum = Integer.parseInt(in.readLine());
			
			// 전체 합집합의 원소와 생성 가능한 집합의 원소의 개수의 최댓값을 저장할 각 변수 초기화
			long totalSet = 0;
			int maxCount = 0;
			
			// 각 집합의 원소를 저장할 배열 sets 초기화
			long[] sets = new long[setNum];
			
			// for 반복문을 사용해 각 집합을 순회
			for (int idx = 0; idx < sets.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 집합의 원소의 개수를 변수 elementNum에 할당
				int elementNum = Integer.parseInt(st.nextToken());
				
				// while 반복문을 사용해 각 원소를 순회
				while (elementNum-- > 0) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원소를 변수 element에 할당
					int element = Integer.parseInt(st.nextToken());
					
					// 해당 집합이 가진 원소를 갱신
					sets[idx] |= 1L << element;
				}
			}
			
			// for 반복문을 사용해 전체 합집합의 원소를 갱신
			for (long set : sets)
				totalSet |= set;
			
			// for 반복문을 사용해 각 원소를 순회
			for (int element = 1; element <= 50; element++) {
				
				// 해당 원소를 포함하지 않는 집합의 합집합을 저장할 변수 remainSet 초기화
				long remainSet = 0;
				
				// for 반복문을 사용해 각 집합을 순회
				for (long set : sets) {
					
					// 해당 집합이 해당 원소를 포함하는 경우 다음 집합을 순회
					if ((set >> element & 1) == 1)
						continue;
					
					// 해당 원소를 포함하지 않는 집합의 합집합을 갱신
					remainSet |= set;
				}
				
				// 해당 원소를 포함하지 않는 집합의 합집합이 전체 합집합과 같은 경우 다음 원소를 순회
				if (remainSet == totalSet)
					continue;
				
				// bitCount() 및 max() 메서드를 사용해 생성 가능한 집합의 원소의 개수의 최댓값을 갱신
				maxCount = Math.max(Long.bitCount(remainSet), maxCount);
			}
			
			// write() 메서드를 사용해 생성 가능한 집합의 원소의 개수의 최댓값을 출력
			out.write(maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}