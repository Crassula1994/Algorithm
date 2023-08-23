package bronze5.num05339;

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
		
		// wrtie() 메서드를 사용해 콜센터에 앉아있는 C3PO를 출력
		out.write("     /~\\\n");
		out.write("    ( oo|\n");
		out.write("    _\\=/_\n");
		out.write("   /  _  \\\n");
		out.write("  //|/.\\|\\\\\n");
		out.write(" ||  \\ /  ||\n");
		out.write("============\n");
		out.write("|          |\n");
		out.write("|          |\n");
		out.write("|          |");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}