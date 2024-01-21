package bronze1.num16968;

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
		
		// readLine() 메서드를 사용해 입력 받은 번호판의 형식을 변수 form에 할당
		String form = in.readLine();
		
		// charAt() 메서드를 사용해 가능한 차량 번호판의 개수를 저장할 변수 count 초기화
		int count = (form.charAt(0) == 'd') ? 10 : 26;
		
		// for 반복문을 사용해 번호판 형식의 각 자리를 순회
		for (int idx = 1; idx < form.length(); idx++) {
			
			// charAt() 메서드를 사용해 이전 자리와 현재 자리의 형식을 각 변수에 할당
			char prevType = form.charAt(idx - 1);
			char curType = form.charAt(idx);
			
			// 현재 자리의 형식이 숫자이고 이전 자리 형식과 다른 경우 차량 번호판의 개수를 갱신
			if (curType == 'd' && curType != prevType) {
				count *= 10;
				
			// 현재 자리의 형식이 숫자이고 이전 자리 형식과 같은 경우 차량 번호판의 개수를 갱신
			} else if (curType == 'd' && curType == prevType) {
				count *= 9;
				
			// 현재 자리의 형식이 문자이고 이전 자리 형식과 다른 경우 차량 번호판의 개수를 갱신
			} else if (curType == 'c' && curType != prevType) {
				count *= 26;
				
			// 현재 자리의 형식이 문자이고 이전 자리 형식과 같은 경우 차량 번호판의 개수를 갱신
			} else {
				count *= 25;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가능한 차량 번호판의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}