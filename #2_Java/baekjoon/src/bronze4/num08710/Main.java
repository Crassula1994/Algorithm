package bronze4.num08710;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 코직의 키, 코치가 요구한 키,
		한 번 때릴 때마다 늘어나는 혹의 길이를 각 변수에 할당 */
		int curHeight = Integer.parseInt(st.nextToken());
		int targetHeight = Integer.parseInt(st.nextToken());
		int bumpHeight = Integer.parseInt(st.nextToken());
		
		// 코직의 키가 코치가 요구한 키보다 크거나 같은 경우 0을 출력
		if (curHeight >= targetHeight) {
			out.write(String.valueOf(0));
			
		// 코직의 키가 코치가 요구한 키보다 작은 경우
		} else {
		
			// 코직이 스스로 때려야 하는 최소 횟수를 변수 minCount에 할당
			int minCount = ((targetHeight - curHeight) % bumpHeight == 0)
					? (targetHeight - curHeight) / bumpHeight
					: (targetHeight - curHeight) / bumpHeight + 1;
			
			// valueOf() 및 write() 메서드를 사용해 코직이 스스로 때려야 하는 최소 횟수를 출력
			out.write(String.valueOf(minCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}