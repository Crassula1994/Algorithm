package gold3.num07432;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// Directory 클래스 정의
	static class Directory {
		
		// 하위 디렉토리를 저장할 Map 객체 subdirectory 초기화
		Map<String, Directory> subdirectory;
		
		// 생성자 정의
		public Directory() {
			subdirectory = new TreeMap<>();
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// 최상위 디렉토리를 나타낼 Directory 객체 rootDirectory 초기화
	static Directory rootDirectory = new Directory();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 디렉토리 전체 경로의 개수를 변수 pathNum에 할당
		int pathNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 경로를 순회
		while (pathNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 경로를 변수 path에 할당
			String path = in.readLine();
			
			// directoryMaker() 메서드를 호출해 경로의 디렉토리 구조를 갱신
			directoryMaker(path);
		}
		
		// directoryPrinter() 및 write() 메서드를 사용해 디렉토리 구조를 출력
		out.write(directoryPrinter(rootDirectory, 0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// directoryMaker() 메서드 정의
	public static void directoryMaker(String path) {
		
		// 현재 디렉토리를 저장할 변수 curDirectory 초기화
		Directory curDirectory = rootDirectory;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(path, "\\");
		
		// while 반복문을 사용해 각 경로의 디렉토리를 순회
		while (st.hasMoreTokens()) {
			
			// nextToken() 메서드를 사용해 해당 디렉토리를 변수 directory에 할당
			String directory = st.nextToken();
			
			// computeIfAbsent() 메서드를 사용해 현재 디렉토리를 갱신
			curDirectory = curDirectory.subdirectory.computeIfAbsent(directory, directoryKey -> new Directory());
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// directoryPrinter() 메서드 정의
	public static String directoryPrinter(Directory curDirectory, int depth) {
		
		// 디렉토리 구조를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 하위 디렉토리를 순회
		for (String directory : curDirectory.subdirectory.keySet()) {
			
			// for 반복문을 사용해 해당 디렉토리의 깊이만큼 공백 문자를 추가
			for (int blank = 0; blank < depth; blank++)
				sb.append(" ");
			
			// append() 메서드를 사용해 해당 디렉토리를 sb에 추가
			sb.append(directory).append("\n");
			
			// get(), directoryPrinter(), append() 메서드를 사용해 해당 디렉토리의 하위 디렉토리를 sb에 추가
			sb.append(directoryPrinter(curDirectory.subdirectory.get(directory), depth + 1));
		}
		
		// toString() 메서드를 사용해 디렉토리 구조를 반환
		return sb.toString();
	}
}