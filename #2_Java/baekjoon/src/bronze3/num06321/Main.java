package bronze3.num06321;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 컴퓨터의 개수를 변수 computerNum에 할당
		int computerNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 컴퓨터를 순회
		for (int computer = 1; computer <= computerNum; computer++) {
			
			// 두 번째 컴퓨터 이후인 경우 빈 줄을 출력
			if (computer > 1)
				out.newLine();
			
			// readLine() 메서드를 사용해 입력 받은 컴퓨터 이름을 변수 sourceName에 할당
			String sourceName = in.readLine();
			
			// write() 메서드를 사용해 컴퓨터 번호를 출력
			out.write("String #" + computer + "\n");
			
			// for 반복문을 사용해 컴퓨터 이름의 각 알파벳의 다음 순서인 알파벳을 출력
			for (int idx = 0; idx < sourceName.length(); idx++)
				out.write((char) ((sourceName.charAt(idx) - 'A' + 1) % 26 + 'A'));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}