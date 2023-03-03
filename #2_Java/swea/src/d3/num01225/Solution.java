package d3.num01225;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
    
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
			int testCase;
			
			// 예외가 발생하지 않을 경우 테스트 케이스의 번호를 변수 testCase에 할당
			try {
				testCase = Integer.parseInt(in.readLine());
			
			// 예외가 발생하는 경우 반복문 탈출
			} catch (NumberFormatException e) {
				break;
			}

			// 입력 받은 8자리의 숫자를 저장할 Queue 객체 codeMaker 초기화
			Queue<Integer> codeMaker = new LinkedList<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
        	StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 숫자를 codeMaker에 저장
        	for (int i = 0; i < 8; i++)
        		codeMaker.offer(Integer.parseInt(st.nextToken()));
        	
        	// while 반복문을 사용해 0이 생성되는 경우까지 순회
        	outer: while (true) {
        		
        		// for 반복문을 사용해 5번의 사이클을 순회
        		for (int cycle = 1; cycle <= 5; cycle++) {
        			
        			// poll() 메서드를 사용해 숫자를 변경 후 변수 number에 할당
        			int number = codeMaker.poll() - cycle;
        			
        			// 해당 숫자가 0 이하인 경우 0을 삽입 후 반복문 탈출
        			if (number <= 0) {
        				codeMaker.offer(0);
        				break outer;
        			}
        			
        			// offer() 메서드를 사용해 변경한 숫자를 codeMaker에 삽입
        			codeMaker.offer(number);
        		}
        	}
    		
        	// write() 메서드를 사용해 테스트 케이스 번호를 출력
        	out.write("#" + testCase);
        	
        	// while 반복문을 사용해 codeMaker가 빌 때까지 순회
        	while (!codeMaker.isEmpty())
        		out.write(" " + codeMaker.poll());
        	
        	// newLine() 메서드를 사용해 줄바꿈을 출력
        	out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}