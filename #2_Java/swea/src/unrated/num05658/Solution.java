package unrated.num05658;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

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
		for(int tc = 1; tc <= testCase; tc++) {

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수와 크기 순서를 각 변수에 할당
			int length = Integer.parseInt(st.nextToken());
			int targetOrder = Integer.parseInt(st.nextToken());

			// 보물상자에 적힌 각 숫자를 저장할 Deque 객체 sequenceDeq 초기화
			Deque<Character> sequenceDeq = new LinkedList<>();

			// 각 비밀번호를 저장할 Set 객체 passwords 초기화
			Set<Integer> passwords = new HashSet<>();
			
			// readLine() 메서드를 사용해 입력 받은 보물상자에 적힌 각 숫자를 변수 sequence에 할당
			String sequence = in.readLine();
        	
			// for 반복문을 사용해 각 숫자를 sequenceDeq에 저장
			for (int idx = 0; idx < sequence.length(); idx++)
				sequenceDeq.offerLast(sequence.charAt(idx));
			
			// for 반복문을 사용해 비밀번호가 원래대로 돌아올 때까지 순회
			for (int rotation = 0; rotation < length / 4; rotation++) {
				
				// for 반복문을 사용해 가능한 각 16진수 비밀번호를 순회
				for (int i = 0; i < 4; i++) {
					
					// 16진수 비밀번호를 저장할 변수 password 초기화
					String password = "";
					
					// for 반복문을 사용해 비밀번호의 각 자리 숫자를 차례로 순회
					for (int n = 0; n < length / 4; n++) {
						
						// pollFirst() 메서드를 사용해 해당 숫자를 digit에 할당
						char digit = sequenceDeq.pollFirst();
						
						// 비밀번호에 해당 숫자를 할당
						password += digit;
						
						// offerLast() 메서드를 사용해 해당 숫자를 다시 sequenceDeq에 저장
						sequenceDeq.offerLast(digit);
					}
					
					// valueOf() 및 add() 메서드를 사용해 16진수 비밀번호를 Set 객체 passwords에 추가
					passwords.add(Integer.valueOf(password, 16));
				}
				
				// offerFirst() 및 pollLast() 메서드를 사용해 비밀번호의 회전을 반영
				sequenceDeq.offerFirst(sequenceDeq.pollLast());
			}
			
			// 각 비밀번호를 큰 값 순으로 저장할 PriorityQueue 객체 maxHeap 초기화
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			// for 반복문을 사용해 각 비밀번호를 maxHeap에 추가
			for (int password : passwords)
				maxHeap.offer(password);
			
			// 목표로 하는 비밀번호를 저장할 변수 targetPassword 초기화
			int targetPassword = 0;
			
			// for 반복문을 사용해 목표로 하는 순서의 값을 변수 targetPassword에 저장
			for (int h = 0; h < targetOrder; h++)
				targetPassword = maxHeap.poll();

			// write() 메서드를 사용해 목표로 하는 비밀번호를 출력
			out.write("#" + tc + " " + targetPassword + "\n");
		}	

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}