package gold1.num13076;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 케스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 숫자 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 저장할 배열 counts 초기화 
		int[] counts = new int[10001];
		
		// 0 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 초기화
		counts[0] = 1;
		
		// for 반복문을 사용해 숫자 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 갱신
		for (int idx = 1; idx < counts.length; idx++)
			counts[idx] = counts[idx - 1] + rationalNumberCounter(idx);
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 상한을 변수 upperLimit에 할당
			int upperLimit = Integer.parseInt(in.readLine());
			
			// write() 메서드를 사용해 입력 받은 숫자의 상한 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 출력
			out.write(counts[upperLimit] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// rationalNumberFinder() 메서드 정의
	public static int rationalNumberCounter(int number) {
		
		// 해당 숫자가 분모일 때 그 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 저장할 변수 count 초기화
		int count = number;
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor * factor <= number; factor++) {
			
			// 해당 숫자가 소인수가 아닌 경우 다음 숫자를 순회
			if (number % factor != 0)
				continue;
			
			// while 반복문을 사용해 해당 숫자가 해당 소인수로 더 나누어지지 않을 때까지 갱신
			while (number % factor == 0)
				number /= factor;
			
			// 해당 숫자가 분모일 때 그 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 갱신
			count -= count / factor;
		}
		
		// 마지막 남은 소인수가 있는 경우 해당 숫자가 분모일 때 그 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 갱신
		if (number > 1)
			count -= count / number;
		
		// 해당 숫자가 분모일 때 그 이하의 숫자로 만들 수 있는 서로 다른 유리수의 개수를 반환
		return count;
	}
}