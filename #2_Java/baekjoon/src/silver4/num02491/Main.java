package silver4.num02491;

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

		// readLine() 및 parseInt() 메서드를 사용해 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 수열의 숫자를 저장할 배열 numbers 초기화
		int[] numbers = new int[length];
		
		// 각 수열의 증가 및 감소 여부를 저장할 2차원 배열 isMonotone 초기화
		int[][] isMonotone = new int[length][2];
		
		// 가장 긴 수열의 길이를 저장할 변수 maxLength 초기화
		int maxLength = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 numbers의 각 원소를 순회
		for (int idx = 0; idx < numbers.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 숫자를 배열 numbers에 할당
			numbers[idx] = Integer.parseInt(st.nextToken());
			
			// 첫 번째 수이거나 
			if (idx == 0) {
				isMonotone[idx][0]++;
				isMonotone[idx][1]++;
			
			// 이전 인덱스의 값과 같은 경우 isMonotone의 각 배열에 1을 추가
			} else if (numbers[idx] == numbers[idx - 1]) {
				isMonotone[idx][0] = isMonotone[idx - 1][0] + 1;
				isMonotone[idx][1] = isMonotone[idx - 1][1] + 1;
				
			// 이전 인덱스의 값보다 큰 경우 isMonotone의 감소 배열의 값을 초기화
			} else if (numbers[idx] > numbers[idx - 1]) {
				isMonotone[idx][0] = isMonotone[idx - 1][0] + 1;
				isMonotone[idx][1] = 1;
			
			// 이전 인덱스의 값보다 작은 경우 isMonotone의 증가 배열의 값을 초기화
			} else {
				isMonotone[idx][0] = 1;
				isMonotone[idx][1] = isMonotone[idx - 1][1] + 1;
			}
			
			// 최대 수열의 길이 갱신
			maxLength = (isMonotone[idx][0] > maxLength) ? isMonotone[idx][0] : maxLength;
			maxLength = (isMonotone[idx][1] > maxLength) ? isMonotone[idx][1] : maxLength;
		}
		
		// valueOf() 및 write() 메서드를 사용해 최대 수열의 길이 출력
		out.write(String.valueOf(maxLength));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}