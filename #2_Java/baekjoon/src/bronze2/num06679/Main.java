package bronze2.num06679;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 1000; number < 10000; number++) {
			
			// digitSumCalculator() 메서드를 호출해 해당 숫자를 10진수, 12진수로 나타냈을 때 자릿수의 합을 각 변수에 할당
			int sum10 = digitSumCalculator(number, 10);
			int sum12 = digitSumCalculator(number, 12);
			
			// 해당 숫자를 10진수, 12진수로 나타냈을 때 자릿수의 합이 다른 경우 다음 숫자 순회
			if (sum10 != sum12)
				continue;
			
			// digitSumCalculator() 메서드를 호출해 해당 숫자를 16진수로 나타냈을 때 자릿수의 합을 변수 sum16에 할당
			int sum16 = digitSumCalculator(number, 16);
			
			// 해당 숫자를 10진수, 16진수로 나타냈을 때 자릿수의 합이 다른 경우 다음 숫자 순회
			if (sum10 != sum16)
				continue;
			
			// write() 메서드를 사용해 싱기한 네 자리 숫자를 출력
			out.write(number + "\n");
		}
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// digitSumCalculator() 메서드 정의
	public static int digitSumCalculator(int number, int radix) {
		
		// 자릿수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// while 반복문을 사용해 각 자릿수의 합을 갱신
		while (number > 0) {
			sum += number % radix;
			number /= radix;
		}
		
		// 자릿수의 합을 반환
		return sum;
	}
}