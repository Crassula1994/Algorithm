package bronze1.num01855;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 열의 개수를 변수 columnNum에 할당
		int columnNum = Integer.parseInt(in.readLine());
		
		// readLine() 메서드를 사용해 입력 받은 암호화된 문자열을 변수 cryptogram에 할당
		String cryptogram = in.readLine();
		
		// 암호문 해독에 필요한 행의 개수를 계산해 변수 rowNum에 할당
		int rowNum = cryptogram.length() / columnNum;
		
		// 각 암호문의 알파벳을 저장할 2차원 배열 table 초기화
		char[][] table = new char[rowNum][columnNum];
		
		// for 반복문을 사용해 2차원 배열 table의 각 행과 열을 순회
		for (int r = 0, idx = 0; r < rowNum; r++) {
			for (int c = 0; c < columnNum; c++) {
			
				// 홀수 행인 경우 알파벳을 table에 저장
				if (r % 2 == 0) {
					table[r][c] = cryptogram.charAt(idx++);
				
				// 짝수 행인 경우 알파벳을 table에 저장
				} else {
					table[r][columnNum - c - 1] = cryptogram.charAt(idx++);
				}
			}
		}
		
		// 해독한 원래의 문자열을 저장할 변수 decodedString 초기화
		String decodedString = "";
		
		// for 반복문을 사용해 2차원 배열 table의 각 열과 행을 순회하며 해독한 결과를 갱신
		for (int c = 0; c < columnNum; c++) {
			for (int r = 0; r < rowNum; r++)
				decodedString += table[r][c];
		}
		
		// write() 메서드를 사용해 원래의 문자열을 출력
		out.write(decodedString);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}