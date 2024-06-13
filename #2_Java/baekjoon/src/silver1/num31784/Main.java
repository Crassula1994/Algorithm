package silver1.num31784;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자물쇠의 길이와 작업의 횟수를 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int totalCount = Integer.parseInt(st.nextToken());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 현재 자물쇠에 표시된 문자열을 배열 lockString에 저장
		char[] lockString = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 알파벳이 'A'인 경우 다음 알파벳 순회
			if (lockString[idx] == 'A')
				continue;
			
			// 해당 알파벳을 A로 만들기 위해 필요한 횟수를 계산해 변수 count에 할당
			int count = 'Z' - lockString[idx] + 1;
			
			// 해당 알파벳을 A로 만들 수 있는 경우 작업의 횟수 및 알파벳 갱신
			if (totalCount >= count) {
				totalCount -= count;
				lockString[idx] = 'A';
			}
		}
		
		// 작업 횟수가 남은 경우 마지막 알파벳을 작업 횟수만큼 조정
		if (totalCount > 0)
			lockString[length - 1] = (char) ((lockString[length - 1] - 'A' + totalCount) % 26 + 'A');
		
		// write() 메서드를 사용해 다이얼을 돌려 만들 수 있는 사전 순으로 가장 작은 문자열을 출력
		out.write(new String(lockString));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}