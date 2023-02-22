package d3.num8931;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 영수증의 액수를 저장할 Stack 객체 receipt 초기화
			Stack<Integer> receipt = new Stack<>();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 줄의 수를 변수 line에 할당
			int line = Integer.parseInt(in.readLine());
			
			// 액수의 총합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 각 줄을 순회
			for (int l = 0; l < line; l++) {
				
				// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				int number = Integer.parseInt(in.readLine());
				
				// 0이 입력된 경우 pop() 메서드를 사용해 최근 액수 제거
				if (number == 0) {
					receipt.pop();
					
				// 0이 아닌 값이 입력된 경우 add() 메서드를 사용해 액수 추가
				} else {
					receipt.add(number);
				}
			}
			
			// while 반복문을 사용해 receipt에 저장된 각 액수의 총합을 계산
			while (!receipt.isEmpty())
				sum += receipt.pop();
			
			// write() 메서드를 사용해 액수의 총합을 출력
			out.write("#" + (tc + 1) + " " + sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}