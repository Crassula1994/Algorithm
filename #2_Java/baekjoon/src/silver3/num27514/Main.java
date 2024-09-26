package silver3.num27514;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 흐즈로의 연산을 통해 만들 수 있는 가장 큰 최댓값의 지수를 저장할 maxExponent 초기화
		int maxExponent = 0;
		
		// 각 원소의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[63];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 수열의 원소를 순회
		while (length-- > 0) {
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 수열의 원소를 변수 element에 할당
			long element = Long.parseLong(st.nextToken());
			
			// 해당 수열의 원소가 0인 경우 다음 원소를 순회
			if (element == 0)
				continue;
			
			// log() 메서드를 사용해 해당 원소의 개수를 배열 counts에 갱신
			counts[(int) (Math.log(element) / Math.log(2))]++;
		}
		
		// for 반복문을 사용해 각 원소의 개수를 순회
		for (int idx = 0; idx < counts.length - 1; idx++) {
			
			// 두 원소를 합해 다음으로 큰 원소의 개수를 갱신
			counts[idx + 1] += counts[idx] / 2;
			
			// 다음으로 큰 원소의 개수가 1개 이상인 경우 흐즈로의 연산을 통해 만들 수 있는 가장 큰 최댓값의 지수를 갱신
			if (counts[idx + 1] > 0)
				maxExponent = idx + 1;
		}
		
		// pow(), valueOf(), write() 메서드를 사용해 흐즈로의 연산을 통해 만들 수 있는 가장 큰 최댓값을 출력
		out.write(String.valueOf((long) Math.pow(2, maxExponent)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}