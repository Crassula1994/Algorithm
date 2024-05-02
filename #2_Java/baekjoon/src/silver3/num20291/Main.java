package silver3.num20291;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파일의 개수를 변수 fileNum에 할당
		int fileNum = Integer.parseInt(in.readLine());
		
		// 각 파일을 확장자 별로 저장할 Map 객체 fileSorter 초기화
		Map<String, Integer> fileSorter = new TreeMap<>();
		
		// for 반복문을 사용해 각 파일의 이름을 순회
		for (int file = 0; file < fileNum; file++) {
			
			// readLine() 및 split() 메서드를 사용해 입력 받은 파일의 확장자를 변수 extension에 저장
			String extension = in.readLine().split("\\.")[1];
			
			// getOrDefault() 및 put() 메서드를 사용해 해당 파일의 확장자 개수를 fileSorter에 저장
			fileSorter.put(extension, fileSorter.getOrDefault(extension, 0) + 1);
		}
		
		// for 반복문을 사용해 각 파일의 확장자와 그 개수를 출력
		for (String extension : fileSorter.keySet())
			out.write(extension + " " + fileSorter.get(extension) + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}