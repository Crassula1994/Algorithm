package bronze5.num02393;

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
		
		// write() 메서드를 사용해 룩 모양의 그림을 출력
		out.write("  ___  ___  ___\n");
		out.write("  | |__| |__| |\n");
		out.write("  |           |\n");
		out.write("   \\_________/\n");
		out.write("    \\_______/\n");
		out.write("     |     |\n");
		out.write("     |     |\n");
		out.write("     |     |\n");
		out.write("     |     |\n");
		out.write("     |_____|\n");
		out.write("  __/       \\__\n");
		out.write(" /             \\\n");
		out.write("/_______________\\\n");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}