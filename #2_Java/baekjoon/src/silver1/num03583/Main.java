package silver1.num03583;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 국가의 수를 변수 countryNum에 할당
		int countryNum = Integer.parseInt(in.readLine());
		
		// 국가를 나타낼 각 알파벳을 저장할 배열 countries 초기화
		char[] countries = new char[52];
		
		// for 반복문을 사용해 알파벳 대문자를 배열 countries에 저장
		for (int idx = 0; idx < 26; idx++)
			countries[idx] = (char) ('A' + idx);
		
		// for 반복문을 사용해 알파벳 소문자를 배열 countries에 저장
		for (int idx = 0; idx < 26; idx++)
			countries[idx + 26] = (char) ('a' + idx);
		
		// write() 메서드를 사용해 건물의 높이, 너비, 길이를 출력
		out.write(2 + " " + countryNum + " " + countryNum + "\n");
		
		// for 반복문을 사용해 1층의 각 칸을 출력
		for (int r = 0; r < countryNum; r++) {
			for (int c = 0; c < countryNum; c++)
				out.write(countries[c]);
				
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// for 반복문을 사용해 2층의 각 칸을 출력
		for (int r = 0; r < countryNum; r++) {
			for (int c = 0; c < countryNum; c++)
				out.write(countries[r]);
				
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}