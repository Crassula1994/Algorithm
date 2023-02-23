package bronze3.num02501;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 약수를 구할 수와 구할 약수의 순서를 각 변수에 할당
		int multiple = Integer.parseInt(st.nextToken());
		int ascOrder = Integer.parseInt(st.nextToken());
		
		// 해당 약수의 순서를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 약수를 구할 수와 같거나 작은 각 숫자를 순회
		for (int num = 1; num <= multiple; num++) {
			
			// 해당 숫자가 약수인 경우 약수의 개수를 갱신
			if (multiple % num == 0)
				count++;
			
			// 해당 숫자가 구할 약수의 순서에 도달한 경우 해당 숫자 출력 후 반복문 탈출
			if (count == ascOrder) {
				out.write(String.valueOf(num));
				break;
			}
			
			// 해당 숫자의 마지막 약수가 구할 약수의 순서보다 작은 경우 0을 출력 
			if (num == multiple)
				out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}