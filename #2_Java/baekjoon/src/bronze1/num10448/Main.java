package bronze1.num10448;

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
		
		// 각 삼각수의 값을 저장할 배열 triangularNumbers 초기화
		int[] triangularNumbers = new int[45];
		
		// 각 숫자를 세 삼각수로 만들 수 있는지 여부를 저장할 배열 possibleList 초기화
		Integer[] possibleList = new Integer[1001];
		
		// for 반복문을 사용해 각 삼각수의 값을 배열 triangularNumbers에 저장
		for (int n = 1; n < 45; n++)
			triangularNumbers[n] = triangularNumbers[n - 1] + n;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 숫자를 이미 확인한 경우 해당 숫자의 가능 여부를 출력 후 다음 테스트 케이스를 순회
			if (possibleList[number] != null) {
				out.write(possibleList[number] + "\n");
				continue;
			}
			
			// 해당 숫자를 세 개의 삼각수의 합으로 표현할 수 있는지 여부를 나타낼 변수 isPossible 초기화
			boolean isPossible = false;
			
			// for 반복문을 사용해 세 삼각수를 순회
			outer: for (int n1 = 1; n1 < 45; n1++) {
				for (int n2 = 1; n2 < 45; n2++) {
					for (int n3 = 1; n3 < 45; n3++) {
						
						// 세 삼각수의 합을 계산해 변수 sum에 할당
						int sum = triangularNumbers[n1] + triangularNumbers[n2] + triangularNumbers[n3];
					
						// 세 삼각수의 합이 해당 숫자인 경우 isPossible 갱신 후 반복문 탈출
						if (sum == number) {
							isPossible = true;
							break outer;
							
						// 세 삼각수의 합이 해당 숫자보다 큰 경우 반복문 탈출
						} else if (sum > number) {
							break;
						}
					}
				}
			}
			
			// 해당 숫자를 세 개의 삼각수의 합으로 표현할 수 있는 경우 가능 여부를 저장 후 1을 출력
			if (isPossible) {
				possibleList[number] = 1;
				out.write(1 + "\n");
			
			// 해당 숫자를 세 개의 삼각수의 합으로 표현할 수 없는 경우 가능 여부를 저장 후 0을 출력
			} else {
				possibleList[number] = 0;
				out.write(0 + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}