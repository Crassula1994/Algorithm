package bronze1.num27161;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 펼쳐질 카드의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 플레이어가 외쳐야 하는 시각 및 시간이 역행하고 있는지 여부를 나타낼 각 변수 초기화
		int curTime = 11;
		boolean isInverse = false;
		
		// while 반복문을 사용해 각 카드를 순회
		while (cardNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 카드에 그려진 시계의 종류 및 카드에 적힌 시간을 각 변수에 할당
			String category = st.nextToken();
			int cardTime = Integer.parseInt(st.nextToken()) - 1;
			
			// 플레이어가 외쳐야 하는 시각을 갱신
			curTime = ((isInverse) ? curTime + 11 : curTime + 1) % 12;
			
			// equals() 메서드를 사용해 시간 역행의 법칙과 동기화의 법칙이 발동되었는지 여부를 저장할 각 변수 갱신
			boolean isReversed = category.equals("HOURGLASS") && curTime != cardTime;
			boolean isSynchronized = !category.equals("HOURGLASS") && curTime == cardTime;
				
			// 시간 역행의 법칙이 발동된 경우 시간이 역행하고 있는지 여부를 갱신
			if (isReversed)
				isInverse = !isInverse;
				
			// write() 메서드를 사용해 플레이어가 외쳐야 하는 시각과 해야 하는 행동을 출력
			out.write((curTime + 1) + " ");
			out.write((isSynchronized) ? "YES" : "NO");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}