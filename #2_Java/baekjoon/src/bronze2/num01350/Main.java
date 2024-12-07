package bronze2.num01350;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파일의 개수를 변수 fileNum에 할당
		int fileNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 클러스터의 크기를 변수 clusterSize에 할당
		int clusterSize = Integer.parseInt(in.readLine());
		
		// 사용한 디스크 크기를 저장할 변수 diskSize 초기화
		long diskSize = 0;
		
		// while 반복문을 사용해 각 파일을 순회
		while (fileNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 파일의 크기를 변수 fileSize에 할당
			int fileSize = Integer.parseInt(st.nextToken());
			
			// 해당 파일을 저장하기 위해 필요한 클러스터의 개수를 변수 clusterNum에 할당
			int clusterNum = (fileSize % clusterSize == 0) ? fileSize / clusterSize : fileSize / clusterSize + 1;
			
			// 사용한 디스크 공간을 갱신
			diskSize += clusterNum * clusterSize;
		}
		
		// valueOf() 및 write() 메서드를 사용해 사용한 디스크 크기를 출력
		out.write(String.valueOf(diskSize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}