package silver4.num10610;

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
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		String number = in.readLine();
		
		// 각 숫자의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[10];
		
		// 각 숫자의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int idx = 0; idx < number.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 숫자를 변수 num에 할당
			int num = number.charAt(idx) - '0';
			
			// 각 숫자의 개수 및 합을 갱신
			counter[num]++;
			sum += num;
		}
		
		// '0'의 개수가 0개이거나 각 숫자의 합이 3으로 나누어 떨어지지 않는 경우 -1 출력
		if (counter[0] == 0 || sum % 3 != 0) {
			out.write(String.valueOf(-1));
		
		// 0의 개수가 1개 이상이고 각 숫자의 합이 3으로 나누어 떨어지는 경우
		} else {
				
			// StringBuilder 객체를 불러와 변수 sb에 할당
			StringBuilder sb = new StringBuilder();

			// for 반복문을 사용해 배열 counter의 각 원소를 순회
			for (int idx = 9; idx >= 0; idx--) {
				
				// for 반복문을 사용해 해당 숫자를 차례로 StringBuilder 객체에 추가
				for (int c = 0; c < counter[idx]; c++)
					sb.append(idx);
			}
			
			// toString() 및 write() 메서드를 사용해 마르코가 만들고 싶어하는 수를 출력
			out.write(sb.toString());
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}