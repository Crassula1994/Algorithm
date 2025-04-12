package bronze3.num02997;

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
		
		// 입력 받은 세 숫자를 저장할 변수 numbers 초기화
		int[] numbers = new int[3];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 세 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 입력 받은 세 숫자를 오름차순으로 정렬
		Arrays.sort(numbers);
		
		// 각 숫자 간의 차이를 각 변수에 할당
		int	lowDiff = numbers[1] - numbers[0];
		int highDiff = numbers[2] - numbers[1];
		
		// 두 숫자의 차이가 같은 경우 상근이가 고른 나머지 숫자를 출력
		if (lowDiff == highDiff) {
			out.write(String.valueOf(numbers[2] + lowDiff));
			
		// 더 작은 숫자 간의 차이가 더 큰 경우 상근이가 고른 나머지 숫자를 출력
		} else if (lowDiff > highDiff) {
			out.write(String.valueOf(numbers[0] + highDiff));
			
		// 더 큰 숫자 간의 차이가 더 큰 경우 상근이가 고른 나머지 숫자를 출력
		} else {
			out.write(String.valueOf(numbers[1] + lowDiff));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}