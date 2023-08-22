package bronze5.num09653;

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
		
		// wrtie() 메서드를 사용해 'STAR' 로고를 출력
		out.write("    8888888888  888    88888\n");
		out.write("   88     88   88 88   88  88\n");
		out.write("    8888  88  88   88  88888\n");
		out.write("       88 88 888888888 88   88\n");
		out.write("88888888  88 88     88 88    888888\n");
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// write() 메서드를 사용해 'WARS' 로고를 출력
		out.write("88  88  88   888    88888    888888\n");
		out.write("88  88  88  88 88   88  88  88\n");
		out.write("88 8888 88 88   88  88888    8888\n");
		out.write(" 888  888 888888888 88  88      88\n");
		out.write("  88  88  88     88 88   88888888\n");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}