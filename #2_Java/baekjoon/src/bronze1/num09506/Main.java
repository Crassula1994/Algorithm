package bronze1.num09506;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 약수를 구할 수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// -1이 입력된 경우 반복문 탈출
			if (number == -1)
				break;
			
			// 해당 숫자의 약수를 저장할 List 객체 divisors 초기화
			List<Integer> divisors = new ArrayList<>();
			
			// 약수의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 해당 수보다 작은 수를 순회
			for (int n = 1; n < number; n++) {
				
				// 해당 숫자가 약수인 경우 divisors에 추가 및 약수의 합 갱신
				if (number % n == 0) {
					divisors.add(n);
					sum += n;
				}
			}
			
			// 완전수가 아닌 경우 완전수가 아님을 출력
			if (number != sum) {
				out.write(number + " is NOT perfect.\n");
				
			// 완전수인 경우 약수들의 합으로 나타내어 출력
			} else {
				out.write(number + " = ");
				for (int idx = 0; idx < divisors.size(); idx++) {
					if (idx != divisors.size() - 1) {
						out.write(divisors.get(idx) + " + ");
					} else {
						out.write(divisors.get(idx) + "\n");
					}
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}