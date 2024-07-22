package silver2.num14231;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 박스의 개수를 변수 boxNum에 할당
		int boxNum = Integer.parseInt(in.readLine());
		
		// 가장 많이 과대포장할 수 있는 박스의 수를 저장할 변수 maxNumber 초기화
		int maxNumber = 0;
		
		// 각 박스의 크기 및 해당 박스까지 가장 많이 과대포장할 수 있는 박스의 수를 저장할 각 배열 초기화
		int[] sizes = new int[boxNum];
		int[] maxNumbers = new int[boxNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 박스의 크기를 배열 sizes에 저장
		for (int idx = 0; idx < sizes.length; idx++)
			sizes[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 박스를 차례로 순회
		for (int cur = 0; cur < sizes.length; cur++) {
			
			// 해당 박스까지 가장 많이 과대포장할 수 있는 박스의 수를 초기화
			maxNumbers[cur] = 1;
			
			// for 반복문을 사용해 이전의 각 박스를 순회
			for (int prev = 0; prev < cur; prev++) {
				
				// 이전 박스의 크기가 해당 박스의 크기보다 작은 경우 해당 박스까지 가장 많이 과대포장할 수 있는 박스의 수를 갱신
				if (sizes[prev] < sizes[cur])
					maxNumbers[cur] = Math.max(maxNumbers[prev] + 1, maxNumbers[cur]);
			}
			
			// max() 메서드를 사용해 가장 많이 과대포장할 수 있는 박스의 수를 갱신
			maxNumber = Math.max(maxNumbers[cur], maxNumber);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 많이 과대포장할 수 있는 박스의 수를 출력
		out.write(String.valueOf(maxNumber));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}