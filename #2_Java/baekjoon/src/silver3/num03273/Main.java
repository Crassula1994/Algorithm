package silver3.num03273;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 수열을 저장할 배열 sequence 초기화
		int[] sequence = new int[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 0; idx < length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 sequence를 오름차순으로 정렬
		Arrays.sort(sequence);
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 목표 합을 변수 targetSum에 할당
		int targetSum = Integer.parseInt(in.readLine());
		
		// 목표로 하는 합이 되는 경우의 수, 해당 합을 구성하는 각 쌍의 인덱스를 저장할 각 변수 초기화
		int count = 0;
		int start = 0;
		int end = length - 1;
		
		// while 반복문을 사용해 쌍의 시작 인덱스와 쌍의 끝 인덱스가 교차할 때까지 순회
		while (start < end) {
		
			// 각 쌍의 합한 값을 변수 sum에 할당
			int sum = sequence[start] + sequence[end];
			
			// 합한 값이 목표로 하는 합보다 작거나 같은 경우 수열의 시작 인덱스를 조정
			if (sum <= targetSum) {
				start++;
			
			// 합한 값이 목표로 하는 합보다 큰 경우 수열의 끝 인덱스를 조정
			} else {
				end--;
			}
			
			// 합이 목표로 하는 합과 같은 경우 목표로 하는 합이 되는 경우의 수 갱신
			if (sum == targetSum)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표로 하는 합이 되는 경우의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}