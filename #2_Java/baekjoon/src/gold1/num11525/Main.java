package gold1.num11525;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 데이터 세트의 개수를 변수 dataSet에 할당
		int dataSet = Integer.parseInt(in.readLine());
		
		// 각 차수에 해당하는 페리 수열(Farey Sequence)의 길이를 저장할 배열 lengths 초기화
		int[] lengths = new int[10001];
		
		// 0차에 해당하는 페리 수열의 길이를 초기화
		lengths[0] = 1;
		
		// for 반복문을 사용해 각 차수에 해당하는 페리 수열의 길이를 갱신
		for (int idx = 1; idx < lengths.length; idx++)
			lengths[idx] = lengths[idx - 1] + sequenceFinder(idx);
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (dataSet-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 데이터 세트의 번호와 페리 수열의 차수를 각 변수에 할당
			int number = Integer.parseInt(st.nextToken());
			int order = Integer.parseInt(st.nextToken());
			
			// format() 및 write() 메서드를 사용해 해당 페리 수열의 차수에 해당하는 수열의 길이를 정해진 형식으로 출력
			out.write(String.format("%d %d\n", number, lengths[order]));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sequenceFinder() 메서드 정의
	public static int sequenceFinder(int order) {
		
		// 해당 숫자가 분모일 때 그 숫자와 소로소인 분자의 개수를 저장할 변수 count 초기화
		int count = order;
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor * factor <= order; factor++) {
			
			// 해당 숫자가 소인수가 아닌 경우 다음 숫자를 순회
			if (order % factor != 0)
				continue;
			
			// while 반복문을 사용해 해당 숫자가 해당 소인수로 더 나누어지지 않을 때까지 갱신
			while (order % factor == 0)
				order /= factor;
			
			// 해당 숫자가 분모일 때 그 숫자와 소로소인 분자의 개수를 갱신
			count -= count / factor;
		}
		
		// 마지막 남은 소인수가 있는 경우 해당 숫자가 분모일 때 그 숫자와 소로소인 분자의 개수를 갱신
		if (order > 1)
			count -= count / order;
		
		// 해당 숫자가 분모일 때 그 숫자와 소로소인 분자의 개수를 반환
		return count;
	}
}