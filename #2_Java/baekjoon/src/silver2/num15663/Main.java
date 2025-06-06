package silver2.num15663;

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
	
	// 수열을 뽑을 숫자가 저장된 배열, 수열로 선택했는지 여부를 저장할 배열 초기화
	static int[] numbers;
	static boolean[] selected;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자연수를 각 변수에 할당
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 주어진 자연수를 저장할 배열 numbers 초기화
		numbers = new int[n];
		
		// 이미 수열로 선택한 값을 저장할 배열 selected 초기화
		selected = new boolean[n];
		
		// 결과를 저장할 배열 result 초기화
		int[] result = new int[m];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 numbers의 각 원소에 자연수를 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 numbers를 오름차순으로 정렬
		Arrays.sort(numbers);
		
		// permutation() 메서드를 호출해 수열을 차례로 출력
		permutation(0, n, m, result, out);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// permutation() 메서드 정의
	public static void permutation(int length, int n, int m, int[] result, BufferedWriter out) throws IOException {
		
		// m개의 값을 추출해 수열을 모두 만든 경우
		if (length == m) {
			
			// for 반복문을 사용해 수열을 출력
			for (int idx = 0; idx < m; idx++)
				out.write(result[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
		// m개의 값을 추출해 수열을 모두 만들지 못한 경우
		} else {
			
			// 마지막으로 선택한 값을 저장할 변수 lastNum 초기화
			int lastNum = 0;
			
			// for 반복문을 사용해 모든 자연수를 차례로 순회
			for (int idx = 0; idx < n; idx++) {
				
				// 선택하지 않은 값이며 해당 값이 마지막으로 선택한 값과 다른 경우
				if (!selected[idx] && lastNum != numbers[idx]) {
					
					// 해당 값을 선택 처리 후 수열에 추가
					selected[idx] = true;
					result[length] = numbers[idx];
					
					// 마지막으로 선택한 값을 갱신
					lastNum = numbers[idx];
					
					// permutation() 메서드 재귀 호출
					permutation(length + 1, n, m, result, out);
					
					// 선택 처리한 해당 값을 원상복구
					selected[idx] = false;
				}
			}
		}
	}
}