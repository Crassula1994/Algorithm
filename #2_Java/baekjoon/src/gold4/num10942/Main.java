package gold4.num10942;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 홍준이가 칠판에 적은 수를 저장할 배열 sequence 초기화
		int[] sequence = new int[size + 1];
		
		// 각 부분 수열의 시작 위치와 끝 위치에 따라 팰린드롬인지 여부를 저장할 2차원 배열 isPalindrome 초기화
		boolean[][] isPalindrome = new boolean[size + 1][size + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 홍준이가 칠판에 적은 수를 배열 sequence에 저장
		for (int idx = 1; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 부분 수열의 길이가 1일 때 팰린드롬인지 여부를 갱신
		for (int idx = 1; idx <= size; idx++)
			isPalindrome[idx][idx] = true;
		
		// for 반복문을 사용해 부분 수열의 길이가 2인 경우를 순회
		for (int idx = 1; idx < size; idx++) {
			
			// 해당 부분 수열이 팰린드롬인 경우 팰린드롬인지 여부를 갱신
			if (sequence[idx] == sequence[idx + 1])
				isPalindrome[idx][idx + 1] = true;
		}
		
		// for 반복문을 사용해 부분 수열의 길이가 3 이상인 경우를 순회
		for (int length = 2; length < size; length++) {
			
			// for 반복문을 사용해 부분 수열의 시작 위치를 순회
			for (int idx = 1; idx <= size - length; idx++) {
				
				// 해당 부분 수열이 팰린드롬인 경우 팰린드롬인지 여부를 갱신
				if (sequence[idx] == sequence[idx + length] && isPalindrome[idx + 1][idx + length - 1])
					isPalindrome[idx][idx + length] = true;
			}
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질문의 개수를 변수 questionNum에 할당
		int questionNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 질문을 순회
		for (int question = 0; question < questionNum; question++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 부분 수열의 시작 위치와 끝 위치를 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 해당 부분 수열이 팰린드롬인 경우 1 출력
			if (isPalindrome[start][end]) {
				out.write(String.valueOf(1));
				
			// 해당 부분 수열이 팰린드롬이 아닌 경우 0 출력
			} else {
				out.write(String.valueOf(0));
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}