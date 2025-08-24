package bronze2.num09243;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파일을 덮어씌울 횟수, 파일이 있던 곳과 삭제 후 비트를 각 변수에 할당
		int targetCount = Integer.parseInt(in.readLine());
		String prevBitString = in.readLine();
		String curBitString = in.readLine();
		
		// 파일을 덮어씌울 횟수가 짝수인 경우 삭제가 성공했는지 여부를 출력
		if ((targetCount & 1) == 0) {
			out.write((prevBitString.equals(curBitString)) ? "Deletion succeeded" : "Deletion failed");
		
		// 파일을 덮어씌울 횟수가 홀수인 경우
		} else {
			
			// 삭제가 성공했는지 여부를 저장할 변수 isSuccess 초기화
			boolean isSuccess = true;
			
			// for 반복문을 사용해 각 비트의 글자를 순회
			for (int idx = 0; idx < prevBitString.length(); idx++) {
				
				// 두 글자가 같은 경우 삭제가 성공했는지 여부를 갱신 후 반복문 탈출
				if (prevBitString.charAt(idx) == curBitString.charAt(idx)) {
					isSuccess = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 삭제가 성공했는지 여부를 출력
			out.write((isSuccess) ? "Deletion succeeded" : "Deletion failed");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}