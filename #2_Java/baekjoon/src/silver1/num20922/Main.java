package silver1.num20922;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이와 부분 수열 내 같은 정수의 개수 제한을 각 변수에 할당
		int seqLength = Integer.parseInt(st.nextToken());
		int numLimit = Integer.parseInt(st.nextToken());
		
		// 입력 받은 수열의 원소를 저장할 배열 sequence 초기화
		int[] sequence = new int[seqLength];

		// 등장한 정수의 개수를 저장할 배열 numCounter 초기화
		int[] numCounter = new int[100001];
		
		// 조건을 만족하는 최장 연속 부분 수열의 길이를 저장할 변수 maxLength 초기화
		int maxLength = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// 최장 연속 부분 수열의 시작 인덱스 및 끝 인덱스를 나타낼 각 변수 초기화
		int start = 0;
		int end = 0;
		
		// for 반복문을 사용해 입력 받은 수열의 원소를 배열 sequence에 저장
		for (int i = 0; i < seqLength; i++)
			sequence[i] = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 끝 인덱스가 수열의 마지막에 도달할 때까지 순회
		while (end < seqLength) {
		
			// 현재 끝 인덱스의 원소의 개수가 개수 제한을 넘지 않은 경우
			if (numCounter[sequence[end]] + 1 <= numLimit) {
				
				// 끝 인덱스의 원소의 개수를 갱신
				numCounter[sequence[end]]++;
				
				// 끝 인덱스를 조정
				end++;
			
			// 현재 끝 인덱스의 원소의 개수가 개수 제한을 넘은 경우
			} else {
				
				// while 반복문을 사용해 끝 인덱스의 원소와 같은 값이 나올 때까지 시작 인덱스의 원소의 개수를 조정
				while (sequence[end] != sequence[start])
					numCounter[sequence[start++]]--;
				
				// 시작 인덱스의 원소의 개수를 추가 조정
				numCounter[sequence[start++]]--;
			}

			// 최장 연속 부분 수열의 길이를 갱신
			maxLength = Math.max(end - start, maxLength);
		}
		
		// valueOf() 및 write() 메서드를 사용해 최장 연속 부분 수열의 길이를 출력
		out.write(String.valueOf(maxLength)); 

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}