package bronze2.num20528;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 개수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 주어진 팰린드롬 문자열을 모두 사용했을 때 끝말잇기를 할 수 있는지 여부를 저장할 변수 isPossible 초기화
		boolean isPossible = true;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 charAt() 메서드를 사용해 끝말잇기를 하기 위한 시작 알파벳을 변수 targetAlphabet에 할당
		char targetAlphabet = st.nextToken().charAt(0);
		
		// while 반복문을 사용해 각 팰린드롬 문자열을 순회
		while (wordNum-- > 1) {
			
			// 해당 문자열로 끝말잇기를 할 수 없는 경우 끝말잇기를 할 수 있는지 여부를 갱신 후 반복문 탈출
			if (st.nextToken().charAt(0) != targetAlphabet) {
				isPossible = false;
				break;
			}
		}
		
		// write() 메서드를 사용해 주어진 팰린드롬 문자열을 모두 사용했을 때 끝말잇기를 할 수 있는지 여부를 출력
		out.write((isPossible) ? "1" : "0");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}