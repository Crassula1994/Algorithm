package silver2.num17103;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 소수인지 여부를 저장할 배열 isNotPrimeNum 초기화
		boolean[] isNotPrimeNum = new boolean[1000001];
		
		// 0과 1의 값은 소수가 아니므로 초기화
		isNotPrimeNum[0] = true;
		isNotPrimeNum[1] = true;
		
		// for 반복문을 사용해 소수인지 차례로 검사
		for (int pNum = 2; pNum <= 1000; pNum++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자로 넘기기
			if (isNotPrimeNum[pNum])
				continue;
			
			// for 반복문을 사용해 소수가 아닌 경우 배열 갱신
			for (int idx = pNum * pNum; idx < 1000001; idx += pNum)
				isNotPrimeNum[idx] = true;
		}
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 골드바흐 파티션의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 isNotPrimeNum의 각 홀수 원소를 순회
			for (int idx = 2; idx <= number / 2; idx ++) {

				// 두 수를 더했을 때 입력 받은 숫자가 되는 두 수가 소수인 경우 골드바흐 파티션의 개수를 갱신
				if (!isNotPrimeNum[idx] && !isNotPrimeNum[number - idx])
					count++;
			}
					
			// write() 메서드를 사용해 골드바흐 파티션의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}