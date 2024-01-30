package bronze5.num10170;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// write() 메서드를 사용해 NFC 서부 디비전 순위를 출력
		out.write("NFC West       W   L  T\n");
		out.write("-----------------------\n");
		out.write("Seattle        13  3  0\n");
		out.write("San Francisco  12  4  0\n");
		out.write("Arizona        10  6  0\n");
		out.write("St. Louis      7   9  0\n");
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// write() 메서드를 사용해 NFC 북부 디비전 순위를 출력
		out.write("NFC North      W   L  T\n");
		out.write("-----------------------\n");
		out.write("Green Bay      8   7  1\n");
		out.write("Chicago        8   8  0\n");
		out.write("Detroit        7   9  0\n");
		out.write("Minnesota      5  10  1");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}