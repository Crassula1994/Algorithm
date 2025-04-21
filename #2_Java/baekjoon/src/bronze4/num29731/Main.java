package bronze4.num29731;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// 릭 애스틀리(Rick Astley)가 만든 공약을 저장할 Set 객체 pledges 초기화
	static Set<String> pledges = new HashSet<>();
	
	// add() 메서드를 사용해 릭 애스틀리가 만든 공약을 pledges에 저장
	static {
		pledges.add("Never gonna give you up");
		pledges.add("Never gonna let you down");
		pledges.add("Never gonna run around and desert you");
		pledges.add("Never gonna make you cry");
		pledges.add("Never gonna say goodbye");
		pledges.add("Never gonna tell a lie and hurt you");
		pledges.add("Never gonna stop");
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 공약의 수를 변수 pledgeNum에 할당
		int pledgeNum = Integer.parseInt(in.readLine());
		
		// 주어진 공약이 기존 공약으로부터 바뀌었는지 여부를 저장할 변수 isHacked 초기화
		boolean isHacked = false;
		
		// while 반복문을 사용해 각 공약을 순회
		while (pledgeNum-- > 0) {
			
			// 주어진 공약이 기존 공약으로부터 바뀐 경우 그 여부를 갱신 후 반복문 탈출
			if (!pledges.contains(in.readLine())) {
				isHacked = true;
				break;
			}
		}
		
		// 모든 문장이 릭 애스틀리가 만든 공약에 속하는지 여부를 출력
		out.write((isHacked) ? "Yes" : "No");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}