package gold5.num01548;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 각 수열의 원소를 저장할 배열 sequence 초기화
		int[] sequence = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열의 원소를 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 수열의 크기가 3 미만인 경우 그 자체로 가장 긴 부분 삼각 수열이므로 입력 받은 수열의 크기를 출력
		if (size < 3) {
			out.write(String.valueOf(size));
			
		// 수열의 크기가 3 이상인 경우
		} else {
			
			// 가장 긴 부분 삼각 수열의 길이를 저장할 변수 maxLength 초기화
			int maxLength = 2;
			
			// sort() 메서드를 사용해 수열을 오름차순으로 정렬
			Arrays.sort(sequence);
			
			// for 반복문을 사용해 수열의 가장 작은 원소를 순회
			for (int minIdx = 0; minIdx < size - 2; minIdx++) {
				
				// for 반복문을 사용해 수열의 가장 큰 원소를 순회
				for (int maxIdx = minIdx + 2; maxIdx < size; maxIdx++) {
					
					// 해당 원소가 삼각 수열을 이루지 않는 경우 반복문 탈출
					if (sequence[minIdx] + sequence[minIdx + 1] <= sequence[maxIdx])
						break;
					
					// max() 메서드를 사용해 가장 긴 부분 삼각 수열의 길이를 갱신
					maxLength = Math.max(maxIdx - minIdx + 1, maxLength);
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 가장 긴 부분 삼각 수열의 길이를 출력
			out.write(String.valueOf(maxLength));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}