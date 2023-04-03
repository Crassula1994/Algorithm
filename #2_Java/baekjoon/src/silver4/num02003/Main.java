package silver4.num02003;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이 및 목표로 하는 합을 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int targetSum = Integer.parseInt(st.nextToken());
		
		// 수열을 저장할 배열 sequence 초기화
		int[] sequence = new int[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 0; idx < length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 목표로 하는 합이 되는 경우의 수, 합, 해당 합을 구성하는 수열의 시작과 끝 인덱스를 저장할 각 변수 초기화
		int count = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		
		// while 반복문을 사용해 수열의 시작 인덱스가 수열의 끝에 도달할 때까지 순회
		while (start < length) {
		
			// 합한 값이 목표로 하는 합보다 크거나 같은 경우 또는 끝 인덱스가 끝에 도달한 경우 수열의 시작 인덱스를 조정
			if (sum >= targetSum || end == length) {
				sum -= sequence[start++];
			
			// 합한 값이 목표로 하는 합보다 작은 경우 수열의 끝 인덱스를 조정
			} else {
				sum += sequence[end++];
			}
			
			// 합이 목표로 하는 합과 같은 경우 목표로 하는 합이 되는 경우의 수 갱신
			if (sum == targetSum)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표로 하는 합이 되는 경우의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}